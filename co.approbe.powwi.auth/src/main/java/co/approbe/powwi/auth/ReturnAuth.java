package co.approbe.powwi.auth;

public class ReturnAuth {
	private String codigoResultado;
	private String mensaje;
	private String tokenConvenio;
	public String getCodigoResultado() {
		return codigoResultado;
	}
	public void setCodigoResultado(String codigoResultado) {
		this.codigoResultado = codigoResultado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	@Override
	public String toString() {
		return "{\"codigoResultado\":\"" + codigoResultado + "\", \"mensaje\":\"" + mensaje + "\", \"tokenConvenio\":\""
				+ tokenConvenio + "\"}";
	}
	
	
	
}
