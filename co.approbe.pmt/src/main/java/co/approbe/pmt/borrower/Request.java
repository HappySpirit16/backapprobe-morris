package co.approbe.pmt.borrower;

public class Request {
	private int id;
	private int clientId;
	private String httpMethod;
	private Loan loan;	
	private CreditLine creditLine;
	
	
	
	@Override
	public String toString() {
		return "Request [id=" + id + ", clientId=" + clientId + ", httpMethod=" + httpMethod + ", loan=" + loan
				+ ", creditLine=" + creditLine + ", getClientId()=" + getClientId() + ", getId()=" + getId()
				+ ", getHttpMethod()=" + getHttpMethod() + ", getLoan()=" + getLoan() + ", getCreditLine()="
				+ getCreditLine() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Request() {
		super();
	}
	public Request(Loan loan) {
		super();
		this.loan = loan;
	}
	
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public Loan getLoan() {
		return loan;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	public CreditLine getCreditLine() {
		return creditLine;
	}
	public void setCreditLine(CreditLine creditLine) {
		this.creditLine = creditLine;
	}


}
