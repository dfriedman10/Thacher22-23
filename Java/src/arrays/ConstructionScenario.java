package arrays;

import java.util.HashMap;
import java.util.Scanner;

public class ConstructionScenario {
	
	
	class Project {
		String name, client;
		int budget, moneySpent;
		boolean finished;
		
		public Project(String name, String client, int budget) {
			this.name = name;
			this.client = client;
			this.budget = budget;
		}
	}
	
	public void run() {
		
		HashMap<String, Project> projects = new HashMap<String, Project>();
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			
			System.out.println("Enter a project name, or press q to quit: ");
			
			String name = in.nextLine();
			
			if (name.equals("q")) break;
			
			if (!projects.containsKey(name)) {
				
				System.out.println("Project not in database. Would you like to add it? (y/n): ");
				String choice = in.nextLine();
				
				if (choice.equals("y")) {
					System.out.println("Enter the client name: ");
					String client = in.nextLine();
					System.out.println("Enter the budget: ");
					int budget = Integer.parseInt(in.nextLine());

					projects.put(name, new Project(name, client, budget));
					
					System.out.println("Project added to database.");
				}
			}
			
			else {
				
				System.out.println("What would you like to do? 1. View project info. 2. Mark project as done. 3. Add to money spent. ");
				String choice = in.nextLine();
				
				if (choice.equals("1")) {
					System.out.println("Client: " + projects.get(name).client);
					System.out.println("Budget: " + projects.get(name).budget);
					System.out.println("Money Spent: " + projects.get(name).moneySpent);
					System.out.println("Finished: " + projects.get(name).finished);
				}
				else if (choice.equals("2")) {
					System.out.println("Project has been marked as complete");
					projects.get(name).finished = true;
				}
				else if (choice.equals("3")) {
					System.out.println("How much money has been spent since the last update? ");
					int amount = Integer.parseInt(in.nextLine());
					projects.get(name).moneySpent += amount;

				}
				else { 
					System.out.println("Invalid choice. Run again.");
				}
			}
			System.out.println("\n\n");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		new ConstructionScenario().run();
		
	}

}
