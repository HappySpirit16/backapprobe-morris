package co.approbe.award.lambda;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel.DynamoDBAttributeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;

@DynamoDBTable(tableName = "authorizationData")
public class Data {
	@DynamoDBHashKey
	private String numberId;
	@DynamoDBTyped(DynamoDBAttributeType.BOOL)
	@DynamoDBAttribute
	private Boolean validCellphone;
	@DynamoDBAttribute
	private Integer countJurad;
	
	@DynamoDBTyped(DynamoDBAttributeType.BOOL)
	@DynamoDBAttribute
	private Boolean validJurad;
	@DynamoDBAttribute
	private String dateSave;
	
	
	public String getNumberId() {
		return numberId;
	}
	public Boolean getValidCellphone() {
		return validCellphone;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public void setValidCellphone(Boolean validCellphone) {
		this.validCellphone = validCellphone;
	}
	public Integer getCountJurad() {
		return countJurad;
	}
	public void setCountJurad(Integer countJurad) {
		this.countJurad = countJurad;
	}
	public Boolean getValidJurad() {
		return validJurad;
	}
	public void setValidJurad(Boolean validJurad) {
		this.validJurad = validJurad;
	}
	public String getDateSave() {
		return dateSave;
	}
	public void setDateSave(String dateSave) {
		this.dateSave = dateSave;
	}
	
	
	
	
	
}
