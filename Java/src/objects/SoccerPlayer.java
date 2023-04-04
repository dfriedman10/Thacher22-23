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
		
		kickStrength ++;

	}
	
	public String toString() {
		
		return super.toString() + " strength: " + kickStrength;
	}
	
	public static void main(String[] args) {
		
		
		
		SoccerPlayer messi = new SoccerPlayer("Messi", true, 35, 100, 5);
		
		messi.shoot();
		messi.train();
		System.out.println(messi);
	}
	
	
	

}
