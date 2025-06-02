package co.approbe.powwi.update;

public class RegistrarHuella {
	private String tokenConvenio;
	private String tokenTransaccional;
	private String idCuenta;
	private String nuevaHuella;
	private String SO;
	private String nombreDispositivo;
	private String IP;
	
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	public String getTokenTransaccional() {
		return tokenTransaccional;
	}
	public void setTokenTransaccional(String tokenTransaccional) {
		this.tokenTransaccional = tokenTransaccional;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getNuevaHuella() {
		return nuevaHuella;
	}
	public void setNuevaHuella(String nuevaHuella) {
		this.nuevaHuella = nuevaHuella;
	}
	public String getSO() {
		return SO;
	}
	public void setSO(String sO) {
		SO = sO;
	}
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"tokenTransaccional\":\"" + tokenTransaccional
				+ "\", \"idCuenta\":\"" + idCuenta + "\", \"nuevaHuella\":\"" + nuevaHuella + "\", \"SO\":\"" + SO
				+ "\", \"nombreDispositivo\":\"" + nombreDispositivo + "\", \"IP\":\"" + IP + "\"}";
	}
	
	
}
