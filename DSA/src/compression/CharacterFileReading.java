package compression;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CharacterFileReading {

	public static void main(String[] args) {
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("test.txt"));

			for (int i = in.read(); i != -1; i = in.read()) {
				char c = (char)i;
				
				System.out.println(c);
				
			}
			in.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
