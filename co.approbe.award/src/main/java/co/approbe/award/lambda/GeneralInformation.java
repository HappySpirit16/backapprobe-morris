package co.approbe.award.lambda;

public class GeneralInformation {
	private String department;
	private String city;
	private String birth;
	private String maritalStatus;
	private String departmentResidence;
	private String address;
	private int value;
	private String occupation; 
	private String homePhone;
	
	
	@Override
	public String toString() {
		return "GeneralInformation [department=" + department + ", city=" + city + ", birth=" + birth
				+ ", maritalStatus=" + maritalStatus + ", departmentResidence=" + departmentResidence + ", address="
				+ address + ", value=" + value + ", occupation=" + occupation + ", homePhone=" + homePhone + "]";
	}
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
	public int getStratum() {
		return value;
	}
	public void setStratum(int stratum) {
		this.value = stratum;
	}
	public String getHomeType() {
		return occupation;
	}
	public void setHomeType(String homeType) {
		this.occupation = homeType;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	
	
	
}
