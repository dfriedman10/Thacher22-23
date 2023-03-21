package objects;

public class Student {

	int grade;
	String name;
	int age;
	String from;
	
	public Student(String n, int a, int g, String f) {
		name = n; 
		grade = g;
		age = a; 
		from = f;
	}
	
	public String toString() {
		
		return "Name: " + name + ", age: " + age + ", grade: " + 
		grade + ", from: " + from;
	}
	
	public void getOlder() {
		age ++;
		grade ++; 
	}
	
	public void move(String newPlace) {
		from = newPlace;
	}
	
	public void sayHi() {
		System.out.println("Hi, my name is " + 
				name + ", I'm from " + from) ;
	}
	
	public void inSameGrade(Student other) {
		
		if (other.grade == grade) {
			System.out.println("same grade!");
		}
		else {
			System.out.println("nope");
		}
	}
	
	public static void main(String[] args) {
		
		Student george = new Student("George", 15, 10, "New York");
		
		Student lucien = new Student("Lucien", 18, 12, "Seattle");
		
		george.getOlder();
		george.getOlder();
		
		
		george.inSameGrade(lucien);
		
		
	}
}
