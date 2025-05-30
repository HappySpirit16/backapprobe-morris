package co.approbe.create.pdf;

public class PdfStructure {
	private String name;
	private int pag;
	private byte[] data;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPag() {
		return pag;
	}
	public void setPag(int pag) {
		this.pag = pag;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	public PdfStructure(String name, int pag, byte[] data) {
		super();
		this.name = name;
		this.pag = pag;
		this.data = data;
	}
	public PdfStructure() {
		super();
	}
	
	

}
