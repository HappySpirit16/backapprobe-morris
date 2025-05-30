package co.approbe.create.pdf;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

@DynamoDBTable(tableName = "borrower")
public class BasicInformation {
	@DynamoDBTypeConvertedJson
	private Identification identification;
	@DynamoDBHashKey
	private String numberId;
	@DynamoDBAttribute
	private String expeditionDate;
	@DynamoDBAttribute
	private String names;
	@DynamoDBAttribute
	private String lastName;
	@DynamoDBAttribute
	private String cellphone;
	@DynamoDBTypeConvertedJson
	private GeneralInformation generalInformation;
	@DynamoDBAttribute
	private String gender;
	@DynamoDBAttribute
	private String email;
	@DynamoDBAttribute
	private String dataExperianS;
	@DynamoDBAttribute
	private String birthday;
	@DynamoDBAttribute
	private int age;
	public Identification getIdentification() {
		return identification;
	}
	public void setIdentification(Identification identification) {
		this.identification = identification;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public String getExpeditionDate() {
		return expeditionDate;
	}
	public void setExpeditionDate(String expeditionDate) {
		this.expeditionDate = expeditionDate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataExperianS() {
		return dataExperianS;
	}
	public void setDataExperianS(String dataExperianS) {
		this.dataExperianS = dataExperianS;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	public GeneralInformation getGeneralInformation() {
		return generalInformation;
	}
	public void setGeneralInformation(GeneralInformation generalInformation) {
		this.generalInformation = generalInformation;
	}
	
	
	public BasicInformation(Identification identification, String numberId, String expeditionDate, String names,
			String lastName, String cellphone, GeneralInformation generalInformation, String gender, String email,
			String dataExperianS, String birthday, int age) {
		super();
		this.identification = identification;
		this.numberId = numberId;
		this.expeditionDate = expeditionDate;
		this.names = names;
		this.lastName = lastName;
		this.cellphone = cellphone;
		this.generalInformation = generalInformation;
		this.gender = gender;
		this.email = email;
		this.dataExperianS = dataExperianS;
		this.birthday = birthday;
		this.age = age;
	}
	public BasicInformation() {
		super();
	}
	
	
	
	

		

}
