package solution;

public class CustomerLoanProspect {
	
	private	String customerName;
	private double totalLoan;
	private double AnnualInterestRate;
	private int years;
	private double monthlyPayment;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getTotalLoan() {
		return totalLoan;
	}
	public void setTotalLoan(double totalLoan) {
		this.totalLoan = totalLoan;
	}
	public double getAnnualInterestRate() {
		return AnnualInterestRate;
	}
	public void setAnnualInterestRate(double AnnualInterestRate) {
		this.AnnualInterestRate = AnnualInterestRate;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	

}
