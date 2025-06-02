package co.approbe.powwi.auth;

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
	private String tipoOperacion;
	
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
	private String monto;
	private String idOperacion;
	private String tipoConsulta;
	private int indiceInicial;
	private int numeroRegistros;
	private String fechaInicial;
	private String fechaFinal;
	private String limiteMovimientos;
	private String idTransaccionAliado;
	private String idTransaccionPowwi;
	private String numeroCelular;
	
	
	
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
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getIdOperacion() {
		return idOperacion;
	}
	public void setIdOperacion(String idOperacion) {
		this.idOperacion = idOperacion;
	}
	public String getTipoConsulta() {
		return tipoConsulta;
	}
	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
	public int getIndiceInicial() {
		return indiceInicial;
	}
	public void setIndiceInicial(int indiceInicial) {
		this.indiceInicial = indiceInicial;
	}
	public int getNumeroRegistros() {
		return numeroRegistros;
	}
	public void setNumeroRegistros(int numeroRegistros) {
		this.numeroRegistros = numeroRegistros;
	}
	public String getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public String getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getLimiteMovimientos() {
		return limiteMovimientos;
	}
	public void setLimiteMovimientos(String limiteMovimientos) {
		this.limiteMovimientos = limiteMovimientos;
	}
	public String getIdTransaccionAliado() {
		return idTransaccionAliado;
	}
	public void setIdTransaccionAliado(String idTransaccionAliado) {
		this.idTransaccionAliado = idTransaccionAliado;
	}
	public String getIdTransaccionPowwi() {
		return idTransaccionPowwi;
	}
	public void setIdTransaccionPowwi(String idTransaccionPowwi) {
		this.idTransaccionPowwi = idTransaccionPowwi;
	}
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	
	
	
}
