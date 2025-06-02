package co.approbe.processactive.dto;

public class Loan {
	
	
	private Double fees;
	private Double value;

	public Double getFees() {
		return fees;
	}


	public Double getValue() {
		return value;
	}


	public void setFees(Double fees) {
		this.fees = fees;
	}


	public void setValue(Double value) {
		this.value = value;
	}


	public Loan(Double fees, Double value) {
		super();
		this.fees = fees;
		this.value = value;
	}


	public Loan() {
		super();
	}


	@Override
	public String toString() {
		return "Loan [fees=" + fees + ", value=" + value + "]";
	}



}
