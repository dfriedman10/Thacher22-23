package objects;

public class Deck {
	
	private Card[] deck = new Card[52];
	
	public Deck() {
		
		
		String[] suits = {"clubs", "spades", "diamonds", "hearts"};
		int index = 0;
		for (int s = 0; s < suits.length; s++) {
			for (int num = 1; num <= 13; num++) {
				deck[index++] = new Card(suits[s], num);	
			}
		}
	}
	
	public Card getRandom() {
		return deck[(int)(Math.random()*52)];
	}
	
	public Card[] deal(int n) {
		Card[] hand = new Card[n];
		
		for (int i = 0; i < n; i++) {
			hand[i] = deck[i];
		}
		return hand;
	}
	
	public void shuffle() {
		// swap 100 times
		for (int i = 0; i < 100; i++) {
			int rand1 = (int)(Math.random()*52), rand2 = (int)(Math.random()*52);
			Card temp = deck[rand1];
			deck[rand1] = deck[rand2];
			deck[rand2] = temp;
		}
	}
	
	public int aceLocation() {
		for (int i = 0; i < deck.length; i++) {
			if (deck[i].num == 1) {
				return i;
			}
		}
		return -1;
	}
	
	public String toString() {
		
		String output = "";
				
		for (Card c : deck) {
			output += c.toString() + "\n";
		}
		
		return output;
	}
}