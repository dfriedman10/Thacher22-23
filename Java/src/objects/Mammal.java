package objects;

public abstract class Mammal {

	String furColor;
	boolean carnivore;
	int weight;
	
	public abstract void draw();
	
	public void eat() {
		weight++;
	}
	
	
	
	public static void main(String[] args) {
		

		Mammal pet = new Mammal();
		
	}
}
