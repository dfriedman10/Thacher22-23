package lists;

import java.util.ArrayList;

public class ListAlgorithms {
	
	public static double avg(ArrayList<Integer> nums) {
		
		double sum = 0;
		for (int n : nums)
			sum += n;
		
		return sum/nums.size();
	}
	
	public static int minIndex(ArrayList<Integer> nums) {
		
		int minI = 0;
		for (int i = 1; i < nums.size(); i++)
			if (nums.get(minI) > nums.get(i))
				minI = i;
		
		return minI;
	}
	
	public static ArrayList<Integer> fibonacci(int n) {
		
		ArrayList<Integer> fibList = new ArrayList<Integer>();
		fibList.add(0); fibList.add(1);
		
		for (int i = 2; i < n; i++) {
			fibList.add(fibList.get(i-1) + fibList.get(i - 2));
		}
		return fibList;
	}
	
	public static ArrayList<Double> randNums(int n, int x) {
		
		ArrayList<Double> nums = new ArrayList<Double>();
		
		while (nums.size() < n) 
			
			nums.add(Math.random() * 2 * x - x);
		
		return nums;
	}
	
	public static void posNeg(ArrayList<Integer> nums) {
		
		ArrayList<Integer> pos = new ArrayList<Integer>(), neg = new ArrayList<Integer>();
		
		for (int n : nums) {
			if (n >= 0)
				pos.add(n);
			else
				neg.add(n);
		}
		System.out.println(pos);
		System.out.println(neg);
	}
	
	public static void reverse(ArrayList<Double> nums) {
		
		for (int i = 0; i < nums.size()/2; i++) {
			
			double temp = nums.get(i);
			nums.set(i, nums.get(nums.size()-i-1));
			nums.set(nums.size()-i-1, temp);
		}
	}
			
	public static void main(String[] args) {

		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4); testList.add(1); testList.add(-3); testList.add(9);
		testList.add(7); testList.add(-2);
		
		System.out.println(minIndex(testList));
	}

}
