package conditionals;

public class IntroConditionals {
	
	public void posNeg(double num) {
		
		if (num > 0) {
			System.out.println("positive");
		}
		else {
			System.out.println("negative");
		}
	}
	
	public void evenOdd(int num) {
		
		if (num % 2 == 0) {
			System.out.println("even");
		}
		else {
			System.out.println("odd");
		}
	}
	
	
	public void upperLower(char c) {
		
		if ('A' <= c && c <= 'Z') {
			System.out.println("uppercase");
		}
		
		else if ('a' <= c && c <= 'z') {
			System.out.println("lowercase");
		}
		
		else {
			System.out.println("neither");
		}
	}
	
	public void divisibleTen(int num) {
		
		if (num % 10 == 0) {
			System.out.println("divisible by 10");
		}
		else {
			System.out.println("not divisible by 10");
		}
		
	}
	
	public void max(double a, double b, double c) {
		
		if (a >= b && a >= c) {
			System.out.println(a);
		}
		else if (b >= c && b >= a) {
			System.out.println(a);
		}
		else {
			System.out.println(c);
		}
	}

	
	public static void main(String[] args) {
		
		IntroConditionals tester = new IntroConditionals();
		
//		tester.posNeg(7);
//		tester.upperLower('G');
		tester.max(4, 4, 3);
		
	}
}
