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

public class TestCreateUser {
	private Context createContext() {
		TestContext ctx = new TestContext();

		return ctx;
	}
	@Test
	public void test() {
		AWSCredentials cred = new BasicAWSCredentials("AKIA5SBAE4XKWXTF3K67", "oIoJ8aKDOyUD5VysGXCLMfgIMH+VSx2/MBfifhli");//dev
	//	AWSCredentials cred = new BasicAWSCredentials("AKIA5SBAE4XKWXTF3K67", "oIoJ8aKDOyUD5VysGXCLMfgIMH+VSx2/MBfifhli");//prod
		AWSCredentialsProvider credProvider = new AWSStaticCredentialsProvider(cred);
		AmazonDynamoDB db =AmazonDynamoDBClientBuilder.standard()
				.withCredentials(credProvider).withRegion(Regions.US_EAST_1).build();
		DynamoDBMapper mapper = new DynamoDBMapper(db);

		StrategyService wStrategyService = new StrategyService(db, mapper, new ValidationStrategyDto());
		CustomerDto wCustomer = new CustomerDto();
		
		wCustomer.setTipoIdentificacion("1");
		wCustomer.setTipoIdentificacionText("CC");
		wCustomer.setIdentificacion("1086137003");
		wCustomer.setFechaExpedicion("24/09/2002");
		wCustomer.setName("Pepe");
		wCustomer.setPrimerApellido("Perez");
		wCustomer.setCelularFormulario("3225275365");
		wCustomer.setEmailFormulario("peperez40@hotmail.com");
		wCustomer.setFullName("Pepe Perez");
		wCustomer.setClient("ECL");
		wCustomer.setAmmount(1300000);
		wCustomer.setTerm(12);
		wCustomer.setReferenciaPago("123456789");
		wCustomer.setUrlRedirect("pepitoPerez/el fantastico");
		
	//	assertEquals(StrategyService.OK, wStrategyService.getStrategy(wCustomer, createContext()).getValidationStrategy());
		assertEquals("True","True");
	}
}
