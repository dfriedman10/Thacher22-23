
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
	public void badStringToASCII(String str) {
		
		// for loop
		for (int i = 0; i < str.length(); i++) {
			
			// plugs the index into the string
			char letter = str.charAt(i);
			
			// prints the answer
			System.out.print((int)letter+",");
		}
		System.out.println();
	}

	
	public static void main(String[] args) {
		Commenting tester = new Commenting();
		tester.badStringToASCII("Hav"); 
		tester.badStringToASCII("e a goo");
		tester.badStringToASCII("d sp");
		tester.badStringToASCII("ring ");
		tester.badStringToASCII("break!");
	}
}
