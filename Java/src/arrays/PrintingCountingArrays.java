package arrays;

public class PrintingCountingArrays {
	
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
		
		System.out.print("[");
		
		for (int i = 0; i < arr.length; i++) {
			
			System.out.print(arr[i]+ ", ");
			
		}
		System.out.println("]");
		
	}
	
	
	public static void main(String[] args) {
		PrintingCountingArrays tester = new PrintingCountingArrays();
		
		tester.countPositives(new int[] {3, -5, 7});
		
		
		

	}

}
