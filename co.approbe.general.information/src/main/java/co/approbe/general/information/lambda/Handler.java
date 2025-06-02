package co.approbe.general.information.lambda;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Handler implements RequestHandler<Request, Object> {
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
			.withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(client);
	@Override
	public Object handleRequest(Request request, Context context) {
			Information generalInformation=null;
			switch (request.getHttpMethod()) {
				case "GET":
					generalInformation=mapper.load(Information.class, request.getId());
					return generalInformation;
				case "POST":
					generalInformation= request.getPrueba();
					mapper.save(generalInformation);
					return generalInformation;
				case "Cities":
					System.out.println("Entra"+request.getDepartament());
					Cities cities=new Cities(); 
					cities=mapper.load(Cities.class,request.getDepartament());
			
					Collections.sort(cities.getCity());
					System.out.println(cities.toString());
					Map<String,Integer> idCities=new HashMap<>();
					
					CitiesSort[] citiesSort=new CitiesSort[cities.getCity().size()];
					
					for(int i=0;i<cities.getCity().size();i++) {
						
						citiesSort[i]=new CitiesSort(i,cities.getCity().get(i));

					}
					System.out.println(idCities);
				return citiesSort;
			}
		return null;
	}

}
