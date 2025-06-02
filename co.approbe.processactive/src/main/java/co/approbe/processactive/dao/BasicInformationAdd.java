package co.approbe.processactive.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName = "borrower")
public class BasicInformationAdd {
	
	@DynamoDBHashKey
	private String numberId;
	@DynamoDBAttribute
	private double active;
	@DynamoDBAttribute
	private String dateActive6;
	@DynamoDBAttribute
	private String dateLastUpdate;

	
	
	public String getNumberId() {
		return numberId;
	}



	public double getActive() {
		return active;
	}



	public String getDateActive6() {
		return dateActive6;
	}



	public String getDateLastUpdate() {
		return dateLastUpdate;
	}



	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}



	public void setActive(double active) {
		this.active = active;
	}



	public void setDateActive6(String dateActive6) {
		this.dateActive6 = dateActive6;
	}



	public void setDateLastUpdate(String dateLastUpdate) {
		this.dateLastUpdate = dateLastUpdate;
	}



	public BasicInformationAdd(String numberId, double active, String dateActive6, String dateLastUpdate) {
		super();
		this.numberId = numberId;
		this.active = active;
		this.dateActive6 = dateActive6;
		this.dateLastUpdate = dateLastUpdate;
	}



	public BasicInformationAdd() {
		super();
	}
	
	
}
