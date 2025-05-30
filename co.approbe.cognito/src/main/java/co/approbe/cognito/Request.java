package co.approbe.cognito;

public class Request {
	private String httpMethod;
	private String cognitoId;
	
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	public String getCognitoId() {
		return cognitoId;
	}
	public void setCognitoId(String cognitoId) {
		this.cognitoId = cognitoId;
	}
	
	public Request() {
		super();
	}
	public Request(String httpMethod, String cognitoId) {
		super();
		this.httpMethod = httpMethod;
		this.cognitoId = cognitoId;
	}
	
	
	
	
}
