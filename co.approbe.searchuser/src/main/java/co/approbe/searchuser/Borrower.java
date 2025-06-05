package co.approbe.searchuser;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

@DynamoDBTable(tableName = "borrower")
public class Borrower {
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
	private GeneralInformation generalInformation;
	@DynamoDBTypeConvertedJson
	private Reference reference;
	@DynamoDBTypeConvertedJson
	private FinancialInformation financialInformation;
	@DynamoDBTypeConvertedJson
	private CreditInformation creditInformation;


	public GeneralInformation getGeneralInformation() {
		return generalInformation;
	}



	public void setGeneralInformation(GeneralInformation generalInformation) {
		this.generalInformation = generalInformation;
	}



	public Reference getReference() {
		return reference;
	}



	public void setReference(Reference reference) {
		this.reference = reference;
	}



	public FinancialInformation getFinancialInformation() {
		return financialInformation;
	}



	public void setFinancialInformation(FinancialInformation financialInformation) {
		this.financialInformation = financialInformation;
	}



	public CreditInformation getCreditInformation() {
		return creditInformation;
	}



	public void setCreditInformation(CreditInformation creditInformation) {
		this.creditInformation = creditInformation;
	}



	public String getNames() {
		return names;
	}



	public void setNames(String names) {
		this.names = names;
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

	
	
	public String getNumberId() {
		return numberId;
	}



	public void setNumberId(String numberId) {
		this.numberId = numberId;
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

	public Borrower() {
		super();
	}





	public Borrower(String numberId, String names, String lastName, String email, String cellphone, String gender) {
		super();
		this.numberId = numberId;
		this.names = names;
		this.lastName = lastName;
		this.email = email;
		this.cellphone = cellphone;
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "Borrower [numberId=" + numberId + ", names=" + names + ", lastName=" + lastName + ", email=" + email
				+ ", cellphone=" + cellphone + ", gender=" + gender + "]";
	}




	
}
