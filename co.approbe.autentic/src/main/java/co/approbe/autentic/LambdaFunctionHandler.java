package co.approbe.autentic;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class LambdaFunctionHandler implements RequestHandler<Request, String> {
	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);
	@Override
	public String handleRequest(Request input, Context context) {
		context.getLogger().log("Input: " + input);
		
		ObjectMapper objectMapperAut = new ObjectMapper();
		Map<String, String> values = new HashMap<String, String>();
		ResponseTokenAut responseAutObject = new ResponseTokenAut();
		Data data=new Data();
		data=mapper.load(Data.class,input.getIdAutenticacionAliado());
		ResultOtp resultOtp=new ResultOtp();
		DocsUser docs=new DocsUser();
		
		String bodyAut = "";
		switch (input.getOperacion()) {
		case "aut":
			values.put("audience", Env.AUTH_AUDIENCE);
			values.put("grant_type", Env.AUTH_GRANTTYPE);
			values.put("client_id", Env.AUTH_CLIENTID);
			values.put("client_secret", Env.AUTH_CLIENTSECRET);
			try {
				bodyAut = objectMapperAut.writeValueAsString(values);
			} catch (JsonProcessingException e3) {
				context.getLogger().log(e3.getMessage());
			}
			try {
				context.getLogger().log("datos salida autentic: " + values);
				HttpClient client = HttpClient.newHttpClient();
				//HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Env.URL_TOKEN + "/oauth/token"))
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Env.URL_TOKEN + "/v2/authorizer/getToken"))//prod
						.setHeader("Content-Type", "application/json")
						.POST(HttpRequest.BodyPublishers.ofString(bodyAut)).build();
				HttpResponse<String> responseAut;
				responseAut = client.send(request, HttpResponse.BodyHandlers.ofString());
				String response = responseAut.body();
				responseAutObject = new Gson().fromJson(response, ResponseTokenAut.class);
				responseAutObject.setId("1");
				mapper.save(responseAutObject);
				context.getLogger().log(response);
			} catch (Exception e) {
				context.getLogger().log(e.getMessage());
			}
			return "ok";
		case "firmaElectronica":
			String code="";
			byte[] kSecret;
			try {
				kSecret = ("Huella").getBytes("UTF-8");
				code = input.getIdAutenticacionAliado() == null ? "mal" : input.getIdAutenticacionAliado();
				byte[] print256 = hmacSha256(kSecret, code);
				code = bytesToHex(print256);
			} catch (UnsupportedEncodingException e) {
				context.getLogger().log(e.getMessage());
			} catch (Exception e) {
				context.getLogger().log(e.getMessage());
			}
			ResponseTokenAut token =mapper.load(ResponseTokenAut.class,"1");
			Map<Object, Object> valuesF = new HashMap<Object, Object>();
			Map<String, String> metadata = new HashMap<String, String>();
			List<Object> files=new ArrayList<Object>();
			metadata.put("names", data.getNames());
			metadata.put("lastNames", data.getLastName());
			metadata.put("documentType", data.getIdentification());
			metadata.put("docId", data.getNumberId());
			metadata.put("secureKey", token.getAccess_token());
			
			Content content=new Content();
			Appearance appearance=new Appearance();
			content.setFileContent(input.getFileContent());
			content.setFileName(input.getFileName());
			
			files.add(content);
			valuesF.put("metadata", metadata);
			valuesF.put("files", files);
			try {
				bodyAut = objectMapperAut.writeValueAsString(valuesF);
			} catch (JsonProcessingException e3) {
				context.getLogger().log(e3.getMessage());
			}
			try {
				context.getLogger().log("datos salida firmaElectronica: " + bodyAut);
				HttpClient client = HttpClient.newHttpClient();
				//HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Env.URL_FIRMA + "/v1/signature/"))//dev
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Env.URL_FIRMA + "/v2/signature/"))//prod
						.setHeader("Content-Type", "application/json")
						.setHeader("Authorization", "Bearer "+token.getAccess_token())
						.POST(HttpRequest.BodyPublishers.ofString(bodyAut)).build();
				HttpResponse<String> responseAut;
				responseAut = client.send(request, HttpResponse.BodyHandlers.ofString());
				ResultSignature resultSignature=new ResultSignature();
				String response = responseAut.body();
				String type=input.getTipoDocumento();
				String numberId=input.getIdAutenticacionAliado();
				DocsUser docs1=new DocsUser();
				docs=new DocsUser();
				try {
					resultSignature = new Gson().fromJson(response, ResultSignature.class);
					context.getLogger().log(resultSignature.toString());
					switch (type) {
					case "_Autorizacion_Tratamiento_Datos_Financiador":
						docs1=mapper.load(DocsUser.class,input.getIdCuenta());
						docs=docs1;
						docs.setId(input.getIdCuenta());
						docs.setUrlAuthorizationAward(resultSignature.getUrlDocuments());
						docs.setNumberId(numberId);
						docs.setCodeFirmDocsAuthorizationAward(resultSignature.getTransactionId());
						docs.setCodeTx(resultSignature.getOperationCode());
						docs.setFileIdAuthorizationAward(resultSignature.getFileids()[0].getFileId());
						mapper.save(docs);
						context.getLogger().log(response);
						return response;
					case "_Autorizacion_Tratamiento_Datos_Deudor":
						docs1=mapper.load(DocsUser.class,input.getIdCuenta());
						docs=docs1;
						docs.setId(input.getIdCuenta());
						docs.setUrlAuthorizationBorrower(resultSignature.getUrlDocuments());
						docs.setNumberId(numberId);
						docs.setCodeFirmDocsAuthorizationBorrower(resultSignature.getTransactionId());
						docs.setCodeTx(resultSignature.getOperationCode());
						docs.setFileIdAuthorizationBorrower(resultSignature.getFileids()[0].getFileId());
						mapper.save(docs);
						context.getLogger().log(response);
						return response;
					case "_Contrato_de_corretaje":
						docs1=mapper.load(DocsUser.class,input.getIdCuenta());
						docs=docs1;
						docs.setId(input.getIdCuenta());
						docs.setUrlContractAward(resultSignature.getUrlDocuments());
						docs.setNumberId(numberId);
						docs.setCodeFirmDocsContractAward(resultSignature.getTransactionId());
						docs.setCodeTx(resultSignature.getOperationCode());
						docs.setFileIdContractAward(resultSignature.getFileids()[0].getFileId());
						mapper.save(docs);
						context.getLogger().log(response);
						return response;
					case "_Contrato_de_mutuo":
						docs1=mapper.load(DocsUser.class,input.getIdCuenta());
						docs=docs1;
						docs.setId(input.getIdCuenta());
						docs.setUrlMutualContract(resultSignature.getUrlDocuments());
						docs.setNumberId(numberId);
						docs.setCodeFirmDocsMutualContract(resultSignature.getTransactionId());
						docs.setCodeTx(resultSignature.getOperationCode());
						docs.setFileIdMutualContract(resultSignature.getFileids()[0].getFileId());
						mapper.save(docs);
						context.getLogger().log(response);
						return response;
					case "_Poder_":
						docs1=mapper.load(DocsUser.class,input.getIdCuenta());
						docs=docs1;
						docs.setId(input.getIdCuenta());
						docs.setUrlPower(resultSignature.getUrlDocuments());
						docs.setNumberId(numberId);
						docs.setCodeFirmDocsPower(resultSignature.getTransactionId());
						docs.setCodeTx(resultSignature.getOperationCode());
						docs.setFileIdPower(resultSignature.getFileids()[0].getFileId());
						mapper.save(docs);
						context.getLogger().log(response);
						return response;
					case "_Pagare":
						docs1=mapper.load(DocsUser.class,input.getIdCuenta());
						docs=docs1;
						docs.setId(input.getIdCuenta());
						System.out.println("entra "+docs.toString());
						docs.setUrlPromissory(resultSignature.getUrlDocuments());
						docs.setNumberId(numberId);
						docs.setCodeFirmDocsPromissory(resultSignature.getTransactionId());
						docs.setCodeTx(resultSignature.getOperationCode());
						docs.setFileIdPromissory(resultSignature.getFileids()[0].getFileId());
						mapper.save(docs);
						context.getLogger().log(response);
						return response;
					}
					return response;
				}catch (Exception e) {
					context.getLogger().log(response);
					return response;
				}
			} catch (Exception e) {
				context.getLogger().log(e.getMessage());
			}
			return "ok";
			
		case "generarOtp":
			values.put("typeSending", input.getCanal());
			values.put("destinationMail",data.getEmail());
			values.put("phoneNumber", data.getCellphone());
			try {
				bodyAut = objectMapperAut.writeValueAsString(values);
			} catch (JsonProcessingException e3) {
				context.getLogger().log(e3.getMessage());
			}
			try {
				context.getLogger().log("datos salida generarOtp: " + values);
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Env.URL_OTP + "/v2/autentic/generateotp"))//prod
						.setHeader("Content-Type", "application/json")
						.setHeader("Authorization", Env.AUTH_PASS)
						.POST(HttpRequest.BodyPublishers.ofString(bodyAut)).build();
				HttpResponse<String> responseAut;
				responseAut = client.send(request, HttpResponse.BodyHandlers.ofString());
				String response = responseAut.body();
				resultOtp = new Gson().fromJson(response, ResultOtp.class);
				context.getLogger().log(response);
				return "ok";
			} catch (Exception e) {
				context.getLogger().log(e.getMessage());
				return "fail";
			}
		case "validarOtp":
			docs.setId(input.getIdCuenta());
			mapper.save(docs);
			try {
				bodyAut = objectMapperAut.writeValueAsString(values);
			} catch (JsonProcessingException e3) {
				context.getLogger().log(e3.getMessage());
			}
			try {
				context.getLogger().log("datos salida validarOtp: " + input.getOtp());
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Env.URL_OTP + "/v2/autentic/validateotp/"+input.getOtp()))//prod
						.setHeader("Content-Type", "application/json")
						.setHeader("Authorization", Env.AUTH_PASS)
						.GET().build();
				HttpResponse<String> responseAut;
				responseAut = client.send(request, HttpResponse.BodyHandlers.ofString());
				String response = responseAut.body();
				context.getLogger().log(response);
				return response;
			} catch (Exception e) {
				context.getLogger().log(e.getMessage());
			}
			return "ok";
		case "certificado":
			values.put("certificationType", input.getCertificationType());
			values.put("transactionId",input.getTransactionId());
			values.put("documentNumber", input.getDocumentNumber());
			try {
				bodyAut = objectMapperAut.writeValueAsString(values);
			} catch (JsonProcessingException e3) {
				context.getLogger().log(e3.getMessage());
			}
			try {
				context.getLogger().log("datos salida certificado: " + values);
				HttpClient client = HttpClient.newHttpClient();
				HttpRequest request = HttpRequest.newBuilder().uri(URI.create(Env.URL_FIRMA + "/v1/certification/"))//prod
						.setHeader("Content-Type", "application/json")
						.POST(HttpRequest.BodyPublishers.ofString(bodyAut)).build();
				HttpResponse<String> responseAut;
				responseAut = client.send(request, HttpResponse.BodyHandlers.ofString());
				String response = responseAut.body();
				resultOtp = new Gson().fromJson(response, ResultOtp.class);
				context.getLogger().log(response);
				return response;
			} catch (Exception e) {
				context.getLogger().log(e.getMessage());
			}
			return "ok";
		}
		return "ok";
	}
	private byte[] hmacSha256(byte[] key, String data) throws Exception {
		String algorithm = "HmacSHA256";
		Mac mac = Mac.getInstance(algorithm);
		mac.init(new SecretKeySpec(key, algorithm));
		return mac.doFinal(data.getBytes("UTF-8"));
	}

	private final char[] hexArray = "0123456789ABCDEF".toCharArray();

	private String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars).toLowerCase();
	}

}
