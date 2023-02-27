
public class Commenting {
	
	// good commenting
	public void goodStringToASCII(String str) {
		
		// iterates through each index in the string
		for (int i = 0; i < str.length(); i++) {
			
			// gets the character at the current index
			char letter = str.charAt(i);
			
			// prints the current character along with its 
			// ASCII value
			System.out.println(letter + ": " + (int)letter);
		}
	}
	
	// bad commenting
	public void badStringtoASCII(String str) {
		
		// for loop
		for (int i = 0; i < str.length(); i++) {
			
			// plugs the index into the string
			char letter = str.charAt(i);
			
			// prints the answer
			System.out.println(letter + ": " + (int)letter);
		}
	}

	
	public static void main(String[] args) {
		Commenting tester = new Commenting();
		tester.goodStringToASCII("hello");
	}
}
