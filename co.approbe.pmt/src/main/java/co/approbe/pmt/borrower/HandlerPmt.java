package co.approbe.pmt.borrower;


import java.util.HashMap;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HandlerPmt implements RequestHandler<Request, Object>{
	
	static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
			.withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(client);
	@Override
	public Object handleRequest(Request request, Context context) {
		HashMap<String, Object> response = new HashMap<>(3);
			
		Loan loan=null;
		CreditLine creditLine=null;
		
		switch (request.getHttpMethod()) {
			case "GET":
				creditLine=mapper.load(CreditLine.class, request.getId());
				loan=(request.getLoan());
				
				double rate=(Double.parseDouble(creditLine.getRate())/100 );
				double rateM=(Math.pow((1.0+rate),(1.0/12.0)))-1.0;
				double roundRate=Math.round(rateM*10000.0)/10000.0;
				double fv=loan.getPv() * Math.pow((1 + roundRate), loan.getNper());
				double insuranceValue=(Double.parseDouble(creditLine.getInsurance())/100)*loan.getPv();
				double platformUseValue=(Double.parseDouble(creditLine.getPlatformUse())/100)*loan.getPv();
				double sum=+insuranceValue+platformUseValue;
				double pmt=(fv * roundRate) / ( Math.pow((1 + roundRate), loan.getNper()) - 1)+sum;						
				double roundDbl = Math.round(pmt*100.0)/100.0;
				response.put("pmt", roundDbl);
				response.put("insurance", insuranceValue);
				response.put("platformUse", platformUseValue);
		        return response;
		}
		return null;
	}

}
