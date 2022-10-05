package inheritance;

public class BankAccount {

	private double balance = 0;
	private String name;
	
	public BankAccount(String n) {
		name = n;
	}
	
	public BankAccount(String n, double b) {
		name = n;
		balance = b;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public String toString() {
		return name + "'s balance is: " + balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public static void main(String[] args ) {
		
		BankAccount b = new BankAccount("david", 100);
		
		System.out.println(b);
	}
}
