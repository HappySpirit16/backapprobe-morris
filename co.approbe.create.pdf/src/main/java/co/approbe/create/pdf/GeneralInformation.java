package co.approbe.create.pdf;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

public class GeneralInformation {
	@DynamoDBTypeConvertedJson
	private Department department;
	@DynamoDBTypeConvertedJson
	private City city;
	private String birth;
	@DynamoDBTypeConvertedJson
	private MaritalStatus maritalStatus;
	@DynamoDBTypeConvertedJson
	private DepartmentResidence departmentResidence;
	private String address;
	private int stratum;
	@DynamoDBTypeConvertedJson
	private HomeType homeType; 
	private String homePhone;
	private int personCharge;
	private int numberChildren;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public DepartmentResidence getDepartmentResidence() {
		return departmentResidence;
	}
	public void setDepartmentResidence(DepartmentResidence departmentResidence) {
		this.departmentResidence = departmentResidence;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStratum() {
		return stratum;
	}
	public void setStratum(int stratum) {
		this.stratum = stratum;
	}
	public HomeType getHomeType() {
		return homeType;
	}
	public void setHomeType(HomeType homeType) {
		this.homeType = homeType;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public int getPersonCharge() {
		return personCharge;
	}
	public void setPersonCharge(int personCharge) {
		this.personCharge = personCharge;
	}
	public int getNumberChildren() {
		return numberChildren;
	}
	public void setNumberChildren(int numberChildren) {
		this.numberChildren = numberChildren;
	}
	@Override
	public String toString() {
		return "GeneralInformation [department=" + department + ", city=" + city + ", birth=" + birth
				+ ", maritalStatus=" + maritalStatus + ", departmentResidence=" + departmentResidence + ", address="
				+ address + ", stratum=" + stratum + ", homeType=" + homeType + ", homePhone=" + homePhone
				+ ", personCharge=" + personCharge + ", numberChildren=" + numberChildren + "]";
	}
	
	
}
