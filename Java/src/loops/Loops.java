package loops;

import java.util.Scanner;

public class Loops {
	
	public void oneToN_Evens(int endpoint) {
		
		int num = 0;
		
		while (num < endpoint) {
			
			num += 2;
			
			System.out.println(num);	
		}
	}
	
	public void multiples(int n, int x) {
		
		int count = x;
		
		while ( count <= n * x) {
			
			System.out.println(count);
			
			count += x;
		}
	}
	
	
	public void evensN(int n) {
		
		int count = 0;
		
		while (count <= n) {
						
			System.out.println(count);
			
			count += 2;
		}
	}
	
	
	public void guessNumber() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("whats my number?");
		int guess = in.nextInt();
		
		while (guess != 25) {
			
			System.out.println("whats my number?");
			guess = in.nextInt();
		}
		
		System.out.println("congratulations!");
	}

	
	public void squareRoot(int n) {
		
		int count = 0;
		
		while (count * count < n) {
			
			count ++;
		}
		
		if (count * count == n) {
			System.out.println(count);
		}
		else {
			System.out.println("not a perfect square");
		}
	}
	
	public void isPrime(int n) {
		
		int count = 2; 
		
		boolean prime = true;
		
		while (count < n) {
			
			if (n % count == 0) {
				prime = false;
				break;
			}
			
			count ++;
		}
		
		if (prime) {
			System.out.println("prime");
		}
		else {
			System.out.println("not prime");
		}
	}
	
	public void odds(int x, int y) {
		
		for (int count = x; count <= y; count += 2) {
			
			System.out.println(count);
			
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Loops tester = new Loops();
		tester.odds(5, 11);
	}
}