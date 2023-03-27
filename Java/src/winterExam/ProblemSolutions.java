package winterExam;

import java.util.Arrays;

public class ProblemSolutions {

	public static void main(String[] args) {
		ProblemSolutions tester = new ProblemSolutions();
		tester.problem1("superwalking");
		
		tester.problem2(new double[] {1, 3, 5});
		
		tester.problem3(new String[] {"coconut", "ball", "become", "aramco", "hi"}, "co");
	}
	
	public void problem1(String word) {
		
		if (word.length() >= 5 && word.substring(0,5).equals("super")) {
			word = "sub" + word.substring(5);
			
		}
		
		if (word.length() >= 3 && word.substring(word.length()-3).equals("ing")) {
			word = word.substring(0, word.length()-3) + "ed";
		}
		System.out.println(word);
	}

	public void problem2(double[] arr) {
		double avg = 0;
		for (int i = 0; i < arr.length; i++) {
			avg += arr[i];
		}
		avg = avg/arr.length;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > avg) {
				arr[i] -= avg;
			}
			else if (arr[i] < avg) {
				arr[i] += avg;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public void problem3(String[] arr, String str) {
		
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].indexOf(str) != -1) {
				count += 1;
			}
		}
		
		System.out.println(count);
	}
}
