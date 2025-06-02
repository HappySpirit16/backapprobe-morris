package co.approbe.powwi.update;

public class ConsultarIdCuenta {
	private String tokenConvenio;
	private String numeroCelular;
	private String SO;
	private String nombreDispositivo;
    private String IP;
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
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
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"numeroCelular\":\"" + numeroCelular + "\", \"SO\":\""
				+ SO + "\", \"nombreDispositivo\":\"" + nombreDispositivo + "\", \"IP\":\"" + IP + "\"}";
	}
    
}
