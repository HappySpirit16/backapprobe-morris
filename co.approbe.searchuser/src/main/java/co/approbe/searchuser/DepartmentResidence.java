package co.approbe.searchuser;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

public class DepartmentResidence {
	@DynamoDBTypeConvertedJson
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "DepartmentResidence [department=" + department + "]";
	}
	
	

}
