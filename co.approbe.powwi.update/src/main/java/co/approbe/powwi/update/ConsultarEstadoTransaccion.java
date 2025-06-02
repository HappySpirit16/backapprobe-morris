package co.approbe.powwi.update;

public class ConsultarEstadoTransaccion {

	private String tokenConvenio;
	private String idTransaccionPowwi;
	private String idTransaccionAliado;
	private String nombreDispositivo;
	private String SO;
	private String IP;
	public String getTokenConvenio() {
		return tokenConvenio;
	}
	public void setTokenConvenio(String tokenConvenio) {
		this.tokenConvenio = tokenConvenio;
	}
	public String getIdTransaccionPowwi() {
		return idTransaccionPowwi;
	}
	public void setIdTransaccionPowwi(String idTransaccionPowwi) {
		this.idTransaccionPowwi = idTransaccionPowwi;
	}
	public String getIdTransaccionAliado() {
		return idTransaccionAliado;
	}
	public void setIdTransaccionAliado(String idTransaccionAliado) {
		this.idTransaccionAliado = idTransaccionAliado;
	}
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}
	public String getSO() {
		return SO;
	}
	public void setSO(String sO) {
		SO = sO;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	@Override
	public String toString() {
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\", \"idTransaccionPowwi\":\"" + idTransaccionPowwi
				+ "\", \"idTransaccionAliado\":\"" + idTransaccionAliado + "\", \"nombreDispositivo\":\""
				+ nombreDispositivo + "\", \"SO\":\"" + SO + "\", \"IP\":\"" + IP + "\"}";
	}
	
	
}
