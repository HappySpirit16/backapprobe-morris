package co.approbe.award.lambda;

public class Request {
	private int id;
	private String httpMethod;
	private String numberId;
	private BasicInformation basicInformation;
	private Powi powwi;
	
	public Powi getPowwi() {
		return powwi;
	}
	public void setPowwi(Powi powwi) {
		this.powwi = powwi;
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
	
	
	
	
	

}
