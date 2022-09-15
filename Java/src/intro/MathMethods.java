package intro;

public class MathMethods {
	
	private double key;
	
	// an example method to use as a guideline
	public void halve(double x) {
		System.out.println(x/2);
	}
	
	// I'll give you the first method's outline to fill in. For the rest, you're in charge of 
	// declaring the entire method.
	public void square(double x) {
		
		System.out.println(x * x);
	}
	
	public void averageFive(double a, double b, double c, double d, double e) {
		
		System.out.println((a+b+c+d+e)/5);
	}
	
	private void raiseToTheFourth(double num) {
		
		System.out.println(num*num*num*num);
	}
	
	public void setKey(double x) {
		
		key = x;
	}
	
	public void multiplyByKey(double num) {
		
		System.out.println(num * key);
	}
	
	public void keyCubed() {
		
		System.out.println(Math.pow(key, 3));
	}
	
	public void makeInteger(double d) {
		System.out.println( (int) d);
	}
	
	public void roundToNearestWhole(double d) {
		
		System.out.println((int)(d + .5));
	}
	
	public static void main(String args[]) {
		
		MathMethods tester = new MathMethods();
		
		// example method
		// output: 4
		tester.halve(8);
		
		// you are in charge of making the rest of these work
		
		// output: 49
		tester.square(7);
		
		// output: 7
		tester.averageFive(7,10,5,7,6);
		
		// output: 81
		tester.raiseToTheFourth(3);
		
		// output: nothing, just save the number 4 as an instance variable
		tester.setKey(4);
		
		// output: 28
		tester.multiplyByKey(7);
		
		// output: 64
		tester.keyCubed();
		
		// output: 3
		tester.makeInteger(3.756);
		
		// output: 8
		tester.roundToNearestWhole(7.8);
	}
}
