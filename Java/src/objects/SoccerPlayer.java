package objects;

public class SoccerPlayer extends Athlete {
	
	int goals;

	
	public SoccerPlayer(String name, boolean pro, int goals) {
		super("soccer", name, pro);
		
		this.goals = goals;
	}
	
	public void score() {
		goals++;
		super.timePracticed += 100;
	}
	
	public String toString() {
		
		return super.toString() + " goals: " + goals;
		
	}

	
	
	

}
