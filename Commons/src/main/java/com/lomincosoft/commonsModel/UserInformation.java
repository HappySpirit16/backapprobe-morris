package com.lomincosoft.commonsModel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "userInformation")
public class UserInformation {
	@DynamoDBHashKey
	private String numberId;
	@DynamoDBAttribute
	private String names;
	@DynamoDBAttribute
	private String lastName;
	@DynamoDBAttribute
	private String email;
	@DynamoDBAttribute
	private String cellphone;
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
	private String lugarExpedicion;
	@DynamoDBAttribute
	private String noId;
	@DynamoDBAttribute
	private String estadosCedula;
	@DynamoDBAttribute
	private String respuesta;
	@DynamoDBAttribute
	private String respuestaReconocer;
	
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
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
	public String getFechaExpReconocerYMA() {
		return fechaExpReconocerYMA;
	}
	public void setFechaExpReconocerYMA(String fechaExpReconocerYMA) {
		this.fechaExpReconocerYMA = fechaExpReconocerYMA;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLugarExpedicion() {
		return lugarExpedicion;
	}
	public void setLugarExpedicion(String lugarExpedicion) {
		this.lugarExpedicion = lugarExpedicion;
	}
	public String getNoId() {
		return noId;
	}
	public void setNoId(String noId) {
		this.noId = noId;
	}
	public String getEstadosCedula() {
		return estadosCedula;
	}
	public void setEstadosCedula(String estadosCedula) {
		this.estadosCedula = estadosCedula;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getRespuestaReconocer() {
		return respuestaReconocer;
	}
	public void setRespuestaReconocer(String respuestaReconocer) {
		this.respuestaReconocer = respuestaReconocer;
	}
	public UserInformation() {
	}
	
	public UserInformation(String numberId, String names, String lastName, String email, String cellphone,
			String cellReconoer, String emailReconocer, String direccionReconoer, String naturalNacional,
			String telefonoReconocer, String fechaExpReconocerYMA, String direccion, String lugarExpedicion,
			String noId, String estadosCedula, String respuesta, String respuestaReconocer) {
		super();
		this.numberId = numberId;
		this.names = names;
		this.lastName = lastName;
		this.email = email;
		this.cellphone = cellphone;
		this.cellReconoer = cellReconoer;
		this.emailReconocer = emailReconocer;
		this.direccionReconoer = direccionReconoer;
		this.naturalNacional = naturalNacional;
		this.telefonoReconocer = telefonoReconocer;
		this.fechaExpReconocerYMA = fechaExpReconocerYMA;
		this.direccion = direccion;
		this.lugarExpedicion = lugarExpedicion;
		this.noId = noId;
		this.estadosCedula = estadosCedula;
		this.respuesta = respuesta;
		this.respuestaReconocer = respuestaReconocer;
	}
	@Override
	public String toString() {
		return "{\"numberId\":\"" + numberId + "\", \"names\":\"" + names + "\", \"lastName\":\"" + lastName
				+ "\", \"email\":\"" + email + "\", \"cellphone\":\"" + cellphone + "\", \"cellReconoer\":\""
				+ cellReconoer + "\", \"emailReconocer\":\"" + emailReconocer + "\", \"direccionReconoer\":\""
				+ direccionReconoer + "\", \"naturalNacional\":\"" + naturalNacional + "\", \"telefonoReconocer\":\""
				+ telefonoReconocer + "\", \"fechaExpReconocerYMA\":\"" + fechaExpReconocerYMA + "\", \"direccion\":\""
				+ direccion + "\", \"lugarExpedicion\":\"" + lugarExpedicion + "\", \"noId\":\"" + noId
				+ "\", \"estadosCedula\":\"" + estadosCedula + "\", \"respuesta\":\"" + respuesta
				+ "\", \"respuestaReconocer\":\"" + respuestaReconocer + "\"}";
	}

}
