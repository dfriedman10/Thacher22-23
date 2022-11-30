package arrays;

public class ArrayExamples {
	
	public void printArray(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			
			System.out.print(arr[i] + ", ");
		}
	}
	
	
	public void create0To100() {
		
		int[] nums = new int[100];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
		
		printArray(nums);
	}
	
	public void numPositives(int[] arr) {
		
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	
	public static void main(String[] args) {
		ArrayExamples tester = new ArrayExamples();
		tester.numPositives(new int[]{4, -1, 7, -4, -3});
		
		
		

	}

}
