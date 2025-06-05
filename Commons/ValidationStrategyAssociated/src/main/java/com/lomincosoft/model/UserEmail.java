package com.lomincosoft.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "userEmail")
public class UserEmail {
	
	@DynamoDBHashKey
	@DynamoDBAttribute
	private String email;
	@DynamoDBAttribute
	private String numberId;
	@DynamoDBAttribute
	private String cellphone;
	@DynamoDBAttribute
	private String dateSave;
	@DynamoDBAttribute
	private int blocking;
	@DynamoDBAttribute
	private String blockingCause;
	public UserEmail() {
	
	}
	public UserEmail(String email, String numberId, String cellphone, String dateSave, int blocking,
			String blockingCause) {
		this.email = email;
		this.numberId = numberId;
		this.cellphone = cellphone;
		this.dateSave = dateSave;
		this.blocking = blocking;
		this.blockingCause = blockingCause;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getDateSave() {
		return dateSave;
	}
	public void setDateSave(String dateSave) {
		this.dateSave = dateSave;
	}

	public int getBlocking() {
		return blocking;
	}
	public void setBlocking(int blocking) {
		this.blocking = blocking;
	}
	public String getBlockingCause() {
		return blockingCause;
	}
	public void setBlockingCause(String blockingCause) {
		this.blockingCause = blockingCause;
	}
	@Override
	public String toString() {
		return "{\"email\":\"" + email + "\", \"numberId\":\"" + numberId + "\", \"cellphone\":\"" + cellphone
				+ "\", \"dateSave\":\"" + dateSave + "\", \"blocking\":\"" + blocking + "\", \"blockingCause\":\""
				+ blockingCause + "\"}";
	}
	
	
	

}
