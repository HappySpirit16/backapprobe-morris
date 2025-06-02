package co.approbe.chance.cron;

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
	private String dateSaveBD;
	public String getNumberId() {
		return numberId;
	}
	public double getActive() {
		return active;
	}
	public String getDateSaveBD() {
		return dateSaveBD;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public void setActive(double active) {
		this.active = active;
	}
	public void setDateSaveBD(String dateSaveBD) {
		this.dateSaveBD = dateSaveBD;
	}
	public BasicInformationAdd(String numberId, double active, String dateSaveBD) {
		super();
		this.numberId = numberId;
		this.active = active;
		this.dateSaveBD = dateSaveBD;
	}
	public BasicInformationAdd() {
		super();
	}

	
}
