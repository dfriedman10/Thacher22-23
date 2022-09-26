package inheritance;

public class Human {

	private int height;
	private int age;
	private String name;
		
	public Human(int h, int a, String name) {
		height = h;
		age = a;
		this.name = name;
	}
	
	public void birthday( ) {
		age++;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public static void main(String[] args) {
		
		Human gage = new Human(60, 10, "gage");
		Human jeremy = new Human(50, 16, "jeremy");



		
	}
	
}
