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
	
	
	public void sayHi() {
		System.out.println("Hi my name is " + 
	name + ", I'm from " + from);
	}
	
	public void getOlder() {
		age ++;
		grade ++;
	}
	
	
	public static void main(String[] args) {
		
		Student jared = new Student("Jared", 17, "SF", 11);
		
		jared.sayHi();
		
		Student sera = new Student("Sera", 16, "LA", 11);
		
		sera.getOlder();
		sera.sayHi();
		
		
		
		
	}

}
