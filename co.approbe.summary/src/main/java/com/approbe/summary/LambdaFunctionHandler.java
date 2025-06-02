package com.approbe.summary;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Request , Object> {
	static Logger logger = LoggerFactory.getLogger(LambdaFunctionHandler.class);
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
			.withRegion(Regions.US_EAST_1).build();
	DynamoDB dynamoDB = new DynamoDB(client);
	DynamoDBMapper mappera = new DynamoDBMapper(client);
	@Override
	public Object handleRequest(Request request, Context context) {
		//int length=request.getId().length;
		String idBorrower ="";
        final String claveEncriptacion = "approbe!";         
        EncriptadorAES encriptador = new EncriptadorAES();
		logger.info(request.toString());
		String number=request.getId();	
		
		JSONArray array = new JSONArray(number);
		String[] numbersId=new String[array.length()];
		for(int i=0; i < array.length(); i++)   
		{  
			JSONObject object = array.getJSONObject(i);  
			numbersId[i]=(object.getString("numberId"));
		}
		CreditLine creditLine=new CreditLine();
		creditLine=mappera.load(CreditLine.class, 1);
		BasicInformation basicInformation=new BasicInformation();
    	Map<String,Object> customer = new HashMap<>();
    	double totalCost=0d;
        for (int i=0;i<array.length();i++) {
        	try {
                idBorrower = encriptador.desencriptar( numbersId[i], claveEncriptacion);
            } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
            	logger.error(ex.getMessage());
            }
        	basicInformation=(mappera.load(BasicInformation.class, idBorrower));
        	totalCost+=basicInformation.getApproveValue(); 
        	 
        }
        double serviceFee=(creditLine.getCommission()/100d)/100d;
        logger.info("serviceFee: "+serviceFee);
        double tax=(creditLine.getTax()/100d)/100d;
        logger.info("tax: "+tax);
        double valueCommision=serviceFee*(double)totalCost;
        logger.info("valuecom: "+valueCommision);
        double valueCommisionTax=(valueCommision*tax)+valueCommision;
        double totalPayment=totalCost+(valueCommisionTax)+(Double.parseDouble(creditLine.getPlatformUse())*totalCost)
        		+(((creditLine.getAdministrationCredit()/100)/100)*totalCost);
       
        customer.put("totalCost",totalCost);
        customer.put("serviceFee",valueCommisionTax);
        customer.put("aval",creditLine.getAval()/100d);
        customer.put("platformUse",creditLine.getPlatformUse());//# en porcentaje
        customer.put("administrationCredit",creditLine.getAdministrationCredit()/100d);
        customer.put("totalPayment",(Math.round(totalPayment * 100.0) / 100.0));
        return customer;
    }

}
