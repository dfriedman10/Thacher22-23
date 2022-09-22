package conditionals;
// Mr. David's Adventure Project
// I got help from Mohammed, Mr. Nadim, and StackOverflow

import java.util.Scanner;

public class Adventure_Example {
	
	// we need our scanner in multiple methods, so make it an instance variable
	private Scanner input = new Scanner(System.in);
	
	// introduces the game and gets the user's name
	public void introduction() {
		
		System.out.println("Welcome to the Amazon. What's your name?");
		
		char answer = input.next().toLowerCase().charAt(0);
		
		System.out.println("Of course, you're " + answer + " the famous explorer. \n"
				+ "You must be here in search of the ancient treasure.");
		
		first_decision();
	}
	
	// asks the first question and gets an answer
	public void first_decision() {
		System.out.println("You are standing on a path leading into the jungle. \nBesides the path"
				+ " is a river. What do you do?");
		
		System.out.println("a. Head down the path. \nb. Hop in the river and start swimming downstream.");
		
		char answer = input.next().toLowerCase().charAt(0);
		
		// if input is 'a', move on to the attacker step
		if (answer == 'a') 
			attacker_decision();
			
		// if input is 'b', move on to the river step
		else if (answer == 'b')
			river_death();
		
		// if they're dumb, give an error
		else 
			input_error();
	}
	
	// the attacker step
	public void attacker_decision() {
		System.out.println("You head down the path. Suddenly, an arrow zips past your head."
				+ "\nWhat do you do?" );
		System.out.println("a. Run! \nb. Climb a tree to get out of view of your attacker. "
				+ "\nc. Pull out your knife and start yelling.");
		
		char answer = input.next().toLowerCase().charAt(0);
		
		// input 'a' leads to the jungle
		if (answer == 'a') 
			lost_in_jungle();
		
		// input 'b' leads to death
		else if (answer == 'b') 
			System.out.println("You climb up the tree, out of sight of your attacker."
				+ "\nHowever you immediately discover there are ravenous \nchimpanzees up here who throw you "
				+ "off for invading their territory. RIP");
		
		// input 'c' leads to the warrior step
		else if (answer == 'c') 
			warrior_decision();
		
		// dumb error
		else
			input_error();
	}
	
	// the warrior step
	public void warrior_decision() {

		System.out.println("A native warrior emerges from the jungle. He orders you to follow him."
				+ "\nWhat do you do?");
		
		System.out.println("a. You don't take orders from anybody. You attack him with your little pocketknife.\n"
				+ "b. You follow him obediently. \nc. You act crazy, waving your arms in the air and yelling nonsense.");
		
		char answer = input.next().toLowerCase().charAt(0);
		
		// input 'a' leads to the warrior death step
		if (answer == 'a') 
			warrior_death();
		
		// input 'b' leads to the python step
		else if (answer == 'b') 
			python_decision();
			
		// input 'c' leads to the chimp step
		else if (answer == 'c') 
			chimp_adoption();
		
		// dumb error
		else 
			input_error();
	}
	
	public void python_decision() {
		System.out.println("He leads you down a path. After a bit, you take a turn onto a new path. "
				+ "\nIn the middle of the path is a 20 foot python, \nlooking at the two of you hungrily. "
				+ "\nIt immediately lunges towards you. What do you do?");
		System.out.println("a. Push the warrior into the python's path. Better him than you. \nb. Grab the warrior and "
				+ "jump into the river.\nc. Draw your knife and rush at the python.");
		
		char answer = input.next().toLowerCase().charAt(0);
		
		// input 'a' leads to the running away step
		if (answer == 'a') 
			run_away();
		
		// input 'b' leads to success
		else if (answer == 'b') 
			success();
		
		// input 'c' leads to death
		else if (answer == 'c') 
			python_death();
				
		// dumb error
		else 
			input_error();
	}
	
	// possible end of game step
	public void run_away() {
		System.out.println("The python happily starts swallowing the warrior. \nYou run back the way you came.");

	}
	
	// possible end of game step
	public void success() {
		System.out.println("You and the warrior float down the river for a bit, safe from the danger of the python."
			+ " Once you're sure its safe, \nyou both get back onto dry land. He expresses his deep gratitude for saving his life,"
			+ "and as thanks, leads you to the lost city of gold. \nYou found it! Now you just have to get all this treasure out of the "
			+ "jungle...");
	}
	
	// possible end of game step
	public void python_death() {
		System.out.println("You are a tasty lunch for the python. RIP");
	}
	
	// possible end of game step
	public void chimp_adoption() {
		System.out.println("The chimpanzees up in the trees recognize you as one of their own."
				+ " They hop down and protect you from your attackers, then adopt you. \nLooks like you'll be living with "
				+ "monkeys for the rest of your days.");
	}
	
	// possible end of game step
	public void warrior_death() {
		System.out.println("Probably not a great idea. RIP");
	}
	
	// possible end of game step
	public void lost_in_jungle() {
		System.out.println("Well, you're alive, but you've run off the path into the middle of"
			+ " unexplored jungle. Good luck ever getting out.");
	}
	
	// possible end of game step
	public void river_death() {
		System.out.println("Maybe not the smartest choice. As soon as you hop in, a group of piranhas \nmake a tasty breakfast out of you. RIP");	
	}
	
	// idiot control
	public void input_error() {
		System.out.println("Not a valid input");
	}

	// main method to get the game started.
	public static void main(String[] args) {
				
		// only need to call introduction() because this leads to the other 
		// methods.
		Adventure_Example test = new Adventure_Example();
		test.introduction();
	}
}
