package com.lomincosoft.commonsDto;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

public class CustomerDto {

	private String id;
	private String tipoIdentificacion;
	private String tipoIdentificacionText;
	private String identificacion;
	private String primerApellido;
	private String name;
	private String fullName;
	private String celularFormulario;
	private String emailFormulario;
	private String fechaExpedicion;
	private String client;
	private String otp;
	private long ammount;
	private int term;
	private String actionStrategyPattern;
	private ValidationStrategyDto validationStrategy;
	private String referenciaPago;
	private String statusCredit="CREDIT_DENIED"; 

	private DocumentDto pagare;
	private DocumentDto poder;
    private DocumentDto autorizacion;
    private DocumentDto contratoMutuo;
	private ResultSignature resultSignaturePagare;
	private ResultSignature resultSignatureMutuo;
	private ResultSignature resultSignatureAutorizacion;
	private String urlRedirect;
	private String direccion;
	private String channel; 
	private String ciudad;
	private String referencia;
    private String msjDeclined; 
	private String ocupacion;
	private long cupo;
	
	public long getCupo() {
		return cupo;
	}

	public void setCupo(long cupo) {
		this.cupo = cupo;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getReferenciaPago() {
		return referenciaPago;
	}

	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
	}

	public DocumentDto getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(DocumentDto autorizacion) {
		this.autorizacion = autorizacion;
	}
	public ResultSignature getResultSignaturePagare() {
		return resultSignaturePagare;
	}

	public void setResultSignaturePagare(ResultSignature resultSignaturePagare) {
		this.resultSignaturePagare = resultSignaturePagare;
	}


	public ResultSignature getResultSignatureMutuo() {
		return resultSignatureMutuo;
	}

	public void setResultSignatureMutuo(ResultSignature resultSignatureMutuo) {
		this.resultSignatureMutuo = resultSignatureMutuo;
	}

	public ResultSignature getResultSignatureAutorizacion() {
		return resultSignatureAutorizacion;
	}

	public void setResultSignatureAutorizacion(ResultSignature resultSignatureAutorizacion) {
		this.resultSignatureAutorizacion = resultSignatureAutorizacion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DocumentDto getPagare() {
		return pagare;
	}

	public void setPagare(DocumentDto pagare) {
		this.pagare = pagare;
	}

	public DocumentDto getPoder() {
		return poder;
	}

	public void setPoder(DocumentDto poder) {
		this.poder = poder;
	}



	public DocumentDto getContratoMutuo() {
		return contratoMutuo;
	}

	public void setContratoMutuo(DocumentDto contratoMutuo) {
		this.contratoMutuo = contratoMutuo;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getTipoIdentificacionText() {
		return tipoIdentificacionText;
	}

	public void setTipoIdentificacionText(String tipoIdentificacionText) {
		this.tipoIdentificacionText = tipoIdentificacionText;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCelularFormulario() {
		return celularFormulario;
	}

	public void setCelularFormulario(String celularFormulario) {
		this.celularFormulario = celularFormulario;
	}

	public String getEmailFormulario() {
		return emailFormulario;
	}

	public void setEmailFormulario(String emailFormulario) {
		this.emailFormulario = emailFormulario;
	}

	public String getFechaExpedicion() {
		return fechaExpedicion;
	}

	public void setFechaExpedicion(String fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public String getActionStrategyPattern() {
		return actionStrategyPattern;
	}

	public void setActionStrategyPattern(String actionStrategyPattern) {
		this.actionStrategyPattern = actionStrategyPattern;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public long getAmmount() {
		return ammount;
	}

	public void setAmmount(long ammount) {
		this.ammount = ammount;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public ValidationStrategyDto getValidationStrategy() {
		return validationStrategy;
	}

	public void setValidationStrategy(ValidationStrategyDto validationStrategy) {
		this.validationStrategy = validationStrategy;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getStatusCredit() {
		return statusCredit;
	}

	public void setStatusCredit(String statusCredit) {
		this.statusCredit = statusCredit;
	}

	public String getUrlRedirect() {
		return urlRedirect;
	}

	public void setUrlRedirect(String urlRedirect) {
		this.urlRedirect = urlRedirect;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	
	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	public String getMsjDeclined() {
		return msjDeclined;
	}

	public void setMsjDeclined(String msjDeclined) {
		this.msjDeclined = msjDeclined;
	}

	@Override
	public String toString() {
		return "{\"tipoIdentificacion\":\"" + tipoIdentificacion + "\", \"identificacion\":\"" + identificacion
				+ "\", \"id\":\"" + id + "\", \"tipoIdentificacionText\":\"" + tipoIdentificacionText
				+ "\", \"term\":\"" + term + "\", \"otp\":\"" + otp + "\", \"cupo\":\"" + cupo + "\", \"actionStrategyPattern\":\""
				+ actionStrategyPattern + "\", \"primerApellido\":\"" + primerApellido + "\", \"name\":\"" + name
				+ "\", \"fullName\":\"" + fullName + "\", \"ammount\":\"" + ammount + "\", \"celularFormulario\":\""
				+ celularFormulario + "\", \"emailFormulario\":\"" + emailFormulario + "\",\"pagare\":\"" + pagare + "\","
				+ "\"poder\":\""+ poder + "\",\"autorizacion\":\""+ autorizacion +"\",\"contratoMutuo\":\""+contratoMutuo+"\""
				+ ",\"resultSignaturePagare\":\""+resultSignaturePagare+"\",\"resultSignatureMutuo\":\""+resultSignatureMutuo+"\""
				+ ",\"resultSignatureAutorizacion\":\""+resultSignatureAutorizacion+"\",\"referenciaPago\":\""+referenciaPago+"\""
				+ ",\"ciudad\":\""+ciudad+"\",\"referencia\":\""+referencia+"\",\"ocupacion\":\""+ocupacion+"\""
				+ ",\"statusCredit\":\""+statusCredit+"\",\"urlRedirect\":\""+urlRedirect+"\",\"channel\":\""+channel+"\"}";
	}

}
