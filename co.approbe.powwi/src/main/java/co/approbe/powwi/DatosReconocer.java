package co.approbe.powwi;

public class DatosReconocer {
	private String celular;
	private String email;
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "{\"celular\":\"" + celular + "\", \"email\":\"" + email + "\"}";
	}
	
}
