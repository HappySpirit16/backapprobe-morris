package co.approbe.userinformation;

public class GeneralInformationAward {
	private String department;
	private String city;
	private String birth;
	private String maritalStatus;
	private String departmentResidence;
	private String address;
	private int value;
	private String occupation; 
	private String homePhone;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getDepartmentResidence() {
		return departmentResidence;
	}
	public void setDepartmentResidence(String departmentResidence) {
		this.departmentResidence = departmentResidence;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	@Override
	public String toString() {
		return "GeneralInformationAward [department=" + department + ", city=" + city + ", birth=" + birth
				+ ", maritalStatus=" + maritalStatus + ", departmentResidence=" + departmentResidence + ", address="
				+ address + ", value=" + value + ", occupation=" + occupation + ", homePhone=" + homePhone + "]";
	}
	public GeneralInformationAward(String department, String city, String birth, String maritalStatus,
			String departmentResidence, String address, int value, String occupation, String homePhone) {
		super();
		this.department = department;
		this.city = city;
		this.birth = birth;
		this.maritalStatus = maritalStatus;
		this.departmentResidence = departmentResidence;
		this.address = address;
		this.value = value;
		this.occupation = occupation;
		this.homePhone = homePhone;
	}
	public GeneralInformationAward() {
		super();
	}
	
	
}
