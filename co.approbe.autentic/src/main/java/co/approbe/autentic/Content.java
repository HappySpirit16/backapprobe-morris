package co.approbe.autentic;

import java.util.Map;

public class Content {
	private String fileName;
	private String fileContent;
	
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	
	
	@Override
	public String toString() {
		return "{\"fileName\":\"" + fileName + "\", \"fileContent\":\"" + fileContent + "\"}";
	}
	public Content() {
		super();
	}
	
	

}
