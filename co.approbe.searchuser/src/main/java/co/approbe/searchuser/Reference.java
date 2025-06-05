package co.approbe.searchuser;

public class Reference {
	private String personalName;
	private String personalLastname;
	private String personalCellphone;
	private String familiarName;
	private String familiarLastname;
	private String relationship;
	private String familiarCellphone;
	
	public String getPersonalName() {
		return personalName;
	}
	public void setPersonalName(String personalName) {
		this.personalName = personalName;
	}
	public String getPersonalLastname() {
		return personalLastname;
	}
	public void setPersonalLastname(String personalLastname) {
		this.personalLastname = personalLastname;
	}
	public String getPersonalCellphone() {
		return personalCellphone;
	}
	public void setPersonalCellphone(String personalCellphone) {
		this.personalCellphone = personalCellphone;
	}
	public String getFamiliarName() {
		return familiarName;
	}
	public void setFamiliarName(String familiarName) {
		this.familiarName = familiarName;
	}
	public String getFamiliarLastname() {
		return familiarLastname;
	}
	public void setFamiliarLastname(String familiarLastname) {
		this.familiarLastname = familiarLastname;
	}
	public String getFamiliarCellphone() {
		return familiarCellphone;
	}
	public void setFamiliarCellphone(String familiarCellphone) {
		this.familiarCellphone = familiarCellphone;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	@Override
	public String toString() {
		return "Reference [personalName=" + personalName + ", personalLastname=" + personalLastname
				+ ", personalCellphone=" + personalCellphone + ", familiarName=" + familiarName + ", familiarLastname="
				+ familiarLastname + ", relationship=" + relationship + ", familiarCellphone=" + familiarCellphone
				+ "]";
	}
	
		
	
}
