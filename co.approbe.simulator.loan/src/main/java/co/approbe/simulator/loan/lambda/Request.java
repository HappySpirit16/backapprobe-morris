package co.approbe.simulator.loan.lambda;

public class Request {
	private int id;
	private int clientId;
	private String httpMethod;
	private Loan loan;	
	private CreditLine creditLine;
	private double rate;
	private String idRelationPay;
	private String fechaAprobacion;


	@Override
	public String toString() {
		return "Request [id=" + id + ", clientId=" + clientId + ", httpMethod=" + httpMethod + ", loan=" + loan
				+ ", creditLine=" + creditLine + ", rate=" + rate + ", idRelationPay=" + idRelationPay
				+ ", fechaAprobacion=" + fechaAprobacion + "]";
	}

	public String getFechaAprobacion() {
		return fechaAprobacion;
	}


	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}


	public String getIdRelationPay() {
		return idRelationPay;
	}

	public void setIdRelationPay(String idRelationPay) {
		this.idRelationPay = idRelationPay;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
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
