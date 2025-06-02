package co.approbe.consult.account;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.Page;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class LambdaFunctionHandler implements RequestHandler<Request, Object> {

	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);
	DynamoDB dynamoDB = new DynamoDB(db);
	
    @Override
    public Object handleRequest(Request input, Context context) {
    	Map<String, Object> values = new HashMap<>();
    	Map<String, String> result = new HashMap<>();
    	Relation relation=new Relation();
    	Data data=new Data();
    	InformationPowwi informationPowwi=new InformationPowwi();
    	InformationPowwi informationPowwi1=new InformationPowwi();
    	String mensaje;
    	ObjectMapper objectMapper = new ObjectMapper();
    	HashMap<String, Object> values1 = new HashMap<>();
		HttpClient client = HttpClient.newHttpClient();
		HttpResponse<String> responsePowwi;
    	String requestBody="";
    	switch (input.getOperacion()) {
		case "obtener":
			
			Table table = dynamoDB.getTable("relationPay");
			Index index = table.getIndex("numberIdBorrower-index");
			QuerySpec spec = new QuerySpec().withProjectionExpression(
					"numberIdBorrower, numberIdMoneylender").withKeyConditionExpression("numberIdBorrower = :_apply")
					.withValueMap(new ValueMap().withString(":_apply", input.getIdAutenticacionAliado()));
			ItemCollection<QueryOutcome> items = index.query(spec);
			int i = 0;
			System.out.println("\nPage: " +spec);
			
			System.out.println("\nPage: " +items);
			for (Page<Item, QueryOutcome> page : items.pages()) {
				Iterator<Item> iterator = page.iterator();
				// System.out.println("\nPage: " + ++pageNum);
				Item item = null;
				while (iterator.hasNext()) {
					item = iterator.next();
					values.put("" + i, item.toJSONPretty());
					 System.out.println(item.toJSONPretty());
					i++;
				}
			}
			if (values.size()==0) {
				result.put("error","no existe");
				return result;
			}
			int lengthMap1 = values.size();

			for (int j = 0; j < lengthMap1; j++) {
				String hashMap = values.get("" + j).toString();
				
				hashMap = hashMap.replaceAll("=", ":");
				relation = new Gson().fromJson(hashMap, Relation.class);

			}
			System.out.println("\nPage: " +"funciona");
			String borrowerId= relation.getNumberIdBorrower()==null?"":relation.getNumberIdBorrower();
			String lenderId= relation.getNumberIdMoneylender()==null?"":relation.getNumberIdMoneylender();
			System.out.println(borrowerId+" "+lenderId);
			data=mapper.load(Data.class,lenderId);
			if(data==null) {
				data=new Data();
			}
				
			informationPowwi=mapper.load(InformationPowwi.class,input.getIdAutenticacionAliado());
			if(informationPowwi==null) {
				informationPowwi=new InformationPowwi();
			}
			informationPowwi1=mapper.load(InformationPowwi.class,lenderId);
			if(informationPowwi1==null) {
				informationPowwi1=new InformationPowwi();
			}
			int n=informationPowwi1.getIdCuenta().length();
			
			result.put("productoDestino",informationPowwi1.getIdCuenta().substring(n-4));
			result.put("lineaDestino", data.getCellphone());
			result.put("productoOrigen",informationPowwi.getIdCuenta());
			result.put("idBorrower", borrowerId);
			result.put("lenderId", lenderId.substring(n-4));
			return result;
			
			case "obtenerPagar":
			
			Table table1 = dynamoDB.getTable("relationPay");
			Index index1 = table1.getIndex("numberIdBorrower-index");
			QuerySpec spec1 = new QuerySpec().withProjectionExpression(
					"numberIdBorrower, numberIdMoneylender").withKeyConditionExpression("numberIdBorrower = :_apply")
					.withValueMap(new ValueMap().withString(":_apply", input.getIdAutenticacionAliado()));
			ItemCollection<QueryOutcome> items1 = index1.query(spec1);
			int j = 0;
			System.out.println("\nPage: " +spec1);
			
			System.out.println("\nPage: " +items1);
			for (Page<Item, QueryOutcome> page : items1.pages()) {
				Iterator<Item> iterator = page.iterator();
				// System.out.println("\nPage: " + ++pageNum);
				Item item = null;
				while (iterator.hasNext()) {
					item = iterator.next();
					values.put("" + j, item.toJSONPretty());
					 System.out.println(item.toJSONPretty());
					j++;
				}
			}
			if (values.size()==0) {
				result.put("error","no existe");
				return result;
			}
			int lengthMap2 = values.size();

			for (int k = 0; k < lengthMap2; k++) {
				String hashMap = values.get("" + k).toString();
				
				hashMap = hashMap.replaceAll("=", ":");
				relation = new Gson().fromJson(hashMap, Relation.class);

			}
			System.out.println("\nPage: " +"funciona");
			String borrowerId1= relation.getNumberIdBorrower()==null?"":relation.getNumberIdBorrower();
			String lenderId1= relation.getNumberIdMoneylender()==null?"":relation.getNumberIdMoneylender();
			System.out.println(borrowerId1+" "+lenderId1);
			data=mapper.load(Data.class,borrowerId1);
			if(data==null) {
				data=new Data();
			}
				
			informationPowwi=mapper.load(InformationPowwi.class,borrowerId1);
			if(informationPowwi==null) {
				informationPowwi=new InformationPowwi();
			}
			informationPowwi1=mapper.load(InformationPowwi.class,lenderId1);
			if(informationPowwi1==null) {
				informationPowwi1=new InformationPowwi();
			}
			int m=informationPowwi1.getIdCuenta().length();
			
			result.put("productoDestino",informationPowwi.getIdCuenta().substring(m-4));
			result.put("lineaDestino", data.getCellphone());
			result.put("productoOrigen",informationPowwi1.getIdCuenta());
			result.put("idBorrower", borrowerId1);
			result.put("lenderId", lenderId1.substring(m-4));
			return result;
    	
    	case "datos":
    		
			objectMapper = new ObjectMapper();
			
			values1.put("idAutenticacionAliado", input.getIdAutenticacionAliado());
			values1.put("operacion", "auth");
			try {
				requestBody = objectMapper.writeValueAsString(values1);
			} catch (JsonProcessingException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			System.out.println("datos salida: "+requestBody);
			HttpRequest request = HttpRequest.newBuilder()
					//.uri(URI.create("https://vuwnwhdth3.execute-api.us-east-1.amazonaws.com/ApprobeDev/authpowwi")) // dev
					.uri(URI.create("https://hgarxx9xvb.execute-api.us-east-1.amazonaws.com/ApiApprobe/authpowwi")) // prod
					.setHeader("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
			
			try {
				responsePowwi = client.send(request, HttpResponse.BodyHandlers.ofString());
				mensaje = responsePowwi.body();
				System.out.println("mensaje "+mensaje);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			return "OK";
    	case "datosOtp":
    		
			objectMapper = new ObjectMapper();
			
			values1.put("idAutenticacionAliado", input.getIdAutenticacionAliado());
			values1.put("operacion", "authOtp");
			values1.put("otp", input.getOtp());
			try {
				requestBody = objectMapper.writeValueAsString(values1);
			} catch (JsonProcessingException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			System.out.println("datos salida: "+requestBody);
			HttpRequest requestOtp = HttpRequest.newBuilder()
					//.uri(URI.create("https://vuwnwhdth3.execute-api.us-east-1.amazonaws.com/ApprobeDev/authpowwi")) // dev
					.uri(URI.create("https://hgarxx9xvb.execute-api.us-east-1.amazonaws.com/ApiApprobe/authpowwi")) // prod
					.setHeader("Content-Type", "application/json")
					.POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
			
			try {
				responsePowwi = client.send(requestOtp, HttpResponse.BodyHandlers.ofString());
				mensaje = responsePowwi.body().toString();
				if (mensaje.contains("fail")) {
					return "FAIL";
				}
				System.out.println("mensaje "+mensaje);
			} catch (IOException e2) {
				
				e2.printStackTrace();
			} catch (InterruptedException e2) {
				
				e2.printStackTrace();
			}
			return "OK";
    }
    	
    	return null;
    }
    
}
