package lists;

import java.util.ArrayList;

public class GettingToKnowLists {
	
	public static ArrayList<Character> removeSeconds(ArrayList<Character> letters) {
		
		for (int i = 1; i < letters.size(); i++) {
			letters.remove(i);
		}
		return letters;
	}
	
	public static ArrayList<String> arrayToList(String[] arr) {
		
		ArrayList<String> myList = new ArrayList<String>(); 
		
		for (int i = arr.length-1; i >= 0; i--) 
			myList.add(arr[i]);
		
		return myList;
	}
	
	
	public static ArrayList<Double> mult(ArrayList<Double> nums) {
		
		for (int i = 0; i < nums.size(); i++) {
			
			nums.set(i, nums.get(i)*2);
		}
		
		
		return nums;
	}
	
	public static void main(String[] args) {
		
//		ArrayList<Character> testList = new ArrayList<Character>();
//		testList.add('f');testList.add('a');
//		testList.add('b');testList.add('d');
//		testList.add('e');testList.add('c');
//		testList.add('s');
//		
//		System.out.println(removeSeconds(testList));
		
		System.out.println(arrayToList(new String[] {"sd", "ff", "dd"}));

		
	}
	

	
	
}
