package co.approbe.chance.cron;

import java.time.LocalDate;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

public class Handler implements RequestHandler<Request, String> {

	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDB db = new DynamoDB(client);
	DynamoDBMapper mapper = new DynamoDBMapper(client);
	
    @Override
    public String handleRequest(Request request, Context context) {
    	
    	Map<String, String> values = new HashMap<>();
 

		Table table = db.getTable("borrower");
		String hashMap;
		int lengthMap;
		Map<Integer, String> customer = new HashMap<>();
		int i = 0;
		Item item = null;
		
		Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
		expressionAttributeValues.put(":pr", 1);
		ItemCollection<ScanOutcome> items = table.scan("active = :pr", // FilterExpression
				"numberId,active,dateSaveBD", // ProjectionExpression
				null, // ExpressionAttributeNames - not used in this example
				expressionAttributeValues);

		Iterator<Item> iterator = items.iterator();
		
		System.out.println("entra");
		while (iterator.hasNext()) {
			item = iterator.next();
			values.put("" + i, item.toJSONPretty());
			i++;
		}
		
		lengthMap = values.size();
		BasicInformationAdd[] data = new BasicInformationAdd[lengthMap];

		for (int j = 0; j < lengthMap; j++) {
			hashMap = values.get("" + j).toString();
			hashMap = hashMap.replaceAll("=", ":");
			data[j] = new Gson().fromJson(hashMap, BasicInformationAdd.class);
			customer.put(j, hashMap);

			String fecha;
			fecha=data[j].getDateSaveBD() == null ? "01/01/2022 08:30:40"
					:data[j].getDateSaveBD();
		
			LocalDate  aprobacion= LocalDate.parse(fecha,request.getNowDate()); 
			Duration diff = Duration.between(aprobacion.atStartOfDay(), request.getActualdate().atStartOfDay());
			
			long diffDays = diff.toDays();
			
			System.out.println(diffDays);
		// comparo si la diferencia es mayor a 90 dias y cambio el active,
			
			if(diffDays>89) {
				data[j].setActive(7);
				mapper.save(data[j]);
			}
		}
		
        
        return "Cambio exitoso";
    }

}
