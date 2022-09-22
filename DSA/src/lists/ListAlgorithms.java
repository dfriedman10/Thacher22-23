package lists;

import java.util.ArrayList;

public class ListAlgorithms {

	
	
//	Take a list of integers as parameter. Return the average of the numbers in this list.
//	 
//
//	Take a list of integers as parameter. Return the minimum number in this list.
//	 
//
//	Take an integer n as parameter. Return a list containing the first n numbers in the Fibonacci sequence (0, 1, 1, 2, 3, 5, 8, 13...)
//
//	Create a method that takes two integers as parameter (n and x), and return a list of n random numbers between -x and x, inclusive.
//	 
//
//	Create a method that takes a list of integers as parameter. The method should then separate these numbers into two ArrayLists: one for positive integers, the other for negative integers. Print both of these lists (we can't return them both).
//	For example, if the random ArrayList was [-9, 3, 42, -17, -19], we would get [3, 42] and [-9, -17, -19].
//
//	 
//
//	Create a method that takes a list of doubles as parameter. Reverse this list without creating any new lists. Do you need to return anything?
			
	
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
