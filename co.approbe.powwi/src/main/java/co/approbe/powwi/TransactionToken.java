package co.approbe.powwi;

public class TransactionToken {
	private String tokenConvenio;
	private int tipoValidacion;
	private String tipoTransaccion;
	private String celular;
	private String otp;
	private String idEnrolamiento;
	private String idValidacion;
	private Double scoreValidacion;
	private String idAutenticacionAliado;
	
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	public int getTipoValidacion() {
		return tipoValidacion;
	}
	public void setTipoValidacion(int tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getIdEnrolamiento() {
		return idEnrolamiento;
	}
	public void setIdEnrolamiento(String idEnrolamiento) {
		this.idEnrolamiento = idEnrolamiento;
	}
	public String getIdValidacion() {
		return idValidacion;
	}
	public void setIdValidacion(String idValidacion) {
		this.idValidacion = idValidacion;
	}
	public Double getScoreValidacion() {
		return scoreValidacion;
	}
	public void setScoreValidacion(Double scoreValidacion) {
		this.scoreValidacion = scoreValidacion;
	}
	public String getIdAutenticacionAliado() {
		return idAutenticacionAliado;
	}
	public void setIdAutenticacionAliado(String idAutenticacionAliado) {
		this.idAutenticacionAliado = idAutenticacionAliado;
	}	
	
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\",\"tipoValidacion\":\"" + tipoValidacion
				+ "\",\"tipoTransaccion\":\"" + tipoTransaccion + "\",\"celular\":\"" + celular + "\",\"otp\":\"" + otp
				+ "\",\"idEnrolamiento\":\"" + idEnrolamiento + "\",\"idValidacion\":\"" + idValidacion
				+ "\",\"scoreValidacion\":\"" + scoreValidacion + "\",\"idAutenticacionAliado\":\""
				+ idAutenticacionAliado + "\"}";
	}
	
	
	
	

	
}
