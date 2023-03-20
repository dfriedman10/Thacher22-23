package objects;

public class Student {
	
	String name;
	int age;
	String from;
	int grade;
	
	public Student(String n, int a, String f, int g) {
		name = n;
		age = a;
		from = f;
		grade = g;
	}
	
	public String toString() {
		
		return "Name: " + name + ", age: " + age + ", from: " + 
				from + ", grade: " + grade;
	}
	
	
	public void sayHi() {
		System.out.println("Hi my name is " + 
	name + ", I'm from " + from);
	}
	
	public void getOlder() {
		age ++;
		grade ++;
	}
	
	public void inSameGrade(Student other) {
		
		if (grade == other.grade) {
			System.out.println("same grade!");
		}
		else {
			System.out.println("nope");
		}
	}
	
	
	public static void main(String[] args) {
		
		Student jared = new Student("Jared", 17, "SF", 11);
		Student sera = new Student("Sera", 16, "LA" ,11);
		
		jared.getOlder();
		jared.inSameGrade(sera);
		
		
		
		
	}

}
