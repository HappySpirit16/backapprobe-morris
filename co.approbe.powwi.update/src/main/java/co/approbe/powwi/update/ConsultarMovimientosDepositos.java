package co.approbe.powwi.update;

import java.util.Date;

public class ConsultarMovimientosDepositos {
	private String tokenConvenio;
	private String tipoConsulta;
	private String idCuenta;
	private Integer indiceInicial;
	private String numeroRegistros;
	private String limiteMovimientos;
	private String fechaInicial;
	private String fechaFinal;
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
	
	public String getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	public Integer getIndiceInicial() {
		return indiceInicial;
	}
	public void setIndiceInicial(Integer indiceInicial) {
		this.indiceInicial = indiceInicial;
	}
	public String getNumeroRegistros() {
		return numeroRegistros;
	}
	public void setNumeroRegistros(String numeroRegistros) {
		this.numeroRegistros = numeroRegistros;
	}
	public String getLimiteMovimientos() {
		return limiteMovimientos;
	}
	public void setLimiteMovimientos(String limiteMovimientos) {
		this.limiteMovimientos = limiteMovimientos;
	}
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"tipoConsulta\":\"" + tipoConsulta
				+ "\", \"idCuenta\":\"" + idCuenta + "\", \"indiceInicial\":\"" + indiceInicial
				+ "\", \"numeroRegistros\":\"" + numeroRegistros + "\", \"limiteMovimientos\":\"" + limiteMovimientos
				+ "\", \"fechaInicial\":\"" + fechaInicial + "\", \"fechaFinal\":\"" + fechaFinal + "\"}";
	}
	
	
	
	
	
	
	
	
}
