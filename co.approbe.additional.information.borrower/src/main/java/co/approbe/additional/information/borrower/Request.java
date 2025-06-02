package co.approbe.additional.information.borrower;

public class Request {
	private int id;
	private String httpMethod;
	private String numberId;
	private BasicInformation basicInformation;
	private Borrower borrower;
	private Log log;
	
	
	
	public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public BasicInformation getBasicInformation() {
		return basicInformation;
	}
	public void setBasicInformation(BasicInformation basicInformation) {
		this.basicInformation = basicInformation;
	}
	public Borrower getBorrower() {
		return borrower;
	}
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	
	
	
	
	

}
