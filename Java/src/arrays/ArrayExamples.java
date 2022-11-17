package arrays;

public class ArrayExamples {
	
	public void countPositives(int[] nums) {
		
		int positives = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			if ( nums[i] > 0  ) {
				
				positives++;
			}
		}
		printArray(nums);
		System.out.println(positives);
	}
	

	public void printArray(int[] arr) {
		
		System.out.print("[" + arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			
			System.out.print(", " + arr[i]);
			
		}
		System.out.println("]");	
	}
	
	public void oneToN(int n) {
		
		int[] nums = new int[n];
		
		for (int i = 0; i <nums.length; i++) {
			
			nums[i] = i;
		}
		printArray(nums);
		
	}
	
	
	public static void main(String[] args) {
		ArrayExamples tester = new ArrayExamples();
		
//		tester.countPositives(new int[] {3, -5, 7});
		tester.oneToN(100);
		
		
		

	}

}
