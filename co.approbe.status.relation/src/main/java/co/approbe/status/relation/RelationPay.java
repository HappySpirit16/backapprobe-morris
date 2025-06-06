package co.approbe.status.relation;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
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
	private String fechaAprobacion="dd/mm/uuuu";
	@DynamoDBAttribute
	private String lastPaymentDate="dd/mm/uuuu";
	@DynamoDBAttribute
	private String plannerPay="sinDatos";
	@DynamoDBAttribute
	private double approveValue=0;
	@DynamoDBAttribute
	private double saldoCredito=0;
	@DynamoDBAttribute
	private double rateApprobe=0;
	@DynamoDBAttribute
	private double feesApprobe=0;
	@DynamoDBAttribute
	private double gainAprrobe=0;
	@DynamoDBAttribute
	private int statusCredit=0;
	@DynamoDBAttribute
	private double feesPaid=0;
	@DynamoDBAttribute
	private String nextFeesDate="dd/mm/uuuu";
	@DynamoDBAttribute
	private double nextPaid=0;
	@DynamoDBAttribute
	private double rentabilidad=0;
	@DynamoDBAttribute
	private double balancePaid=0;
	
	// ajuste tabla
	
	@DynamoDBAttribute
	private String nameBorrower;
	@DynamoDBAttribute
	private double ranking;
	@DynamoDBAttribute
	private double active=2;
	@DynamoDBAttribute
	private String gender;
	@DynamoDBAttribute
	private String activityBorrower;

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getActivityBorrower() {
		return activityBorrower;
	}
	public void setActivityBorrower(String activityBorrower) {
		this.activityBorrower = activityBorrower;
	}
	public double getActive() {
		return active;
	}
	public void setActive(double active) {
		this.active = active;
	}
	public String getNameBorrower() {
		return nameBorrower;
	}
	public void setNameBorrower(String nameBorrower) {
		this.nameBorrower = nameBorrower;
	}
	public double getRanking() {
		return ranking;
	}
	public void setRanking(double ranking) {
		this.ranking = ranking;
	}
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
	public String getPlannerPay() {
		return plannerPay;
	}
	public double getRentabilidad() {
		return rentabilidad;
	}
	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	public void setPlannerPay(String plannerPay) {
		this.plannerPay = plannerPay;
	}
	public void setRentabilidad(double rentabilidad) {
		this.rentabilidad = rentabilidad;
	}
	public double getSaldoCredito() {
		return saldoCredito;
	}
	public void setSaldoCredito(double saldoCredito) {
		this.saldoCredito = saldoCredito;
	}
	

	public String getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(String lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	
	public RelationPay(String id, String numberIdBorrower, String numberIdMoneylender, String dateSaveBD,
			String fechaAprobacion, String lastPaymentDate, String plannerPay, double approveValue, double saldoCredito,
			double rateApprobe, double feesApprobe, double gainAprrobe, int statusCredit, double feesPaid,
			String nextFeesDate, double nextPaid, double rentabilidad, double balancePaid, String nameBorrower,
			double ranking, double active, String gender, String activityBorrower) {
		super();
		this.id = id;
		this.numberIdBorrower = numberIdBorrower;
		this.numberIdMoneylender = numberIdMoneylender;
		this.dateSaveBD = dateSaveBD;
		this.fechaAprobacion = fechaAprobacion;
		this.lastPaymentDate = lastPaymentDate;
		this.plannerPay = plannerPay;
		this.approveValue = approveValue;
		this.saldoCredito = saldoCredito;
		this.rateApprobe = rateApprobe;
		this.feesApprobe = feesApprobe;
		this.gainAprrobe = gainAprrobe;
		this.statusCredit = statusCredit;
		this.feesPaid = feesPaid;
		this.nextFeesDate = nextFeesDate;
		this.nextPaid = nextPaid;
		this.rentabilidad = rentabilidad;
		this.balancePaid = balancePaid;
		this.nameBorrower = nameBorrower;
		this.ranking = ranking;
		this.active = active;
		this.gender = gender;
		this.activityBorrower = activityBorrower;
	}
	public String getDateSaveBD() {
		return dateSaveBD;
	}
	public void setDateSaveBD(String dateSaveBD) {
		this.dateSaveBD = dateSaveBD;
	}
	public RelationPay() {
		super();
	}
		
	
}
