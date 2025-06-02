package co.approbe.core.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "hubspot")
public class Hubspot {

	@DynamoDBHashKey
	@DynamoDBAttribute
	private String id;
	@DynamoDBAttribute
	private String numberId;
	@DynamoDBAttribute
	private String creationDate; 
	@DynamoDBAttribute
	private String idHubspot; 
	@DynamoDBAttribute
	private String updateDate;
	@DynamoDBAttribute
	private String typeCreation;
	
	public Hubspot() {
		super();
	}
	
	public Hubspot(String id, String numberId, String creationDate, String idHubspot, String updateDate,
			String typeCreation) {
		super();
		this.id = id;
		this.numberId = numberId;
		this.creationDate = creationDate;
		this.idHubspot = idHubspot;
		this.updateDate = updateDate;
		this.typeCreation = typeCreation;
	}

	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public String getIdHubspot() {
		return idHubspot;
	}
	public void setIdHubspot(String idHubspot) {
		this.idHubspot = idHubspot;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getTypeCreation() {
		return typeCreation;
	}

	public void setTypeCreation(String typeCreation) {
		this.typeCreation = typeCreation;
	}
	
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"numberId\":\"" + numberId + "\", \"creationDate\":\"" + creationDate
				+ "\", \"idHubspot\":\"" + idHubspot + "\", \"updateDate\":\"" + updateDate + "\", \"typeCreation\":\""
				+ typeCreation + "\"}";
	}
	
}