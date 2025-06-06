package co.approbe.additional.information.borrower;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

public class BasicInformation {
	@DynamoDBAttribute
	@DynamoDBAutoGeneratedKey
	private String id;
	@DynamoDBAttribute
	private String identificationType;
	@DynamoDBHashKey
	private String numberId;
	@DynamoDBAttribute
	private int habit;
	@DynamoDBAttribute
	private int capacity;
	@DynamoDBAttribute
	private int scoreAcierta;
	@DynamoDBAttribute
	private int score;
	@DynamoDBAttribute
	private int percentageCapacity;
	@DynamoDBAttribute
	private int feePlan;
	@DynamoDBAttribute
	private int ranking;
	@DynamoDBAttribute
	private int approveValue;
	@DynamoDBAttribute
	private int rate;
	@DynamoDBAttribute
	private int fees;
	@DynamoDBAttribute
	private int active;
	@DynamoDBAttribute
	private String description;
	LocalDateTime dateTime = LocalDateTime.now(ZoneOffset.of("-05:00"));
	DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	@DynamoDBAttribute
	private String dateSaveBD = dateTime.format(dtformat);
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}
	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public int getHabit() {
		return habit;
	}
	public void setHabit(int habit) {
		this.habit = habit;
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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
	public int getRanking() {
		return ranking;
	}
	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	public int getApproveValue() {
		return approveValue;
	}
	public void setApproveValue(int approveValue) {
		this.approveValue = approveValue;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateSaveBD() {
		return dateSaveBD;
	}
	public void setDateSaveBD(String dateSaveBD) {
		this.dateSaveBD = dateSaveBD;
	}
	public BasicInformation(String id, String identificationType, String numberId, int habit, int capacity,
			int scoreAcierta, int score, int percentageCapacity, int feePlan, int ranking, int approbeValue, int rate,
			int fees, int active, String description, String dateSaveBD) {
		super();
		this.id = id;
		this.identificationType = identificationType;
		this.numberId = numberId;
		this.habit = habit;
		this.capacity = capacity;
		this.scoreAcierta = scoreAcierta;
		this.score = score;
		this.percentageCapacity = percentageCapacity;
		this.feePlan = feePlan;
		this.ranking = ranking;
		this.approveValue = approveValue;
		this.rate = rate;
		this.fees = fees;
		this.active = active;
		this.description = description;
		this.dateSaveBD = dateSaveBD;
	}
	public BasicInformation() {
		super();
	}
	@Override
	public String toString() {
		return "BasicInformation [id=" + id + ", identificationType=" + identificationType + ", numberId=" + numberId
				+ ", habit=" + habit + ", capacity=" + capacity + ", scoreAcierta=" + scoreAcierta + ", score=" + score
				+ ", percentageCapacity=" + percentageCapacity + ", feePlan=" + feePlan + ", ranking=" + ranking
				+ ", approveValue=" + approveValue + ", rate=" + rate + ", fees=" + fees + ", active=" + active
				+ ", description=" + description + ", dateSaveBD=" + dateSaveBD + "]";
	}
	
	
	
	
}
