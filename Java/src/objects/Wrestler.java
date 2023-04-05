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

	public void tagTeam(Wrestler[] allies, Wrestler[] opps) {
		
		double allyWeight = this.weight, oppWeight = 0;
		
		for (int i = 0; i < allies.length; i++) {
			allies[i].color = this.color;
			allyWeight += allies[i].weight;
		}
		
		for (int i = 0; i < opps.length; i++) {
			opps[i].color = opps[0].color;
			oppWeight += opps[i].weight;
		}
		
		if (allyWeight >= oppWeight) {
			
			System.out.println("Allied team wins!");
			for (int i = 0; i < allies.length; i++) {
				allies[i].wins ++;
			}
			this.wins++;
		}
		else {
			System.out.println("Opponent team wins!");
			for (int i = 0; i < opps.length; i++) {
				opps[i].wins ++;
			}
		}

	}
	
	public double getWeight() {
		return weight;
	}
	
	
	public void fight() {
		System.out.println("fight");
	}
	
	
	public static void main(String[] args) {
		
//		Wrestler me = new Wrestler("blue", 100, 0);
//		
//		Wrestler graham = new Wrestler("green", 80, 5);
//		Wrestler evie = new Wrestler("blue", 150, 2);
//		
//		Wrestler[] allies = { graham,  evie };
//		Wrestler[] opps = { new Wrestler("red", 70, 5), new Wrestler("black", 200, 2), new Wrestler("white", 120, 2)  };
//
//		
//		me.tagTeam(allies, opps);
//		
//		System.out.println(opps[0].wins);
		
		
		
		Wrestler jc = new JohnCena("blue", 100, 20);
		
		jc.fight();
		
		
		

		
		
		
		
	}

}
