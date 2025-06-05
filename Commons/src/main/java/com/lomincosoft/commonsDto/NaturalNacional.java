package com.lomincosoft.commonsDto;

public class NaturalNacional {

	 private Identificacion identificacion;  
     private Edad edad;
     private Ubicacion ubicacion;
     private String llave;
     private String actividadEconomica;
     private Boolean rut;
     private String codigoCIIU;
     private String nombres;
     private String primerApellido;
     private String segundoApellido;
     private String genero;
     private String estadoCivil;
     private Boolean validada;
     private String nombreCompleto;
	public Identificacion getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Identificacion identificacion) {
		this.identificacion = identificacion;
	}
	public Edad getEdad() {
		return edad;
	}
	public void setEdad(Edad edad) {
		this.edad = edad;
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public String getActividadEconomica() {
		return actividadEconomica;
	}
	public void setActividadEconomica(String actividadEconomica) {
		this.actividadEconomica = actividadEconomica;
	}
	public Boolean getRut() {
		return rut;
	}
	public void setRut(Boolean rut) {
		this.rut = rut;
	}
	public String getCodigoCIIU() {
		return codigoCIIU;
	}
	public void setCodigoCIIU(String codigoCIIU) {
		this.codigoCIIU = codigoCIIU;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Boolean getValidada() {
		return validada;
	}
	public void setValidada(Boolean validada) {
		this.validada = validada;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	@Override
	public String toString() {
		return "{\"identificacion\":"+identificacion.toString()+", \"edad\":" + edad.toString() +", \"ubicacion\":" + ubicacion.toString()
				+ ", \"llave\":\"" + llave + "\", \"actividadEconomica\":\"" + actividadEconomica + "\", \"rut\":\""
				+ rut + "\", \"codigoCIIU\":\"" + codigoCIIU + "\", \"nombres\":\"" + nombres
				+ "\", \"primerApellido\":\"" + primerApellido + "\", \"segundoApellido\":\"" + segundoApellido
				+ "\", \"genero\":\"" + genero + "\", \"estadoCivil\":\"" + estadoCivil + "\", \"validada\":\""
				+ validada + "\", \"nombreCompleto\":\"" + nombreCompleto + "\"}";
	}


}
