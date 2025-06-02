package com.approbe.summary;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "borrower")
public class BasicInformation {
	@DynamoDBAttribute
	private String id;
	@DynamoDBHashKey
	private String numberId;
	@DynamoDBAttribute
	private int approveValue;
	@DynamoDBAttribute
	private int feesApprobe;
	@DynamoDBAttribute
	private int fv;
	@DynamoDBAttribute
	private int v;
	@DynamoDBAttribute
	private int percentageApprobe;
	@DynamoDBAttribute
	private int valuePay;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public int getApproveValue() {
		return approveValue;
	}
	public void setApproveValue(int approveValue) {
		this.approveValue = approveValue;
	}
	public int getFeesApprobe() {
		return feesApprobe;
	}
	public void setFeesApprobe(int feesApprobe) {
		this.feesApprobe = feesApprobe;
	}
	public int getFv() {
		return fv;
	}
	public void setFv(int fv) {
		this.fv = fv;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public int getPercentageApprobe() {
		return percentageApprobe;
	}
	public void setPercentageApprobe(int percentageApprobe) {
		this.percentageApprobe = percentageApprobe;
	}
	public int getValuePay() {
		return valuePay;
	}
	public void setValuePay(int valuePay) {
		this.valuePay = valuePay;
	}
	public BasicInformation(String id, String numberId, int approveValue, int feesApprobe, int fv, int v,
			int percentageApprobe, int valuePay) {
		super();
		this.id = id;
		this.numberId = numberId;
		this.approveValue = approveValue;
		this.feesApprobe = feesApprobe;
		this.fv = fv;
		this.v = v;
		this.percentageApprobe = percentageApprobe;
		this.valuePay = valuePay;
	}
	public BasicInformation() {
		super();
	}
	
	


}
