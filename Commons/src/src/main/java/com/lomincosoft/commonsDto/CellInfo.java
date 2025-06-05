package com.lomincosoft.commonsDto;

public class CellInfo {
	
     private String llave;
     private String numeroEntidades;
     private String ultimaConfirmacion;
     private String tipo;
     private String fuente;
     private String celular;
     private String creacion;
     private String contrato;
     private String actualizacion;
     private String reportado;
     private Integer numReportes;
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public String getNumeroEntidades() {
		return numeroEntidades;
	}
	public void setNumeroEntidades(String numeroEntidades) {
		this.numeroEntidades = numeroEntidades;
	}
	public String getUltimaConfirmacion() {
		return ultimaConfirmacion;
	}
	public void setUltimaConfirmacion(String ultimaConfirmacion) {
		this.ultimaConfirmacion = ultimaConfirmacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFuente() {
		return fuente;
	}
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCreacion() {
		return creacion;
	}
	public void setCreacion(String creacion) {
		this.creacion = creacion;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getActualizacion() {
		return actualizacion;
	}
	public void setActualizacion(String actualizacion) {
		this.actualizacion = actualizacion;
	}
	public String getReportado() {
		return reportado;
	}
	public void setReportado(String reportado) {
		this.reportado = reportado;
	}
	public Integer getNumReportes() {
		return numReportes;
	}
	public void setNumReportes(Integer numReportes) {
		this.numReportes = numReportes;
	}
	@Override
	public String toString() {
		return "{\"llave\":\"" + llave + "\", \"numeroEntidades\":\"" + numeroEntidades
				+ "\", \"ultimaConfirmacion\":\"" + ultimaConfirmacion + "\", \"tipo\":\"" + tipo + "\", \"fuente\":\""
				+ fuente + "\", \"celular\":\"" + celular + "\", \"creacion\":\"" + creacion + "\", \"contrato\":\""
				+ contrato + "\", \"actualizacion\":\"" + actualizacion + "\", \"reportado\":\"" + reportado
				+ "\", \"numReportes\":\"" + numReportes + "\"}";
	}
     
     

}
