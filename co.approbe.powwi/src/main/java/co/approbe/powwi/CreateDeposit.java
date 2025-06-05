package co.approbe.powwi;

public class CreateDeposit {
	private String tokenConvenio;
    private String tokenTransaccional;
    private String huellaDispositivo;
    private String tipoDocumento;
    private String numeroDocumento;
    private String fechaExpedicion;
    private String celular;
    private String fechaNacimiento;
    private String correoElectronico;
    private String sexo;
    private Boolean checkDatos;
    private Boolean checkProducto;
    private Boolean checkHabbeasData;
    private Boolean checkInformacionTr;
    private Boolean checkBiometria;
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



	public Boolean getCheckDatos() {
		return checkDatos;
	}



	public void setCheckDatos(Boolean checkDatos) {
		this.checkDatos = checkDatos;
	}



	public Boolean getCheckProducto() {
		return checkProducto;
	}



	public void setCheckProducto(Boolean checkProducto) {
		this.checkProducto = checkProducto;
	}



	public Boolean getCheckHabbeasData() {
		return checkHabbeasData;
	}



	public void setCheckHabbeasData(Boolean checkHabbeasData) {
		this.checkHabbeasData = checkHabbeasData;
	}



	public Boolean getCheckInformacionTr() {
		return checkInformacionTr;
	}



	public void setCheckInformacionTr(Boolean checkInformacionTr) {
		this.checkInformacionTr = checkInformacionTr;
	}



	public Boolean getCheckBiometria() {
		return checkBiometria;
	}



	public void setCheckBiometria(Boolean checkBiometria) {
		this.checkBiometria = checkBiometria;
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
		return "{\"tokenConvenio\":\"" + tokenConvenio + "\",\"tokenTransaccional\":\"" + tokenTransaccional
				+ "\",\"huellaDispositivo\":\"" + huellaDispositivo + "\",\"tipoDocumento\":\"" + tipoDocumento
				+ "\",\"numeroDocumento\":\"" + numeroDocumento + "\",\"fechaExpedicion\":\"" + fechaExpedicion
				+ "\",\"celular\":\"" + celular + "\",\"fechaNacimiento\":\"" + fechaNacimiento
				+ "\",\"correoElectronico\":\"" + correoElectronico + "\",\"sexo\":\"" + sexo + "\",\"checkDatos\":\""
				+ checkDatos + "\",\"checkProducto\":\"" + checkProducto + "\",\"checkHabbeasData\":\""
				+ checkHabbeasData + "\",\"checkInformacionTr\":\"" + checkInformacionTr + "\",\"checkBiometria\":\""
				+ checkBiometria + "\",\"SO\":\"" + SO + "\",\"nombreDispositivo\":\"" + nombreDispositivo
				+ "\",\"IP\":\"" + IP + "\"}";
	}
    
    
}
