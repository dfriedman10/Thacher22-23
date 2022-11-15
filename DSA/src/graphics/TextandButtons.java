package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextandButtons {
	
	final int WIDTH = 600, HEIGHT = 600, BUTTONHEIGHT = 50;

	public void startGraphics() {
		
		JFrame frame = new JFrame("Graphics Example");
		
		frame.setSize(WIDTH, HEIGHT);
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		JTextArea textBox = new JTextArea();
		
		textBox.setSize(new Dimension(WIDTH, HEIGHT - BUTTONHEIGHT));
		
		textBox.setText("Welcome to ____");
		
		textBox.setEditable(false);
		
		JPanel container = new JPanel();
		
		JButton button = new JButton("Say Hi");
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				textBox.setText(textBox.getText() + "\nHI");
				
			}
			
		});
		
		JButton button2 = new JButton("button 2");
		
		JPanel buttonContainer = new JPanel();
		
		
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(textBox);
		buttonContainer.add(button);
		buttonContainer.add(button2);
		container.add(buttonContainer);
		
		frame.add(container);
		
		frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		new TextandButtons().startGraphics();
		
		
		try {
			BufferedReader in = new 
					BufferedReader(new FileReader("text.txt"));
			
			String text = "";
			
			for (String line = in.readLine(); in != null;
					line = in.readLine()) {
				
				text += line + "\n";
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
