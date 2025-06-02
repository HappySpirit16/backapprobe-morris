package co.approbe.powwi.update;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.google.gson.Gson;

public class LambdaFunctionHandler implements RequestHandler<Request, String> {

	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);

	@Override
	public String handleRequest(Request input, Context context) {
		TokenPowwi tokenPowwi = new TokenPowwi();
		Data data = new Data();
		tokenPowwi = mapper.load(TokenPowwi.class, 1);
		BasicInformation basicInformation = new BasicInformation();
		String HOST = Env.AUTH_HOST;
		String region = Env.AUTH_REGION;
		System.out.println("prueba" + region);
		String path = "";
		String requestPayload = "";
		TreeMap<String, String> headers = new TreeMap<String, String>();
		AWSV4Auth awsv4Auth;
		Map<String, String> header;
		String requestBody = "";
		String print = "";
		byte[] kSecret;
		try {
			kSecret = ("Huella").getBytes("UTF-8");
			byte[] print256 = hmacSha256(kSecret, "1");
			print = bytesToHex(print256);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		switch (input.getOperacion()) {
		case "tokenTransaccional":
			basicInformation = new BasicInformation();
			basicInformation = mapper.load(BasicInformation.class, input.getIdAutenticacionAliado());
			if(basicInformation==null) {
				basicInformation=new BasicInformation();
			}
			data = mapper.load(Data.class, input.getIdAutenticacionAliado());
			TransactionToken transactionToken = new TransactionToken();
			transactionToken.setCelular("(+57)" + (data.getCellphone() == null ? "" : data.getCellphone()));
			transactionToken.setIdAutenticacionAliado(input.getIdAutenticacionAliado());
			transactionToken.setIdEnrolamiento("");
			transactionToken.setIdValidacion("");
			transactionToken.setIdCuenta(basicInformation.getIdCuenta() == null ? "" : basicInformation.getIdCuenta());
			transactionToken.setScoreValidacion(0.0);
			transactionToken.setTipoTransaccion("3");
			transactionToken.setTipoValidacion(3);
			transactionToken.setTokenConvenio(tokenPowwi.getToken());
			requestBody = transactionToken.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/gtt/generartokentransaccional";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);

				String mensaje = transaction.getMensaje() == null ? "mal" : transaction.getMensaje();
				if (mensaje.equals("Transacción exitosa")) {
					basicInformation.setTokenTransaccional(transaction.getTokenTransaccional());
					mapper.save(basicInformation);
					return mensaje;
				} else {
					return "Datos invalidos";
				}
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			return null;

		case "registrarHuella":
			basicInformation = mapper.load(BasicInformation.class, input.getIdAutenticacionAliado());
			if(basicInformation==null) {
				basicInformation=new BasicInformation();
			}
			RegistrarHuella registrar = new RegistrarHuella();
			registrar.setIdCuenta(input.getIdCuenta());
			registrar.setIP(input.getIP());
			registrar.setNombreDispositivo(input.getNombreDispositivo());
			registrar.setNuevaHuella(print);
			registrar.setSO(input.getSO());
			registrar.setTokenConvenio(tokenPowwi.getToken());
			registrar.setTokenTransaccional(
					basicInformation.getTokenTransaccional() == null ? "" : basicInformation.getTokenTransaccional());
			requestBody = registrar.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/rhu/registrarhuelladispositivo";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);// Revisar respuesta

				String mensaje = transaction.getMensaje() == null ? "mal" : transaction.getMensaje();
				if (mensaje.equals("Transacción exitosa")) {
					basicInformation.setHuella(input.getHuellaDispositivo());
					basicInformation.setNumberId(input.getIdAutenticacionAliado());
					mapper.save(basicInformation);
					return mensaje;
				} else {
					return "Datos invalidos";
				}
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			return null;

		case "tokenConsulta":
			TokenConsulta tokenConsulta = new TokenConsulta();
			basicInformation = mapper.load(BasicInformation.class, input.getIdAutenticacionAliado());
			if(basicInformation==null) {
				basicInformation=new BasicInformation();
			}
			tokenConsulta.setTokenConvenio(tokenPowwi.getToken());
			tokenConsulta
					.setHuellaDispositivo(basicInformation.getHuella() == null ? "" : basicInformation.getHuella());
			tokenConsulta.setIdCuenta(basicInformation.getIdCuenta() == null ? "" : basicInformation.getIdCuenta());
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
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				System.out.println("respuesta" + answerd);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);// Revisar respuesta

				String mensaje = transaction.getMensaje() == null ? "mal" : transaction.getMensaje();
				if (mensaje.equals("Consulta exitosa")) {
					basicInformation.setTokenConsulta(transaction.getTokenConsulta());
					mapper.save(basicInformation);
					return mensaje;
				} else {
					return "Datos invalidos";
				}
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			return null;

		case "ConsultarId":
			ConsultarIdCuenta consultarIdCuenta = new ConsultarIdCuenta();
			data = mapper.load(Data.class, input.getIdAutenticacionAliado());
			consultarIdCuenta.setTokenConvenio(tokenPowwi.getToken());
			consultarIdCuenta.setNumeroCelular("(+57)" + (data.getCellphone() == null ? "" : data.getCellphone()));
			consultarIdCuenta.setSO(input.getSO());
			consultarIdCuenta.setNombreDispositivo(input.getNombreDispositivo());
			consultarIdCuenta.setIP(input.getIP());
			requestBody = consultarIdCuenta.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/cic/consultaidcuenta";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);// Revisar respuesta

				return answerd;
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			return null;

		case "consultarSaldo":
			basicInformation = mapper.load(BasicInformation.class, input.getIdAutenticacionAliado()==null?"":input.getIdAutenticacionAliado());
			if(basicInformation==null) {
				basicInformation=new BasicInformation();
			}
			String tokenConsultas = "";
			data = mapper.load(Data.class, input.getIdAutenticacionAliado());
			HashMap<String, Object> values = new HashMap<>();
			values.put("idCuenta", input.getIdCuenta());
			ObjectMapper objectMapper = new ObjectMapper();
			ConsultarSaldo consultarSaldo = new ConsultarSaldo();
			consultarSaldo.setTokenConvenio(tokenPowwi.getToken());
			consultarSaldo.setNumeroCelular("(+57)" + (data.getCellphone() == null ? " " : data.getCellphone()));
			consultarSaldo.setHuellaDispositivo(basicInformation.getHuella() == null ? " " : basicInformation.getHuella());
			consultarSaldo.setTokenConsulta(basicInformation.getTokenConsulta() == null ? "" : basicInformation.getTokenConsulta());
			consultarSaldo.setIdCuenta(basicInformation.getIdCuenta() == null ? " " : basicInformation.getIdCuenta());
			requestBody = consultarSaldo.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/csa/consultarsaldo";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);// Revisar respuesta

				String mensaje = transaction.getMensaje() == null ? "mal" : transaction.getMensaje();

				return answerd;
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		case "consultarMovimientos":
			basicInformation = mapper.load(BasicInformation.class, input.getIdAutenticacionAliado());
			if(basicInformation==null) {
				basicInformation=new BasicInformation();
			}
			LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.of("-05:00"));
			DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			String fechaFinal=dateTime.format(dtformat);
			
			ConsultarMovimientosDepositos consultarMovimientos = new ConsultarMovimientosDepositos();
			consultarMovimientos.setTokenConvenio(tokenPowwi.getToken());
			String probe=basicInformation.getIdCuenta() == null ? " " : basicInformation.getIdCuenta();
			System.out.println("resutl:"+probe);
			consultarMovimientos.setIdCuenta(probe);
			consultarMovimientos.setTipoConsulta("D");
			consultarMovimientos.setIndiceInicial(input.getIndiceInicial());
			consultarMovimientos.setNumeroRegistros(input.getNumeroRegistros() + "");
			consultarMovimientos.setLimiteMovimientos(input.getLimiteMovimientos() + "");
			consultarMovimientos.setFechaInicial(input.getFechaInicial());
			consultarMovimientos.setFechaFinal(fechaFinal);
			requestBody = consultarMovimientos.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/cct/consultarmovimientosdepositos";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);// Revisar respuesta

				String mensaje = transaction.getMensaje() == null ? "mal" : transaction.getMensaje();

				return answerd;
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			return null;
		case "consultarCosto":
			ConsultarCostos consultarCostos = new ConsultarCostos();
			basicInformation = mapper.load(BasicInformation.class, input.getIdAutenticacionAliado()==null?"":input.getIdAutenticacionAliado());
			if(basicInformation==null) {
				basicInformation=new BasicInformation();
			}
			consultarCostos.setTokenConvenio(tokenPowwi.getToken());
			consultarCostos.setTipoOperacion(input.getTipoOperacion());
			consultarCostos.setIdCuenta(basicInformation.getIdCuenta() == null ? "" : basicInformation.getIdCuenta());
			consultarCostos.setMonto(input.getMonto());
//    		transactionToken.setIdCuenta(input.getIdCuenta());
			requestBody = consultarCostos.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/cct/consultarcostotransaccion";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				CreditLine creditLine=mapper.load(CreditLine.class, 1);
				List<String> listResponse=new ArrayList<String>();
				String resp="{\"commissionOrigination\":\"" + creditLine.getCommission() + "\"}";
				String resp2="{\"commissionFGA\":\"" + creditLine.getCommissionFGA() + "\"}";
				String resp3="{\"taxes\":\"" + creditLine.getTax() + "\"}";
				listResponse.add(answerd);
				listResponse.add(resp);
				listResponse.add(resp2);
				listResponse.add(resp3);
				return listResponse.toString();
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			return null;
		case "consultarEstadoRetiro":
			ConsultarEstadoRetiro consultarEstadoRetiro = new ConsultarEstadoRetiro();
			basicInformation = mapper.load(BasicInformation.class, input.getIdAutenticacionAliado()==null?"":input.getIdAutenticacionAliado());
			if(basicInformation==null) {
				basicInformation=new BasicInformation();
			}
			consultarEstadoRetiro.setTokenConvenio(tokenPowwi.getToken());
			consultarEstadoRetiro
					.setIdOperacion(basicInformation.getIdOperacion() == null ? "" : basicInformation.getIdOperacion());
			consultarEstadoRetiro
					.setIdCuenta(basicInformation.getIdCuenta() == null ? "" : basicInformation.getIdCuenta());
			// transactionToken.setIdCuenta(input.getIdCuenta());
			requestBody = consultarEstadoRetiro.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/cmv/consultarestadoretiro";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				return answerd;
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			return null;
		case "consultarEstadoDeposito":
			ConsultarEstadoDeposito consultarEstadoDeposito = new ConsultarEstadoDeposito();
			basicInformation = mapper.load(BasicInformation.class, input.getIdAutenticacionAliado()==null?"":input.getIdAutenticacionAliado());
			if(basicInformation==null) {
				basicInformation=new BasicInformation();
			}
			data = mapper.load(Data.class, input.getIdAutenticacionAliado());
			consultarEstadoDeposito.setTokenConvenio(tokenPowwi.getToken());
			consultarEstadoDeposito.setNumeroCelular("(+57)" +( data.getCellphone() == null ? "" : data.getCellphone()));
			consultarEstadoDeposito
					.setIdCuenta(basicInformation.getIdCuenta() == null ? "" : basicInformation.getIdCuenta());
			// transactionToken.setIdCuenta(input.getIdCuenta());
			requestBody = consultarEstadoDeposito.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/ced/consultarestadodeposito";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				return answerd;
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			return null;
		case "consultarEstadoTransaccion":
			ConsultarEstadoTransaccion consultarEstadoTransaccion = new ConsultarEstadoTransaccion();
			basicInformation = mapper.load(BasicInformation.class, input.getIdAutenticacionAliado()==null?"":input.getIdAutenticacionAliado());
			if(basicInformation==null) {
				basicInformation=new BasicInformation();
			}
			data = mapper.load(Data.class, input.getIdAutenticacionAliado());
			consultarEstadoTransaccion.setTokenConvenio(tokenPowwi.getToken());
			consultarEstadoTransaccion.setIdTransaccionAliado(input.getIdTransaccionAliado());
			consultarEstadoTransaccion.setIdTransaccionPowwi(input.getIdTransaccionPowwi());
			consultarEstadoTransaccion.setNombreDispositivo(input.getNombreDispositivo());
			consultarEstadoTransaccion.setSO(input.getSO());
			consultarEstadoTransaccion.setNombreDispositivo(input.getNombreDispositivo());
			consultarEstadoTransaccion.setIP(input.getIP());
			// transactionToken.setIdCuenta(input.getIdCuenta());
			requestBody = consultarEstadoTransaccion.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/ced/consultarestadodeposito";
			requestPayload = requestBody;
			headers = new TreeMap<String, String>();
			headers.put("host", HOST);
			awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY, Env.AUTH_SECRET_KEY).path(path).region(region)
					.service("execute-api")// execute-api
					.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
			header = awsv4Auth.getHeaders();
			try {
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				return answerd;
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		case "consultarSaldoDeposito":
			ConsultarSaldoDeposito consultarSaldoDeposito = new ConsultarSaldoDeposito();
			consultarSaldoDeposito.setTokenConvenio(tokenPowwi.getToken());
			consultarSaldoDeposito.setTipoConsulta(input.getTipoConsulta());
			consultarSaldoDeposito.setIdCuenta(input.getIdCuenta());
			requestBody = consultarSaldoDeposito.toString();
			System.out.println("respuesta " + requestBody);
			path = "/MisPesosAPI/cds/consultarsaldodepositos";
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
				ReturnTransactionToken transaction = new ReturnTransactionToken();
				String answerd = clientHttp("https://" + HOST, path, header, requestBody);
				return answerd;
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
			return null;

		}
		return null;
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
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			
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
}