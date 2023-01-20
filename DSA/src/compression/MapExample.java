package compression;
import java.io.BufferedReader;
import java.util.HashMap;

public class MapExample {

	
	public static void main(String[] args) {
		
		HashMap<Character, Integer> map = 
				new HashMap<Character, Integer>();
		
		map.put('g', 5);
		map.get('g');
		
		if (map.containsKey('g')) {
			map.put('g', map.get('g') + 1);
		}
	}
}
