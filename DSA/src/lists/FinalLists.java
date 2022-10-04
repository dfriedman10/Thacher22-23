package lists;

import java.util.ArrayList;

//Easier:
//Write a method that takes a list of integers as parameter. Return how many of these integers are even. 
//Write a method that takes two integers as parameter (n and x). Return a list containing the first n multiples of x.
//Write a method that takes a list of characters as parameter, as well as 2 integers (i and j). These integers represent the start and end index of a sublist. Return the sublist from i to j. Per usual in CS, the start index is inclusive, end index is exclusive. 
//For example, for inputs ['g', 'm', 'd', 'e', 'i', 'p', 'w'], 2, and 5, we would return ['d', 'e', 'i']
//
//Medium:
//Write a merge method. This method should take two lists of integers as parameters. Return a new list containing all elements from both lists, in alternating order (the first element is from the first list, the second element is from the second list, the third element is from the first list, ...)
//For example, inputs of [5, 2, 9] and [1, 3, 7] would return [5, 1, 2, 3, 9, 7]
//
//Write a method that takes two lists of strings as parameter. The second list is a "delete list". Any strings in the first list that also appear in the second list should be removed from the first. Do we need to return anything?
//Harder:
//Write a method that takes a list of strings as parameter. Remove any duplicates from the list, and return how many duplicates were removed.
//
//Write a method that generates a list of the first n magic squares. A magic square is a number that is a perfect square and also the sum of numbers 1 through n. For example, 36 is a magic square because it is a perfect square and the sum of numbers 1 to 8. 1225 is the next magic square, it is 35 squared and the sum of 1 to 49. 
//
//Challenge:
//Write a method that takes a list of strings as parameter. Create a series of lists such that each list only holds strings of the same length. How can you return this collection of lists?

public class FinalLists {

	public static int numEvens(ArrayList<Integer> nums) {
		
		int total = 0;
		
		for (int n : nums)
			if (n % 2 == 0)
				total++;
		
		return total;
	}
	
	public static ArrayList<Integer> multiples(int n, int x) {
		
		ArrayList<Integer> mult = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) 
			mult.add(i * x);
		
		return mult;
	}
	
	public static ArrayList<Character> subList(ArrayList<Character> orig, int i, int j) {
		
		ArrayList<Character> newList = new ArrayList<Character>();
		
		for (int k = i; k < j; k++) 
			newList.add(orig.get(k));
		
		return newList;
	}
	
	public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		
		ArrayList<Integer> merged = new ArrayList<Integer>();
		
		for (int i = 0; i < Math.max(list1.size(), list2.size()); i++) {
			if (i < list1.size()) 
				merged.add(list1.get(i));
				
			if (i < list2.size()) 
				merged.add(list2.get(i));
		}
		
		return merged;
	}
	
	public static void delete(ArrayList<String> orig, ArrayList<String> deleteList) {
		
		for (String s : deleteList) 
			
			while (orig.indexOf(s) != -1)
				orig.remove(s);
		
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4); testList.add(1); testList.add(3);
		testList.add(2); testList.add(8); testList.add(5);
		
		ArrayList<Integer> testList2 = new ArrayList<Integer>();
		testList2.add(7); testList2.add(9); testList2.add(6);
		
		System.out.println(merge(testList, testList2));
	}
}
