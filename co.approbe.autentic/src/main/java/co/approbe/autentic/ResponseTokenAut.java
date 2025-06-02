package co.approbe.autentic;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="dataAutentic")
public class ResponseTokenAut {
	@DynamoDBHashKey
	private String id="1";
	@DynamoDBAttribute
	private String access_token;
	@DynamoDBAttribute
	private String scope;
	@DynamoDBAttribute
	private String expires_in;
	@DynamoDBAttribute
	private String token_type;
	LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.of("-05:00"));
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	@DynamoDBAttribute
	private String dateSave = dateTime.format(dtformat);
	
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}
	public String getToken_type() {
		return token_type;
	}
	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getDateSave() {
		return dateSave;
	}
	public void setDateSave(String dateSave) {
		this.dateSave = dateSave;
	}
	public ResponseTokenAut() {
		super();
	}
	public ResponseTokenAut(String id, String access_token, String scope, String expires_in, String token_type,
			String dateSave) {
		super();
		this.id = id;
		this.access_token = access_token;
		this.scope = scope;
		this.expires_in = expires_in;
		this.token_type = token_type;
		this.dateSave = dateSave;
	}
	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"access_token\":\"" + access_token + "\", \"scope\":\"" + scope
				+ "\", \"expires_in\":\"" + expires_in + "\", \"token_type\":\"" + token_type + "\", \"dateSave\":\""
				+ dateSave + "\"}";
	}
	
	
}
