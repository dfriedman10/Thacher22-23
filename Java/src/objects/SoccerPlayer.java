package objects;

public class SoccerPlayer extends Athlete {
	
	int kickStrength;
	
	public SoccerPlayer(String name, 
			boolean pro, int vert, int numSponsors, int kickStrength) {
		
		super("soccer", name, pro, vert, numSponsors);
		
		this.kickStrength = kickStrength;
	}

	public void shoot() {
		if (kickStrength > 5 && super.getVert() > 20) {
			System.out.println("GOAAAAAL");
		}
		else {
			System.out.println("weak");
		}
	}
	

	public void train() {
		
		super.train();
		
		System.out.println("run run run");

	}
	
	public String toString() {
		
		return super.toString() + " strength: " + kickStrength;
	}
	
	public static void main(String[] args) {
		
		
		
		Athlete messi = new SoccerPlayer("Messi", true, 35, 100, 5);
		Athlete lucien = new Athlete("track", "lucien", true, 35, 100);
		Athlete ronaldo = new SoccerPlayer("Messi", true, 35, 100, 5);
		

		
		Athlete[] athletes = { messi, lucien, ronaldo  };
		
		for (int i = 0; i < athletes.length; i++) {
			athletes[i].train();
		}
		
		
		
	}
	
	
	

}
