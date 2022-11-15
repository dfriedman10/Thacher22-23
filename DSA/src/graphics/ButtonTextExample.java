package graphics;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

// this class demonstrates how to read text from a file, create a JFrame with text output,
// and add buttons to your JFrame.
public class ButtonTextExample {
	
	// constant width and height, and our file's name
	private final int WIDTH = 600, HEIGHT = 600, TEXTHEIGHT = 475;
	private final String fileName = "test.txt";
	
	
	// the constructor now does several things rather than just set up basic graphics, so I've 
	// separated it into helper methods.
	public ButtonTextExample() {
		
		// this will hold the contents of our file to read
		String fileContent = readFile();
		JPanel panel = new JPanel();
		
		// gives our panel a certain layout to my liking - not necessary, just looks nice
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		
		// gives our panel a nice looking border
		panel.setBorder(BorderFactory.createTitledBorder("File Analysis"));
		
		// initializes the text container, and doesn't allow the user to type
		// into the display
		JTextArea displayarea = new JTextArea();
		displayarea.setEditable(false);
		
		// put the text field into a scroll pane so that we can see everything that's 
		// been displayed throughout the program
		JScrollPane scroll = new JScrollPane (displayarea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		// set a "preferred" size for our scroll panel - this will not always be used, but 
		// the window will try
		scroll.setPreferredSize(new Dimension(WIDTH,TEXTHEIGHT));
		panel.add(scroll);
		
		// create and add listeners to the buttons
		JButton lettersButton = new JButton("Letter Count");
		lettersButton.addActionListener(new ActionListener() {
			
			// what we want to happen when the user clicks this button
			public void actionPerformed(ActionEvent e) {
				
				// counts the number of letters in our file
				String output="";
				output = "\n     Number of letters in "+fileName+": ";
				output += fileContent.length();
				
				// adds our new text to the previous text display - make sure not to overwrite 
				// previous text!
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		
		JButton wordsButton = new JButton("Word Count");
		wordsButton.addActionListener(new ActionListener() {
			
			// what we want to happen when the user clicks this button
			public void actionPerformed(ActionEvent e) {
				
				// counts the number of words in our file
				int wordCount = 1;
				for (int i = 0; i < fileContent.length(); i++) 
					if (fileContent.charAt(i) == ' '|| fileContent.charAt(i) == '\n')
						wordCount++;
				
				String output="";
				output = "\n     Number of words in "+fileName+": ";
				output += wordCount;
				
				// adds our new text to the previous text display - make sure not to overwrite 
				// previous text!
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		
		// create an inner container for the two buttons and add it to our main panel
		JPanel innerPanel = new JPanel();
		innerPanel.add(wordsButton);
		innerPanel.add(lettersButton);
		panel.add(innerPanel);
		
		// the main container, with the usual setup
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		panel.setFocusable(true);
		
		// beginning text display
		displayarea.setText("\n   Currently working in "+fileName+".");
		
		// we don't need a run() method because the only actions happen
		// in the buttons' action listeners!
	}
	
	// reads our file's text and saves it as a string
	private String readFile() {
		
		String content = "";
		
		// surround with a try/catch in case the file doesn't exist
		try {
			// create a reader to parse our file
			BufferedReader in = new BufferedReader(new FileReader(fileName));
		
			// we'll read the file line by line - there are other ways to read files,
			// some are more useful in other circumstances
			for (String line = in.readLine(); line != null; line = in.readLine()) 
				// since we're reading line by line, we won't read the new lines, so we need 
				// to manually add them in to retain accuracy.
				content += line+"\n";
			
			// we added one too many new lines, so we need to clear it off
			if (content.charAt(content.length()-1) == '\n')
				content = content.substring(0, content.length()-1);
			
			// close the reader to make sure file corruption doesn't happen - always be sure 
			// to do this!!
			in.close();
		} 
		
		// good idea to take care of the case in which the user enters a bad file name
		catch (FileNotFoundException e) {
			System.out.println("File not found :( make sure file is in the project (not source code) and "
					+ "has the correct name");
			System.exit(1);
		} 
		catch (IOException e) {
			System.out.println("Error reading file :(");
			System.exit(1);
		}
		
		return content;
	}
	
	// the usual basic main method to get our window running
	public static void main(String[] args) {
		new ButtonTextExample();}
}