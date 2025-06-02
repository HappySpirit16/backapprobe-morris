package co.approbe.powwi.update;

public class TokenConsulta {
	private String tokenConvenio;
	private String huellaDispositivo;
	private String idCuenta;
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
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
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"huellaDispositivo\":\"" + huellaDispositivo
				+ "\", \"idCuenta\":\"" + idCuenta + "\"}";
	}
	
}
