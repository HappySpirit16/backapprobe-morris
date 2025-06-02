package com.approbe.summary;

public class Request {
	private String id;
//	private int percentage;
//	private int clientId;
//	private String httpMethod;
//	private int value;
//	private CreditLine creditLine;
//	private NumberId numberId;
	
	
	public Request() {
		super();
	}
	
	



	@Override
	public String toString() {
		return "Request [id=" + id + "]";
	}





	public Request(String id) {
	super();
	this.id = id;
}





	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	


	

	
	
}
