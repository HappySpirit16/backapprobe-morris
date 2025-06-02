package co.approbe.powwi.update;

public class ConsultarEstadoRetiro {
	private String tokenConvenio;
	private String idCuenta;
	private String idOperacion;
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"idCuenta\":\"" + idCuenta + "\", \"idOperacion\":\""
				+ idOperacion + "\"}";
	}
	
	
	
}
