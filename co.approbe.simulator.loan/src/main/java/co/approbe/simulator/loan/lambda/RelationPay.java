package co.approbe.simulator.loan.lambda;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

@DynamoDBTable(tableName="relationPay")
public class RelationPay {
	@DynamoDBHashKey
	private String id;
	@DynamoDBTypeConvertedJson
	private PlannerPay plannerPay;
	
	
	public String getId() {
		return id;
	}


	public PlannerPay getPlannerPay() {
		return plannerPay;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setPlannerPay(PlannerPay plannerPay) {
		this.plannerPay = plannerPay;
	}

	public RelationPay(String id, PlannerPay plannerPay) {
		super();
		this.id = id;
		this.plannerPay = plannerPay;
	}


	public RelationPay() {
		super();
	}
	
}
