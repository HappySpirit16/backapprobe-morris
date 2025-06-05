package com.lomincosoft.commonsDto;

public class Identificacion {

    private String estado;
    private String fechaExpedicion;
    private String ciudad;
    private String departamento;
    private String numero;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaExpedicion() {
		return fechaExpedicion;
	}
	public void setFechaExpedicion(String fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "{\"estado\":\"" + estado + "\", \"fechaExpedicion\":\"" + fechaExpedicion + "\", \"ciudad\":\"" + ciudad
				+ "\", \"departamento\":\"" + departamento + "\", \"numero\":\"" + numero + "\"}";
	}


    
    
}
