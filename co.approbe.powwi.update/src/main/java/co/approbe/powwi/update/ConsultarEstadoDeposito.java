package co.approbe.powwi.update;

public class ConsultarEstadoDeposito {
	private String tokenConvenio;
	private String numeroCelular;
	private String idCuenta;
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"numeroCelular\":\"" + numeroCelular
				+ "\", \"idCuenta\":\"" + idCuenta + "\"}";
	}
	
	
	
}
