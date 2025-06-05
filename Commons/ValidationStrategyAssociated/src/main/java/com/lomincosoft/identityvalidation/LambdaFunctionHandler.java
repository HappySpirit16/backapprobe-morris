package com.lomincosoft.identityvalidation;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lomincosoft.commonsDto.CustomerDto;
import com.lomincosoft.commonsDto.ValidationStrategyDto;
import com.lomincosoft.service.StrategyService;


public class LambdaFunctionHandler implements RequestHandler<CustomerDto, Object> {

	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);
	ValidationStrategyDto validationStrategy;
	
	
	private static final String CREATE_TRANSACTION = "CREATE_TRANSACTION";
	private static final String CREATE_TRANSACTION_EMBEDDED = "CREATE_TRANSACTION_EMBEDDED";
	private static final String TRANSACTION_STATUS = "TRANSACTION_STATUS";
	public static final String ERROR_IDENTITY_VALIDATION = "ERROR_IDENTITY_VALIDATION";
	
	public static final String OK = "OK";
	private static final String ACTION_ERROR = "ACTION_ERROR";

	HttpClient client = HttpClient.newHttpClient();	
	HttpResponse<String> response;
	String messageBodyReconocerOrEvidente = "";
	public Object handleRequest(CustomerDto pCustomer, Context context) {
		context.getLogger().log("Customer: " + pCustomer.toString());
		validationStrategy = new ValidationStrategyDto();
		StrategyService wStrategyService = new StrategyService(db, mapper, validationStrategy);
		context.getLogger().log("StrategyPattern: " +pCustomer.getActionStrategyPattern());
		if (pCustomer.getActionStrategyPattern() == null) {
			validationStrategy.setValidationStrategy(ACTION_ERROR);
		} else {
			switch (pCustomer.getActionStrategyPattern()) {
			case CREATE_TRANSACTION:
				return wStrategyService.getStrategy(pCustomer, context);
			case CREATE_TRANSACTION_EMBEDDED:
				return wStrategyService.getStrategyWallet(pCustomer, context);
			case TRANSACTION_STATUS:
				return wStrategyService.transactioStatus(pCustomer, context);
			default:
				validationStrategy.setValidationStrategy(ACTION_ERROR);
			}
		}
		context.getLogger().log("Respuesta: "+validationStrategy.toString());
		return validationStrategy;
    }

}
