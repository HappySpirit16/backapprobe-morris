package co.approbe.create.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.Page;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.google.gson.Gson;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;

public class Handler implements RequestHandler<Request, List<Object>> {
	AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
			.withCredentials(DefaultAWSCredentialsProviderChain.getInstance()).build();
	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);
	private final AmazonSimpleEmailService client;
	DynamoDB dynamoDB = new DynamoDB(db);

	public Handler() {
		this.client = AmazonSimpleEmailServiceClientBuilder.standard().build();
	}

	@Override
	public List<Object> handleRequest(Request input, Context context) {
		String idBorrower ="";
        final String claveEncriptacion = "approbe!";         
        EncriptadorAES encriptador = new EncriptadorAES();
		List<Object> pdfByte = new ArrayList<Object>();
		PdfStructure promissory=new PdfStructure();
		PdfStructure power=new PdfStructure();
		PdfStructure mutualContract=new PdfStructure();
		PdfStructure contractAward=new PdfStructure();
		PdfStructure authorizationAward=new PdfStructure();
		PdfStructure authorizationBorrower=new PdfStructure();
		RelationPay relation = new RelationPay();
		context.getLogger().log("Input: " + input);
		String bucketName = Env.BUCKETS3;
		String key = "approbe.png";
		DocsUser docsUser = new DocsUser();
		S3Object s3Object = s3Client.getObject(bucketName, key);
		String numberCredit = "";
		String numberId = "";
		String name = "";
		String address ="";
		String phone = "";
		String lenderId="";
		String nameLender="";
		String bucketName1 = Env.BUCKETS3;
		String key1 = "approbe1.png";

		S3Object s3Object1 = s3Client.getObject(bucketName1, key1);

		byte[] buffer = new byte[4096];
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try (S3ObjectInputStream s3ObjectInputStream = s3Object.getObjectContent()) {

			int bytesRead;
			while ((bytesRead = s3ObjectInputStream.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		ByteArrayOutputStream output1 = new ByteArrayOutputStream();
		try (S3ObjectInputStream s3ObjectInputStream1 = s3Object1.getObjectContent()) {

			int bytesRead1;
			while ((bytesRead1 = s3ObjectInputStream1.read(buffer)) != -1) {
				output1.write(buffer, 0, bytesRead1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		ImageData image = ImageDataFactory.create(output1.toByteArray());
		ImageData image1 = ImageDataFactory.create(output.toByteArray());
		Data data = new Data();
		BasicInformation basic = new BasicInformation();
		

		if (input.getPdf().equals("borrower")) {
			numberId = input.getNumberId();
			basic = mapper.load(BasicInformation.class, input.getNumberId());
			name = basic.getNames() + " " + basic.getLastName();
			address = basic.getGeneralInformation().getAddress();
//			String resultGeneral=basic.getGeneralInformation().to;
//			System.out.println("resutl: "+resultGeneral);
			phone = basic.getCellphone();
			Map<String, Object> values = new HashMap<>();
			Table table = dynamoDB.getTable("relationPay");
			Index index = table.getIndex("numberIdBorrower-index");
			QuerySpec spec = new QuerySpec().withProjectionExpression("numberIdBorrower, id, numberIdMoneylender")
					.withKeyConditionExpression("numberIdBorrower = :_apply")
					.withValueMap(new ValueMap().withString(":_apply", numberId));
			ItemCollection<QueryOutcome> items = index.query(spec);
			int i = 0;
			context.getLogger().log("\nPage: " + spec);

			context.getLogger().log("\nPage: " + items);
			for (Page<Item, QueryOutcome> page : items.pages()) {
				Iterator<Item> iterator = page.iterator();
				// System.out.println("\nPage: " + ++pageNum);
				Item item = null;
				while (iterator.hasNext()) {
					item = iterator.next();
					values.put("" + i, item.toJSONPretty());
					System.out.println(item.toJSONPretty());
					i++;
				}
			}
			if (values.size() == 0) {

			}
			int lengthMap1 = values.size();

			for (int j = 0; j < lengthMap1; j++) {
				String hashMap = values.get("" + j).toString();
				hashMap = hashMap.replaceAll("=", ":");
				relation = new Gson().fromJson(hashMap, RelationPay.class);
				context.getLogger().log(relation.toString());
				String borrowerId= relation.getNumberIdBorrower()==null?"":relation.getNumberIdBorrower();
				lenderId=""; //relation.getNumberIdMoneylender()==null?"":relation.getNumberIdMoneylender();
				context.getLogger().log(borrowerId+" "+lenderId);
				//data = mapper.load(Data.class, lenderId);
				nameLender="";//data.getNames()+" "+data.getLastName();
			}
			numberCredit = relation.getId();
			
		} else if(input.getPdf().equals("award")) {
			idBorrower =input.getNumberId();
//			try {
//                idBorrower = encriptador.desencriptar( input.getNumberId(), claveEncriptacion);
//            } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
//            	context.getLogger().log(ex.getMessage());
//            }
			Map<String, Object> values = new HashMap<>();
			Table table = dynamoDB.getTable("relationPay");
			Index index = table.getIndex("numberIdBorrower-index");
			QuerySpec spec = new QuerySpec().withProjectionExpression("numberIdBorrower, id, numberIdMoneylender")
					.withKeyConditionExpression("numberIdBorrower = :_apply")
					.withValueMap(new ValueMap().withString(":_apply",idBorrower));
			ItemCollection<QueryOutcome> items = index.query(spec);
			int i = 0;
			context.getLogger().log("\nPage: " + spec);

			context.getLogger().log("\nPage: " + items);
			for (Page<Item, QueryOutcome> page : items.pages()) {
				Iterator<Item> iterator = page.iterator();
				// System.out.println("\nPage: " + ++pageNum);
				Item item = null;
				while (iterator.hasNext()) {
					item = iterator.next();
					values.put("" + i, item.toJSONPretty());
					context.getLogger().log(item.toJSONPretty());
					i++;
				}
			}
			if (values.size() == 0) {

			}
			int lengthMap1 = values.size();

			for (int j = 0; j < lengthMap1; j++) {
				String hashMap = values.get("" + j).toString();
				hashMap = hashMap.replaceAll("=", ":");
				relation = new Gson().fromJson(hashMap, RelationPay.class);
				context.getLogger().log(relation.toString());
				String borrowerId= relation.getNumberIdBorrower()==null?"":relation.getNumberIdBorrower();
				lenderId= relation.getNumberIdMoneylender()==null?"":relation.getNumberIdMoneylender();
				context.getLogger().log(borrowerId+" "+lenderId);
				data = mapper.load(Data.class, lenderId);
				nameLender=data.getNames()+" "+data.getLastName();
			}
			numberCredit = relation.getId();
		}
		switch (input.getPdf()) {
		case "email":
			idBorrower=input.getNumberId();
//			try {
//                idBorrower = encriptador.desencriptar( input.getNumberId(), claveEncriptacion);
//            } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
//            	context.getLogger().log(ex.getMessage());
//            }
			GeneralInformationTable general = new GeneralInformationTable();
			general = mapper.load(GeneralInformationTable.class, 3);
			data = mapper.load(Data.class, idBorrower);
			SendEmailRequest request = new SendEmailRequest()
					.withDestination(new Destination().withToAddresses(data.getEmail()))
					.withMessage(
							new Message()
									.withBody(new Body().withHtml(new Content().withCharset("UTF-8")
											.withData("<h1>" + general.getTemplate() + "</h1>")))
									.withSubject(
											new Content().withCharset("UTF-8").withData("Generación firmas Exitosas")))
					.withSource(Env.EMAIL_PROD);

			// Envía el correo electrónico utilizando las credenciales de IAM de la función
			// de Lambda
			client.sendEmail(request);
			pdfByte.add("ok");
			return pdfByte;
		case "promesa":
			promissory.setName("promesa");
			promissory.setPag(2);
			promissory.setData(Promissory.promissory(image, image1, name, numberId, address, phone, numberCredit,lenderId, nameLender));
			pdfByte.add(promissory);
			return pdfByte;
		case "autorizacionFinanciador":
			authorizationAward.setName("autorizacionFinanciador");
			authorizationAward.setPag(2);
			authorizationAward.setData(AuhtorizationAward.auhtorizationAward(image, image1));
			pdfByte.add(authorizationAward);
			return pdfByte;
		case "autorizacionDeudor":
			authorizationBorrower.setName("autorizacionDeudor");
			authorizationBorrower.setPag(2);
			authorizationBorrower.setData(AuhtorizationBorrower.authorizationBorrower(image, image1));
			pdfByte.add(AuhtorizationBorrower.authorizationBorrower(image, image1));
			return pdfByte;
		case "contratoFinanciador":
			contractAward.setName("contratoFinanciador");
			contractAward.setPag(6);
			contractAward.setData(ContractAward.contractAward(image, image1, name, numberId));
			pdfByte.add(ContractAward.contractAward(image, image1, name, numberId));
			return pdfByte;
//		case "contratoMutuo":
//			mutualContract.setName("contratoMutuo");
//			mutualContract.setPag(7);
//			mutualContract.setData(MutualContract.mutualContract(image, image1));
//			pdfByte.add(mutualContract);
//			return pdfByte;
//		case "poder":
//			power.setName("poder");
//			power.setPag(2);
//			power.setData(Power.power(image, image1));
//			pdfByte.add(Power.power(image, image1));
//			return pdfByte;
//		case "all":
//			pdfByte.add(Promissory.promissory(image, image1, name, numberId, address, phone, numberCredit,lenderId, nameLender));
//			pdfByte.add(AuhtorizationAward.auhtorizationAward(image, image1));
//			pdfByte.add(AuhtorizationBorrower.authorizationBorrower(image, image1));
//			pdfByte.add(ContractAward.contractAward(image, image1, name, numberId));
//			pdfByte.add(MutualContract.mutualContract(image, image1));
//			pdfByte.add(Power.power(image, image1));
//			return pdfByte;

		case "borrower":
			BasicInformation borrowerInfo=new BasicInformation();
			borrowerInfo=mapper.load(BasicInformation.class, input.getNumberId());
			promissory.setName("_Pagare");
			promissory.setPag(2);
			promissory.setData(Promissory.promissory(image, image1, name, numberId, address, phone, numberCredit,lenderId, nameLender));
			authorizationBorrower.setName("_Autorizacion_Tratamiento_Datos_Deudor");
			authorizationBorrower.setPag(2);
			authorizationBorrower.setData(AuhtorizationBorrower.authorizationBorrower(image, image1));
			mutualContract.setName("_Contrato_de_mutuo");
			mutualContract.setPag(6);
			mutualContract.setData(MutualContract.mutualContract(image, image1,numberId, name, "   ", "   "));
			power.setName("_Poder_");
			power.setPag(2);
			power.setData(Power.power(image, image1,numberId, name,phone, borrowerInfo.getIdentification().getDescription()));
			
			pdfByte.add(promissory);
			pdfByte.add(power);
			pdfByte.add(mutualContract);
			pdfByte.add(authorizationBorrower);
			
			
			return pdfByte;
		case "borrowerBNPL":
			Data dataBorrower=new Data();
			dataBorrower=mapper.load(Data.class, input.getNumberId());
			promissory.setName("_Pagare");
			promissory.setPag(2);
			promissory.setData(Promissory.promissory(image, image1, dataBorrower.getNames()+" "+dataBorrower.getLastName(), input.getNumberId(),input.getAddress(), dataBorrower.getCellphone(), input.getBorrowerNumberCredit(),input.getIdFinancier(), input.getFinanciador()));
			authorizationBorrower.setName("_Autorizacion_Tratamiento_Datos_Deudor");
			authorizationBorrower.setPag(2);
			authorizationBorrower.setData(AuhtorizationBorrower.authorizationBorrower(image, image1));
			mutualContract.setName("_Contrato_de_mutuo");
			mutualContract.setPag(7);
			mutualContract.setData(MutualContractCupos.mutualContract(image, image1,input.getNumberId(), dataBorrower.getNames()+" "+dataBorrower.getLastName(), input.getIdFinancier(), input.getFinanciador()));
						
			pdfByte.add(promissory);
			pdfByte.add(authorizationBorrower);
			pdfByte.add(mutualContract);			
			return pdfByte;
		
		case "borrowerBNPLCupos":
			Data dataBorrowercupos=new Data();
			dataBorrowercupos=mapper.load(Data.class, input.getNumberId());
			promissory.setName("_Pagare");
			promissory.setPag(2);
			promissory.setData(Promissory.promissory(image, image1, dataBorrowercupos.getNames()+" "+dataBorrowercupos.getLastName(), input.getNumberId(),input.getAddress(), dataBorrowercupos.getCellphone(), input.getBorrowerNumberCredit(),input.getIdFinancier(), input.getFinanciador()));
			authorizationBorrower.setName("_Autorizacion_Tratamiento_Datos_Deudor");
			authorizationBorrower.setPag(2);
			authorizationBorrower.setData(AuhtorizationBorrower.authorizationBorrower(image, image1));
			mutualContract.setName("_Contrato_de_mutuo");
			mutualContract.setPag(7);
			mutualContract.setData(MutualContractCupos.mutualContract(image, image1,input.getNumberId(), dataBorrowercupos.getNames()+" "+dataBorrowercupos.getLastName(), input.getIdFinancier(), input.getFinanciador()));			
			pdfByte.add(promissory);
			pdfByte.add(authorizationBorrower);
			pdfByte.add(mutualContract);
			
			return pdfByte;
			
			
		case "borrowerWallet":
			Data dataBorrower1=new Data();
			dataBorrower1=mapper.load(Data.class, input.getNumberId());
			promissory.setName("_Pagare");
			promissory.setPag(2);
			promissory.setData(Promissory.promissory(image, image1, dataBorrower1.getNames()+" "+dataBorrower1.getLastName(), input.getNumberId(),input.getAddress(), dataBorrower1.getCellphone(), input.getBorrowerNumberCredit(),input.getIdFinancier(), input.getFinanciador()));
			mutualContract.setName("_Contrato_de_mutuo");
			mutualContract.setPag(7);
			mutualContract.setData(MutualContractCupos.mutualContract(image, image1,input.getNumberId(), dataBorrower1.getNames()+" "+dataBorrower1.getLastName(), "901672135", "MAKENOS SAS"));	
			pdfByte.add(promissory);
			pdfByte.add(mutualContract);
			
			
			
			return pdfByte;
			

		case "award":
			Award award=new Award();
			award=mapper.load(Award.class, lenderId);
			
			
			promissory.setName("_Pagare");
			promissory.setPag(2);
			promissory.setData(Promissory.promissory(image, image1, name, numberId, address, phone, numberCredit,lenderId, nameLender));
			authorizationAward.setName("_Autorizacion_Tratamiento_Datos_Financiador");
			authorizationAward.setPag(2);
			authorizationAward.setData(AuhtorizationAward.auhtorizationAward(image, image1));
			contractAward.setName("_Contrato_de_corretaje");
			contractAward.setPag(7);
			contractAward.setData(ContractAward.contractAward(image, image1, nameLender, lenderId));
			mutualContract.setName("_Contrato_de_mutuo");
			mutualContract.setPag(6);
			mutualContract.setData(MutualContract.mutualContract(image, image1,"   ","   ", lenderId, nameLender));
			power.setName("_Poder_");
			power.setPag(2);
			power.setData(Power.power(image, image1,lenderId, nameLender,award.getCellphone(), award.getIdentification()));
			
			pdfByte.add(promissory);
			pdfByte.add(power);
			pdfByte.add(mutualContract);
			pdfByte.add(contractAward);
			pdfByte.add(authorizationAward);
			
			
			
			return pdfByte;

		}

		return null;
	}
}