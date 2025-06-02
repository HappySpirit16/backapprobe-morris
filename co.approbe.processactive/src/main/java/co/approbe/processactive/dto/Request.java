package co.approbe.processactive.dto;

public class Request {
	private String email;
	private String httpMethod;
	private String id; 
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//para consultar movimientos de borrower o award
	private String numberId;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
}
