package co.approbe.powwi.update;

public class ConsultarSaldo {
	private String tokenConvenio;
	private String tokenConsulta;
	private String huellaDispositivo;
	private String idCuenta;
	private String numeroCelular;
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	public String getTokenConsulta() {
		return tokenConsulta;
	}
	public void setTokenConsulta(String tokenConsulta) {
		this.tokenConsulta = tokenConsulta;
	}
	public String getHuellaDispositivo() {
		return huellaDispositivo;
	}
	public void setHuellaDispositivo(String huellaDispositivo) {
		this.huellaDispositivo = huellaDispositivo;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"tokenConsulta\":\"" + tokenConsulta
				+ "\", \"huellaDispositivo\":\"" + huellaDispositivo + "\", \"idCuenta\":\"" + idCuenta
				+ "\", \"numeroCelular\":\"" + numeroCelular + "\"}";
	}
	
	
	
	
	
}
