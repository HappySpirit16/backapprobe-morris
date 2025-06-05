package co.approbe.authorization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	public Integer handleRequest(Request request, Context context) {
		context.getLogger().log("Entra a AutorizationData");
		context.getLogger().log("Data: " + request.toString());
		Data basicInformation = new Data();
		Logs logs = new Logs();
		Data basicInformationValid = new Data();
		int difM = 0;
		int dias = 0;
		int i = 1;
		int a = 0;
		int jurad = 0;
		switch (request.getHttpMethod()) {
		case "POST":
			context.getLogger().log("Entra a AutorizationData POST");
			basicInformation = request.getData();
			String numberId = basicInformation.getNumberId() == null ? "00" : basicInformation.getNumberId();
			basicInformationValid = mapper.load(Data.class, numberId);
			if (basicInformationValid == null) {
				context.getLogger().log("Entra a AutorizationData POST pot primera vez");
				basicInformation.setCountJurad(0);
				basicInformation.setValidJurad(false);
				if (basicInformation.getGender() == null || basicInformation.getGender().equals(" ")) {
					basicInformation.setCountExperian(1);
				} else {
					basicInformation.setCountExperian(0);
				}
				basicInformation.setFlagExist(1);
				basicInformation.setFail(0);
				basicInformation.setCount(0);
				logs.setNumberId(numberId);
				logs.setLogs(basicInformation.toString());
				mapper.save(logs);
				mapper.save(basicInformation);
				return 1;
			} else {
				try {
					Calendar inicio = new GregorianCalendar();
					Calendar fin = new GregorianCalendar();
					inicio.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(basicInformationValid.getDateSave()));
					fin.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(basicInformation.getDateSave()));
					int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
					// Conversion de string a date
					String Dateinicio = basicInformationValid.getDateSave();
					String Datefinal = basicInformation.getDateSave();
					SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					Date fechaInicio = date.parse(Dateinicio);
					// La fecha actual
					Date fechaactual = date.parse(Datefinal);
					System.out.println("fechaactual " + fechaactual);
					System.out.println("fechaInicio " + fechaInicio);
					int milisecondsByDay = 86400000;
					dias = (int) ((fechaactual.getTime() - fechaInicio.getTime()) / milisecondsByDay);
					difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
					System.out.println(difM);
					System.out.println("dias " + dias);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				context.getLogger().log("data : " + basicInformationValid.toString());
				jurad = basicInformationValid.getCountJurad();
				
				if (basicInformationValid.getCountExperian() == 7) {
					context.getLogger().log("Restricciones por bloqueo permanente");
					return 7; 
				}else if(basicInformationValid.getCountExperian() == 8) {
					context.getLogger().log("Restricciones por bloqueo permanente");
					return 8; 
				}

				if (jurad == 2) {
					context.getLogger().log("Restricciones por jurad para BNPL");
					return 3;
				}

				if (((basicInformationValid.getCountExperian() == 2) || (basicInformationValid.getCountExperian() == 3))
						&& (dias < 1)) {
					basicInformation.setCount(basicInformationValid.getCount());
					basicInformation.setFail(basicInformationValid.getFail());
					basicInformation.setStatusProceed(basicInformationValid.getStatusProceed());
					basicInformation.setStatusFail(basicInformationValid.getStatusFail());
					basicInformation.setCountJurad(basicInformationValid.getCountJurad());
					basicInformation.setValidJurad(basicInformationValid.getValidJurad());
					basicInformation.setCountExperian(3);
					logs.setNumberId(numberId);
					logs.setLogs(basicInformation.toString());
					mapper.save(logs);
					mapper.save(basicInformation);
					return 3;
				} else if (basicInformationValid.getCountExperian() == 0) {
					context.getLogger().log("CountExperian : 0");
					basicInformation.setCount(basicInformationValid.getCount());
					basicInformation.setStatusProceed(basicInformationValid.getStatusProceed());
					basicInformation.setFail(basicInformationValid.getFail());
					basicInformation.setStatusProceed(basicInformationValid.getStatusProceed());
					basicInformation.setStatusFail(basicInformationValid.getStatusFail());
					basicInformation.setCountExperian(basicInformationValid.getCountExperian());
					if (basicInformation.getGender() == null || basicInformation.getGender().equals(" ")) {
						context.getLogger().log("CountExperian : 0");
						basicInformation.setCountExperian(1);
					} else {
						basicInformation.setCountExperian(basicInformationValid.getCountExperian());
					}
					basicInformation.setCountJurad(basicInformationValid.getCountJurad());
					basicInformation.setValidJurad(basicInformationValid.getValidJurad());
					logs.setNumberId(numberId);
					logs.setLogs(basicInformation.toString());
					mapper.save(logs);
					mapper.save(basicInformation);
					return 1;
				} else if (((basicInformationValid.getCountExperian() == 2)
						|| (basicInformationValid.getCountExperian() == 3)) && (dias >= 1)) {
					basicInformation.setCount(basicInformationValid.getCount());
					basicInformation.setFail(basicInformationValid.getFail());
					basicInformation.setStatusProceed(basicInformationValid.getStatusProceed());
					basicInformation.setStatusFail(basicInformationValid.getStatusFail());
					basicInformation.setCountJurad(basicInformationValid.getCountJurad());
					basicInformation.setValidJurad(basicInformationValid.getValidJurad());
					if (basicInformation.getGender() == null || basicInformation.getGender().equals(" ")) {
						basicInformation.setCountExperian(3);
					} else {
						basicInformation.setCountExperian(basicInformationValid.getCountExperian());
					}
					logs.setNumberId(numberId);
					logs.setLogs(basicInformation.toString());
					mapper.save(logs);
					mapper.save(basicInformation);
					return 4;
				} else if ((basicInformationValid.getCountExperian() == 4) && (difM < 1)) {
					basicInformation.setCount(basicInformationValid.getCount());
					basicInformation.setFail(basicInformationValid.getFail());
					basicInformation.setStatusProceed(basicInformationValid.getStatusProceed());
					basicInformation.setStatusFail(basicInformationValid.getStatusFail());
					basicInformation.setCountJurad(basicInformationValid.getCountJurad());
					basicInformation.setValidJurad(basicInformationValid.getValidJurad());
					if (basicInformation.getGender() == null) {
						basicInformation.setCountExperian(1);
					} else {
						basicInformation.setCountExperian(0);
					}
					logs.setNumberId(numberId);
					logs.setLogs(basicInformation.toString());
					mapper.save(logs);
					mapper.save(basicInformation);
					return 5;
				} else if ((basicInformationValid.getCountExperian() == 5) && (difM < 1)) {
					logs.setNumberId(numberId);
					basicInformation.setCountJurad(basicInformation.getCountJurad());
					logs.setLogs(basicInformation.toString());
					mapper.save(logs);
					return 6;
				} else if ((basicInformationValid.getCountExperian() == 5) && (difM >= 1)) {
					basicInformation.setCount(basicInformationValid.getCount());
					basicInformation.setFail(basicInformationValid.getFail());
					basicInformation.setStatusProceed(basicInformationValid.getStatusProceed());
					basicInformation.setStatusFail(basicInformationValid.getStatusFail());
					basicInformation.setCountJurad(basicInformationValid.getCountJurad());
					basicInformation.setValidJurad(basicInformationValid.getValidJurad());
					if (basicInformation.getGender() == null || basicInformation.getGender().equals(" ")) {
						basicInformation.setCountExperian(1);
					} else {
						basicInformation.setCountExperian(0);
					}
					logs.setNumberId(numberId);
					logs.setLogs(basicInformation.toString());
					mapper.save(logs);
					mapper.save(basicInformation);
					return 1;
				} else if ((basicInformationValid.getCountExperian() == 2) && (dias < 1)
						&& (basicInformationValid.getFail() == 2)) {
					basicInformation.setCount(basicInformationValid.getCount());
					basicInformation.setFail(basicInformationValid.getFail());
					basicInformation.setStatusProceed(basicInformationValid.getStatusProceed());
					basicInformation.setStatusFail(basicInformationValid.getStatusFail());
					basicInformation.setCountJurad(basicInformationValid.getCountJurad());
					basicInformation.setValidJurad(basicInformationValid.getValidJurad());
					basicInformation.setCountExperian(2);
					logs.setNumberId(numberId);
					logs.setLogs(basicInformation.toString());
					mapper.save(logs);
					mapper.save(basicInformation);
					return 3;
				} else if ((basicInformationValid.getCountExperian() == 5) && (dias < 1)
						&& (basicInformationValid.getFail() == 4)) {
					basicInformation.setCount(basicInformationValid.getCount());
					basicInformation.setFail(basicInformationValid.getFail());
					basicInformation.setStatusProceed(basicInformationValid.getStatusProceed());
					basicInformation.setStatusFail(basicInformationValid.getStatusFail());
					basicInformation.setCountJurad(basicInformationValid.getCountJurad());
					basicInformation.setValidJurad(basicInformationValid.getValidJurad());
					basicInformation.setCountExperian(5);
					logs.setNumberId(numberId);
					logs.setLogs(basicInformation.toString());
					mapper.save(logs);
					mapper.save(basicInformation);
					return 6;
				} else {
					basicInformation.setCount(basicInformationValid.getCount());
					basicInformation.setFail(basicInformationValid.getFail());
					basicInformation.setStatusProceed(basicInformationValid.getStatusProceed());
					basicInformation.setStatusFail(basicInformationValid.getStatusFail());
					if (basicInformation.getGender() == null || basicInformation.getGender().equals(" ")) {
						basicInformation.setCountExperian(2);
					} else {
						basicInformation.setCountExperian(basicInformationValid.getCountExperian());
					}
					basicInformation.setCountJurad(basicInformationValid.getCountJurad());
					basicInformation.setValidJurad(basicInformationValid.getValidJurad());
					logs.setNumberId(numberId);
					logs.setLogs(basicInformation.toString());
					mapper.save(logs);
					mapper.save(basicInformation);
					return 2;
				}
			}
		case "FALLA":
			basicInformation = request.getData();
			String numberId1 = basicInformation.getNumberId() == null ? "00" : basicInformation.getNumberId();
			basicInformationValid = mapper.load(Data.class, numberId1);
			a = basicInformationValid.getFail();
			a++;
			basicInformationValid.setFail(a);
			basicInformationValid.setStatusFail("Consultas fallidas :" + a);
			mapper.save(basicInformationValid);
			return 1;
		case "PASA":
			basicInformation = request.getData();
			String numberId2 = basicInformation.getNumberId() == null ? "00" : basicInformation.getNumberId();
			basicInformationValid = mapper.load(Data.class, numberId2);
			int b = basicInformationValid.getCount();
			b++;
			basicInformationValid.setCount(b);
			basicInformationValid.setStatusProceed("Consultas exitosas :" + b);
			mapper.save(basicInformationValid);
			return 1;
		case "CONSULTA":
			basicInformation = request.getData();
			String numberId3 = basicInformation.getNumberId() == null ? "00" : basicInformation.getNumberId();
			basicInformationValid = mapper.load(Data.class, numberId3);

			try {
				Calendar inicio = new GregorianCalendar();
				Calendar fin = new GregorianCalendar();
				inicio.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(basicInformationValid.getDateSave()));
				fin.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(basicInformation.getDateSave()));
				int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
				// Conversion de string a date
				String Dateinicio = basicInformationValid.getDateSave();
				String Datefinal = basicInformation.getDateSave();
				SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				Date fechaInicio = date.parse(Dateinicio);
				// La fecha actual
				Date fechaactual = date.parse(Datefinal);
				System.out.println("fechaactual " + fechaactual);
				System.out.println("fechaInicio " + fechaInicio);
				int milisecondsByDay = 86400000;
				dias = (int) ((fechaactual.getTime() - fechaInicio.getTime()) / milisecondsByDay);
				difM = difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
				System.out.println(difM);
				System.out.println("dias " + dias);
			} catch (Exception e) {
				// TODO: handle exception
			}
			if (jurad ==2 && dias<1) {
				context.getLogger().log("Restricciones por jurad para BNPL");
				return 3;
			}
			if (((basicInformationValid.getCountExperian() == 2) || (basicInformationValid.getCountExperian() == 3))
					&& (dias < 1)) {
				return 3;
			} else if (basicInformationValid.getCountExperian() == 0) {
				return 1;
			}
			if (((basicInformationValid.getCountExperian() == 2) || (basicInformationValid.getCountExperian() == 3))
					&& (dias >= 1)) {
				return 4;
			} else if ((basicInformationValid.getCountExperian() == 4) && (difM < 1)) {
				return 5;
			} else if ((basicInformationValid.getCountExperian() == 5) && (difM < 1)) {
				return 6;
			} else if ((basicInformationValid.getCountExperian() == 5) && (difM >= 1)) {
				return 1;
			} else if ((basicInformationValid.getCountExperian() == 2) && (dias < 1)
					&& (basicInformationValid.getFail() == 2)) {
				return 3;
			} else if ((basicInformationValid.getCountExperian() == 5) && (dias < 1)
					&& (basicInformationValid.getFail() == 4)) {
				return 6;
			} else {
				return 2;
			}

		}
		return null;
	}

}
