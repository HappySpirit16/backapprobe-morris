package co.approbe.powwi.auth;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "userInformation")
public class UserInformation {

	@DynamoDBHashKey
	private String numberId;
	@DynamoDBAttribute
	private String names;
	@DynamoDBAttribute
	private String lastName;
	@DynamoDBAttribute
	private String gender;
	@DynamoDBAttribute
	private String email;
	@DynamoDBAttribute
	private String cellphone;
	@DynamoDBAttribute
	private String companyName;
	@DynamoDBAttribute
	private String companyActivity;
	@DynamoDBAttribute
	private String position;
	@DynamoDBAttribute
	private String companyPhone;
	@DynamoDBAttribute
	private String companyAddress;
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyActivity() {
		return companyActivity;
	}
	public void setCompanyActivity(String companyActivity) {
		this.companyActivity = companyActivity;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	
	
	
}
