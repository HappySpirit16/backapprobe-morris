package com.lomincosoft.commonsDto;

public class Ubicacion {
  private Integer antiguedad;

public Integer getAntiguedad() {
	return antiguedad;
}

public void setAntiguedad(Integer antiguedad) {
	this.antiguedad = antiguedad;
}

@Override
public String toString() {
	return "{\"antiguedad\":\"" + antiguedad + "\"}";
}


  
}
