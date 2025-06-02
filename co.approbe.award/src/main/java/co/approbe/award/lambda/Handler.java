package co.approbe.award.lambda;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;

public class Handler implements RequestHandler<Request, Object> {
	AmazonDynamoDB db = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(db);

	@Override
	public Object handleRequest(Request request, Context context) {

		BasicInformation basicInformation = new BasicInformation();
		UserInformation userInformation = new UserInformation();
		System.out.println("esta llegando: " + request.getBasicInformation());
		Log log = new Log();
		switch (request.getHttpMethod()) {
		case "POST":
			basicInformation = request.getBasicInformation();
			try {
				final String claveEncriptacion = "approbe!";
				String datosOriginales = basicInformation.toString();

				EncriptadorAES encriptador = new EncriptadorAES();

				String encriptado = encriptador.encriptar(datosOriginales, claveEncriptacion);
				log.setInformation(encriptado);
//		            String desencriptado = encriptador.desencriptar(encriptado, claveEncriptacion);

//		            System.out.println("Cadena Original: " + datosOriginales);
//		            System.out.println("Escriptado     : " + encriptado);
//		            System.out.println("Desencriptado  : " + desencriptado);    
				mapper.save(log);

				userInformation.setNumberId(basicInformation.getNumberId());
				userInformation.setNames(basicInformation.getNames());
				userInformation.setLastName(basicInformation.getLastName());
				userInformation.setGender(basicInformation.getGender());
				userInformation.setEmail(basicInformation.getEmail());
				userInformation.setCellphone(basicInformation.getCellphone());

//					userInformation.setGeneralInformationAward(basicInformation.getGeneralInformation());
//					userInformation.setFinancialInformationAward(basicInformation.getFinancialInformation());

//					userInformation.setCompanyName(basicInformation.getEconomicActivity().getCompany());
//					userInformation.setCompanyActivity(basicInformation.getEconomicActivity().getCompanyActivity().getDescription());
//					userInformation.setPosition(basicInformation.getEconomicActivity().getPosition());
//					userInformation.setCompanyPhone(basicInformation.getEconomicActivity().getPhone());
//					userInformation.setCompanyAddress(basicInformation.getEconomicActivity().getAddress());

				userInformation.setCompanySeniority(0);

			} catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException
					| NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException ex) {
				System.out.println("error" + ex);
				// Logger.getLogger(EncriptadorAES.class.getName()).log(Level.SEVERE, null, ex);
			}
			Data dataValidJurad = new Data();
			dataValidJurad = mapper.load(Data.class, basicInformation.getNumberId());
			if (dataValidJurad.getValidJurad()
					&& (dataValidJurad.getCountJurad() == 1 || dataValidJurad.getCountJurad() == 4 || dataValidJurad.getCountJurad() == 10)) {
				int difM = 0;
				int dias = 0;

				try {
					LocalDateTime dateTimeLocal = LocalDateTime.now(ZoneOffset.of("-05:00"));
					DateTimeFormatter dtformatLocal = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
					String dateSave = dateTimeLocal.format(dtformatLocal);

					// Conversion de string a date
					String Dateinicio = dataValidJurad.getDateSave();
					SimpleDateFormat dateActual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					Date fechaInicio = dateActual.parse(Dateinicio);
					// La fecha actual
					Date fechaactual;
					fechaactual = dateActual.parse(dateSave);
					System.out.println("fechaactual " + fechaactual);
					System.out.println("fechaInicio " + fechaInicio);
					int milisecondsByDay = 86400000;
					dias = (int) ((fechaactual.getTime() - fechaInicio.getTime()) / milisecondsByDay);
					System.out.println("dias " + dias);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (dias > 0) {
					return null;
				} else {
					mapper.save(basicInformation);
					mapper.save(userInformation);

					// cuando funcione poowwi descomentar para crear cuenta de deposito
					boolean powwi = request.getPowwi().isPasoPowwi();

					if (!request.getPowwi().isPasoPowwi()) {
						Data data = new Data();
						data = mapper.load(Data.class, basicInformation.getNumberId());
						boolean dataPowwi = data.getValidCellphone() == null ? false : data.getValidCellphone();
						if (dataPowwi) {
							powwi = true;
						}
					}

					if (powwi) {

						CreateDeposit createDeposit = new CreateDeposit();
						createDeposit.setCelular(basicInformation.getCellphone());
						createDeposit.setCorreoElectronico(basicInformation.getEmail());
						createDeposit.setFechaExpedicion(request.getPowwi().getFechaExpedicion());
						createDeposit.setFechaNacimiento(request.getPowwi().getFechaNacimiento());
						createDeposit.setHuellaDispositivo(basicInformation.getCellphone());
						createDeposit.setIP(request.getPowwi().getIp());
						createDeposit.setNumeroDocumento(basicInformation.getNumberId());

						String sexo = basicInformation.getGender();
						sexo = sexo.substring(0, 1);
						String typeDocument = basicInformation.getIdentification();
						typeDocument = typeDocument.substring(0, 1);

						createDeposit.setSexo(sexo);
						createDeposit.setTipoDocumento(typeDocument);

						try {
							HttpResponse<String> responseCredit;
							String responseaCredit = "";
							System.out.println("datos salida: " + createDeposit.toString());
							HttpClient clientCredit = HttpClient.newHttpClient();
							HttpRequest requestaCredit = HttpRequest.newBuilder().uri(URI.create(
								//	"https://vuwnwhdth3.execute-api.us-east-1.amazonaws.com/ApprobeDev/powwiservices")) // dev
									"https://hgarxx9xvb.execute-api.us-east-1.amazonaws.com/ApiApprobe/powwiservices")) //prod
									.setHeader("Content-Type", "application/json")
									.POST(HttpRequest.BodyPublishers.ofString(createDeposit.toString())).build();
							responseCredit = clientCredit.send(requestaCredit, HttpResponse.BodyHandlers.ofString());

							responseaCredit = responseCredit.body() == null ? "la transaccion no se realizo"
									: responseCredit.body();

							System.out.println("la respuesta es: " + responseaCredit);
						} catch (JsonProcessingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

					return basicInformation;
				}
			}
		}
		return null;
	}

}
