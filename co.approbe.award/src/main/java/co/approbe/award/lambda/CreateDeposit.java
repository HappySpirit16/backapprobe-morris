package co.approbe.award.lambda;

public class CreateDeposit {
	private String operacion= "crearDeposito";
	private String huellaDispositivo;
	private String  tipoDocumento;
	private String  numeroDocumento;
	private String  fechaExpedicion;
	private String  celular;
	private String  fechaNacimiento;
	private String  correoElectronico;
	private String  sexo;
	private boolean checkDatos=true;
	private boolean checkProducto=true;
	private boolean checkHabbeasData= true;
	private boolean checkInformacionT= true;
	private boolean  checkBiometria= true;
	private String  SO="WEB";
	private String  nombreDispositivo="PC";
	private String  IP; 

	public String getHuellaDispositivo() {
		return huellaDispositivo;
	}
	public void setHuellaDispositivo(String huellaDispositivo) {
		this.huellaDispositivo = huellaDispositivo;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getFechaExpedicion() {
		return fechaExpedicion;
	}
	public void setFechaExpedicion(String fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	
	public CreateDeposit() {
		super();
	}
	public CreateDeposit(String operacion, String huellaDispositivo, String tipoDocumento, String numeroDocumento,
			String fechaExpedicion, String celular, String fechaNacimiento, String correoElectronico, String sexo,
			boolean checkDatos, boolean checkProducto, boolean checkHabbeasData, boolean checkInformacionT,
			boolean checkBiometria, String sO, String nombreDispositivo, String iP) {
		super();
		this.operacion = operacion;
		this.huellaDispositivo = huellaDispositivo;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.fechaExpedicion = fechaExpedicion;
		this.celular = celular;
		this.fechaNacimiento = fechaNacimiento;
		this.correoElectronico = correoElectronico;
		this.sexo = sexo;
		this.checkDatos = checkDatos;
		this.checkProducto = checkProducto;
		this.checkHabbeasData = checkHabbeasData;
		this.checkInformacionT = checkInformacionT;
		this.checkBiometria = checkBiometria;
		SO = sO;
		this.nombreDispositivo = nombreDispositivo;
		IP = iP;
	}
	@Override
	public String toString() {
		return "{\"operacion\":\"" + operacion + "\", \"huellaDispositivo\":\"" + huellaDispositivo
				+ "\", \"tipoDocumento\":\"" + tipoDocumento + "\", \"numeroDocumento\":\"" + numeroDocumento
				+ "\", \"fechaExpedicion\":\"" + fechaExpedicion + "\", \"celular\":\"" + celular
				+ "\", \"fechaNacimiento\":\"" + fechaNacimiento + "\", \"correoElectronico\":\"" + correoElectronico
				+ "\", \"sexo\":\"" + sexo + "\", \"checkDatos\":\"" + checkDatos + "\", \"checkProducto\":\""
				+ checkProducto + "\", \"checkHabbeasData\":\"" + checkHabbeasData + "\", \"checkInformacionT\":\""
				+ checkInformacionT + "\", \"checkBiometria\":\"" + checkBiometria + "\", \"SO\":\"" + SO
				+ "\", \"nombreDispositivo\":\"" + nombreDispositivo + "\", \"IP\":\"" + IP+ "\"}";
	}
	
}
