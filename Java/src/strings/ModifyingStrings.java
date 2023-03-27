package strings;

public class ModifyingStrings {
	
	public void replace(String str, String toReplace, String replacement) {
		
		for (int i = 0; i < str.length() - toReplace.length() + 1; i++) {
			
			if (str.substring(i, i + toReplace.length()).equals(toReplace)) {
				
				str = str.substring( 0, i ) + replacement + 
						str.substring(i+toReplace.length());       
			}
		}
		
		System.out.println(str);
	}
	
	
	public void changePrefix(String word) {
		
		if (word.substring(0, 3).equals("pre")) {
			word = "un" + word.substring(3);
		}
		
		System.out.println(word);
	}
	
	

	public static void main(String[] args) {
		ModifyingStrings tester = new ModifyingStrings();
		
		tester.replace("Harry Potter You're a wizard Harry Potter", "Harry", "Julia");
	}
	
	
	
	
	
}
