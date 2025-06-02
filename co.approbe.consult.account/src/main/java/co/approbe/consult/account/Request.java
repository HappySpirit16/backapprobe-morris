package co.approbe.consult.account;

public class Request {
	private String operacion;
	private String idAutenticacionAliado;
	private String otp;
	
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public String getIdAutenticacionAliado() {
		return idAutenticacionAliado;
	}
	public void setIdAutenticacionAliado(String idAutenticacionAliado) {
		this.idAutenticacionAliado = idAutenticacionAliado;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	
}
