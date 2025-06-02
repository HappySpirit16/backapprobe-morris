package co.approbe.processactive.dao;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;


@DynamoDBTable(tableName="relationPay")
public class RelationPay {
	@DynamoDBHashKey
	private String id;
	@DynamoDBAttribute
	private String numberIdBorrower;
	@DynamoDBAttribute
	private String numberIdMoneylender;
	LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.of("-05:00"));
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	@DynamoDBAttribute
	private String dateSaveBD = dateTime.format(dtformat);
	
	//ajuste a tabla 
	@DynamoDBAttribute
	private String fechaAprobacion;
	@DynamoDBAttribute
	private String lastPaymentDate;
	@DynamoDBAttribute
	private String nameBorrower;
	@DynamoDBAttribute
	private double ranking;
	@DynamoDBAttribute
	private double active;
	@DynamoDBAttribute
	private String gender;
	@DynamoDBAttribute
	private String activityBorrower;
	
	public String getActivityBorrower() {
		return activityBorrower;
	}
	public void setActivityBorrower(String activityBorrower) {
		this.activityBorrower = activityBorrower;
	}
	public String getNameBorrower() {
		return nameBorrower;
	}
	public double getRanking() {
		return ranking;
	}
	public double getActive() {
		return active;
	}
	public void setNameBorrower(String nameBorrower) {
		this.nameBorrower = nameBorrower;
	}
	public void setRanking(double ranking) {
		this.ranking = ranking;
	}
	public void setActive(double active) {
		this.active = active;
	}
	public String getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(String lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	@DynamoDBAttribute
	private String plannerPay;
	@DynamoDBAttribute
	private double saldoCredito;
	@DynamoDBAttribute
	private double approveValue;
	@DynamoDBAttribute
	private double rateApprobe;
	@DynamoDBAttribute
	private double feesApprobe;
	@DynamoDBAttribute
	private double gainAprrobe;
	@DynamoDBAttribute
	private int statusCredit;
	@DynamoDBAttribute
	private double feesPaid;
	@DynamoDBAttribute
	private String nextFeesDate;
	@DynamoDBAttribute
	private double nextPaid;
	@DynamoDBAttribute
	private double rentabilidad;
	@DynamoDBAttribute
	private double balancePaid;
	

	public int getStatusCredit() {
		return statusCredit;
	}
	public void setStatusCredit(int statusCredit) {
		this.statusCredit = statusCredit;
	}
	public double getApproveValue() {
		return approveValue;
	}
	public double getRateApprobe() {
		return rateApprobe;
	}
	public double getFeesApprobe() {
		return feesApprobe;
	}
	public double getGainAprrobe() {
		return gainAprrobe;
	}
	public void setApproveValue(double approveValue) {
		this.approveValue = approveValue;
	}
	public void setRateApprobe(double rateApprobe) {
		this.rateApprobe = rateApprobe;
	}
	public void setFeesApprobe(double feesApprobe) {
		this.feesApprobe = feesApprobe;
	}
	public void setGainAprrobe(double gainAprrobe) {
		this.gainAprrobe = gainAprrobe;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumberIdBorrower() {
		return numberIdBorrower;
	}
	public void setNumberIdBorrower(String numberIdBorrower) {
		this.numberIdBorrower = numberIdBorrower;
	}
	public String getNumberIdMoneylender() {
		return numberIdMoneylender;
	}
	public void setNumberIdMoneylender(String numberIdMoneylender) {
		this.numberIdMoneylender = numberIdMoneylender;
	}

	public String getNextFeesDate() {
		return nextFeesDate;
	}
	public void setNextFeesDate(String nextFeesDate) {
		this.nextFeesDate = nextFeesDate;
	}
	public double getFeesPaid() {
		return feesPaid;
	}
	public double getNextPaid() {
		return nextPaid;
	}
	public void setFeesPaid(double feesPaid) {
		this.feesPaid = feesPaid;
	}
	public void setNextPaid(double nextPaid) {
		this.nextPaid = nextPaid;
	}
	public double getBalancePaid() {
		return balancePaid;
	}

	public void setBalancePaid(double balancePaid) {
		this.balancePaid = balancePaid;
	}
	public String getFechaAprobacion() {
		return fechaAprobacion;
	}
	public double getRentabilidad() {
		return rentabilidad;
	}
	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	public void setRentabilidad(double rentabilidad) {
		this.rentabilidad = rentabilidad;
	}

	public String getPlannerPay() {
		return plannerPay;
	}
	public void setPlannerPay(String plannerPay) {
		this.plannerPay = plannerPay;
	}
	public double getSaldoCredito() {
		return saldoCredito;
	}
	public void setSaldoCredito(double saldoCredito) {
		this.saldoCredito = saldoCredito;
	}

	public String getDateSaveBD() {
		return dateSaveBD;
	}
	public void setDateSaveBD(String dateSaveBD) {
		this.dateSaveBD = dateSaveBD;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public RelationPay(String id, String numberIdBorrower, String numberIdMoneylender, String dateSaveBD,
			String fechaAprobacion, String lastPaymentDate, String nameBorrower, double ranking, double active,
			String gender, String activityBorrower, String plannerPay, double saldoCredito, double approveValue,
			double rateApprobe, double feesApprobe, double gainAprrobe, int statusCredit, double feesPaid,
			String nextFeesDate, double nextPaid, double rentabilidad, double balancePaid) {
		super();
		this.id = id;
		this.numberIdBorrower = numberIdBorrower;
		this.numberIdMoneylender = numberIdMoneylender;
		this.dateSaveBD = dateSaveBD;
		this.fechaAprobacion = fechaAprobacion;
		this.lastPaymentDate = lastPaymentDate;
		this.nameBorrower = nameBorrower;
		this.ranking = ranking;
		this.active = active;
		this.gender = gender;
		this.activityBorrower = activityBorrower;
		this.plannerPay = plannerPay;
		this.saldoCredito = saldoCredito;
		this.approveValue = approveValue;
		this.rateApprobe = rateApprobe;
		this.feesApprobe = feesApprobe;
		this.gainAprrobe = gainAprrobe;
		this.statusCredit = statusCredit;
		this.feesPaid = feesPaid;
		this.nextFeesDate = nextFeesDate;
		this.nextPaid = nextPaid;
		this.rentabilidad = rentabilidad;
		this.balancePaid = balancePaid;
	}
	public RelationPay() {
		super();
	}
		
	
}
