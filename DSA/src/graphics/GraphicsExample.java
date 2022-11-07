package graphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsExample {
	
	final int WIDTH = 600, HEIGHT = 600;
	
	public void draw(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect(100, 100, 50, 50);
		
	}

	public void startGraphics() {
		
		JFrame frame = new JFrame("Graphics Example");
		
		frame.setSize(WIDTH, HEIGHT);
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		JPanel canvas = new JPanel() {
			
			public void paint(Graphics g) {
				
				draw(g);
			}
		};
		
		frame.add(canvas);
		
		frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		new GraphicsExample().startGraphics();
	}
	
	
	
}
