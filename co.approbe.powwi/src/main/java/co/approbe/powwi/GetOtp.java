package co.approbe.powwi;

public class GetOtp {
	private String tokenConvenio;
	private String celular;
	private String canal;
	private String tipoTransaccion;
	private String codigoTransaccion;
	private String idCuenta;
	
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public String getCodigoTransaccion() {
		return codigoTransaccion;
	}
	public void setCodigoTransaccion(String codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}
	
	
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"celular\":\"" + celular + "\", \"canal\":\"" + canal
				+ "\", \"tipoTransaccion\":\"" + tipoTransaccion + "\", \"codigoTransaccion\":\"" + codigoTransaccion
				+ "\", \"idCuenta\":\"" + idCuenta + "\"}";
	}
	
	
	
	
	
	
}
