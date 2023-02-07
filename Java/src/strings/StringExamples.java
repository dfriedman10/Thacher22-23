package strings;

public class StringExamples {
	
	
	public void findLetter(String str, char letter) {
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			
			if (str.charAt(i) == letter) {
				count++;
			}
			
		}
		System.out.println(count);
	}
	
	public void findWord(String str, String searchWord) {
		int count = 0; 
		
		for (int i = 0; i < str.length() - searchWord.length() +1; i++) {
			if (str.substring(i, i + searchWord.length()).equalsIgnoreCase(searchWord)) {
				
				count ++;
				
			}
		}
		System.out.println(count);
	}

	public static void main(String[] args) {

		StringExamples tester = new StringExamples();
//		tester.findLetter("everyone eats eggs", 'g');
		
		tester.findWord("Lance eats lance's eggs with Lance", "Lance");

		
		
		
		
		
	}

}
