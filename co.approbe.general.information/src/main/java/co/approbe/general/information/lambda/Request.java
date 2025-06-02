package co.approbe.general.information.lambda;

public class Request {
	private int id;
	private String httpMethod;
	private String departament; 
	private Information information;
	
	public String getDepartament() {
		return departament;
	}
	public Information getInformation() {
		return information;
	}
	public void setDepartament(String departament) {
		this.departament = departament;
	}
	public void setInformation(Information information) {
		this.information = information;
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
	public Information getPrueba() {
		return information;
	}
	public void setPrueba(Information information) {
		this.information = information;
	}
	
	
	
	
	
	
	

}
