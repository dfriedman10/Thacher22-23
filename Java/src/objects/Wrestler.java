package objects;

public class Wrestler {
	
	String color;
	private double weight; 
	private int wins;
	
	public Wrestler(String color, double weight, int wins) {
		this.wins = wins;
		this.weight = weight; 
		this.color = color;
	}

	public void tagTeam(Wrestler[] allies, 
			Wrestler[]  opps) {
		
		double allyWeight = this.weight, 
				oppWeight = 0;
		
		for (int i = 0; i< allies.length; i++) {
			allies[i].color = this.color;
			allyWeight += allies[i].weight;
		}
		
		for (int i = 0; i< opps.length; i++) {
			opps[i].color = opps[0].color;
			oppWeight += opps[i].weight;
		}
		
		if (allyWeight >= oppWeight) {
			System.out.println("My team wins!");
			this.wins ++;
			for (int i = 0; i< allies.length; i++) {
				allies[i].wins ++;
			}
		}
		else {
			System.out.println("Opponents win :(");
			for (int i = 0; i< opps.length; i++) {
				opps[i].wins ++;
			}
		}
	}
	
	public double getWeight() {
		return weight;
	}
	
	
	public static void main(String[] args) {
		
		Wrestler me = new Wrestler("blue", 100, 0);

		Wrestler george = new Wrestler("red", 50, 2);
		Wrestler lucien = new Wrestler("green", 200, 1);
		Wrestler paige = new Wrestler("purple", 150, 0);
		Wrestler kaili = new Wrestler("white", 120, 3);
		
		Wrestler[] allies = {george};
		
		me.tagTeam(allies, new Wrestler[] {lucien, paige, kaili});

		System.out.println(george.color);
		
		
		
	}

}
