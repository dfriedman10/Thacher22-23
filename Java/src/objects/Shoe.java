package objects;

public class Shoe {
	
	int size;
	String color;
	String brand;
	String type;
	
	public Shoe(int s, String c, 
			String b, String t) {
		
		size = s;
		color = c;
		brand = b;
		type = t;
	}
	
	public Shoe(int s, String c) {
		
		size = s;
		color = c;
		brand = "unknown";
		type = "uknown";
	}
	
	public void changeColor(String newColor) {
		
		color = newColor;
	}
	
	public int getSize() {
		return size;
	}
	
	public static void main(String[] args) {
		
		Shoe jordans = new Shoe(10, "Blue", "Jordan", "One");
		
		Shoe sneaker = new Shoe(12, "Red");
		
		System.out.println(  sneaker.getSize() + jordans.getSize()  );
	}

}
