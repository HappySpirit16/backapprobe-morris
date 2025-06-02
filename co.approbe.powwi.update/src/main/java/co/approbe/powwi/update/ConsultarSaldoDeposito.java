package co.approbe.powwi.update;

public class ConsultarSaldoDeposito {
	private String tokenConvenio;
	private String tipoConsulta;
	private String idCuenta;
	private String indiceInicial;
	private String numeroRegistros;
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getIndiceInicial() {
		return indiceInicial;
	}
	public void setIndiceInicial(String indiceInicial) {
		this.indiceInicial = indiceInicial;
	}
	public String getNumeroRegistros() {
		return numeroRegistros;
	}
	public void setNumeroRegistros(String numeroRegistros) {
		this.numeroRegistros = numeroRegistros;
	}
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"tipoConsulta\":\"" + tipoConsulta
				+ "\", \"idCuenta\":\"" + idCuenta + "\", \"indiceInicial\":\"" + indiceInicial
				+ "\", \"numeroRegistros\":\"" + numeroRegistros + "\"}";
	}
	
	
}
