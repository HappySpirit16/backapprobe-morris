package co.approbe.status.relation;

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
import com.google.gson.Gson;

public class Handler implements RequestHandler<Request, String> {
	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);
	DynamoDB dynamoDB = new DynamoDB(db);
    @Override
    public String handleRequest(Request input, Context context) {
        context.getLogger().log("Input: " + input);
        String numberId="";
        RelationPay relation=new RelationPay();
        RelationPay relation1=new RelationPay();
        String numberCredit="";
        numberId=input.getNumberId();
		Map<String, Object> values = new HashMap<>();
		Table table = dynamoDB.getTable("relationPay");
		Index index = table.getIndex("numberIdBorrower-index");
		QuerySpec spec = new QuerySpec().withProjectionExpression("numberIdBorrower, id, numberIdMoneylender")
				.withKeyConditionExpression("numberIdBorrower = :_apply")
				.withValueMap(new ValueMap().withString(":_apply", numberId));
		ItemCollection<QueryOutcome> items = index.query(spec);
		int i = 0;
		for (Page<Item, QueryOutcome> page : items.pages()) {
			Iterator<Item> iterator = page.iterator();
			// System.out.println("\nPage: " + ++pageNum);
			Item item = null;
			while (iterator.hasNext()) {
				item = iterator.next();
				values.put("" + i, item.toJSONPretty());
				i++;
			}
		}
		if (values.size() == 0) {

		}
		int lengthMap1 = values.size();

		for (int j = 0; j < lengthMap1; j++) {
			String hashMap = values.get("" + j).toString();
			hashMap = hashMap.replaceAll("=", ":");
			relation = new Gson().fromJson(hashMap, RelationPay.class);
			context.getLogger().log("relation: " + relation.toString());
		}
		numberCredit = relation.getId();
        switch (input.getType()) {
        case "pendienteFirmas":
			numberId=input.getNumberId();
			relation1=mapper.load(RelationPay.class, numberCredit);
			relation1.setActive(2);
			mapper.save(relation1);
		return "ok";
        case "desembolso":
			numberId=input.getNumberId();
			relation1=mapper.load(RelationPay.class, numberCredit);
			relation1.setActive(6);
			relation1.setStatusCredit(1);
			mapper.save(relation1);
		return "ok";
		case "deudor":
			relation1=mapper.load(RelationPay.class, numberCredit);
			if(relation1.getActive()>2.9 && relation1.getActive()<3.1)
				relation1.setActive(5);
			else relation1.setActive(4);
			mapper.save(relation1);
        return "ok";
		case "financiador":
			numberId=input.getNumberId();
			relation1=mapper.load(RelationPay.class, numberCredit);
			if(relation1.getActive()>3.9 && relation1.getActive()<4.1)
				relation1.setActive(5);
			else relation1.setActive(3);
			mapper.save(relation1);
	    return "ok";
		case "declinar":
			numberId=input.getNumberId();
			relation1=mapper.load(RelationPay.class, numberCredit);
			relation1.setActive(7);
			mapper.save(relation1);
		return "ok";
		case "estado":
			numberId=input.getNumberId();
			relation1=mapper.load(RelationPay.class, numberCredit);
		return ""+(int)relation1.getActive();
        }
        return null;
    }

}
