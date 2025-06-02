package co.approbe.autentic;

public class Request {
	private String operacion;
	private String celular;
	private String canal;
	private String tipoTransaccion;
	private String codigoTransaccion;
	
	private int tipoValidacion;
	private String otp;
	private String idEnrolamiento;
	private String idValidacion;
	private double scoreValidacion;
	private String idAutenticacionAliado;
	private String idCuenta;
	
	private String correoElectronico;
	private boolean checkBiometria;
	private boolean checkDatos;
	private boolean checkInformacionTr;
	private boolean checkHabbeasData;
	private boolean checkProducto;
	private String fechaExpedicion;
	private String fechaNacimiento;
	private String huellaDispositivo;
	private String IP;
	private String nombreDispositivo;
	private String numeroDocumento;
	private String sexo;
	private String SO;
	private String tipoDocumento;
	private String pages;
	private String fileName;
	private String fileContent;
	private String certificationType;
	private String transactionId;
	private String documentNumber;
	
	
	
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getTipoTransaccion() {
		return tipoTransaccion;
	}
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}
	public String getCodigoTransaccion() {
		return codigoTransaccion;
	}
	public void setCodigoTransaccion(String codigoTransaccion) {
		this.codigoTransaccion = codigoTransaccion;
	}
	public int getTipoValidacion() {
		return tipoValidacion;
	}
	public void setTipoValidacion(int tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getIdEnrolamiento() {
		return idEnrolamiento;
	}
	public void setIdEnrolamiento(String idEnrolamiento) {
		this.idEnrolamiento = idEnrolamiento;
	}
	public String getIdValidacion() {
		return idValidacion;
	}
	public void setIdValidacion(String idValidacion) {
		this.idValidacion = idValidacion;
	}
	public double getScoreValidacion() {
		return scoreValidacion;
	}
	public void setScoreValidacion(double scoreValidacion) {
		this.scoreValidacion = scoreValidacion;
	}
	public String getIdAutenticacionAliado() {
		return idAutenticacionAliado;
	}
	public void setIdAutenticacionAliado(String idAutenticacionAliado) {
		this.idAutenticacionAliado = idAutenticacionAliado;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public boolean isCheckBiometria() {
		return checkBiometria;
	}
	public void setCheckBiometria(boolean checkBiometria) {
		this.checkBiometria = checkBiometria;
	}
	public boolean isCheckDatos() {
		return checkDatos;
	}
	public void setCheckDatos(boolean checkDatos) {
		this.checkDatos = checkDatos;
	}
	public boolean isCheckInformacionTr() {
		return checkInformacionTr;
	}
	public void setCheckInformacionTr(boolean checkInformacionTr) {
		this.checkInformacionTr = checkInformacionTr;
	}
	public boolean isCheckHabbeasData() {
		return checkHabbeasData;
	}
	public void setCheckHabbeasData(boolean checkHabbeasData) {
		this.checkHabbeasData = checkHabbeasData;
	}
	public boolean isCheckProducto() {
		return checkProducto;
	}
	public void setCheckProducto(boolean checkProducto) {
		this.checkProducto = checkProducto;
	}
	public String getFechaExpedicion() {
		return fechaExpedicion;
	}
	public void setFechaExpedicion(String fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getHuellaDispositivo() {
		return huellaDispositivo;
	}
	public void setHuellaDispositivo(String huellaDispositivo) {
		this.huellaDispositivo = huellaDispositivo;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getNombreDispositivo() {
		return nombreDispositivo;
	}
	public void setNombreDispositivo(String nombreDispositivo) {
		this.nombreDispositivo = nombreDispositivo;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getSO() {
		return SO;
	}
	public void setSO(String sO) {
		SO = sO;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	public String getCertificationType() {
		return certificationType;
	}
	public void setCertificationType(String certificationType) {
		this.certificationType = certificationType;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	
	
	
}
