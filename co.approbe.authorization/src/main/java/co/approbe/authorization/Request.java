package co.approbe.authorization;

public class Request {
	private int id;
	private String httpMethod;
	private String numberId;
	private Data data;
	private String flag;
	
	
	
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
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	@Override
	public String toString() {
		return "Request [id=" + id + ", httpMethod=" + httpMethod + ", numberId=" + numberId + ", data=" + data
				+ ", flag=" + flag + "]";
	}																																																																																																			
}
