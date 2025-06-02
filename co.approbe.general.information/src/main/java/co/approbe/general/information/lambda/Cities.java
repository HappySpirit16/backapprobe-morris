package co.approbe.general.information.lambda;


import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "cities")
public class Cities {
	@DynamoDBHashKey
	private String department;
	@DynamoDBAttribute
	private List<String> city;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Cities() {
		super();
	}

	public List<String> getCity() {
		return city;
	}

	public void setCity(List<String> city) {
		this.city = city;
	}


	public Cities(String department, List<String> city) {
		super();
		this.department = department;
		this.city = city;
	}

	@Override
	public String toString() {
		return "{\"department\":\"" + department + "\", \"city\":\"" + city + "\"}";
	}
	

}
