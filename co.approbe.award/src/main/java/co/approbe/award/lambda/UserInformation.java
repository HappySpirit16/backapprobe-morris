package co.approbe.award.lambda;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

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
	@DynamoDBAttribute
	private Integer companySeniority;
	@DynamoDBTypeConvertedJson 	
	private GeneralInformation generalInformationAward;
	@DynamoDBTypeConvertedJson
	private FinancialInformation financialInformationAward;

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

	public Integer getCompanySeniority() {
		return companySeniority;
	}

	public void setCompanySeniority(Integer companySeniority) {
		this.companySeniority = companySeniority;
	}



	public GeneralInformation getGeneralInformationAward() {
		return generalInformationAward;
	}

	public void setGeneralInformationAward(GeneralInformation generalInformationAward) {
		this.generalInformationAward = generalInformationAward;
	}

	public FinancialInformation getFinancialInformationAward() {
		return financialInformationAward;
	}

	public void setFinancialInformationAward(FinancialInformation financialInformationAward) {
		this.financialInformationAward = financialInformationAward;
	}

	public String getNumberId() {
		return numberId;
	}

	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}

	
	public UserInformation() {
		super();
	}

	public UserInformation(String numberId, String names, String lastName, String gender, String email,
			String cellphone, String companyName, String companyActivity, String position, String companyPhone,
			String companyAddress, Integer companySeniority, GeneralInformation generalInformationAward,
			FinancialInformation financialInformationAward) {
		super();
		this.numberId = numberId;
		this.names = names;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.cellphone = cellphone;
		this.companyName = companyName;
		this.companyActivity = companyActivity;
		this.position = position;
		this.companyPhone = companyPhone;
		this.companyAddress = companyAddress;
		this.companySeniority = companySeniority;
		this.generalInformationAward = generalInformationAward;
		this.financialInformationAward = financialInformationAward;
	}

	@Override
	public String toString() {
		return "UserInformation [numberId=" + numberId + ", names=" + names + ", lastName=" + lastName + ", gender="
				+ gender + ", email=" + email + ", cellphone=" + cellphone + ", companyName=" + companyName
				+ ", companyActivity=" + companyActivity + ", position=" + position + ", companyPhone=" + companyPhone
				+ ", companyAddress=" + companyAddress + ", companySeniority=" + companySeniority
				+ ", generalInformationAward=" + generalInformationAward + ", financialInformationAward="
				+ financialInformationAward + "]";
	}



}
