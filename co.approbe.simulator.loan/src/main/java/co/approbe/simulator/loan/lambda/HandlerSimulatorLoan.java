package co.approbe.simulator.loan.lambda;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class HandlerSimulatorLoan implements RequestHandler<Request, Object> {
	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
	DynamoDBMapper mapper = new DynamoDBMapper(client);

	@Override
	public Object handleRequest(Request request, Context context) {
		HashMap<String, Object> response = new HashMap<>(3);
		HashMap<String, Object> response1 = new HashMap<>(3);
		Loan loan = null;
		CreditLine creditLine = null;

		switch (request.getHttpMethod()) {
		case "GET":
			creditLine = mapper.load(CreditLine.class, request.getId());
			loan = (request.getLoan());

			double rate = (Double.parseDouble(creditLine.getRate()) / 100) / loan.getFees();
			double rateYear = (Double.parseDouble(creditLine.getRate()) / 100);
			double rateM = (Math.pow((1.0 + rateYear), (1.0 / 12.0))) - 1.0;
			double value = loan.getValue();
			double fees = loan.getFees();
			double iN = Math.pow((1.0 + rate), fees);
			double va = value * (iN - 1) / (rate * iN);

			double balance = va;
			double roundDbl = pmt(rateM, balance, fees, loan, creditLine);
			double rateMonth = balance * rateM;
			double installment = roundDbl - rateMonth;
			Double totalRate = rateMonth;
			List<Double> datos = new ArrayList<>();
			List<Double> datos1 = new ArrayList<>();
			List<Double> datos2 = new ArrayList<>();
			datos.add(Math.round(balance * 100.0) / 100.0);
			datos1.add(Math.round(installment * 100.0) / 100.0);
			datos2.add(Math.round(rateMonth * 100.0) / 100.0);

			for (int i = 2; i <= fees; i++) {
				balance = balance - installment;
				rateMonth = balance * rateM;
				installment = roundDbl - rateMonth;
				totalRate += rateMonth;
				datos.add(Math.round(balance * 100.0) / 100.0);
				datos1.add(Math.round(installment * 100.0) / 100.0);
				datos2.add(Math.round(rateMonth * 100.0) / 100.0);

			}
//			response.put("saldo deuda", datos);
//			response.put("abono capital", datos1);
//			response.put("interes mensual", datos2);
			if (va > 10000000) {
				va = 10000000;
			}
			response.put("valorPrestado", (Math.round(va * 100.0) / 100.0));
			// response.put("total intereses pagados", (Math.round(totalRate * 100.0) /
			// 100.0));

			return response;
		case "PAGOS":
			creditLine = mapper.load(CreditLine.class, request.getId());
			loan = (request.getLoan());
		//	double rateP = (request.getRate() / 100) / loan.getFees();
			double rateYearP = request.getRate() / 100;
			double rateMP = (Math.pow((1.0 + rateYearP), (1.0 / 12.0))) - 1.0;
			double valueP = loan.getValue();
			Double feesP =(double) loan.getFees();
			double vaP=loan.getValue();
			
			double balanceP = vaP;
			double roundDblP = pmt(rateMP, balanceP, feesP, loan, creditLine);
			double rateMonthP = balanceP * rateMP;
			double installmentP = roundDblP - rateMonthP;
			Double totalRateP = rateMonthP;
			Double[] datosP = new Double[feesP.intValue()];
			Double[] datos1P = new Double[feesP.intValue()];
			Double[] datos2P = new Double[feesP.intValue()];
			String[] fecha = new String[feesP.intValue()];
			datosP[0]=(Math.round(balanceP * 100.0) / 100.0);
			datos1P[0]=(Math.round(installmentP * 100.0) / 100.0);
			datos2P[0]=(Math.round(rateMonthP * 100.0) / 100.0);
			
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			LocalDate fechaLocal = LocalDate.parse(request.getFechaAprobacion(), formateador);
			fecha[0]=fechaLocal.plusMonths(1).toString();
			System.out.println(fechaLocal);			
			
			for (int i = 1; i < feesP; i++) {
				balanceP = balanceP - installmentP;
				rateMonthP = balanceP * rateMP;
				installmentP = roundDblP - rateMonthP;
				totalRateP += rateMonthP;
				datosP[i]=(Math.round(balanceP * 100.0) / 100.0);
				datos1P[i]=(Math.round(installmentP * 100.0) / 100.0);
				datos2P[i]=(Math.round(rateMonthP * 100.0) / 100.0);
				fecha[i]=fechaLocal.plusMonths(i+1).toString();
				System.out.println(fecha[i]);
			}
			
			PlannerPay plannerPay=new PlannerPay();
			plannerPay.setAbonoCapital(datos1P);
			plannerPay.setInteresMensual(datos2P);
			plannerPay.setSaldoDeuda(datosP);
			plannerPay.setFechas(fecha);
			
			Credit credit=new Credit();
			credit.setPlannerPay(plannerPay); 
			if(request.getIdRelationPay()!=null) {
				credit.setId(request.getIdRelationPay());
				mapper.save(credit);
			}
		
			
			
		   

	//		response.put("saldo deuda", datos);
//			response.put("abono capital", datos1);
//			response.put("interes mensual", datos2);
			
	//		response.put("valorPrestado", (Math.round(va * 100.0) / 100.0));
			// response.put("total intereses pagados", (Math.round(totalRate * 100.0) /
			// 100.0));

			return credit.getPlannerPay();

		}
		return null;
	}

	public static double pmt(double rate, double va, double n, Loan loan, CreditLine creditLine) {
		double fv = va * Math.pow((1 + rate), n);
	//	double insuranceValue = (Double.parseDouble(creditLine.getInsurance()) / 100) * loan.getValue();
	//	double platformUseValue = (Double.parseDouble(creditLine.getPlatformUse()) / 100) * loan.getValue();
	//	double sum = +insuranceValue + platformUseValue;
		double pmt = (fv * rate) / (Math.pow((1 + rate), n) - 1);
		double roundDbl = Math.round(pmt * 100.0) / 100.0;

		return roundDbl;

	}

}
