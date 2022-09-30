package conditionals;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsAnimation {
	
	public void draw(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect(100, 100, 50, 50);
		
		
	}
	

	public void startGraphics() {
		
		JFrame window = new JFrame("Graphics 1.0");
		
		window.setSize(600, 600);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel canvas = new JPanel() {
			
			public void paint(Graphics g) {
				
				draw(g);
			}
		};
		
		window.add(canvas);
		window.setVisible(true);
	}

	public static void main(String[] args) {

		GraphicsAnimation test = new GraphicsAnimation();
		test.startGraphics();
		
	}
}
