package com.approbe.summary;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="creditLine")
public class CreditLine {
	@DynamoDBHashKey(attributeName = "id")
	private int id;	
	@DynamoDBAttribute
	private int minValue;
	@DynamoDBAttribute
	private int maxValue;
	@DynamoDBAttribute
	private int minInstallments;
	@DynamoDBAttribute
	private int maxInstallments;
	@DynamoDBAttribute
	private String rate;
	@DynamoDBAttribute
	private String platformUse;
	@DynamoDBAttribute
	private String insurance;
	@DynamoDBAttribute
	private String rateApprobe;
	@DynamoDBAttribute
	private int administrationCredit;
	@DynamoDBAttribute
	private int serviceFee;
	@DynamoDBAttribute
	private int aval;
	@DynamoDBAttribute
	private int commission;
	@DynamoDBAttribute
	private int tax;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	public int getAval() {
		return aval;
	}
	public void setAval(int aval) {
		this.aval = aval;
	}
	public String getRateApprobe() {
		return rateApprobe;
	}
	public void setRateApprobe(String rateApprobe) {
		this.rateApprobe = rateApprobe;
	}
	
	public CreditLine() {
		super();
	}

	public int getMinValue() {
		return minValue;
	}
	public void setMinValue(int minValue) {
		this.minValue = minValue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	public int getMinInstallments() {
		return minInstallments;
	}
	public void setMinInstallments(int minInstallments) {
		this.minInstallments = minInstallments;
	}
	public int getMaxInstallments() {
		return maxInstallments;
	}
	public void setMaxInstallments(int maxInstallments) {
		this.maxInstallments = maxInstallments;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getPlatformUse() {
		return platformUse;
	}
	public void setPlatformUse(String platformUse) {
		this.platformUse = platformUse;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public int getAdministrationCredit() {
		return administrationCredit;
	}
	public void setAdministrationCredit(int administrationCredit) {
		this.administrationCredit = administrationCredit;
	}
	public int getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(int serviceFee) {
		this.serviceFee = serviceFee;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}
	public CreditLine(int id, int minValue, int maxValue, int minInstallments, int maxInstallments, String rate,
			String platformUse, String insurance, String rateApprobe, int administrationCredit, int serviceFee,
			int aval, int commission, int tax) {
		super();
		this.id = id;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.minInstallments = minInstallments;
		this.maxInstallments = maxInstallments;
		this.rate = rate;
		this.platformUse = platformUse;
		this.insurance = insurance;
		this.rateApprobe = rateApprobe;
		this.administrationCredit = administrationCredit;
		this.serviceFee = serviceFee;
		this.aval = aval;
		this.commission = commission;
		this.tax = tax;
	}
	
	
	
}
