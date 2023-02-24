package strings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {
	

	public void modifyFile(String fileName) throws IOException {
		
		
		BufferedReader reader = 
				new BufferedReader(new FileReader(fileName));
		
		BufferedWriter writer = 
				new BufferedWriter(new FileWriter("edited_" + fileName));
		
		for (String line = reader.readLine(); 
				line != null; line = reader.readLine()) {
			
			
			
			line = line + line; // this can change
			
			
			
			writer.write(line + '\n');
			
		}
		
		reader.close();
		writer.close();
	}
	
	
	public static void main(String[] args) throws IOException {
	
		FileReadWrite tester = new FileReadWrite();
		tester.modifyFile("roster");
		
	}

}
