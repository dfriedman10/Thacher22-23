package objects;

public class Classroom {
	
	Student[] students;
	String teacher;
	String subject;
	
	public Classroom(int numberStudents, String t, String sub) {
		
		students = new Student[numberStudents];
		teacher = t; 
		subject = sub; 
	}
	
	public void addStudent(String name, int age, int grade, String from, int i) {
		
		if (students[i] == null) {
			
			students[i] = new Student(name, age, grade, from);
			
		}
		else {
			System.out.println("Spot already taken. Try again");
		}
	}
	
	public void introduceEveryone() {
		
		for (int i = 0; i < students.length; i++) {
			
			if (students[i] != null) {
				students[i].sayHi();
			}
		}
	}
	
	public double averageAge() {
		
		double count = 0;
		int numFilled = 0;
		
		for (int i = 0; i < students.length; i++) {
			
			if (students[i] != null) {
				count += students[i].age;
				numFilled++;
			}
		}
		
		return count / numFilled;
	}
	
	
	
	
	

	public static void main(String[] args) {

		Classroom compsciC = new Classroom(7, "Mr. Friedman", "CS");
		
		compsciC.addStudent("Evie", 17, 11, "Ojai", 1);
		compsciC.addStudent("Graham", 12, 11, "SB", 2);
		compsciC.addStudent("Julia", 20, 11, "Orlando", 3);
		
		System.out.println(compsciC.averageAge());

		
		
		
	}

}
