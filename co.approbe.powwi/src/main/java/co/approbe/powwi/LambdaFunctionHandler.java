package co.approbe.powwi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.google.gson.Gson;

import co.approbe.dto.Hubspot;
import co.approbe.dto.RequestHubspot;

public class LambdaFunctionHandler implements RequestHandler<Request, Integer> {

	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);

	private static final String URL_AWS = Env.URL_AWS;
	private static final String URL_GCP = Env.URL_GCP;
//	private static final String URL_AWS = "https://hgarxx9xvb.execute-api.us-east-1.amazonaws.com/ApiApprobe/"; //prod
//	private static final String URL_GCP = "https://prod.approbe.co/";  // prod

	@Override
	public Integer handleRequest(Request input, Context context) {
		TokenPowwi tokenPowwi = new TokenPowwi();
		Boolean flag = false;
		Data data = new Data();
		String mensaje = "";

		tokenPowwi = mapper.load(TokenPowwi.class, 1);
		BasicInformation basicInformation = new BasicInformation();
		String HOST = Env.AUTH_HOST;
		String region = Env.AUTH_REGION;
		String path = "";
		String print = "";
		String huella = "";
		String requestPayload = "";
		String lastname = "";
		TreeMap<String, String> headers = new TreeMap<String, String>();
		AWSV4Auth awsv4Auth;
		Map<String, String> header;
		byte[] kSecret;
		try {
			kSecret = ("Huella").getBytes("UTF-8");
			huella = input.getHuellaDispositivo() == null ? "mal" : input.getHuellaDispositivo();
			byte[] print256 = hmacSha256(kSecret, huella);
			print = bytesToHex(print256);
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper = new ObjectMapper();

		HashMap<String, Object> values = new HashMap<>();
		values.put("idAutenticacionAliado", input.getNumeroDocumento());
		values.put("operacion", "");
		String requestBody = "";
		try {
			requestBody = objectMapper.writeValueAsString(values);
		} catch (JsonProcessingException e2) {

			e2.printStackTrace();
		}
		System.out.println("datos salida: " + requestBody);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest requesta = HttpRequest.newBuilder().uri(URI.create(URL_AWS + "authpowwi"))
				.setHeader("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		HttpResponse<String> responsePowwi;
		HttpResponse<String> responseJurad;
		try {
			responsePowwi = client.send(requesta, HttpResponse.BodyHandlers.ofString());
			mensaje = responsePowwi.body();
			System.out.println("mensaje " + mensaje);
		} catch (IOException e2) {

			e2.printStackTrace();
		} catch (InterruptedException e2) {

			e2.printStackTrace();
		}

		switch (input.getOperacion()) {
		case "otpTx":
			basicInformation = mapper.load(BasicInformation.class,
					input.getNumeroDocumento() == null ? "" : input.getNumeroDocumento());
			if (basicInformation == null) {
				basicInformation = new BasicInformation();
			}
			data = mapper.load(Data.class, input.getNumeroDocumento());
			if (data == null) {
				data = new Data();
			}
			GetOtp getOtp1 = new GetOtp();
			getOtp1.setCanal(input.getCanal());// 600887
			getOtp1.setCelular("(+57)" + (data.getCellphone() == null ? "" : data.getCellphone()));
			getOtp1.setCodigoTransaccion(input.getCodigoTransaccion());
			getOtp1.setTipoTransaccion(input.getTipoTransaccion());
			getOtp1.setIdCuenta(basicInformation.getIdCuenta() == null ? "" : basicInformation.getIdCuenta());
			getOtp1.setTokenConvenio(tokenPowwi.getToken());
			requestBody = getOtp1.toString();
			path = "/MisPesosAPI/got/generarotp"; // generar otp
			context.getLogger().log("salida: " + requestBody);
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);

			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ResponseDepositCreate responseTx = new ResponseDepositCreate();
				ResultTransaction resultTx = new ResultTransaction();
				// return clientHttp("https://"+HOST,path,header,requestBody);
				String answerdTx = clientHttp("https://" + HOST, path, header, requestBody);
				responseTx = new Gson().fromJson(answerdTx, ResponseDepositCreate.class);
				mensaje = responseTx.getMensaje() == null ? "mal" : responseTx.getMensaje();

				if (mensaje.equals("Transacción exitosa")) {
					return 1;

				} else {
					return 0;
				}
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		case "jurad":
			context.getLogger().log("Entra A JURAD");
			String tipoDocumentoJurad = "";
			data = mapper.load(Data.class, input.getNumeroDocumento());
			if (data == null) {
				data = new Data();
				data.setNumberId(input.getNumeroDocumento());
				data.setExpeditionDate(input.getFechaExpedicion());
				data.setIdentification(input.getTipoDocumento());
				data.setCountJurad(0);
				data.setCountExperian(0);
			} else {
				Integer countJ = data.getCountJurad() == null ? 0 : data.getCountJurad();
				data.setCountJurad(countJ);
				boolean validJ = data.getValidJurad() == null ? false : data.getValidJurad();
				if (countJ == 1) {
					if (validJ) {
						data.setStatusJurad(data.getStatusJurad() + "\n VALIDO \n");
						data.setCountExperian(data.getCountExperian() + 1);
						data.setValidJurad(true);
						mapper.save(data);
					//	hubspot(context, data);
						return 1;
					}
				} else if (countJ == 2) {
					data.setStatusJurad(data.getStatusJurad() + "\n INTENTO FRAUDE \n");
					mapper.save(data);
					return 0;
				} else if (countJ == 3) {
					data.setStatusJurad(data.getStatusJurad() + "\n CONTACTAR ADMIN \n");
					mapper.save(data);
					return 4;
					// mientras jurad soluciona el tiempo de respuesta
				} else if (countJ == 10 && data.getCountExperian() == 1) {
					context.getLogger().log("Entra a condicional");
					data.setStatusJurad(data.getStatusJurad() + "\n RESPUESTA NULA \n");
					mapper.save(data);
				//	hubspot(context, data);
					return 10;
				} else if (countJ == 4) {
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					data.setStatusJurad(data.getStatusJurad() + "\n PEPS \n");
					data.setResponseJurad(responseJ + " \n PEPS \n");
					data.setCountExperian(data.getCountExperian() + 1);
					data.setValidJurad(true);
					mapper.save(data);
				//	hubspot(context, data);
					return 5;
				}
			}
		//	context.getLogger().log("DATA: " + data.toString());

//			else if(countJ>4){
//				data.setStatusJurad(data.getStatusJurad()+"\n CONTACTAR ADMIN \n");
//				mapper.save(data);
//				return 4;
//			}
			switch (data.getIdentification()) {
			case "CC":
				tipoDocumentoJurad = "1";
				break;
			case "CE":
				tipoDocumentoJurad = "2";
				break;
			case "NIT":
				tipoDocumentoJurad = "3";
				break;

			}
			context.getLogger().log("Entra para consultar a GCP JURAD");
			ObjectMapper objectMapperJurad = new ObjectMapper();
			String dateExpedition = data.getExpeditionDate().replaceAll("-", "/");
			Map<String, String> consultJurad = new HashMap<String, String>();
			consultJurad.put("tipoIdentificacion", tipoDocumentoJurad);
			consultJurad.put("numeroIdentificacion", data.getNumberId());
			consultJurad.put("fechaCedulacion", dateExpedition);
			String bodyJurad = "";
			try {
				bodyJurad = objectMapperJurad.writeValueAsString(consultJurad);
			} catch (JsonProcessingException e3) {
				e3.printStackTrace();
			}
			try {
				System.out.println("datos salida jurad: " + consultJurad);
				client = HttpClient.newHttpClient();
				requesta = HttpRequest.newBuilder().uri(URI.create(URL_GCP + "risk-engine/politicaListasRestrictivas"))
						.setHeader("Content-Type", "application/json")
						.POST(HttpRequest.BodyPublishers.ofString(bodyJurad)).build();

				responseJurad = client.send(requesta, HttpResponse.BodyHandlers.ofString());
				mensaje = responseJurad.body();
				context.getLogger().log("Mensaje a GCP JURAD" + mensaje);
				ResponseJurad responseJuradObject = new ResponseJurad();
				context.getLogger().log("Mensaje a GCP JURAD" + responseJuradObject.toString());
				responseJuradObject = new Gson().fromJson(mensaje, ResponseJurad.class);
				System.out.println("respuesta Jurad" + responseJuradObject.toString());
				if (responseJuradObject.getMensaje() == null) {
					// dejar pasar para validar manualmente
					data.setStatusJurad(data.getStatusJurad() + "\n RESPUESTA NULA \n");
					data.setCountExperian(data.getCountExperian() + 1);
					data.setValidJurad(true);
					data.setCountJurad(10);
					mapper.save(data);
				//	hubspot(context, data);
					return 10;
				}
				if (responseJuradObject.getMensaje().contains("Validar")) {
					context.getLogger().log("ENTRA POR FECHA DE CEDULACION ERRONEA");
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					int response = 0;
					if (data.getCountJurad() == 5) {
						context.getLogger().log("CEDULACION ERRONEA POR CUARTA VEZ");
						data.setCountJurad(2);
						data.setStatusJurad(data.getStatusJurad() + "\n INTENTO FRAUDE FECHA \n");
						data.setResponseJurad(
								responseJ + " \n INTENTO FRAUDE  FECHA\n" + responseJuradObject.toString());
						response = 0;
					} else if (data.getCountJurad() == 6) {
						data.setCountJurad(5);
						data.setStatusJurad(data.getStatusJurad() + "\n FECHA \n");
						data.setResponseJurad(responseJ + " \n FECHA 3 \n" + responseJuradObject.toString());
						response = 2;
					} else if (data.getCountJurad() == 7) {
						data.setCountJurad(6);
						data.setStatusJurad(data.getStatusJurad() + "\n FECHA \n");
						data.setResponseJurad(responseJ + " \n FECHA 2 \n" + responseJuradObject.toString());
						response = 2;
					} else {
						data.setCountJurad(7);
						data.setStatusJurad(data.getStatusJurad() + "\n FECHA \n");
						data.setResponseJurad(responseJ + " \n FECHA 1 \n" + responseJuradObject.toString());
						response = 2;
					}
					data.setValidJurad(false);
					mapper.save(data);
					return response;// INTENTO FALLIDO

				} else if (responseJuradObject.getMensaje().contains("Almacenar")) {
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					data.setStatusJurad(data.getStatusJurad() + "\n INTENTO FALLIDO INFO HISTO \n");
					data.setResponseJurad(responseJ + " \n CONTACTAR ADMIN \n" + responseJuradObject.toString());
					data.setCountExperian(data.getCountExperian() + 1);
					data.setValidJurad(true);
					data.setCountJurad(10);
					mapper.save(data);
				//	hubspot(context, data);
					return 10;
				} else if (responseJuradObject.getMensaje().contains("Por po")) {
					data.setCountJurad(8);
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					data.setStatusJurad(data.getStatusJurad() + "\n POR POLITICA \n");
					data.setResponseJurad(responseJ + " \n POR POLITICA \n" + responseJuradObject.toString());
					data.setValidJurad(false);
					mapper.save(data);
					return 0;
				} else if (responseJuradObject.getMensaje().contains("Fuente caida")) {
					data.setCountJurad(10);
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					data.setStatusJurad(data.getStatusJurad() + "\n FUENTE CAIDA \n");
					data.setResponseJurad(responseJ + " \n FUENTE CAIDA \n" + responseJuradObject.toString());
					data.setValidJurad(true);
					data.setCountExperian(data.getCountExperian() + 1);
					mapper.save(data);
				//	hubspot(context, data);
					return 10;
				} else if (responseJuradObject.getMensaje().contains("Ejecutar")) {
					Integer countJurad = (data.getCountJurad()==null || data.getCountJurad() == 0 ) ? data.getCountJurad() + 1 : 1;
					data.setCountJurad(countJurad);
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					data.setStatusJurad(data.getStatusJurad() + "\n VALIDO \n");
					data.setResponseJurad(responseJ + " \n VALIDO\n" + responseJuradObject.toString());
					data.setCountExperian(data.getCountExperian() + 1);
					data.setValidJurad(true);
					mapper.save(data);
					//hubspot(context, data);
					return 1;
				} else if (responseJuradObject.getMensaje().contains("Flujo")) {
					data.setCountJurad(4);
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					data.setStatusJurad(data.getStatusJurad() + "\n PEPS \n");
					data.setResponseJurad(responseJ + " \n PEPS \n" + responseJuradObject.toString());
					data.setValidJurad(true);
					mapper.save(data);
					data.setCountExperian(data.getCountExperian() + 1);
					//hubspot(context, data);
					return 5;
					// desde aqui sebastian, tomar en cuenta el caso validar, que tambien es por
					// fecha en gcp
				} else if (responseJuradObject.getMensaje().contains("Fecha")) {
					context.getLogger().log("ENTRA POR FECHA DE CEDULACION ERRONEA");
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					int response = 0;
					if (data.getCountJurad() == 5) {
						context.getLogger().log("CEDULACION ERRONEA POR SEGUNDA VEZ");
						data.setCountJurad(2);
						data.setStatusJurad(data.getStatusJurad() + "\n INTENTO FRAUDE FECHA \n");
						data.setResponseJurad(
								responseJ + " \n INTENTO FRAUDE  FECHA\n" + responseJuradObject.toString());
						response = 0;
					} else {
						data.setCountJurad(5);
						data.setStatusJurad(data.getStatusJurad() + "\n FECHA \n");
						data.setResponseJurad(responseJ + " \n FECHA \n" + responseJuradObject.toString());
						response = 11;
					}
					data.setValidJurad(false);
					mapper.save(data);
					return response;
				} else if (responseJuradObject.getMensaje().contains("error format")) {
					context.getLogger().log("ENTRA POR FORMATO DE CEDULA ERRONEA");
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					data.setCountJurad(6);
					data.setStatusJurad(data.getStatusJurad() + "\n ERROR FORMAT \n");
					data.setResponseJurad(responseJ + " \n ERROR FORMAT\n" + responseJuradObject.toString());
					data.setValidJurad(false);
					mapper.save(data);
					return 11;
				} else if (responseJuradObject.getMensaje().contains("Cancelado muerte")) {
					context.getLogger().log("ENTRA POR CEDULA CANCELADA POR MUERTE");
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					data.setCountJurad(2);
					data.setStatusJurad(data.getStatusJurad() + "\n INTENTO FRAUDE MUERTE \n");
					data.setResponseJurad(
							responseJ + " \n INTENTO FRAUDE FECHA MUERTE\n" + responseJuradObject.toString());
					data.setValidJurad(false);
					mapper.save(data);
					return 0;
					// hasta aqui sebastian
				} else {
					data.setStatusJurad(data.getStatusJurad() + "\n RESPUESTA NO DEFINIDA \n");
					String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
					data.setResponseJurad(responseJ + " \n NO DEFINIDA \n" + responseJuradObject.toString());
					data.setCountJurad(0);
					data.setValidJurad(false);
					mapper.save(data);
					return 4;
				}
			} catch (IOException | InterruptedException e2) {
				e2.printStackTrace();
			} catch (IllegalStateException e) {
				data.setCountJurad(10);
				String responseJ = data.getResponseJurad() == null ? "" : data.getResponseJurad();
				data.setStatusJurad(data.getStatusJurad() + "\n FUENTE CAIDA \n");
				data.setResponseJurad(responseJ + " \n FUENTE CAIDA \n" + mensaje);
				data.setValidJurad(true);
				// para aumenta el caso que consulta experian o reconocer
				data.setCountExperian(data.getCountExperian() + 1);
				mapper.save(data);
			//	hubspot(context, data);
				return 10;
			}

			return 0;
		case "otp":
			String tipoDocumento = "";
			data = mapper.load(Data.class, input.getNumeroDocumento());
			if (data == null) {
				return 2;
			}
			switch (data.getIdentification()) {
			case "CC":
				tipoDocumento = "1";
				break;
			case "CE":
				tipoDocumento = "2";
				break;
			case "NIT":
				tipoDocumento = "3";
				break;

			}

			GetOtpCreate getOtp = new GetOtpCreate();
			int tam = data.getLastName().length();
			// Custom input string
			String str = data.getLastName();

			char[] ch = new char[str.length()];

			for (int i = 0; i < str.length(); i++) {
				ch[i] = str.charAt(i);
			}

			for (char c : ch) {
				if (Character.toString(c).matches(" ")) {
					break;
				}
				lastname = lastname + c;
			}
			ConsultReconocer consultReconocer = new ConsultReconocer();
			getOtp.setCanal(input.getCanal());// 600887
			getOtp.setCelular("(+57)" + data.getCellphone());
			getOtp.setCodigoTransaccion(input.getCodigoTransaccion());
			getOtp.setTipoTransaccion(input.getTipoTransaccion());
			getOtp.setTokenConvenio(tokenPowwi.getToken());
			consultReconocer.setTipoIdentificacion(tipoDocumento);
			consultReconocer.setIdentificacion(input.getNumeroDocumento());
			consultReconocer.setPrimerApellido(lastname);
			consultReconocer.setName(data.getNames());
			consultReconocer.setFullName(data.getLastName());
			consultReconocer.setCelularFormulario(data.getCellphone());
			consultReconocer.setEmailFormulario(data.getEmail());
			requestBody = consultReconocer.toString();
			String requestBody1 = getOtp.toString();
			objectMapper = new ObjectMapper();
			System.out.println("datos salida reconocer: " + requestBody);
			System.out.println("datos salida otp: " + requestBody1);
			client = HttpClient.newHttpClient();
			requesta = HttpRequest.newBuilder().uri(URI.create(URL_GCP + "experian-reconocer/api/experian/reconocer"))
					.setHeader("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

			try {
				responsePowwi = client.send(requesta, HttpResponse.BodyHandlers.ofString());
				mensaje = responsePowwi.body();
				DatosReconocer datos = new DatosReconocer();
				datos = new Gson().fromJson(mensaje, DatosReconocer.class);
				System.out.println("respuesta caren " + mensaje);
				if ((datos.getCelular().equals("SI")) && (datos.getEmail().equals("SI"))) {
					data.setReconocer(true);
					mapper.save(data);
				} else {
					data.setReconocer(false);
					mapper.save(data);
				}

			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}
			requestBody = getOtp.toString();
			path = "/MisPesosAPI/got/generarotp"; // generar otp
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			// Put your Access Key in place of <ACCESS_KEY> and Secret Key in place of
			// <SECRET_KEY> in double quotes
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ResponseDepositCreate response = new ResponseDepositCreate();
				ResultTransaction resultT = new ResultTransaction();
				// return clientHttp("https://"+HOST,path,header,requestBody);
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				response = new Gson().fromJson(answerd, ResponseDepositCreate.class);
				mensaje = response.getMensaje() == null ? "mal" : response.getMensaje();

				if (mensaje.equals("Transacción exitosa")) {
					return 1;

				} else {
					return 0;
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
			return 0;

		case "tokenTransaccional":
			basicInformation = new BasicInformation();
			data = mapper.load(Data.class, input.getNumeroDocumento());
			if (data.getCountPowwi() >= 5) {
				return 3;
			}
			TransactionToken transactionToken = new TransactionToken();
			transactionToken.setCelular("(+57)" + data.getCellphone());
			transactionToken.setIdAutenticacionAliado(input.getNumeroDocumento());
			transactionToken.setIdEnrolamiento(input.getIdEnrolamiento());
			transactionToken.setIdValidacion(input.getIdValidacion());
			transactionToken.setOtp(input.getOtp());
			transactionToken.setScoreValidacion(input.getScoreValidacion());
			transactionToken.setTipoTransaccion(input.getTipoTransaccion());
			transactionToken.setTipoValidacion(input.getTipoValidacion());
			transactionToken.setTokenConvenio(tokenPowwi.getToken());
//    		transactionToken.setIdCuenta(input.getIdCuenta());
			requestBody = transactionToken.toString();
			System.out.println("salida token transaccional " + requestBody);
			path = "/MisPesosAPI/gtt/generartokentransaccional";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				// return clientHttp("https://"+HOST,path,header,requestBody);
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);
				System.out.println("respuesta token transaccional " + answerd);
				mensaje = transaction.getMensaje() == null ? "mal" : transaction.getMensaje();
				if (mensaje.equals("Transacción exitosa")) {
					context.getLogger().log("exito en autenticar el otp");
					basicInformation.setTokenTransaccional(transaction.getTokenTransaccional());
					basicInformation.setNumberId(input.getNumeroDocumento());
					basicInformation.setIdCuenta(input.getIdCuenta());
					data.setValidCellphone(true);
					mapper.save(basicInformation);
					mapper.save(data);
					if (data.getReconocer()) {
						return 1;
					} else {
						return 0;
					}

				} else if (mensaje.equals("OTP invalida")) {
					context.getLogger().log("falla en autenticar el otp con otp ivalido");
					data.setValidCellphone(false);
					data.setCountPowwi(data.getCountPowwi() + 1);
					mapper.save(data);
					return 0;
				} else {
					context.getLogger().log("falla en autenticar el otp");
					data.setValidCellphone(false);
					mapper.save(data);
					return 0;
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
			return 0;
		case "tokenConsulta":
			TokenConsulta tokenConsulta = new TokenConsulta();
			tokenConsulta.setTokenConvenio(tokenPowwi.getToken());
			tokenConsulta.setHuellaDispositivo(print);
			tokenConsulta.setIdCuenta(input.getIdCuenta());
			requestBody = tokenConsulta.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/otc/obtenertokenconsulta";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				// return clientHttp("https://"+HOST,path,header,requestBody);
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);// Revisar respuesta

				mensaje = transaction.getMensaje() == null ? "mal" : transaction.getMensaje();
				if (mensaje.equals("Transacción exitosa")) {
					basicInformation.setHuella(input.getHuellaDispositivo());
					basicInformation.setNumberId(input.getNumeroDocumento());
					basicInformation.setTokenConsulta(
							transaction.getTokenConsulta() == null ? "" : transaction.getTokenConsulta());
					mapper.save(basicInformation);
					return 1;
				} else {
					return 0;
				}
			} catch (IOException | InterruptedException e) {

				e.printStackTrace();
			}
			return 0;
		case "crearDeposito":

			basicInformation = new BasicInformation();
			basicInformation = mapper.load(BasicInformation.class, input.getNumeroDocumento());
			if (basicInformation == null) {
				basicInformation = new BasicInformation();
			}
			System.out.println("basic " + basicInformation.toString());
			CreateDeposit createDeposit = new CreateDeposit();
			ResponseDepositCreate response = new ResponseDepositCreate();
			String dateBirth = input.getTipoDocumento() == "CC" ? "C" : "C";
			createDeposit.setCelular("(+57)" + input.getCelular());
			createDeposit.setCheckBiometria(input.isCheckBiometria());
			createDeposit.setCheckDatos(input.isCheckDatos());
			createDeposit.setCheckInformacionTr(input.isCheckInformacionTr());
			createDeposit.setCheckHabbeasData(input.isCheckHabbeasData());
			createDeposit.setCheckProducto(input.isCheckProducto());
			createDeposit.setCorreoElectronico(input.getCorreoElectronico());
			createDeposit.setFechaExpedicion(input.getFechaExpedicion());
			createDeposit.setFechaNacimiento(input.getFechaNacimiento());
			createDeposit.setHuellaDispositivo(print);
			createDeposit.setIP(input.getIP());
			createDeposit.setNombreDispositivo(input.getNombreDispositivo());
			createDeposit.setNumeroDocumento(input.getNumeroDocumento());
			createDeposit.setSexo(input.getSexo());
			createDeposit.setSO(input.getSO());
			createDeposit.setTipoDocumento(dateBirth);
			createDeposit.setTokenConvenio(tokenPowwi.getToken());
			createDeposit.setTokenTransaccional(
					basicInformation.getTokenTransaccional() == null ? "" : basicInformation.getTokenTransaccional());
			requestBody = createDeposit.toString();
			path = "/MisPesosAPI/cde/creardeposito";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				response = new Gson().fromJson(answerd, ResponseDepositCreate.class);

				mensaje = response.getMensaje() == null ? "mal" : response.getMensaje();
				if (mensaje.equals("Transacción exitosa")) {
					context.getLogger().log("Creacion de cuenta powwi");
					basicInformation.setHuella(print);
					basicInformation.setExpeditionDate(input.getFechaExpedicion());
					basicInformation.setBirthDate(input.getFechaNacimiento());
					basicInformation.setNumberId(input.getNumeroDocumento());
					basicInformation.setIdCuenta(input.getIdCuenta());
					basicInformation.setDateUpdate(response.getFecha());
					basicInformation.setEmail(input.getCorreoElectronico());
					basicInformation.setNames(response.getNombres());
					basicInformation.setLastname(response.getApellidos());
					basicInformation.setIdCuenta(response.getIdCuenta());
					basicInformation.setCellphone(input.getCelular());
					basicInformation.setAccountCreated(true);
					mapper.save(basicInformation);
					return 1;
				} else {
					return 0;
				}
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		default:
			return 0;
		}
	}

	private static String clientHttp(String host, String pathUrl, Map<String, String> header, String requestBody)
			throws JsonProcessingException, IOException, InterruptedException {
		String responsea = "";
		try {
			HttpClient clienta = HttpClient.newHttpClient();

			HttpRequest requestb = HttpRequest.newBuilder().uri(URI.create(host + pathUrl))
					.header("Content-Type", "application/json").header("userName", Env.AUTH_USERNAME)
					.header("x-amz-date", header.get("x-amz-date")).header("Authorization", header.get("Authorization"))
					.POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

			HttpResponse<String> responsee = clienta.send(requestb, HttpResponse.BodyHandlers.ofString());
			responsea = responsee.body();
			System.out.println("respuesta: " + responsee.body());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return responsea;
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

	private void hubspot(Context context, Data basicInformation) {
		try {
			Hubspot hubspot = mapper.load(Hubspot.class, basicInformation.getNumberId());
			context.getLogger().log("Usuario hubspot: " + hubspot);
			if (hubspot != null) {
				context.getLogger().log(basicInformation.getNumberId() + " Usuario registrado en hubspot");
			} else {
				RequestHubspot request = new RequestHubspot();
				request.setEmail(basicInformation.getEmail());
				request.setFirstname(basicInformation.getNames());
				request.setLastname(basicInformation.getLastName());
				request.setId_titular(basicInformation.getNumberId());
				request.setPhone(basicInformation.getCellphone());
				request.setAction("CREATEUSER");
				conecctionHubspot(request.toString(), context);
			}

		} catch (Exception e) {
			context.getLogger().log(basicInformation.getNumberId() + " falla hubspot en hubspot");
		}
	}

	private String conecctionHubspot(String body, Context context) {
		String responseH = "FAIL";
		try {
			context.getLogger().log(" -- Body para Hubspot: " + body);
			AWSLambda lambdaClient = AWSLambdaClientBuilder.defaultClient();
//			AWSCredentials cred = new BasicAWSCredentials("AKIA5SBAE4XKWXTF3K67","oIoJ8aKDOyUD5VysGXCLMfgIMH+VSx2/MBfifhli");// dev
//			AWSCredentialsProvider credProvider = new AWSStaticCredentialsProvider(cred);
//			AWSLambda lambdaClient = AWSLambdaClientBuilder.standard().withCredentials(credProvider)
//					.withRegion(Regions.US_EAST_1).build();
//			
			InvokeRequest invokeRequest = new InvokeRequest().withFunctionName("HubsPot").withPayload(body);
			InvokeResult invokeResult = lambdaClient.invoke(invokeRequest);
			String responsePayload = StandardCharsets.UTF_8.decode(invokeResult.getPayload()).toString();
			responseH = new Gson().fromJson(responsePayload, String.class);

		} catch (Exception e) {
			context.getLogger().log(" -- Hubspot Error: " + e);
		}

		return responseH;
	}

}
