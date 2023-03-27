package strings;


public class StringExamples {
	
	public void contains(String str1, String str2) {
		
		if (str1.indexOf(str2) >= 0) 
			System.out.println(true);
		else
			System.out.println(false);
		
		
	}
	
	public void findLetter(String str, char letter) {
		
		int count = 0;
		
		for (int i = 0; i < str.length(); i++) {
			
			if ( str.charAt(i) == letter ) {
				
				count += 1;
			}
		}
		
		System.out.println(count);
		
	}
	
	public void findWord(String str, String searchWord) {
		
		int count = 0; 
		
		for (int i = 0; i < str.length()-(searchWord.length()-1); i++) {
			
			if ( str.substring(i, i+searchWord.length()).equals(searchWord) ) {
				
				count+= 1;
			}
		}
		
		System.out.println(count);
		
		
		
	}

	public static void main(String[] args) {

		StringExamples tester = new StringExamples();

//		tester.findLetter("evie like eggs", 'g');
		
//		tester.findWord("graham graham graham", "ham");
		
		tester.contains("bisquick", "ibbbsland");
		
	}

}
