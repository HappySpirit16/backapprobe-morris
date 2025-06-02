package co.approbe.additional.information.borrower;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "borrower")
public class Borrower {
	@DynamoDBHashKey
	private String numberId;
	@DynamoDBAttribute
	private int approveValue;
	@DynamoDBAttribute
	private int score;
	@DynamoDBAttribute
	private int ranking;
	@DynamoDBAttribute
	private int capacity;
	@DynamoDBAttribute
	private int scoreAcierta;
	@DynamoDBAttribute
	private int percentageCapacity;
	@DynamoDBAttribute
	private int feePlan;
	@DynamoDBAttribute
	private int rateApprobe;
	@DynamoDBAttribute
	private int feesApprobe;
	LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.of("-05:00"));
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	@DynamoDBAttribute
	private String dateSave = dateTime.format(dtformat);
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getScoreAcierta() {
		return scoreAcierta;
	}
	public void setScoreAcierta(int scoreAcierta) {
		this.scoreAcierta = scoreAcierta;
	}
	public int getPercentageCapacity() {
		return percentageCapacity;
	}
	public void setPercentageCapacity(int percentageCapacity) {
		this.percentageCapacity = percentageCapacity;
	}
	public int getFeePlan() {
		return feePlan;
	}
	public void setFeePlan(int feePlan) {
		this.feePlan = feePlan;
	}
	public int getRateApprobe() {
		return rateApprobe;
	}
	public void setRateApprobe(int rateApprobe) {
		this.rateApprobe = rateApprobe;
	}
	public int getFeesApprobe() {
		return feesApprobe;
	}
	public void setFeesApprobe(int feesApprobe) {
		this.feesApprobe = feesApprobe;
	}
	public String getDateSave() {
		return dateSave;
	}
	public void setDateSave(String dateSave) {
		this.dateSave = dateSave;
	}
	public Borrower(String numberId, int approveValue, int score, int ranking, int capacity, int scoreAcierta,
			int percentageCapacity, int feePlan, int rateApprobe, int feesApprobe, String dateSave) {
		super();
		this.numberId = numberId;
		this.approveValue = approveValue;
		this.score = score;
		this.ranking = ranking;
		this.capacity = capacity;
		this.scoreAcierta = scoreAcierta;
		this.percentageCapacity = percentageCapacity;
		this.feePlan = feePlan;
		this.rateApprobe = rateApprobe;
		this.feesApprobe = feesApprobe;
		this.dateSave = dateSave;
	}
	public Borrower() {
		super();
	}
	@Override
	public String toString() {
		return "Borrower [numberId=" + numberId + ", approveValue=" + approveValue + ", score=" + score + ", ranking="
				+ ranking + ", capacity=" + capacity + ", scoreAcierta=" + scoreAcierta + ", percentageCapacity="
				+ percentageCapacity + ", feePlan=" + feePlan + ", rateApprobe=" + rateApprobe + ", feesApprobe="
				+ feesApprobe + ", dateSave=" + dateSave + "]";
	}
	
	

}
