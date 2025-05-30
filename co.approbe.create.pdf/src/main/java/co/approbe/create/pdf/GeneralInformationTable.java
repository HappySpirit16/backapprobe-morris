package co.approbe.create.pdf;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "tableGeneralInformation")
public class GeneralInformationTable {
	
	@DynamoDBHashKey
	private int id;	
	@DynamoDBAttribute
	private String template;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public GeneralInformationTable() {
		super();
	}
	

}
