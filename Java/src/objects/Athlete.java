package objects;

public class Athlete {
	
	String sport;
	String name;
	boolean pro;
	private int vert;
	int numSponsors;
	
	public Athlete(String sport, String name, 
			boolean pro, int vert, int numSponsors) {
		
		this.sport = sport;
		this.name = name;
		
		this.numSponsors = numSponsors;
	}
	
	public String toString() {
		return "name: " + name + ", sport: " + sport 
				+ (pro ? " is pro" : "isn't pro");
	}
	
	public void goPro() {
		
		if (vert > 30) {
			pro = true;
		}
		else {
			System.out.println("no springs");
		}
		
	}
		
	public void train() {
		System.out.println("Lift lift lift");
	}
	
	public int getVert() {
		return vert;
	}
	
	
	
}
