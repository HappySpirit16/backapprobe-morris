package com.lomincosoft.commonsDto;

public class EmailInfo {
	 
      private String llave;
      private String email;
      private String ultimaConfirmacion;
      private int numeroEntidades;
      private String fuente;
      private String contrato;
      private String creacion;
      private String actualizacion;
      private String reportado;
      private Integer numReportes;
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUltimaConfirmacion() {
		return ultimaConfirmacion;
	}
	public void setUltimaConfirmacion(String ultimaConfirmacion) {
		this.ultimaConfirmacion = ultimaConfirmacion;
	}
	public int getNumeroEntidades() {
		return numeroEntidades;
	}
	public void setNumeroEntidades(int numeroEntidades) {
		this.numeroEntidades = numeroEntidades;
	}
	public String getFuente() {
		return fuente;
	}
	public void setFuente(String fuente) {
		this.fuente = fuente;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getCreacion() {
		return creacion;
	}
	public void setCreacion(String creacion) {
		this.creacion = creacion;
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
		return "{\"llave\":\"" + llave + "\", \"email\":\"" + email + "\", \"ultimaConfirmacion\":\""
				+ ultimaConfirmacion + "\", \"numeroEntidades\":\"" + numeroEntidades + "\", \"fuente\":\"" + fuente
				+ "\", \"contrato\":\"" + contrato + "\", \"creacion\":\"" + creacion + "\", \"actualizacion\":\""
				+ actualizacion + "\", \"reportado\":\"" + reportado + "\", \"numReportes\":\"" + numReportes + "\"}";
	}


}
