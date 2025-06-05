package com.lomincosoft.commonsDto;

public class Telefono {
	
     private String llave;
     private String telefono;
     private int numeroEntidades;
     private String nombreDepartamento;
     private Integer indicativoPais;
     private String nombreCiudad;
     private String ultimaConfirmacion;
     private String contrato;
     private String codigoArea;
     private String tipo;
     private String fuente;
     private String creacion;
     private String actualizacion;
     private Integer numReportes;
     private Boolean tipoResidencia;
     private Boolean tipoLaboralOComercial;
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getNumeroEntidades() {
		return numeroEntidades;
	}
	public void setNumeroEntidades(int numeroEntidades) {
		this.numeroEntidades = numeroEntidades;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public Integer getIndicativoPais() {
		return indicativoPais;
	}
	public void setIndicativoPais(Integer indicativoPais) {
		this.indicativoPais = indicativoPais;
	}
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	public String getUltimaConfirmacion() {
		return ultimaConfirmacion;
	}
	public void setUltimaConfirmacion(String ultimaConfirmacion) {
		this.ultimaConfirmacion = ultimaConfirmacion;
	}
	public String getContrato() {
		return contrato;
	}
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
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
	public Integer getNumReportes() {
		return numReportes;
	}
	public void setNumReportes(Integer numReportes) {
		this.numReportes = numReportes;
	}
	public Boolean getTipoResidencia() {
		return tipoResidencia;
	}
	public void setTipoResidencia(Boolean tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}
	public Boolean getTipoLaboralOComercial() {
		return tipoLaboralOComercial;
	}
	public void setTipoLaboralOComercial(Boolean tipoLaboralOComercial) {
		this.tipoLaboralOComercial = tipoLaboralOComercial;
	}
	@Override
	public String toString() {
		return "{\"llave\":\"" + llave + "\", \"telefono\":\"" + telefono + "\", \"numeroEntidades\":\""
				+ numeroEntidades + "\", \"nombreDepartamento\":\"" + nombreDepartamento + "\", \"indicativoPais\":\""
				+ indicativoPais + "\", \"nombreCiudad\":\"" + nombreCiudad + "\", \"ultimaConfirmacion\":\""
				+ ultimaConfirmacion + "\", \"contrato\":\"" + contrato + "\", \"codigoArea\":\"" + codigoArea
				+ "\", \"tipo\":\"" + tipo + "\", \"fuente\":\"" + fuente + "\", \"creacion\":\"" + creacion
				+ "\", \"actualizacion\":\"" + actualizacion + "\", \"numReportes\":\"" + numReportes
				+ "\", \"tipoResidencia\":\"" + tipoResidencia + "\", \"tipoLaboralOComercial\":\""
				+ tipoLaboralOComercial + "\"}";
	}

}
