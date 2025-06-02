package co.approbe.powwi.transaction;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

public class GeneralInformation {
	@DynamoDBTypeConvertedJson
	private Department department;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
