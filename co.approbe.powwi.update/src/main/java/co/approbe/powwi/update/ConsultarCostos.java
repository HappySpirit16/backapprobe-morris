package co.approbe.powwi.update;

public class ConsultarCostos {
	private String tokenConvenio;
	private String tipoOperacion;
	private String idCuenta;
	private String monto;
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"tipoOperacion\":\"" + tipoOperacion
				+ "\", \"idCuenta\":\"" + idCuenta + "\", \"monto\":\"" + monto + "\"}";
	}
	
	
	
}
