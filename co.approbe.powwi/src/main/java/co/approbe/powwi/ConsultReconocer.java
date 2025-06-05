package co.approbe.powwi;

public class ConsultReconocer {
	private String tipoIdentificacion;
	private String identificacion;
	private String primerApellido;
	private String name;
	private String fullName;
	private String celularFormulario;
	private String emailFormulario;
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCelularFormulario() {
		return celularFormulario;
	}
	public void setCelularFormulario(String celularFormulario) {
		this.celularFormulario = celularFormulario;
	}
	public String getEmailFormulario() {
		return emailFormulario;
	}
	public void setEmailFormulario(String emailFormulario) {
		this.emailFormulario = emailFormulario;
	}
	@Override
	public String toString() {
		return "{\"tipoIdentificacion\":\"" + tipoIdentificacion + "\", \"identificacion\":\"" + identificacion
				+ "\", \"primerApellido\":\"" + primerApellido + "\", \"name\":\"" + name + "\", \"fullName\":\""
				+ fullName + "\", \"celularFormulario\":\"" + celularFormulario + "\", \"emailFormulario\":\""
				+ emailFormulario + "\"}";
	}
	
	
}
