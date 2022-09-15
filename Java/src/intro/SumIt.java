package intro;
import java.util.Scanner;

public class SumIt {
	
	// Scanner for use throughout the file
	private Scanner in = new Scanner(System.in);

	// instance variables
	private double number1, number2;

	// use the scanner to set the values of your two instance variables
	public void setNums() {		
		
		System.out.println("enter 2 numbers: ");
		number1 = in.nextDouble();
		number2 = in.nextDouble();

		
	}

	// create a local variable to hold the sum, then print this new variable
	public void printSum() {
		
		double sum = number1 + number2;
		System.out.println(sum);
	}

	public static void main(String[] args) {
		SumIt runner = new SumIt();

		runner.setNums();
		runner.printSum();
	}

}