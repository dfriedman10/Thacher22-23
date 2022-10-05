package inheritance;

public class InterestAccount extends BankAccount{

	private double rate;
	
	public InterestAccount(String n, int b, double r) {
		super(n, b);
		rate = r;
	}
	
	public InterestAccount(String n, double r) {
		super(n);
		rate = r;
	}
	
	public void addInterest() {
		deposit(getBalance()*rate);
	}
}
