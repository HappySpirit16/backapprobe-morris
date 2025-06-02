package co.approbe.award.lambda;

public class Authorization {
	
	private boolean legalProcess;
	private boolean judicialProcess;
	private boolean marketingInformation;
	private boolean acceptDuveraInformation;
	private String password;
	private String incomeOrigin;
	private boolean understandAndAccept;
	private boolean declarationsAccept;
	
	
	
	public boolean isMarketingInformation() {
		return marketingInformation;
	}
	public void setMarketingInformation(boolean marketingInformation) {
		this.marketingInformation = marketingInformation;
	}
	public boolean isAcceptDuveraInformation() {
		return acceptDuveraInformation;
	}
	public void setAcceptDuveraInformation(boolean acceptDuveraInformation) {
		this.acceptDuveraInformation = acceptDuveraInformation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOrigin() {
		return incomeOrigin;
	}
	public void setOrigin(String origin) {
		this.incomeOrigin = origin;
	}
	
	public boolean isLegalProcess() {
		return legalProcess;
	}
	public void setLegalProcess(boolean legalProcess) {
		this.legalProcess = legalProcess;
	}
	public boolean isJudicialProcess() {
		return judicialProcess;
	}
	public void setJudicialProcess(boolean judicialProcess) {
		this.judicialProcess = judicialProcess;
	}
	public String getIncomeOrigin() {
		return incomeOrigin;
	}
	public void setIncomeOrigin(String incomeOrigin) {
		this.incomeOrigin = incomeOrigin;
	}
	public boolean isUnderstandAndAccept() {
		return understandAndAccept;
	}
	public void setUnderstandAndAccept(boolean understandAndAccept) {
		this.understandAndAccept = understandAndAccept;
	}
	public boolean isDeclarationsAccept() {
		return declarationsAccept;
	}
	public void setDeclarationsAccept(boolean declarationsAccept) {
		this.declarationsAccept = declarationsAccept;
	}
	@Override
	public String toString() {
		return "Authorization [legalProcess=" + legalProcess + ", judicialProcess=" + judicialProcess
				+ ", marketingInformation=" + marketingInformation + ", acceptDuveraInformation="
				+ acceptDuveraInformation + ", password=" + password + ", incomeOrigin=" + incomeOrigin
				+ ", understandAndAccept=" + understandAndAccept + ", declarationsAccept=" + declarationsAccept + "]";
	}
	
	
	
	

}
