package com.lomincosoft.commonsDto;

import java.util.List;

public class ValidationStrategyDto  {

	private String id; 
	private double amountFinance;
	private int fees; 
	private double rateApprobeAnnual; 
	private double rateApprobeMonth; 
	private double fGA; 
	private double platform; 
	private String datePaid; 
	private String numCredit; 
	private String minPaid; 
	private String fechaCreacion; 
	private String paid; 
	private String url;
	private double cuotaBenefits;
	private double feesBenefits;
	
	
	private String validationStrategy;
	private CuestionarioDto questionarie;
	private List<DocumentDto> documents; 
	private List<String> partner; 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public List<DocumentDto> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentDto> documents) {
		this.documents = documents;
	}

	public String getValidationStrategy() {
		return validationStrategy;
	}

	public void setValidationStrategy(String validationStrategy) {
		this.validationStrategy = validationStrategy;
	}

	public CuestionarioDto getQuestionarie() {
		return questionarie;
	}

	public void setQuestionarie(CuestionarioDto questionarie) {
		this.questionarie = questionarie;
	}
	public double getAmountFinance() {
		return amountFinance;
	}
	public void setAmountFinance(double amountFinance) {
		this.amountFinance = amountFinance;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public double getRateApprobeAnnual() {
		return rateApprobeAnnual;
	}
	public void setRateApprobeAnnual(double rateApprobeAnnual) {
		this.rateApprobeAnnual = rateApprobeAnnual;
	}
	public double getRateApprobeMonth() {
		return rateApprobeMonth;
	}
	public void setRateApprobeMonth(double rateApprobeMonth) {
		this.rateApprobeMonth = rateApprobeMonth;
	}
	public double getfGA() {
		return fGA;
	}
	public void setfGA(double fGA) {
		this.fGA = fGA;
	}
	public double getPlatform() {
		return platform;
	}
	public void setPlatform(double platform) {
		this.platform = platform;
	}
	public String getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(String datePaid) {
		this.datePaid = datePaid;
	}
	public String getNumCredit() {
		return numCredit;
	}
	public void setNumCredit(String numCredit) {
		this.numCredit = numCredit;
	}
	public String getMinPaid() {
		return minPaid;
	}
	public void setMinPaid(String minPaid) {
		this.minPaid = minPaid;
	}
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPaid() {
		return paid;
	}
	public void setPaid(String paid) {
		this.paid = paid;
	}

	public double getCuotaBenefits() {
		return cuotaBenefits;
	}
	public void setCuotaBenefits(double cuotaBenefits) {
		this.cuotaBenefits = cuotaBenefits;
	}
	public double getFeesBenefits() {
		return feesBenefits;
	}
	public void setFeesBenefits(double feesBenefits) {
		this.feesBenefits = feesBenefits;
	}
	public List<String> getPartner() {
		return partner;
	}
	public void setPartner(List<String> partner) {
		this.partner = partner;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"amountFinance\":\"" + amountFinance + "\", \"fees\":\"" + fees
				+ "\", \"rateApprobeAnnual\":\"" + rateApprobeAnnual + "\", \"rateApprobeMonth\":\"" + rateApprobeMonth
				+ "\", \"fGA\":\"" + fGA + "\", \"platform\":\"" + platform + "\", \"validationStrategy\":\""
				+ validationStrategy + "\", \"questionarie\":\"" + questionarie.toString() + "\", \"documents\":\"" + documents
				+ "\",\"datePaid\":\""+datePaid+"\",\numCredit\":\""+numCredit+"\",\"minPaid\":\""+minPaid+"\",\"fechaCreacion\":\""+fechaCreacion+"\""
						+ ",\"paid\":\""+paid+"\"}";
	}

}
