package winterExam;
import java.util.ArrayList;

public class FinalProject_YourName {
	
	// holds the branches before tree construction
	ArrayList<Branch<Integer>> branches = new ArrayList<Branch<Integer>>();
	
	// holds the numbers generated from traversing your tree
	ArrayList<Integer> soln = new ArrayList<Integer>();

	
	// calls each step of the process
	public FinalProject_YourName() {
		buildList();
		buildTree();
		getNums(branches.remove(0), 0);
		
		// converts each number in your solution to its character equivalent
		for (int n : soln)
			System.out.print((char)n);
	}
	
	// generates a list of branches from a provided text file. Each number should be turned into a leaf,
	// each line of the text file should be turned into a parent branch, with each of these 
	// leaves as children
	public void buildList() {

		// your code here
	}
	
	// builds a tree by removing the first 5 branches from the list then creating a new parent branch
	// with these 5 branches as its children. Repeat until there is only 1 branch remaining in the list
	public void buildTree() {
		
		// your code here
	}
	
	// traverses the tree to generate our solution numbers. The number for the root of the tree is 0. 
	// Any other branch's number is equal to its parent's number + the index of this branch in its parent's
	// children list
	public void getNums(Branch<Integer> b, int currNum) {

		// your code here
	}
	
	public static void main(String[] args) {
		new FinalProject_YourName();
	}
}

