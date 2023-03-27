package objects;
import java.util.Scanner;

public class BankAccount {
	private int amount;
	private double interest;
	private String name;
	
	public BankAccount(int a, double i, String n) {
		amount = a;
		interest = i;
		name = n;
	}
	
	public BankAccount(double i, String n) {
		interest = i;
		name = n;
		amount = 0;
	}

	public void withdraw(int n) {
		amount -= n;
	}
	public void deposit(int n) {
		amount +=n;
	}
	public void display() {
		System.out.println(name +", your current balance is: $"+amount);
	}
	public void addInterest() {
		amount += amount*interest;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);	
		BankAccount act = new BankAccount(.021,"David");
		String ans;
		do {
			System.out.println("\nPress q to quit, s to see your balance, w to withdraw, \nd to deposit, and i to add interest.");
			ans = in.next();
			if (ans.equals("w")) {
				System.out.println("How much do you want to withdraw?");
				act.withdraw(in.nextInt());
			}
			else if (ans.equals("d")) {
				System.out.println("How much do you want to deposit?");
				act.deposit(in.nextInt());
			}
			else if (ans.equals("s")) {
				act.display();
			}
			else if (ans.equals("i")) {
				System.out.println("Interest added.");
				act.addInterest();
			}
		} while (!ans.equals("q"));
		in.close();
	}

}