package co.approbe.autentic;

public class ResultOtp {
	private String msj;
    private String code;
    private String idTransaction;
	public String getMsj() {
		return msj;
	}
	public void setMsj(String msj) {
		this.msj = msj;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(String idTransaction) {
		this.idTransaction = idTransaction;
	}
	public ResultOtp(String msj, String code, String idTransaction) {
		super();
		this.msj = msj;
		this.code = code;
		this.idTransaction = idTransaction;
	}
	public ResultOtp() {
		super();
	}
	@Override
	public String toString() {
		return "{\"msj\":\"" + msj + "\", \"code\":\"" + code + "\", \"idTransaction\":\"" + idTransaction + "\"}";
	}
	

}
