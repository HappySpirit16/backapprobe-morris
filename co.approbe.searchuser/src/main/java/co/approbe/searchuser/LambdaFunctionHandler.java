package co.approbe.searchuser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;


public class LambdaFunctionHandler implements RequestHandler<Request, Object> {
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDB db = new DynamoDB(client);
	DynamoDBMapper mapper = new DynamoDBMapper(client);
	
    @Override
    public Object handleRequest(Request request, Context context) {
    	Map<String, String> values = new HashMap<>();
		switch (request.getHttpMethod()) {
		case "GET":
			Table tableUser = db.getTable("userInformation");
			String hashMapU;
			int lengthMap;
			Map<Integer, String> customerUser = new HashMap<>();
			int y = 0;
			Item itemUser = null;
			Map<String, Object> expressionAttributeValuesUser = new HashMap<String, Object>();
			
			expressionAttributeValuesUser.put(":email", request.getEmail());
			ItemCollection<ScanOutcome> itemsUser = tableUser.scan("email = :email", // FilterExpression
					"numberId", // ProjectionExpression
					null, // ExpressionAttributeNames - not used in this example
					expressionAttributeValuesUser);
			
			Iterator<Item> iteratorUser = itemsUser.iterator();
			while (iteratorUser.hasNext()) {
				itemUser = iteratorUser.next();
				values.put("" + y, itemUser.toJSONPretty());
				System.out.println(itemUser.toJSONPretty());
				y++;
			}
			
			lengthMap = values.size();
			UserInformation user0=new UserInformation();
			if(lengthMap>0) {
				UserInformation [] user=new  UserInformation [lengthMap];
			    
				for (int j = 0; j < lengthMap; j++) {
					hashMapU = values.get("" + j).toString();
					hashMapU = hashMapU.replaceAll("=", ":");
					user[j] = new Gson().fromJson(hashMapU,UserInformation.class);
					customerUser.put(j, hashMapU);
				}
				    System.out.println(lengthMap);
				    String cedula= user[0].getNumberId();
				   user0= mapper.load(UserInformation.class, cedula);
			}else {
				  System.out.println("entro al else");
				Map<String, String> values1 = new HashMap<>();
				int x=0;
				String hashMap1;
				int lengthMap1;
				Map<Integer, String> customerUser1 = new HashMap<>();
				Item itemUser1 = null;
				Map<String, Object> expressionAttributeValuesUser1 = new HashMap<String, Object>();
				
				if(request.getRol()==1) {
					Table tableUser1 = db.getTable("borrower");
					expressionAttributeValuesUser1.put(":Email", request.getEmail());
					ItemCollection<ScanOutcome> itemsUser1 = tableUser1.scan("email = :Email", // FilterExpression
							"numberId,lastName", // ProjectionExpression
							null, // ExpressionAttributeNames - not used in this example
							expressionAttributeValuesUser1);

					Iterator<Item> iteratorUser1 = itemsUser1.iterator();
					while (iteratorUser1.hasNext()) {
						itemUser1 = iteratorUser1.next();
						values1.put("" + x, itemUser1.toJSONPretty());
						System.out.println(itemUser1.toJSONPretty());
						x++;
					}

					lengthMap1 = values1.size();
					System.out.println(lengthMap1);
					if (lengthMap1 > 0) {
						Borrower[] user = new Borrower[lengthMap1];
						Borrower user1 = new Borrower();
						for (int j = 0; j < lengthMap1; j++) {
							hashMap1 = values1.get("" + j).toString();
							hashMap1 = hashMap1.replaceAll("=", ":");
							user[j] = new Gson().fromJson(hashMap1, Borrower.class);
							customerUser1.put(j, hashMap1);
						}
						String cedula1= user[0].getNumberId();
						System.out.println(cedula1);
						user1=mapper.load(Borrower.class, cedula1);
						
						String companyName;
						String companyActivity;
						String position;
						String companyPhone;
						String companyAddress;
						
						System.out.println(user1.getCreditInformation().getProfession().getProfession());
						if (!user1.getCreditInformation().getProfession().getProfession().equals("empleado")) {
							System.out.println("entra aqui en if");
							companyName = "";
							companyActivity = "";
							position = "";
							companyPhone = "";
							companyAddress = "";

						}else {
							System.out.println("entra aqui en else");
							companyName =user1.getCreditInformation().getLaborInformation().getCompanyName();
							companyActivity =user1.getCreditInformation().getLaborInformation().getCompanyActivity().getActivity().getDescription();
							position = user1.getCreditInformation().getLaborInformation().getPosition();
							companyPhone =user1.getCreditInformation().getLaborInformation().getCompanyPhone();
							companyAddress =user1.getCreditInformation().getLaborInformation().getAddress();
						}
						
						user0.setNumberId(cedula1);
						user0.setNames(user1.getNames());
						user0.setLastName(user1.getLastName());
						user0.setGender(user1.getGender());
						user0.setCellphone(user1.getCellphone());
						user0.setEmail(user1.getEmail());
						user0.setGeneralInformation(user1.getGeneralInformation());
						user0.setReference(user1.getReference());
						user0.setFinancialInformation(user1.getFinancialInformation());
						user0.setCreditInformation(user1.getCreditInformation());
						user0.setCompanyName(companyName);
						user0.setCompanyActivity(companyActivity);
						user0.setPosition(position);
						user0.setCompanyAddress(companyAddress);
						user0.setCompanyPhone(companyPhone);
	
						user0.setCompanySeniority(0);
						
				
	
					}
					
					
				}
				
				// esto se puede quitar despues de actulizar los datos de los clientes anteriores a 05/09/2022
				
				if(request.getRol()==2) {
					System.out.println("1");
					Table tableUser1 = db.getTable("award");
					expressionAttributeValuesUser1.put(":Email", request.getEmail());
					ItemCollection<ScanOutcome> itemsUser1 = tableUser1.scan("email = :Email", // FilterExpression
							"numberId", // ProjectionExpression
							null, // ExpressionAttributeNames - not used in this example
							expressionAttributeValuesUser1);

					Iterator<Item> iteratorUser1 = itemsUser1.iterator();
					while (iteratorUser1.hasNext()) {
						itemUser1 = iteratorUser1.next();
						values1.put("" + x, itemUser1.toJSONPretty());
						System.out.println(itemUser1.toJSONPretty());
						x++;
					}

					lengthMap1 = values1.size();
					System.out.println("tiene : "+lengthMap1);
					if (lengthMap1 > 0) {
						Award[] user = new Award[lengthMap1];
						Award user1 = new Award();
						for (int j = 0; j < lengthMap1; j++) {
							hashMap1 = values1.get("" + j).toString();
							hashMap1 = hashMap1.replaceAll("=", ":");
							user[j] = new Gson().fromJson(hashMap1, Award.class);
							customerUser1.put(j, hashMap1);
						}
						String cedula1= user[0].getNumberId();
						System.out.println("la cedula es:"+cedula1);
						user1=mapper.load(Award.class, cedula1);
						
						user0.setNumberId(cedula1);
						user0.setNames(user1.getNames());
						user0.setLastName(user1.getLastName());
						user0.setGender(user1.getGender());
						user0.setCellphone(user1.getCellphone());
						user0.setEmail(user1.getEmail());
//						user0.setCompanyName(user1.getEconomicActivity().getCompany());
//						user0.setCompanyActivity(user1.getEconomicActivity().getCompanyActivity().getDescription());
//						user0.setPosition(user1.getEconomicActivity().getPosition());
//						user0.setCompanyAddress(user1.getEconomicActivity().getAddress());
//						user0.setCompanyPhone(user1.getEconomicActivity().getPhone());
//						user0.setGeneralInformationAward(user1.getGeneralInformation());
//						user0.setCompanySeniority(0);			
					}
					
				}
				mapper.save(user0);
			}
		    // hasta aqui se debe borrar
			   
			return user0;
		}
        return null;
    }

}
