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
		

		Mammal[] eric = new Mammal[8];
		
		eric[0] = new Dog();
		
	}
}
