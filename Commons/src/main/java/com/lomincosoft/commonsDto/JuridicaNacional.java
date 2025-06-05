package com.lomincosoft.commonsDto;

public class JuridicaNacional {
	
     private String llave;
     private String razonSocial;
     private Boolean validada;
     private String codigoCIIU;
     private String identificacion;
	public String getLlave() {
		return llave;
	}
	public void setLlave(String llave) {
		this.llave = llave;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public Boolean getValidada() {
		return validada;
	}
	public void setValidada(Boolean validada) {
		this.validada = validada;
	}
	public String getCodigoCIIU() {
		return codigoCIIU;
	}
	public void setCodigoCIIU(String codigoCIIU) {
		this.codigoCIIU = codigoCIIU;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	@Override
	public String toString() {
		return "{\"llave\":\"" + llave + "\", \"razonSocial\":\"" + razonSocial + "\", \"validada\":\"" + validada
				+ "\", \"codigoCIIU\":\"" + codigoCIIU + "\", \"identificacion\":\"" + identificacion + "\"}";
	}

}
