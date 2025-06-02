package co.approbe.processactive;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import co.approbe.processactive.dao.BasicInformationAdd;
import co.approbe.processactive.dao.Credit;
import co.approbe.processactive.dao.RelationPay;
import co.approbe.processactive.dto.Borrower;
import co.approbe.processactive.dto.Loan;
import co.approbe.processactive.dto.Request;

public class LambdaFunctionHandler implements RequestHandler<Request, Object> {

	private static final Logger LOG = Logger.getLogger(LambdaFunctionHandler.class.getName());

	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDB db = new DynamoDB(client);
	DynamoDBMapper mapper = new DynamoDBMapper(client);

	@Override
	public List<?> handleRequest(Request request, Context context) {
		Map<String, String> values = new HashMap<>();
		switch (request.getHttpMethod()) {
		case "GET":
			Table table = db.getTable("borrower");

			String hashMap;
			int lengthMap1;
			Map<Integer, String> customer = new HashMap<>();
			int i = 0;
			Item item = null;

			Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
			expressionAttributeValues.put(":pr", request.getEmail());

			ItemCollection<ScanOutcome> items = table.scan("email = :pr", // FilterExpression
					"numberId,active,dateActive1,dateActive4,dateActive5,dateActive6,dateActive7,dateSaveBD,feesApprobe,rateApprobe,approveValue,creditInformation", // ProjectionExpression
					null, // ExpressionAttributeNames - not used in this example
					expressionAttributeValues);

			Iterator<Item> iterator = items.iterator();

			System.out.println("entra");
			while (iterator.hasNext()) {
				item = iterator.next();
				values.put("" + i, item.toJSONPretty());
				LOG.info(item.toJSONPretty());
				i++;
			}

			lengthMap1 = values.size();
			Borrower[] data = new Borrower[lengthMap1];
			String purpuse;

			for (int j = 0; j < lengthMap1; j++) {
				hashMap = values.get("" + j).toString();
				hashMap = hashMap.replaceAll("=", ":");
				data[j] = new Gson().fromJson(hashMap, Borrower.class);
				customer.put(j, hashMap);
				purpuse = data[j].getCreditInformation();
				purpuse = purpuse.substring(purpuse.indexOf("purpose") + 32, purpuse.indexOf("}") - 1);
				data[j].setCreditInformation(purpuse);

			}

			Arrays.sort(data);
			return Arrays.asList(data);

		case "Borrower":
			Table tableBorrower = db.getTable("credit");
			String hashMapB;
			int lengthMapB;
			Map<Integer, String> customerB = new HashMap<>();
			int b = 0;
			Item itemB = null;

			Map<String, Object> expressionAttributeValuesB = new HashMap<String, Object>();
			expressionAttributeValuesB.put(":pr", request.getNumberId());

			ItemCollection<ScanOutcome> itemsB = tableBorrower.scan("numberIdBorrower = :pr", // FilterExpression
					"id,fechaAprobacion,lastPaymentDate,saldoCredito,plannerPay,approveValue,rateApprobe,feesApprobe,gainAprrobe,statusCredit,feesPaid,nextFeesDate,nextPaid,Rentabilidad,balancePaid", // ProjectionExpression
					null, // ExpressionAttributeNames - not used in this example
					expressionAttributeValuesB);

			Iterator<Item> iteratorB = itemsB.iterator();
			while (iteratorB.hasNext()) {
				itemB = iteratorB.next();
				values.put("" + b, itemB.toJSONPretty());
				LOG.info(itemB.toJSONPretty());
				b++;
			}

			lengthMapB = values.size();
			if (lengthMapB > 0) {
				Credit[] dataB = new Credit[lengthMapB];

				for (int j = 0; j < lengthMapB; j++) {
					hashMapB = values.get("" + j).toString();
					hashMapB = hashMapB.replaceAll("=", ":");
					dataB[j] = new Gson().fromJson(hashMapB, Credit.class);
					customerB.put(j, hashMapB);
				}

				if (dataB[0].getStatusCredit() == (1) && dataB[0].getPlannerPay().equals("sinDatos")) {

					Loan loan1 = new Loan();
					loan1.setFees(dataB[0].getFeesApprobe());
					loan1.setValue(dataB[0].getApproveValue());

					HashMap<String, Object> values1 = new HashMap<>();
					values1.put("id", 1);
					values1.put("rate", dataB[0].getRateApprobe());
					values1.put("idRelationPay", dataB[0].getId());
					values1.put("httpMethod", "PAGOS");
					values1.put("fechaAprobacion", dataB[0].getFechaAprobacion());
					values1.put("loan", loan1);

					LOG.info("la salida es: " + values1);

					try {

						ObjectMapper objectMapper = new ObjectMapper();
						String requestBody;
						String responseaCredit = "";
						requestBody = objectMapper.writeValueAsString(values1);
						System.out.println("datos salida: " + requestBody);
						HttpClient clientCredit = HttpClient.newHttpClient();
						HttpRequest requestaCredit = HttpRequest.newBuilder()
								//.uri(URI.create(
								//"https://vuwnwhdth3.execute-api.us-east-1.amazonaws.com/ApprobeDev/simulatorloan")) // dev
								 .uri(URI.create("https://hgarxx9xvb.execute-api.us-east-1.amazonaws.com/ApiApprobe/simulatorloan"))
								// //prod
								.setHeader("Content-Type", "application/json")
								.POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();
						HttpResponse<String> response = clientCredit.send(requestaCredit,
								HttpResponse.BodyHandlers.ofString());

						responseaCredit = response.body();
						LOG.info(responseaCredit);
						dataB[0].setPlannerPay(responseaCredit);
						System.out.println(dataB[0].getPlannerPay());
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
						LOG.severe(e.getMessage());
					}

				}
				return Arrays.asList(dataB);
			} else
				return null;

		case "Award":
			Table tableAward = db.getTable("credit");
			String hashMapA;
			int lengthMapA;
			Map<Integer, String> customerA = new HashMap<>();
			int a = 0;
			Item itemA = null;

			Map<String, Object> expressionAttributeValuesA = new HashMap<>();
			expressionAttributeValuesA.put(":pr", request.getNumberId());

			ItemCollection<ScanOutcome> itemsA = tableAward.scan("numberIdMoneylender = :pr", // FilterExpression
					"id,approveValue,rateApprobe,feesApprobe,gainAprrobe,statusCredit,feesPaid,nextFeesDate,nextPaid,Rentabilidad,balancePaid", // ProjectionExpression
					null, // ExpressionAttributeNames - not used in this example
					expressionAttributeValuesA);

			Iterator<Item> iteratorA = itemsA.iterator();
			while (iteratorA.hasNext()) {
				itemA = iteratorA.next();
				values.put("" + a, itemA.toJSONPretty());
				LOG.info(itemA.toJSONPretty());
				a++;
			}

			lengthMapA = values.size();
			Credit[] dataA = new Credit[lengthMapA];

			for (int j = 0; j < lengthMapA; j++) {
				hashMapA = values.get("" + j).toString();
				hashMapA = hashMapA.replaceAll("=", ":");
				dataA[j] = new Gson().fromJson(hashMapA, Credit.class);
				customerA.put(j, hashMapA);
			}

			return List.of(dataA).stream().filter(credit -> credit.getStatusCredit() == (1))
					.collect(Collectors.toList());

		case "AwardStatus0":
			Table tableAward0 = db.getTable("relationPay");
			String hashMapA0;
			int lengthMapA0;
			Map<Integer, String> customerA0 = new HashMap<>();
			int a0 = 0;
			Item itemA0 = null;

			Map<String, Object> expressionAttributeValuesA0 = new HashMap<>();
			expressionAttributeValuesA0.put(":pr", request.getNumberId());

			ItemCollection<ScanOutcome> itemsA0 = tableAward0.scan("numberIdMoneylender = :pr", // FilterExpression
					"id,gender,dateSaveBD,numberIdBorrower,fechaAprobacion,activityBorrower,approveValue,nameBorrower,ranking,active,rateApprobe,feesApprobe,gainAprrobe,statusCredit,feesPaid,nextFeesDate,nextPaid,Rentabilidad,balancePaid", // ProjectionExpression
					null, // ExpressionAttributeNames - not used in this example
					expressionAttributeValuesA0);

			Iterator<Item> iteratorA0 = itemsA0.iterator();
			while (iteratorA0.hasNext()) {
				itemA0 = iteratorA0.next();
				values.put("" + a0, itemA0.toJSONPretty());
				System.out.println(itemA0.toJSONPretty());
				a0++;
			}

			lengthMapA0 = values.size();
			RelationPay[] dataA0 = new RelationPay[lengthMapA0];

			for (int j = 0; j < lengthMapA0; j++) {
				hashMapA0 = values.get("" + j).toString();
				hashMapA0 = hashMapA0.replaceAll("=", ":");
				dataA0[j] = new Gson().fromJson(hashMapA0, RelationPay.class);
				customerA0.put(j, hashMapA0);
			}

			return List.of(dataA0).stream().filter(relationPay -> relationPay.getStatusCredit() == (0))
					.collect(Collectors.toList());

		case "Desembolso":

			LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.of("-05:00"));
			DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("ddMMyyyy");
			DateTimeFormatter dtformat2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			String date2 = dateTime.format(dtformat2);
			String date = dateTime.format(dtformat);

			RelationPay relationPay = mapper.load(RelationPay.class, request.getId());

			BasicInformationAdd borrowerUpdate = mapper.load(BasicInformationAdd.class,
					relationPay.getNumberIdBorrower());
			borrowerUpdate.setActive(6);
			borrowerUpdate.setDateActive6(date2);
			borrowerUpdate.setDateLastUpdate(date2);
			mapper.save(borrowerUpdate);

			relationPay.setStatusCredit(1);
			relationPay.setActive(6);
			mapper.save(relationPay);
			int m=relationPay.getNumberIdBorrower().length();
			String id = relationPay.getNumberIdMoneylender() + date+relationPay.getNumberIdBorrower().substring(m-4);

			ObjectMapper mapper1 = new ObjectMapper();
			mapper1.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			Credit credit = mapper1.convertValue(relationPay, Credit.class);
			credit.setId(id);
			credit.setWarranty(relationPay.getId());
			mapper.save(credit);

			List<Credit> response = new ArrayList<>();

			response.add(credit);

			return response;

		}

		return null;
	}

}
