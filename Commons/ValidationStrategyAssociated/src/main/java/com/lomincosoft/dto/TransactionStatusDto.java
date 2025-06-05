package com.lomincosoft.dto;

public class TransactionStatusDto {

	private String id;
	private String ammount;
	private String status;
	private String creationDate;
	private String cyclo; 
	private String statusDate;
	private String accountingDate; 
	private String msg; 
	
	
	public TransactionStatusDto() {
	
	}
	public TransactionStatusDto(String id, String ammount, String status, String creationDate, String cyclo,
			String statusDate, String accountingDate, String msg) {
		super();
		this.id = id;
		this.ammount = ammount;
		this.status = status;
		this.creationDate = creationDate;
		this.cyclo = cyclo;
		this.statusDate = statusDate;
		this.accountingDate = accountingDate;
		this.msg = msg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAmmount() {
		return ammount;
	}
	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getCyclo() {
		return cyclo;
	}
	public void setCyclo(String cyclo) {
		this.cyclo = cyclo;
	}
	public String getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}
	public String getAccountingDate() {
		return accountingDate;
	}
	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"ammount\":\"" + ammount + "\", \"status\":\"" + status
				+ "\", \"creationDate\":\"" + creationDate + "\", \"cyclo\":\"" + cyclo + "\", \"statusDate\":\""
				+ statusDate + "\", \"accountingDate\":\"" + accountingDate + "\", \"msg\":\"" + msg + "\"}";
	}
}
