package lists;
import java.util.ArrayList;

public class TestingLists {
	
	public ArrayList<Integer> generateList(int n) {
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 0; i <= n; i++) {
			
			nums.add(i);
		}
		
		return nums;
	}
	
	public ArrayList<Double> increaseBy10(ArrayList<Double> nums) {
		
		for (int i = 0; i < nums.size(); i++) {
			
			nums.set(i, nums.get(i)+10);
		}
		return nums;
	}


	public static void main(String[] args) {
		
		TestingLists tester = new TestingLists();
		
		System.out.println(tester.generateList(25));
		
		ArrayList<Double> testList = new ArrayList<Double>();
		testList.add(5.2);
		testList.add(9.2);
		testList.add(10.3);
		
		System.out.println(tester.increaseBy10(testList));

		
	}
}
