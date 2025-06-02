package co.approbe.additional.information.borrower;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Request, Object> {
	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);
    @Override
    public String handleRequest(Request request, Context context) {
    	BasicInformation basicInformation=null;
    	Borrower borrower=new Borrower();
		Log log=new Log();
		switch (request.getHttpMethod()) {
		case "POST":
			basicInformation= request.getBasicInformation();
			borrower.setApproveValue(basicInformation.getApproveValue());
			borrower.setNumberId(basicInformation.getNumberId());
			borrower.setRanking(basicInformation.getRanking());
			borrower.setScore(basicInformation.getScore());
			borrower.setCapacity(basicInformation.getCapacity());
			borrower.setFeePlan(basicInformation.getFeePlan());
			borrower.setFeesApprobe(basicInformation.getFees());
			borrower.setPercentageCapacity(basicInformation.getPercentageCapacity());
			borrower.setRateApprobe(basicInformation.getRate());
			borrower.setScoreAcierta(basicInformation.getScoreAcierta());
			try {
	            final String claveEncriptacion = "approbe!";            
	            String datosOriginales = basicInformation.toString();            
	            
	            EncriptadorAES encriptador = new EncriptadorAES();
	            
	            String encriptado = encriptador.encriptar(datosOriginales, claveEncriptacion);
	            log.setInformation(encriptado);         
	            mapper.save(log);
	        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
	           System.out.println("error"+ex);
	        	// Logger.getLogger(EncriptadorAES.class.getName()).log(Level.SEVERE, null, ex);
	        }
			mapper.save(borrower);
			return "ok";
		}
	return null;
    }

}