package com.lomincosoft.commonsModel;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;
import com.amazonaws.util.Base32;
import com.lomincosoft.commonsDto.AES256;
import com.lomincosoft.commonsDto.CustomerDto;
import com.lomincosoft.commonsDto.DocumentDto;
import com.lomincosoft.commonsDto.ResultSignature;

@DynamoDBTable(tableName = "customerbnpl")
public class Customer {

	@DynamoDBHashKey
	@DynamoDBAttribute
	private String id;
	@DynamoDBAttribute
	private String tipoIdentificacion;
	@DynamoDBAttribute
	private String tipoIdentificacionText;
	@DynamoDBAttribute
	private String identificacion;
	@DynamoDBAttribute
	private String primerApellido;
	@DynamoDBAttribute
	private String name;
	@DynamoDBAttribute
	private String fullName;
	@DynamoDBAttribute
	private String celularFormulario;
	@DynamoDBAttribute
	private String emailFormulario;
	@DynamoDBAttribute
	private String fechaExpedicion;
	@DynamoDBAttribute
	private String client;
	@DynamoDBAttribute
	private long ammount;
	@DynamoDBAttribute
	private int term;
	@DynamoDBAttribute
	private String validationStrategy;
	@DynamoDBAttribute
	private String fechaSolicitud;
	@DynamoDBAttribute
	private String referenciaPago;

	@DynamoDBAttribute
	private double score;
	@DynamoDBAttribute
	private double feesApprobe;
	@DynamoDBAttribute
	private double rateApprobe;
	@DynamoDBAttribute
	private double approveValue;
	@DynamoDBAttribute
	private double scoreAcierta;
	@DynamoDBAttribute
	private double value;
	@DynamoDBAttribute
	private String causalRechazo;
	@DynamoDBAttribute
	private String respuesta;
	@DynamoDBAttribute
	private String xml;
	@DynamoDBAttribute
	private double valorCuota;
	@DynamoDBAttribute
	private double amountFinance;
	@DynamoDBAttribute
	private String statusCredit;
	@DynamoDBAttribute
	private double fGA;
	@DynamoDBAttribute
	private double platform;

	@DynamoDBTypeConvertedJson
	private DocumentDto pagare;
	@DynamoDBTypeConvertedJson
	private DocumentDto poder;
	@DynamoDBTypeConvertedJson
	private DocumentDto autorizacion;
	@DynamoDBTypeConvertedJson
	private DocumentDto contratoMutuo;
	@DynamoDBTypeConvertedJson
	private ResultSignature resultSignaturePagare;
	@DynamoDBTypeConvertedJson
	private ResultSignature resultSignatureMutuo;
	@DynamoDBTypeConvertedJson
	private ResultSignature resultSignatureAutorizacion;
	@DynamoDBAttribute
	private String statusDate;
	@DynamoDBAttribute
	private String cycle;
	@DynamoDBAttribute
	private String accountingDate;
	@DynamoDBAttribute
	private String validationMessage;
	@DynamoDBAttribute
	private String process;
	@DynamoDBAttribute
	private String productNumber;
	@DynamoDBAttribute
	private String urlRedirect;

	
	 // informacion de experean reconocer
	@DynamoDBAttribute
	private String cellReconoer;
	@DynamoDBAttribute
	private String emailReconocer;
	@DynamoDBAttribute
	private String direccionReconoer;
	@DynamoDBAttribute
	private String naturalNacional;
	@DynamoDBAttribute
	private String telefonoReconocer;
	@DynamoDBAttribute
	private String fechaExpReconocerYMA;
	@DynamoDBAttribute
	private String direccion;
	@DynamoDBAttribute
	private String ciudad;
	@DynamoDBAttribute
	private String referencia;
	@DynamoDBAttribute
	private String juridicaNacional;
	@DynamoDBAttribute
	private String alerta;
	@DynamoDBAttribute
	private String respuestaReconocer;
	
	//varibales para casos especiales
	@DynamoDBAttribute
	private double feeWithBenefit;
	@DynamoDBAttribute
	private double feeWithuotWenefit;
	@DynamoDBAttribute
	private double capitalAmortization;
	@DynamoDBAttribute
	private double capitalBalance;
	@DynamoDBAttribute
	private double monthlyRate;
	@DynamoDBAttribute
	private double interests;
	@DynamoDBAttribute
	private double feesBenefit;
	@DynamoDBAttribute
	private String channel;
	@DynamoDBAttribute
	private String ocupacion;
	

	public Customer() {

	}

	public Customer(CustomerDto pCustomer) {
		this.identificacion = pCustomer.getIdentificacion();
		this.tipoIdentificacion = pCustomer.getTipoIdentificacion();
		this.tipoIdentificacionText = pCustomer.getTipoIdentificacionText();
		this.primerApellido = pCustomer.getPrimerApellido();
		this.name = pCustomer.getName();
		this.fullName = pCustomer.getFullName();
		this.celularFormulario = pCustomer.getCelularFormulario();
		this.emailFormulario = pCustomer.getEmailFormulario();
		this.fechaExpedicion = pCustomer.getFechaExpedicion();
		this.client = pCustomer.getClient();
		this.ammount = pCustomer.getAmmount();
		this.term = pCustomer.getTerm();
		this.pagare = pCustomer.getPagare();
		this.poder = pCustomer.getPoder();
		this.autorizacion = pCustomer.getAutorizacion();
		this.contratoMutuo = pCustomer.getContratoMutuo();
		this.resultSignaturePagare = pCustomer.getResultSignaturePagare();
		this.resultSignatureMutuo = pCustomer.getResultSignatureMutuo();
		this.resultSignatureAutorizacion = pCustomer.getResultSignatureAutorizacion();
		this.statusCredit = pCustomer.getStatusCredit();
		this.referenciaPago =(pCustomer.getReferenciaPago()==null)?"NA":pCustomer.getReferenciaPago();
		this.urlRedirect=pCustomer.getUrlRedirect(); 
		if (pCustomer.getValidationStrategy() != null)
			this.validationStrategy = pCustomer.getValidationStrategy().getValidationStrategy();
		generateIdAndDate(pCustomer);
		this.direccion=(pCustomer.getDireccion()==null)?" ":pCustomer.getDireccion();;
		this.referencia=(pCustomer.getReferencia()==null)?"NA":pCustomer.getReferencia();
		this.ciudad=(pCustomer.getCiudad()==null)?" ":pCustomer.getCiudad();
		this.ocupacion=(pCustomer.getOcupacion()==null)?"NA":pCustomer.getOcupacion();
		
	}

	public double getfGA() {
		return fGA;
	}

	public void setfGA(double fGA) {
		this.fGA = fGA;
	}

	public double getPlatform() {
		return platform;
	}

	public void setPlatform(double platform) {
		this.platform = platform;
	}

	public double getAmountFinance() {
		return amountFinance;
	}

	public void setAmountFinance(double amountFinance) {
		this.amountFinance = amountFinance;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getFeesApprobe() {
		return feesApprobe;
	}

	public void setFeesApprobe(double feesApprobe) {
		this.feesApprobe = feesApprobe;
	}

	public double getRateApprobe() {
		return rateApprobe;
	}

	public void setRateApprobe(double rateApprobe) {
		this.rateApprobe = rateApprobe;
	}

	public double getApproveValue() {
		return approveValue;
	}

	public void setApproveValue(double approveValue) {
		this.approveValue = approveValue;
	}

	public double getScoreAcierta() {
		return scoreAcierta;
	}

	public void setScoreAcierta(double scoreAcierta) {
		this.scoreAcierta = scoreAcierta;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCausalRechazo() {
		return causalRechazo;
	}

	public void setCausalRechazo(String causalRechazo) {
		this.causalRechazo = causalRechazo;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public double getValorCuota() {
		return valorCuota;
	}

	public void setValorCuota(double valorCuota) {
		this.valorCuota = valorCuota;
	}

	public DocumentDto getPagare() {
		return pagare;
	}

	public void setPagare(DocumentDto pagare) {
		this.pagare = pagare;
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

	public DocumentDto getPoder() {
		return poder;
	}

	public void setPoder(DocumentDto poder) {
		this.poder = poder;
	}

	public DocumentDto getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(DocumentDto autorizacion) {
		this.autorizacion = autorizacion;
	}

	public DocumentDto getContratoMutuo() {
		return contratoMutuo;
	}

	public void setContratoMutuo(DocumentDto contratoMutuo) {
		this.contratoMutuo = contratoMutuo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getReferenciaPago() {
		return referenciaPago;
	}

	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
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

	public String getValidationStrategy() {
		return validationStrategy;
	}

	public void setValidationStrategy(String validationStrategy) {
		this.validationStrategy = validationStrategy;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getAccountingDate() {
		return accountingDate;
	}

	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}
	public String getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(String validationMessage) {
		this.validationMessage = validationMessage;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getStatusCredit() {
		return statusCredit;
	}

	public void setStatusCredit(String statusCredit) {
		this.statusCredit = statusCredit;
	}
	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getUrlRedirect() {
		return urlRedirect;
	}

	public void setUrlRedirect(String urlRedirect) {
		this.urlRedirect = urlRedirect;
	}

	public String getCellReconoer() {
		return cellReconoer;
	}

	public void setCellReconoer(String cellReconoer) {
		this.cellReconoer = cellReconoer;
	}

	public String getEmailReconocer() {
		return emailReconocer;
	}

	public void setEmailReconocer(String emailReconocer) {
		this.emailReconocer = emailReconocer;
	}

	public String getDireccionReconoer() {
		return direccionReconoer;
	}

	public void setDireccionReconoer(String direccionReconoer) {
		this.direccionReconoer = direccionReconoer;
	}

	public String getNaturalNacional() {
		return naturalNacional;
	}

	public void setNaturalNacional(String naturalNacional) {
		this.naturalNacional = naturalNacional;
	}

	public String getTelefonoReconocer() {
		return telefonoReconocer;
	}

	public void setTelefonoReconocer(String telefonoReconocer) {
		this.telefonoReconocer = telefonoReconocer;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	// @Override
//	public String toString() {
//		return "{\"tipoIdentificacion\":\"" + tipoIdentificacion + "\", \"identificacion\":\"" + identificacion
//				+ "\", \"id\":\"" + id + "\", \"tipoIdentificacionText\":\"" + tipoIdentificacionText
//				+ "\", \"term\":\"" + term + "\", \"primerApellido\":\"" + primerApellido + "\", \"name\":\"" + name
//				+ "\", \"fechaSolicitud\":\"" + fechaSolicitud + "\", \"fullName\":\"" + fullName + "\", \"ammount\":\""
//				+ ammount + "\", \"celularFormulario\":\"" + celularFormulario + "\", \"emailFormulario\":\""
//				+ emailFormulario + "\",\"pagare\":\"" + pagare + "\",\"poder\":\""+ poder + "\""
//				+ ",\"autorizacion\":\""+ autorizacion +"\",\"contratoMutuo\":\""+contratoMutuo+"\""
//				+ ",\"resultSignaturePagare\":\""+resultSignaturePagare+"\",\"resultSignatureMutuo\":\""+resultSignatureMutuo+"\""
//				+ ",\"resultSignatureAutorizacion\":\""+resultSignatureAutorizacion+"\",\"referenciaPago\":\""+referenciaPago+"\"}";
//	}
//	
	


	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getRespuestaReconocer() {
		return respuestaReconocer;
	}

	public void setRespuestaReconocer(String respuestaReconocer) {
		this.respuestaReconocer = respuestaReconocer;
	}

	public String getJuridicaNacional() {
		return juridicaNacional;
	}

	public String getFechaExpReconocerYMA() {
		return fechaExpReconocerYMA;
	}

	public void setFechaExpReconocerYMA(String fechaExpReconocerYMA) {
		this.fechaExpReconocerYMA = fechaExpReconocerYMA;
	}

	public String getAlerta() {
		return alerta;
	}

	public void setAlerta(String alerta) {
		this.alerta = alerta;
	}

	public void setJuridicaNacional(String juridicaNacional) {
		this.juridicaNacional = juridicaNacional;
	}

	
	
	public double getFeeWithBenefit() {
		return feeWithBenefit;
	}

	public void setFeeWithBenefit(double feeWithBenefit) {
		this.feeWithBenefit = feeWithBenefit;
	}

	public double getFeeWithuotWenefit() {
		return feeWithuotWenefit;
	}

	public void setFeeWithuotWenefit(double feeWithuotWenefit) {
		this.feeWithuotWenefit = feeWithuotWenefit;
	}

	public double getFeesBenefit() {
		return feesBenefit;
	}

	public void setFeesBenefit(double feesBenefit) {
		this.feesBenefit = feesBenefit;
	}

	public double getCapitalAmortization() {
		return capitalAmortization;
	}

	public void setCapitalAmortization(double capitalAmortization) {
		this.capitalAmortization = capitalAmortization;
	}

	public double getCapitalBalance() {
		return capitalBalance;
	}

	public void setCapitalBalance(double capitalBalance) {
		this.capitalBalance = capitalBalance;
	}


	public double getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(double monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public double getInterests() {
		return interests;
	}

	public void setInterests(double interests) {
		this.interests = interests;
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

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"tipoIdentificacion\":\"" + tipoIdentificacion
				+ "\", \"tipoIdentificacionText\":\"" + tipoIdentificacionText + "\", \"identificacion\":\""
				+ identificacion + "\", \"primerApellido\":\"" + primerApellido + "\", \"name\":\"" + name
				+ "\", \"fullName\":\"" + fullName + "\", \"celularFormulario\":\"" + celularFormulario
				+ "\", \"emailFormulario\":\"" + emailFormulario + "\", \"fechaExpedicion\":\"" + fechaExpedicion
				+ "\", \"client\":\"" + client + "\", \"ammount\":\"" + ammount + "\", \"term\":\"" + term
				+ "\", \"validationStrategy\":\"" + validationStrategy + "\", \"fechaSolicitud\":\"" + fechaSolicitud
				+ "\", \"referenciaPago\":\"" + referenciaPago + "\", \"score\":\"" + score + "\", \"feesApprobe\":\""
				+ feesApprobe + "\", \"rateApprobe\":\"" + rateApprobe + "\", \"approveValue\":\"" + approveValue
				+ "\", \"scoreAcierta\":\"" + scoreAcierta + "\", \"value\":\"" + value + "\", \"causalRechazo\":\""
				+ causalRechazo + "\", \"respuesta\":\"" + respuesta + "\", \"xml\":\"" + xml + "\", \"valorCuota\":\""
				+ valorCuota + "\", \"amountFinance\":\"" + amountFinance + "\", \"statusCredit\":\"" + statusCredit
				+ "\", \"fGA\":\"" + fGA + "\", \"platform\":\"" + platform + "\", \"pagare\":\"" + pagare
				+ "\", \"poder\":\"" + poder + "\", \"autorizacion\":\"" + autorizacion + "\", \"contratoMutuo\":\""
				+ contratoMutuo + "\", \"resultSignaturePagare\":\"" + resultSignaturePagare
				+ "\", \"resultSignatureMutuo\":\"" + resultSignatureMutuo + "\", \"resultSignatureAutorizacion\":\""
				+ resultSignatureAutorizacion + "\", \"statusDate\":\"" + statusDate + "\", \"cycle\":\"" + cycle
				+ "\", \"accountingDate\":\"" + accountingDate + "\", \"validationMessage\":\"" + validationMessage
				+ "\", \"process\":\"" + process + "\", \"productNumber\":\"" + productNumber + "\", \"urlRedirect\":\""
				+ urlRedirect + "\", \"cellReconoer\":\"" + cellReconoer + "\", \"emailReconocer\":\"" + emailReconocer
				+ "\", \"direccionReconoer\":\"" + direccionReconoer + "\", \"naturalNacional\":\"" + naturalNacional
				+ "\", \"telefonoReconocer\":\"" + telefonoReconocer + "\", \"fechaExpReconocerYMA\":\""
				+ fechaExpReconocerYMA + "\", \"direccion\":\"" + direccion + "\", \"juridicaNacional\":\""
				+ ",\"ciudad\":\""+ciudad+"\",\"referencia\":\""+referencia+"\",\"channel\":\""+channel+"\""
				+ juridicaNacional + "\", \"alerta\":\"" + alerta + "\", \"respuestaReconocer\":\"" + respuestaReconocer
				+ "\"}";
	}

	public void generateIdAndDate(CustomerDto pCustomer) {
		MessageDigest digest = null;

		LocalDateTime date = LocalDateTime.now(ZoneOffset.of("-05:00"));
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyy-HH:mm:ss");
		String strDate = dateFormat.format(date);
		this.fechaSolicitud = strDate;
		String generatedId = pCustomer.getIdentificacion() + strDate;
//		AES256 aes256 = new AES256();
//		this.id = aes256.encrypt("90325F38F29BA5B60C2AA637DB782" + pCustomer.getClient(), "AES", "AES/CBC/NoPadding",
//				generatedId);

		try {
			digest = MessageDigest.getInstance("SHA-1");
			byte[] encodedHash = digest.digest(generatedId.getBytes(StandardCharsets.UTF_8)); 
		//	String hashedString = Base64.getEncoder().encodeToString(encodedHash);
			String hashedString = Base32.encodeAsString(encodedHash); 
			this.id=hashedString;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}



}
