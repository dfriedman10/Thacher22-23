package strings;

public class ModifyingStrings {
	
	public void replace(String original, 
			String toReplace, String replacement) {
		
		 
		
		for (int i = 0; i < original.length() - toReplace.length()+1; i++) {
			
			if (original.substring(i, i + toReplace.length()).equals(toReplace)) {
				
				original = original.substring(0, i) + 
						replacement + original.substring(i+toReplace.length());
				
			}
		}
		System.out.println(original);
		
	}
	
	

	public static void main(String[] args) {
		
		ModifyingStrings tester = new ModifyingStrings();
		
		tester.replace("hello mateo bye mateo", "mateo", "Shiraz");
		
		
		
		
		
		
	}
	
	
	
	
	
}
