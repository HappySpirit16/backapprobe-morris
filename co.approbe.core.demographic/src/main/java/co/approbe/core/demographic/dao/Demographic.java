package co.approbe.core.demographic.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "demographic")
public class Demographic {
	@DynamoDBAttribute
	@DynamoDBHashKey
	private String clientNumber;
	@DynamoDBAttribute
	private String numberId;
	@DynamoDBAttribute
	private String typeId;
	@DynamoDBAttribute
	private String name1; 
	@DynamoDBAttribute
	private String name2;
	@DynamoDBAttribute
	private String lastname1;
	@DynamoDBAttribute
	private String lastname2;
	@DynamoDBAttribute
	private String bussinesName;
	@DynamoDBAttribute
	private String cellphoneNumber;
	@DynamoDBAttribute
	private String city;
	@DynamoDBAttribute
	private String address;
	@DynamoDBAttribute
	private String department;
	@DynamoDBAttribute
	private String district;
	public String getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getLastname1() {
		return lastname1;
	}
	public void setLastname1(String lastname1) {
		this.lastname1 = lastname1;
	}
	public String getLastname2() {
		return lastname2;
	}
	public void setLastname2(String lastname2) {
		this.lastname2 = lastname2;
	}
	public String getBussinesName() {
		return bussinesName;
	}
	public void setBussinesName(String bussinesName) {
		this.bussinesName = bussinesName;
	}
	
	public String getCellphoneNumber() {
		return cellphoneNumber;
	}
	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public Demographic(String clientNumber, String numberId, String typeId, String name1, String name2,
			String lastname1, String lastname2, String bussinesName, String cellphoneNumber, String city,
			String address, String department, String district) {
		super();
		this.clientNumber = clientNumber;
		this.numberId = numberId;
		this.typeId = typeId;
		this.name1 = name1;
		this.name2 = name2;
		this.lastname1 = lastname1;
		this.lastname2 = lastname2;
		this.bussinesName = bussinesName;
		this.cellphoneNumber = cellphoneNumber;
		this.city = city;
		this.address = address;
		this.department = department;
		this.district = district;
	}
	public Demographic() {
		super();
	}
	@Override
	public String toString() {
		return "{\"clientNumber\":\"" + clientNumber + "\", \"numberId\":\"" + numberId + "\", \"typeId\":\"" + typeId
				+ "\", \"name1\":\"" + name1 + "\", \"name2\":\"" + name2 + "\", \"lastname1\":\"" + lastname1
				+ "\", \"lastname2\":\"" + lastname2 + "\", \"bussinesName\":\"" + bussinesName
				+ "\", \"cellphoneNumber\":\"" + cellphoneNumber + "\", \"city\":\"" + city + "\", \"address\":\""
				+ address + "\", \"department\":\"" + department + "\", \"district\":\"" + district + "\"}";
	}
	

}
