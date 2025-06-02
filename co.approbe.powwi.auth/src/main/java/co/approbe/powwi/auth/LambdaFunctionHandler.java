package co.approbe.powwi.auth;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;


public class LambdaFunctionHandler implements RequestHandler<Request, String> {

	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);

	
    @Override
    public String handleRequest(Request input, Context context) {
		TokenPowwi tokenPowwi=new TokenPowwi();
		Data data=new Data();
		tokenPowwi=mapper.load(TokenPowwi.class,1);
		data=mapper.load(Data.class,input.getIdAutenticacionAliado());
		LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.of("-05:00"));
		DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dateActual = dateTime.format(dtformat);
		String dateBD=tokenPowwi.getDateSave();
		String pattern = "dd/MM/yyyy HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date1;
		Date date2;
		long diff=0;
		try {
			date1 = sdf.parse(dateBD);
			date2 = sdf.parse(dateActual);
			 // obtener la diferencia entre dos fechas en minutos
            long elapsedms = date2.getTime() - date1.getTime();
            diff = TimeUnit.MINUTES.convert(elapsedms, TimeUnit.MILLISECONDS);
            System.out.println("diferencia en minut:"+diff);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BasicInformation basicInformation=new BasicInformation();
		String requestBody = "";
		String HOST=Env.AUTH_HOST;//"prep.powwi.co";
		String region =Env.AUTH_REGION; //"us-east-1";
		String answerd="";
		ReturnAuth returnAuth=new ReturnAuth();
		
		String requestPayload = "";
		String path = "/MisPesosAPI/au/autenticacionconvenio";		
		TreeMap<String, String> headers = new TreeMap<String, String>();
		headers.put("host", HOST);
		if (diff>5) {
			System.out.println("diferencia mayor");
			try {
				AWSV4Auth awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY,Env.AUTH_SECRET_KEY)
						.path(path).region(region).service("execute-api")// execute-api
						.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
				Map<String, String> header = awsv4Auth.getHeaders();
				answerd= clientHttp("https://"+HOST,path,header,requestBody);
				returnAuth = new Gson().fromJson(answerd, ReturnAuth.class);
				String mensaje=returnAuth.getMensaje()== null ? "mal" :returnAuth.getMensaje();
				if (mensaje.equals("Transacción exitosa")) {
					tokenPowwi.setToken(returnAuth.getTokenConvenio());
					tokenPowwi.setId(1);
					tokenPowwi.setDateSave(dateActual);
					mapper.save(tokenPowwi);
				}else {
					return "Datos invalidos";
				}
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		switch (input.getOperacion()) {
    	case "auth":
    		basicInformation=new BasicInformation();
    		basicInformation=mapper.load(BasicInformation.class,input.getIdAutenticacionAliado());
    		TransactionToken transactionToken=new TransactionToken();
    		transactionToken.setCelular("(+57)"+(data.getCellphone()==null?"":data.getCellphone()));
    		transactionToken.setIdAutenticacionAliado(input.getIdAutenticacionAliado());
    		transactionToken.setIdEnrolamiento("");
    		transactionToken.setIdValidacion("");
    		transactionToken.setIdCuenta(basicInformation.getIdCuenta()==null?"":basicInformation.getIdCuenta());
    		transactionToken.setScoreValidacion(0.0);
    		transactionToken.setTipoTransaccion("3");
    		transactionToken.setTipoValidacion(1);
    		transactionToken.setTokenConvenio(tokenPowwi.getToken());
//    		transactionToken.setIdCuenta(input.getIdCuenta());
    		requestBody =transactionToken.toString();
    		System.out.println("respuesta "+requestBody);
    		path = "/MisPesosAPI/gtt/generartokentransaccional";
    		requestPayload = requestBody;
    		headers = new TreeMap<String, String>();
    		headers.put("host", HOST);
    		AWSV4Auth awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY,Env.AUTH_SECRET_KEY)
    				.path(path).region(region).service("execute-api")// execute-api
    				.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
    		Map<String, String> header = awsv4Auth.getHeaders();
    		try {
    			ReturnTransactionToken transaction=new ReturnTransactionToken();
				answerd= clientHttp("https://"+HOST,path,header,requestBody);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);
				
				String mensaje=transaction.getMensaje()== null ? "mal" :transaction.getMensaje();
				if (mensaje.equals("Transacción exitosa")) {
					basicInformation.setTokenTransaccional(transaction.getTokenTransaccional());
					mapper.save(basicInformation);
				}else {
					return "Datos invalidos";
				}
			} catch (IOException | InterruptedException e) {
				
				e.printStackTrace();
			}
    	
    		TokenConsulta tokenConsulta=new TokenConsulta();
    		basicInformation=mapper.load(BasicInformation.class,input.getIdAutenticacionAliado());
    		tokenConsulta.setTokenConvenio(tokenPowwi.getToken());
    		tokenConsulta.setHuellaDispositivo(basicInformation.getHuella()==null?"":basicInformation.getHuella());
    		tokenConsulta.setIdCuenta(basicInformation.getIdCuenta()==null?"":basicInformation.getIdCuenta());
    		requestBody =tokenConsulta.toString();
    		System.out.println("respuesta "+requestBody);
    		path = "/MisPesosAPI/otc/obtenertokenconsulta";
    		requestPayload = requestBody;
    		headers = new TreeMap<String, String>();
    		headers.put("host", HOST);
    		awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY,Env.AUTH_SECRET_KEY)
    				.path(path).region(region).service("execute-api")// execute-api
    				.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
    		header = awsv4Auth.getHeaders();
    		try {
    			ReturnTransactionToken transaction=new ReturnTransactionToken();
				answerd= clientHttp("https://"+HOST,path,header,requestBody);
				System.out.println("respuesta"+answerd);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);//Revisar respuesta
				
				String mensaje=transaction.getMensaje()== null ? "mal" :transaction.getMensaje();
				if (mensaje.equals("Consulta exitosa")) {
					basicInformation.setTokenConsulta(transaction.getTokenConsulta());
					mapper.save(basicInformation);
					return mensaje;
				}else {
					return "Datos invalidos";
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
    		 return null;
    	case "authOtp":
    		basicInformation=new BasicInformation();
    		basicInformation=mapper.load(BasicInformation.class,input.getIdAutenticacionAliado());
    		TransactionTokenOtp transactionTokenOtp=new TransactionTokenOtp();
    		transactionTokenOtp.setCelular("(+57)"+(data.getCellphone()==null?"":data.getCellphone()));
    		transactionTokenOtp.setIdAutenticacionAliado(input.getIdAutenticacionAliado());
    		transactionTokenOtp.setIdEnrolamiento("");
    		transactionTokenOtp.setIdValidacion("");
    		transactionTokenOtp.setIdCuenta(basicInformation.getIdCuenta()==null?"":basicInformation.getIdCuenta());
    		transactionTokenOtp.setScoreValidacion(0.0);
    		transactionTokenOtp.setTipoTransaccion("2");
    		transactionTokenOtp.setTipoValidacion(1);
    		transactionTokenOtp.setOtp(input.getOtp());
    		transactionTokenOtp.setTokenConvenio(tokenPowwi.getToken());
//    		transactionToken.setIdCuenta(input.getIdCuenta());
    		requestBody =transactionTokenOtp.toString();
    		System.out.println("respuesta "+requestBody);
    		path = "/MisPesosAPI/gtt/generartokentransaccional";
    		requestPayload = requestBody;
    		headers = new TreeMap<String, String>();
    		headers.put("host", HOST);
    		AWSV4Auth awsv4Auth1 = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY,Env.AUTH_SECRET_KEY)
    				.path(path).region(region).service("execute-api")// execute-api
    				.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
    		Map<String, String> header1 = awsv4Auth1.getHeaders();
    		try {
				//return clientHttp("https://"+HOST,path,header,requestBody);
    			ReturnTransactionToken transaction=new ReturnTransactionToken();
				answerd= clientHttp("https://"+HOST,path,header1,requestBody);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);
				
				String mensaje=transaction.getMensaje()== null ? "mal" :transaction.getMensaje();
				if (mensaje.equals("Transacción exitosa")) {
					basicInformation.setTokenTransaccional(transaction.getTokenTransaccional());
					mapper.save(basicInformation);
				}else {
					basicInformation.setTokenTransaccional(" ");
					mapper.save(basicInformation);
					return "fail";
				}
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
    	
    		TokenConsulta tokenConsultaOtp=new TokenConsulta();
    		basicInformation=mapper.load(BasicInformation.class,input.getIdAutenticacionAliado());
    		tokenConsultaOtp.setTokenConvenio(tokenPowwi.getToken());
    		tokenConsultaOtp.setHuellaDispositivo(basicInformation.getHuella()==null?"":basicInformation.getHuella());
    		tokenConsultaOtp.setIdCuenta(basicInformation.getIdCuenta()==null?"":basicInformation.getIdCuenta());
    		requestBody =tokenConsultaOtp.toString();
    		System.out.println("respuesta "+requestBody);
    		path = "/MisPesosAPI/otc/obtenertokenconsulta";
    		requestPayload = requestBody;
    		headers = new TreeMap<String, String>();
    		headers.put("host", HOST);
    		awsv4Auth = new AWSV4Auth.Builder(Env.AUTH_ACCESS_KEY,Env.AUTH_SECRET_KEY)
    				.path(path).region(region).service("execute-api")// execute-api
    				.httpMethodName("POST ").headers(headers).payload(requestPayload).build();
    		header = awsv4Auth.getHeaders();
    		try {
    			ReturnTransactionToken transaction=new ReturnTransactionToken();
				answerd= clientHttp("https://"+HOST,path,header,requestBody);
				System.out.println("respuesta"+answerd);
				transaction = new Gson().fromJson(answerd, ReturnTransactionToken.class);//Revisar respuesta
				
				String mensaje=transaction.getMensaje()== null ? "mal" :transaction.getMensaje();
				if (mensaje.equals("Consulta exitosa")) {
					basicInformation.setTokenConsulta(transaction.getTokenConsulta());
					mapper.save(basicInformation);
					return mensaje;
				}else {
					return "Datos invalidos";
				}
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 return null;
		}
		return "OK";
    }
    private static String clientHttp(String host, String pathUrl, Map<String, String> header,String requestBody)throws JsonProcessingException,IOException, InterruptedException {
    	String responsea = "";
    	String username=Env.AUTH_USERNAME;
    	try {
			HttpClient clienta = HttpClient.newHttpClient();

			HttpRequest requestb = HttpRequest.newBuilder()
					.uri(URI.create(host+pathUrl))
					.header("Content-Type", "application/json").header("userName", username)
					.header("x-amz-date", header.get("x-amz-date"))
					.header("Authorization", header.get("Authorization"))
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

}
