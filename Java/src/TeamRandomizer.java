import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamRandomizer {
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> names = new ArrayList<String>();
		
		BufferedReader in = new BufferedReader(new FileReader("roster"));
		
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			
			names.add(line);
		}
		
		in.close();
		
		Scanner scanner = new Scanner(System.in);
		
		while (names.size() > 1) {
			
			System.out.println(names.remove(0) + " and " + names.remove(0));
			scanner.nextLine();
		}
		
		if (names.size() == 1) 
			System.out.println(names.remove(0));
		
		
	}

}
