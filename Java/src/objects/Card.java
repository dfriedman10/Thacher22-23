package objects;

public class Card {
	
	String suit; 
	int num;
	
	public Card(String s, int n) {
		suit = s; 
		num = n;
	}
	
	public String toString() {
		return num + " of " + suit;
				
	}
	
	
	
}