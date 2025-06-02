package co.approbe.powwi.transaction;

public class Profession {
	private String profession;

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "" + profession ;
	}
}
