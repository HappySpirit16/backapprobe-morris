package co.approbe.pmt.borrower;

public class Loan {
	
	
	private int nper;
	private int pv;
	

	
	public Loan(int nper, int pv) {
		super();
		this.nper = nper;
		this.pv = pv;
	}


	public int getNper() {
		return nper;
	}


	public void setNper(int nper) {
		this.nper = nper;
	}


	public int getPv() {
		return pv;
	}


	public void setPv(int pv) {
		this.pv = pv;
	}


	public Loan() {
		super();
	}
 
	
	
	
}
