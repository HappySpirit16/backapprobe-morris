package co.approbe.powwi.transaction;

public class Relation {
	public String numberIdBorrower;
	public String numberIdMoneylender;
	public String getNumberIdBorrower() {
		return numberIdBorrower;
	}
	public void setNumberIdBorrower(String numberIdBorrower) {
		this.numberIdBorrower = numberIdBorrower;
	}
	public String getNumberIdMoneylender() {
		return numberIdMoneylender;
	}
	public void setNumberIdMoneylender(String numberIdMoneylender) {
		this.numberIdMoneylender = numberIdMoneylender;
	}
	public Relation(String numberIdBorrower, String numberIdMoneylender) {
		super();
		this.numberIdBorrower = numberIdBorrower;
		this.numberIdMoneylender = numberIdMoneylender;
	}
	
	
	public Relation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "{\"numberIdBorrower\":\"" + numberIdBorrower + "\", \"numberIdMoneylender\":\"" + numberIdMoneylender
				+ "\"}";
	}
	

}
