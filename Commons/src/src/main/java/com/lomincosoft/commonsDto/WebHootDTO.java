package com.lomincosoft.commonsDto;

public class WebHootDTO {
	
	private String id;
	private String referenciaPago;
	private String statusCredit;
	private String statusDate;
	private String checkSum; 
	private long ammount;
	private String client; 
	private String referencia;
	
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public WebHootDTO() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReferenciaPago() {
		return referenciaPago;
	}
	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
	}
	public String getStatusCredit() {
		return statusCredit;
	}
	public void setStatusCredit(String statusCredit) {
		this.statusCredit = statusCredit;
	}
	public String getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}
	public String getCheckSum() {
		return checkSum;
	}
	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}
	public long getAmmount() {
		return ammount;
	}
	public void setAmmount(long ammount) {
		this.ammount = ammount;
	}
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"referenciaPago\":\"" + referenciaPago + "\",\"referencia\":\"" + referencia +"\", \"statusCredit\":\""
				+ statusCredit + "\", \"statusDate\":\"" + statusDate + "\", \"checkSum\":\"" + checkSum
				+ "\", \"ammount\":\"" + ammount + "\", \"client\":\"" + client + "\"}";
	}


}
