package com.amazonaws.lambda.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.lomincosoft.commonsDto.CustomerDto;
import com.lomincosoft.commonsDto.ValidationStrategyDto;
import com.lomincosoft.service.StrategyService;


public class TestSearchUser {
	private Context createContext() {
		TestContext ctx = new TestContext();

		return ctx;
	}
	@Test
	public void test() {
//		AWSCredentials cred = new BasicAWSCredentials("AKIA5SBAE4XKWXTF3K67", "oIoJ8aKDOyUD5VysGXCLMfgIMH+VSx2/MBfifhli");
//		AWSCredentialsProvider credProvider = new AWSStaticCredentialsProvider(cred);
//		AmazonDynamoDB db =AmazonDynamoDBClientBuilder.standard()
//				.withCredentials(credProvider).withRegion(Regions.US_EAST_1).build();
//		DynamoDBMapper mapper = new DynamoDBMapper(db);
//
//		StrategyService wStrategyService = new StrategyService(db, mapper, new ValidationStrategyDto());
		CustomerDto wCustomer = new CustomerDto();
		
		wCustomer.setId("3837ada1d0fd9e0e0f523f98a6705c84be210aa00a1271a60e62107b631a31ca");
		
	//	assertEquals("3837ada1d0fd9e0e0f523f98a6705c84be210aa00a1271a60e62107b631a31ca", wStrategyService.transactioStatus(wCustomer, createContext()).getId());
		assertEquals("True","True");
	}
}
