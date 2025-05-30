package co.approbe.create.pdf;

public class Request {

	private String name;
	private String numberId;
	private String phone;
	private String pdf;
	private String address;
	private String borrowerNumberCredit;
	private String financiador; 
	private String idFinancier; 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPdf() {
		return pdf;
	}
	public void setPdf(String pdf) {
		this.pdf = pdf;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getBorrowerNumberCredit() {
		return borrowerNumberCredit;
	}
	public void setBorrowerNumberCredit(String borrowerNumberCredit) {
		this.borrowerNumberCredit = borrowerNumberCredit;
	}
	
	
	public String getFinanciador() {
		return financiador;
	}
	public void setFinanciador(String financiador) {
		this.financiador = financiador;
	}
	public String getIdFinancier() {
		return idFinancier;
	}
	public void setIdFinancier(String idFinancier) {
		this.idFinancier = idFinancier;
	}
	public Request(String name, String numberId, String phone, String pdf, String address,
			String borrowerNumberCredit) {
		super();
		this.name = name;
		this.numberId = numberId;
		this.phone = phone;
		this.pdf = pdf;
		this.address = address;
		this.borrowerNumberCredit = borrowerNumberCredit;
	}
	public Request() {
		super();
	}
	
	
}
