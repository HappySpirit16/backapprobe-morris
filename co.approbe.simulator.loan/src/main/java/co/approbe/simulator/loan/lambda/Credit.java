package co.approbe.simulator.loan.lambda;



import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

@DynamoDBTable(tableName="credit")
public class Credit {
	@DynamoDBHashKey
	private String id;
	@DynamoDBTypeConvertedJson
	private PlannerPay plannerPay;

	public Credit(String id, PlannerPay plannerPay) {
		super();
		this.id = id;
		this.plannerPay = plannerPay;
	}
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


	public Credit() {
		super();
	}
	
		
}
