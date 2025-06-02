package co.approbe.processactive.dto;



public class Borrower implements Comparable<Borrower> {

	private String numberId;	

	//informacion que se trae desde base de datos; 

	private int active; 
	private String dateActive1; 
	private String dateActive4;
	private String dateActive5;
	private String dateActive6;
	private String dateActive7;
	private String dateSaveBD;
	private Integer feesApprobe;
	private String creditInformation;
	private double rateApprobe; 
	private double approveValue; 
	

	public double getApproveValue() {
		return approveValue;
	}
	public void setApproveValue(double approveValue) {
		this.approveValue = approveValue;
	}
	public double getRateApprobe() {
		return rateApprobe;
	}
	public void setRateApprobe(double rateApprobe) {
		this.rateApprobe = rateApprobe;
	}
	public String getCreditInformation() {
		return creditInformation;
	}
	public void setCreditInformation(String creditInformation) {
		this.creditInformation = creditInformation;
	}
	public Integer getFeesApprobe() {
		return feesApprobe;
	}
	public void setFeesApprobe(Integer feesApprobe) {
		this.feesApprobe = feesApprobe;
	}
	public String getDateSaveBD() {
		return dateSaveBD;
	}
	public void setDateSaveBD(String dateSaveBD) {
		this.dateSaveBD = dateSaveBD;
	}

	public String getNumberId() {
		return numberId;
	}
	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getDateActive1() {
		return dateActive1;
	}
	public void setDateActive1(String dateActive1) {
		this.dateActive1 = dateActive1;
	}
	public String getDateActive4() {
		return dateActive4;
	}
	public void setDateActive4(String dateActive4) {
		this.dateActive4 = dateActive4;
	}
	public String getDateActive5() {
		return dateActive5;
	}
	public void setDateActive5(String dateActive5) {
		this.dateActive5 = dateActive5;
	}
	public String getDateActive6() {
		return dateActive6;
	}
	public void setDateActive6(String dateActive6) {
		this.dateActive6 = dateActive6;
	}
	public String getDateActive7() {
		return dateActive7;
	}
	public void setDateActive7(String dateActive7) {
		this.dateActive7 = dateActive7;
	}

	public Borrower() {
		super();
	}


	public Borrower(String numberId, int active, String dateActive1, String dateActive4, String dateActive5,
			String dateActive6, String dateActive7, String dateSaveBD, Integer feesApprobe, String creditInformation,
			double rateApprobe, int approveValue) {
		super();
		this.numberId = numberId;
		this.active = active;
		this.dateActive1 = dateActive1;
		this.dateActive4 = dateActive4;
		this.dateActive5 = dateActive5;
		this.dateActive6 = dateActive6;
		this.dateActive7 = dateActive7;
		this.dateSaveBD = dateSaveBD;
		this.feesApprobe = feesApprobe;
		this.creditInformation = creditInformation;
		this.rateApprobe = rateApprobe;
		this.approveValue = approveValue;
	}

	@Override
	public String toString() {
		return "{\"numberId\":\"" + numberId + "\", \"active\":\"" + active + "\", \"dateActive1\":\"" + dateActive1
				+ "\", \"dateActive4\":\"" + dateActive4 + "\", \"dateActive5\":\"" + dateActive5
				+ "\", \"dateActive6\":\"" + dateActive6 + "\", \"dateActive7\":\"" + dateActive7
				+ "\", \"dateSaveBD\":\"" + dateSaveBD + "\", \"feesApprobe\":\"" + feesApprobe
				+ "\", \"creditInformation\":\"" + creditInformation + "\", \"rateApprobe\":\"" + rateApprobe
				+ "\", \"approveValue\":\"" + approveValue + "\"}";
	}
	@Override
	public int compareTo(Borrower o) {
		// TODO Auto-generated method stub
		return 0;
	} 
}
