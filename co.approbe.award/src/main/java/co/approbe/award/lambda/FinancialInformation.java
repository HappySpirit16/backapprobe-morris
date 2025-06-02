package co.approbe.award.lambda;

public class FinancialInformation {
	private long totalIncome;
	private long totalExpense;
	private long assets;
	private long liability;
	private boolean declare;
	private boolean agent;
	private long totalNetworth;
	
	public long getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(long totalIncome) {
		this.totalIncome = totalIncome;
	}
	public long getTotalExpense() {
		return totalExpense;
	}
	public void setTotalExpense(long totalExpense) {
		this.totalExpense = totalExpense;
	}
	public long getAssets() {
		return assets;
	}
	public void setAssets(long assets) {
		this.assets = assets;
	}
	public long getLiability() {
		return liability;
	}
	public void setLiability(long liability) {
		this.liability = liability;
	}
	public boolean isDeclare() {
		return declare;
	}
	public void setDeclare(boolean declare) {
		this.declare = declare;
	}
	public boolean isAgent() {
		return agent;
	}
	public void setAgent(boolean agent) {
		this.agent = agent;
	}
	public long getTotalNetworth() {
		return totalNetworth;
	}
	public void setTotalNetworth(long totalNetworth) {
		this.totalNetworth = totalNetworth;
	}

	@Override
	public String toString() {
		return "FinancialInformation [totalIncome=" + totalIncome + ", totalExpense=" + totalExpense + ", assets="
				+ assets + ", liability=" + liability + ", declare=" + declare + ", agent=" + agent + ", totalNetworth="
				+ totalNetworth + "]";
	}
	

}
