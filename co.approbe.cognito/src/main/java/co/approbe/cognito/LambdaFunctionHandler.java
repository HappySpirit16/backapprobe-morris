package co.approbe.cognito;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
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

public class LambdaFunctionHandler implements RequestHandler<Request, Object> {
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDB dynamoDB = new DynamoDB(client);
	

	@Override
	public Object handleRequest(Request request, Context context) {
		Map<Integer, String> values = new HashMap<>();
		Map<String, String> response = new HashMap<>();
		Map<String, String> expressionNames = new HashMap<>();
		String cognito ="";
		Table table=null;
		Index index=null;
		ItemCollection<QueryOutcome> items = null;
		QuerySpec spec=null;
		int i = 0;
		switch (request.getHttpMethod()) {
		case "GET":
			
			cognito = request.getCognitoId();
			expressionNames.put("#n", "names");
			expressionNames.put("#ln", "lastName");
			table = dynamoDB.getTable("borrower");
			index = table.getIndex("active-index");
			spec = new QuerySpec().withProjectionExpression("numberId,#n,#ln")
					.withNameMap(expressionNames).withFilterExpression("cognitoId = :_cognito")
					.withKeyConditionExpression("active = :_apply")
					.withValueMap(new ValueMap().withNumber(":_apply", 1).withString(":_cognito", cognito));
			items = index.query(spec);
			i = 0;
			for (Page<Item, QueryOutcome> page : items.pages()) {

				Iterator<Item> iterator = page.iterator();
				// System.out.println("\nPage: " + ++pageNum);
				Item item = null;

				while (iterator.hasNext()) {

					item = iterator.next();
					values.put(i, item.toJSONPretty());
					// System.out.println(item.toJSONPretty());
					i++;
				}
			}
			return values;
			
		case "GETAWARD":
			cognito = request.getCognitoId();
			expressionNames.put("#n", "names");
			expressionNames.put("#ln", "lastName");
			table = dynamoDB.getTable("award");
			index = table.getIndex("active-index");
			spec = new QuerySpec().withProjectionExpression("numberId,#n,#ln")
					.withNameMap(expressionNames).withFilterExpression("cognitoId = :_cognito")
					.withKeyConditionExpression("active = :_apply")
					.withValueMap(new ValueMap().withNumber(":_apply", 1).withString(":_cognito", cognito));
			items = index.query(spec);
			i = 0;
			for (Page<Item, QueryOutcome> page : items.pages()) {

				Iterator<Item> iterator = page.iterator();
				// System.out.println("\nPage: " + ++pageNum);
				Item item = null;

				while (iterator.hasNext()) {

					item = iterator.next();
					values.put(i, item.toJSONPretty());
					// System.out.println(item.toJSONPretty());
					i++;
				}
			}
			return values;
		}
		return null;
	}
}