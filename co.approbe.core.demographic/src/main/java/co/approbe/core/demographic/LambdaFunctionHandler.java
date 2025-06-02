package co.approbe.core.demographic;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import co.approbe.core.demographic.dao.Demographic;


public class LambdaFunctionHandler implements RequestHandler<Demographic, String> {
	
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDB db = new DynamoDB(client);
	DynamoDBMapper mapper = new DynamoDBMapper(client);
    @Override
    public String handleRequest(Demographic demographic, Context context) {
        context.getLogger().log("Input: " + demographic);
        try {
        	  mapper.save(demographic);
              return "ok";	
        }catch(Exception e) {
        	return "fail";
        }
      
    }

}
