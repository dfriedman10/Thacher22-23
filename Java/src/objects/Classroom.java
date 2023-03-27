package objects;

public class Classroom {
	
	Student[] students;
	String teacher;
	String subject;
	
	public Classroom(int n, String t, String s) {
		students = new Student[n];
		teacher = t;
		subject = s;
	}

	public void addStudent(int i, String name, 
			int age, int grade, String from) {
		
		if (students[i] == null) {
			students[i] = new Student(name, age, grade, from);
		}
		else {
			System.out.println("Seat taken. Choose a new spot");
		}
	}
	
	public void allSayHi() {
		for (int i = 0; i < students.length; i++) {
			
			if (students[i] != null) {
				students[i].sayHi();
			}
		}
	}
	
	public double averageAge() {
		
		double sum = 0;
		int seatsFilled = 0;
		
		for (int i = 0; i < students.length; i++) {
			
			if (students[i] != null) {
				sum += students[i].age;
				seatsFilled ++;
			}
		}
		return sum / seatsFilled;
	}
	
	public static void main(String[] args) {
		
		Classroom cs = new Classroom(5, "Mr. Friedman", "CS");
		cs.addStudent(0, "George", 15, 10, "NYC");

		cs.addStudent(1, "Jayden", 16, 10, "Seoul");
		
		cs.addStudent(2, "Petra", 17, 12, "LA");
			
		System.out.println( cs.averageAge()  );
}	
}
