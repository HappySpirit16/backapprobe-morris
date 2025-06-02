package co.approbe.powwi.auth;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "powwi")
public class TokenPowwi {
	@DynamoDBAttribute
	@DynamoDBHashKey
	private int id;
	@DynamoDBAttribute
	private String token;
	LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.of("-05:00"));
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	@DynamoDBAttribute
	private String dateSave = dateTime.format(dtformat);
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getDateSave() {
		return dateSave;
	}
	public void setDateSave(String dateSave) {
		this.dateSave = dateSave;
	}
	public TokenPowwi(int id, String token, String dateSave) {
		super();
		this.id = id;
		this.token = token;
		this.dateSave = dateSave;
	}
	public TokenPowwi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
