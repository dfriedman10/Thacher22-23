package intro;
import java.util.Scanner;

public class LineSlope {
	
	private Scanner in = new Scanner(System.in);
	
	// you'll probably want some instance variables... (4 coordinates)
	private double x1, x2, y1, y2;
	


	// use the scanner to assign your instance variables
	public void setCoordinates () {
		
		System.out.println("Enter four coordinates");
		x1 = in.nextDouble();
		x2 = in.nextDouble();
		y1 = in.nextDouble();
		y2 = in.nextDouble();
	}
	
	// calculate the slope, store it in a local variable, then print this variable
	public void display_slope () {
		
		double slope = (y2-y1)/(x2-x1);
		System.out.println(slope);
	}
	
	public static void main(String[] args) {
		
		LineSlope runner = new LineSlope();
		
		runner.setCoordinates();
		runner.display_slope();

	}
}