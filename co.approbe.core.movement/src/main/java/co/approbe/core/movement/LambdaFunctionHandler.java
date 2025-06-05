package co.approbe.core.movement;

import java.util.logging.Logger;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import co.approbe.core.movement.dao.Movements;


public class LambdaFunctionHandler implements RequestHandler<Movements, Object> {
private static final Logger LOG = Logger.getLogger(LambdaFunctionHandler.class.getName());
	
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDB db = new DynamoDB(client);
	DynamoDBMapper mapper = new DynamoDBMapper(client);

	@Override
	public String handleRequest(Movements movements, Context context) {
		try {
			mapper.save(movements);
			return "ok";
		}catch (Exception e) {
			LOG.severe(e.getMessage());
			return "fail";
		}
    }

}
