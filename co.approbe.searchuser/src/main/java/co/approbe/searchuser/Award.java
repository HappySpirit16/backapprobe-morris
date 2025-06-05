package co.approbe.searchuser;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

@DynamoDBTable(tableName = "award")
public class Award {
	@DynamoDBHashKey
	private String numberId;
	@DynamoDBAttribute
	private String names;
	@DynamoDBAttribute
	private String lastName;
	@DynamoDBAttribute
	private String email;
	@DynamoDBAttribute
	private String cellphone;
	@DynamoDBAttribute
	private String gender;
	@DynamoDBTypeConvertedJson
	private EconomicActivity economicActivity;
	@DynamoDBTypeConvertedJson
	private GeneralInformationAward generalInformation;
	@DynamoDBTypeConvertedJson
	private FinancialInformationAward financialInformation;
	
	public GeneralInformationAward getGeneralInformation() {
		return generalInformation;
	}
	public void setGeneralInformation(GeneralInformationAward generalInformation) {
		this.generalInformation = generalInformation;
	}
	public EconomicActivity getEconomicActivity() {
		return economicActivity;
	}
	public void setEconomicActivity(EconomicActivity economicActivity) {
		this.economicActivity = economicActivity;
	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public FinancialInformationAward getFinancialInformation() {
		return financialInformation;
	}
	public void setFinancialInformation(FinancialInformationAward financialInformation) {
		this.financialInformation = financialInformation;
	}
	public Award() {
		super();
	}

	public Award(String numberId, String names, String lastName, String email, String cellphone, String gender,
			EconomicActivity economicActivity, GeneralInformationAward generalInformation,
			FinancialInformationAward financialInformation) {
		super();
		this.numberId = numberId;
		this.names = names;
		this.lastName = lastName;
		this.email = email;
		this.cellphone = cellphone;
		this.gender = gender;
		this.economicActivity = economicActivity;
		this.generalInformation = generalInformation;
		this.financialInformation = financialInformation;
	}
	@Override
	public String toString() {
		return "Award [numberId=" + numberId + ", names=" + names + ", lastName=" + lastName + ", email=" + email
				+ ", cellphone=" + cellphone + ", gender=" + gender + ", economicActivity=" + economicActivity
				+ ", generalInformation=" + generalInformation + ", financialInformation=" + financialInformation + "]";
	}

	
	
	
	

}
