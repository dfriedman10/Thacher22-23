package objects;

public class JohnCena extends Wrestler{
	
	
	
	public JohnCena(String color, double weight, int wins) {
		super(color, weight, wins);
		// TODO Auto-generated constructor stub
	}
	
	public void fight(Wrestler opp) {
		
		if (opp.getWeight() < this.getWeight()*2) {
			
			opp.color = "blue";
			
		}
		
	}

}
