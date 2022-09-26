package inheritance;

public class Student extends Human{

	private int grade;
	
	public Student(int height, int age, String name, int grade) {
		
		super(height, age, name);
		
		this.grade = grade;
	}
	
	public void takeTest() {
		System.out.println("stress");
	}
	
	public void birthday() {
		System.out.println("hbd");
		super.birthday();
	}
	
	
	public static void main(String[] args) {
		
		Student marg = new Student(60, 10, "margaret", 11);
		
		System.out.println(marg.getAge());
		marg.birthday();
		System.out.println(marg.getAge());
		



		
	}
}
