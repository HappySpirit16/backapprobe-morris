package com.lomincosoft.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "partner")
public class Partner {

	@DynamoDBHashKey
	@DynamoDBAttribute
	private String id;
	@DynamoDBAttribute
	private String partnerName;
	@DynamoDBAttribute
	private int createPowwi;
	@DynamoDBAttribute
	private int minCreditTerm;
	@DynamoDBAttribute
	private int maxCreditTerm;
	@DynamoDBAttribute
	private long minAmmount;
	@DynamoDBAttribute
	private long maxAmmount;
	
	@DynamoDBAttribute
	private String urlBNPL;
	@DynamoDBAttribute
	private String urlWallet;
	@DynamoDBAttribute
	private int activeUrlBNPL;
	@DynamoDBAttribute
	private int activeUrlWallet;

	
	public Partner() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public int getCreatePowwi() {
		return createPowwi;
	}

	public void setCreatePowwi(int createPowwi) {
		this.createPowwi = createPowwi;
	}

	public int getMinCreditTerm() {
		return minCreditTerm;
	}

	public void setMinCreditTerm(int minCreditTerm) {
		this.minCreditTerm = minCreditTerm;
	}

	public int getMaxCreditTerm() {
		return maxCreditTerm;
	}

	public void setMaxCreditTerm(int maxCreditTerm) {
		this.maxCreditTerm = maxCreditTerm;
	}

	public long getMinAmmount() {
		return minAmmount;
	}

	public void setMinAmmount(long minAmmount) {
		this.minAmmount = minAmmount;
	}

	public long getMaxAmmount() {
		return maxAmmount;
	}

	public void setMaxAmmount(long maxAmmount) {
		this.maxAmmount = maxAmmount;
	}

	public String getUrlBNPL() {
		return urlBNPL;
	}

	public void setUrlBNPL(String urlBNPL) {
		this.urlBNPL = urlBNPL;
	}

	public String getUrlWallet() {
		return urlWallet;
	}

	public void setUrlWallet(String urlWallet) {
		this.urlWallet = urlWallet;
	}

	public int getActiveUrlBNPL() {
		return activeUrlBNPL;
	}

	public void setActiveUrlBNPL(int activeUrlBNPL) {
		this.activeUrlBNPL = activeUrlBNPL;
	}

	public int getActiveUrlWallet() {
		return activeUrlWallet;
	}

	public void setActiveUrlWallet(int activeUrlWallet) {
		this.activeUrlWallet = activeUrlWallet;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\", \"partnerName\":\"" + partnerName + "\", \"createPowwi\":\"" + createPowwi
				+ "\", \"minCreditTerm\":\"" + minCreditTerm + "\", \"maxCreditTerm\":\"" + maxCreditTerm
				+ "\", \"minAmmount\":\"" + minAmmount + "\", \"maxAmmount\":\"" + maxAmmount + "\", \"urlBNPL\":\""
				+ urlBNPL + "\", \"urlWallet\":\"" + urlWallet + "\", \"activeUrlBNPL\":\"" + activeUrlBNPL
				+ "\", \"activeUrlWallet\":\"" + activeUrlWallet + "\"}";
	}
}
