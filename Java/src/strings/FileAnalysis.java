package strings;
// Program to provide simple text analysis on a chosen file

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileAnalysis {
	private final int WIDTH = 600, HEIGHT = 600;
	private String content = "";
	
	// return an array of size 26, where each entry in the array is the 
	// frequency of the corresponding letter (the first value represents 
	// the frequency of 'a', the second 'b', and so on
	private int[] calcFrequencies() {
		int[] freq = new int[26];
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			if (c >= 97 && c <= 122) 
				freq[c-97] ++;
		}
		return freq;
	}
	
	// returns the number of words in the file
	private int numWords() {
		int count = 1;
		for (int i = 0; i < content.length(); i++) 
			if (content.charAt(i) == ' '|| content.charAt(i) == '\n') 
				count++;
		return count;
	}
	
	// returns the number of lines in the file
	private int numLines() {
		int count = 1;
		for (int i = 0; i < content.length(); i++) 
			if (content.charAt(i) == '\n') 
				count++;
		return count;
	}
	
	// returns the most common letter in the file
	private char mostCommonLetter() {
		int[] freq = calcFrequencies();
		int maxi = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[maxi] < freq[i])
				maxi = i;
		}
		return (char)(maxi+97);
	}
	
	// returns the most common word in the file
	private String mostCommonWord() {
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> freqs = new ArrayList<Integer>();
		for (int i = 0; i < content.length(); i++) {
			String word = "";
			for (; i < content.length() && ((content.charAt(i) >= 97 && 
					content.charAt(i) < 123) ||content.charAt(i)=='\''); i++)
				word += content.charAt(i);
			if (word.length() > 0) {
				if (!words.contains(word)) {
					words.add(word);
					freqs.add(1);
				}
				else
					freqs.set(words.indexOf(word), freqs.get(words.indexOf(word))+1);
			}
		}
		int maxi = 0;
		for (int i = 0; i < freqs.size(); i++) 
			if (freqs.get(maxi) < freqs.get(i))
				maxi = i;
		return words.get(maxi);
	}
	
	// returns the ten most common words (of length > 5) in 
	// the file, in order from most common to least common
	private String[] tenMostCommonWords() {
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Integer> freqs = new ArrayList<Integer>();
		for (int i = 0; i < content.length(); i++) {
			String word = "";
			for (; i < content.length() && ((content.charAt(i) >= 97 && 
					content.charAt(i) < 123) ||content.charAt(i)=='\''); i++)
				word += content.charAt(i);
			if (word.length() >= 5 && word.indexOf("'") == -1) {
				if (!words.contains(word)) {
					words.add(word);
					freqs.add(1);
				}
				else
					freqs.set(words.indexOf(word), freqs.get(words.indexOf(word))+1);
			}
		}
		
		int x = freqs.size();
		freqs.add(0);
		words.add("");
		int[] commonFreqs = {x,x,x,x,x,x,x,x,x,x};
		for (int i = 0; i < commonFreqs.length-1; i++) {
			int maxi = i;
			for (int j = i+1; j< commonFreqs.length; j++) 
				if (freqs.get(commonFreqs[maxi]) < freqs.get(commonFreqs[j]))
					maxi = j;
			int temp = commonFreqs[i];
			commonFreqs[i] = commonFreqs[maxi];
			commonFreqs[maxi] = temp;
		}
		for (int i = 0; i < freqs.size(); i++) {
			if (freqs.get(i) > freqs.get(commonFreqs[9])) {
				commonFreqs[9] = i;
				for (int j = 9; j > 0 && freqs.get(commonFreqs[j])>
						freqs.get(commonFreqs[j-1]); j--) {
					int temp = commonFreqs[j];
					commonFreqs[j] = commonFreqs[j-1];
					commonFreqs[j-1] = temp;
				}
			}
		}
		String[] commonWords = new String[10];
		for (int i = 0; i < commonFreqs.length; i++) 
			commonWords[i] = words.get(commonFreqs[i]);
		return commonWords;
	}
	
	// returns the longest sentence in the file
	private String longestSentence() {
		String longest ="";
		String sentence = "";
		boolean newline = false;
		for (int i = 0; i < content.length(); i++) {
			if (content.charAt(i) == '.' ||content.charAt(i) == '!'
					||content.charAt(i) == '?') {
				if (longest.length() < sentence.length())
					longest = sentence;
				sentence = "";
			}
			else if (content.charAt(i) != '\n') {
				if (content.charAt(i) == ' ' && newline) {
					sentence += "\n      ";
					newline = false;
				}
				else
					sentence += content.charAt(i);
			}
			else 
				sentence += " ";
			if (sentence.length() %80 == 79)
				newline = true;
		}
		return longest;
	}
	
	// returns the percent of characters in the file that are vowels.
	// cast the decimal to a string, shorten it to a few decimal 
	// points, then add a % sign to the end
	private String percentVowels() {
		double vowelCount = 0, charCount = 0;
		
		for (int i = 0; i < content.length(); i++) {
			char c = content.charAt(i);
			if (c <= 122 && c >= 97) {
				charCount ++;
				if (c == 'a' || c == 'e' ||c=='i'||c=='o'||c=='u')
					vowelCount ++;
				else if (c == 'y')
					vowelCount +=.5;
			}
		}
		String out = ""+ vowelCount/charCount*100.0;
		return out.substring(0,5) + "%";
	}
	
	// returns how many times searchWord appears in the file
	private int findWord(String searchWord) {
		
		return content.split(searchWord).length-1;
	}
	
	
	// ***** STOP HERE ***** //

	
	public FileAnalysis() {
		
		JFileChooser fc = new JFileChooser();
		File workingDirectory = new File(System.getProperty("user.dir"));
		fc.setCurrentDirectory(workingDirectory);
		fc.showOpenDialog(null);
		File f = fc.getSelectedFile();
		if (f == null)
			System.exit(-1);
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(f));

			for (int letter = in.read(); letter != -1; letter = in.read()) {
				content += (char)letter;
			}
			in.close();
			content = content.toLowerCase();
		} catch (FileNotFoundException e1) {
			System.out.println("File not found :(");
			return;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// the main container
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// the inner container
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		panel.setBorder(BorderFactory.createTitledBorder("File Analysis"));
		
		// text container
		JTextArea displayarea = new JTextArea();
		displayarea.setEditable(false);
		
		// create and add listeners to the buttons
		JButton freqButton = new JButton("Letter Frequencies");
		freqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "";
				int[] freq = calcFrequencies();
				output = "\n   Letter frequencies in " + f.getName()+": \n";
				for (int i = 0; i < freq.length; i++) 
					output += "\n      "+(char)(i+97)+": " +freq[i];
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton numWordsButton = new JButton("Number of Words in File");
		numWordsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Number of words in "+f.getName()+": " + numWords();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton numLinesButton = new JButton("Number of Lines in File");
		numLinesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Number of lines in "+f.getName()+": " + numLines();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton mostCommonLetterButton = new JButton("Most Common Letter");
		mostCommonLetterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Most common letter in "+f.getName()+": "+mostCommonLetter();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton mostCommonWordButton = new JButton("Most Common Word");
		mostCommonWordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Most common word in "+f.getName()+": "+mostCommonWord();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton tenMostCommonButton = new JButton("10 Most Common Words");
		tenMostCommonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "";
				String[] common = tenMostCommonWords();
				output += "\n   10 most common words in "+f.getName()+
						" (of at least length 5):\n";
				for (int i = 0; i < common.length; i++)
					output += "\n      "+(i+1)+". "+common[i];
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton longestSentenceButton = new JButton("Longest Sentence");
		longestSentenceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Longest sentence in "+f.getName()+":";
				output += "\n\n      "+longestSentence();
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayarea.setText("\n   Currently working in "+f.getName()+".");
			}
		});
		
		JButton percentVowelsButton = new JButton("Percent Vowels");
		percentVowelsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String output = "\n   Vowels make up "+percentVowels() +
						" of letters in "+f.getName()+".";
				displayarea.setText(displayarea.getText()+"\n"+output+"\n");
			}
		});
		
		JButton searchButton  = new JButton("Count Occurrences");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchWord = JOptionPane.showInputDialog(null,
			            "Enter a word to search for", null);
				if (searchWord != null) {
					String output = "\n   " + searchWord + " appears: "+findWord(searchWord) + " times.";
					displayarea.setText(displayarea.getText()+"\n"+output+"\n");
				}
			}
		});
		
		// add a scroll bar to the text area
		JScrollPane scroll = new JScrollPane (displayarea);
		scroll.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(400,475));
		panel.add(scroll);
		
		// create three containers for the three button rows 
		JPanel innerPanel2 = new JPanel(),innerPanel3 = new JPanel(),
				innerPanel4 = new JPanel(), innerPanel5 = new JPanel();
		innerPanel2.add(freqButton);
		innerPanel2.add(numWordsButton);
		innerPanel2.add(numLinesButton);
		innerPanel3.add(mostCommonLetterButton);
		innerPanel3.add(mostCommonWordButton);
		innerPanel3.add(tenMostCommonButton);
		innerPanel4.add(percentVowelsButton);
		innerPanel4.add(longestSentenceButton);
		innerPanel4.add(clearButton);
		innerPanel5.add(searchButton);

		panel.add(innerPanel2);
		panel.add(innerPanel3);
		panel.add(innerPanel4);
		panel.add(innerPanel5);

		
		// final setup on the frame
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	
		// beginning text display
		displayarea.setText("\n   Currently working in "+f.getName()+".");
	}
	
	public static void main(String[] args) {
		new FileAnalysis();
//		System.out.println((char)94);
	}
}