package co.approbe.userinformation;

public class Request {
	private String httpMethod;
	private String numberId;
    private String names; 
    private String lastName; 
	private String cellphone;
    private String companyName;
    private String companyActivity;
    private String position;
    private String companyPhone;
    private String companyAddress;
    private Integer companySeniority;
    private GeneralInformation generalInformation;
	private Reference reference;
	private FinancialInformation financialInformation;
	private GeneralInformationAward generalInformationAward;
	private FinancialInformationAward financialInformationAward;
	
	 public String getLastName() {
			return lastName;
		}
	public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
	public FinancialInformationAward getFinancialInformationAward() {
		return financialInformationAward;
	}
	public void setFinancialInformationAward(FinancialInformationAward financialInformationAward) {
		this.financialInformationAward = financialInformationAward;
	}
	public GeneralInformationAward getGeneralInformationAward() {
		return generalInformationAward;
	}
	public void setGeneralInformationAward(GeneralInformationAward generalInformationAward) {
		this.generalInformationAward = generalInformationAward;
	}
	public FinancialInformation getFinancialInformation() {
		return financialInformation;
	}
	public void setFinancialInformation(FinancialInformation financialInformation) {
		this.financialInformation = financialInformation;
	}
	public Reference getReference() {
		return reference;
	}
	public void setReference(Reference reference) {
		this.reference = reference;
	}
	public GeneralInformation getGeneralInformation() {
		return generalInformation;
	}
	public void setGeneralInformation(GeneralInformation generalInformation) {
		this.generalInformation = generalInformation;
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
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	} 
	
}
