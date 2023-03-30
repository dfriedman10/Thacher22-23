package objects;

public class Athlete {
	
	String sport;
	int timePracticed;
	String name;
	boolean pro;
	
	public Athlete(String sport, 
			String name, boolean pro) {
		
		this.sport = sport;
		this.timePracticed= 0;	// in hours
		this.name = name;
		this.pro = pro;
	}
	
	public String toString() {
		return "My name is " + name +", I play " 
				+ sport + ". Professional status: " + pro;
	}
	
	public void play(int time) {
		timePracticed += time;
	}

	public void goPro() {
		if (timePracticed > 10000) {
			pro = true;
		}
		else {
			System.out.println("Not enough practice time");
		}
	}
}
