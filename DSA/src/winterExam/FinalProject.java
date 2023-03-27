package winterExam;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FinalProject {
	
	ArrayList<Branch<Integer>> branches;
	ArrayList<Integer> soln = new ArrayList<Integer>();

	public FinalProject() {
		buildList();
		buildTree();
		getNums(branches.remove(0), 0);
		
		for (int n : soln)
			System.out.print((char)n);
	}
	
	public void buildList() {
		try {
			branches = new ArrayList<Branch<Integer>>();
	
			BufferedReader in = new BufferedReader(new FileReader("FinalCodes.txt"));
			
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				Branch<Integer> b = new Branch<Integer>();
				for (String s : line.split(",")) {
					b.children.add(new Branch<Integer>(Integer.parseInt(s)));
				}
				branches.add(b);
			}
			in.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found :(");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buildTree() {
		while (branches.size() > 1) { 
			Branch<Integer> b = new Branch<Integer>();
			for (int i = 0; i < 5; i ++) {
				b.children.add(branches.remove(0));
			}
			branches.add(b);
		}
	}
	
	public void getNums(Branch<Integer> b, int currNum) {
		if (b.children.size() == 0) {
			soln.add(currNum + b.data);
		}
		else {
			for (int i = 0; i < b.children.size(); i++) {
				getNums(b.children.get(i), currNum+i);
			}
		}
	}
	
	public static void main(String[] args) {
		new FinalProject();
	}
}
