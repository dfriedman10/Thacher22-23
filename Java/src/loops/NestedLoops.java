package loops;

public class NestedLoops {

	
	
	public static void main(String[] args) {

		
		NestedLoops tester = new NestedLoops();
		tester.allPrimes(10000);
	}
	
	
	public void repeatedCounting(int n) {
		
		for (int count = 0; count <= n; count ++) {
			
			print20Times(count);
			System.out.println();
			
		}
	}
	
	public void print20Times(int num) {
		
		for (int numReps = 0; numReps < 20; numReps++) {
			
			System.out.print(num + " ");
			
		}
	}
	

	public void allPrimes(int n) {
		
		for (int count = 2; count <= n; count++) {
			
			isPrime(count);
		}
	}
	
	public void isPrime(int n) {
		
		boolean isPrime = true;
		
		for (int divisor = 2; divisor < n; divisor ++) {
			
			if (n % divisor == 0) {
				
//				System.out.println(n + " is not Prime");
				isPrime = false;
				break;
			}
		}
	
		if (isPrime == true)
			System.out.println(n + " is prime");

	}
	
	
}
