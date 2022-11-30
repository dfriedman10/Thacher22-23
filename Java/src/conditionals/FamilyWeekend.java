package conditionals;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FamilyWeekend {
	
	public void draw(Graphics g) {
		
		g.setColor( new Color(255, 0, 0)   );
		
		nCircles(g, 75);
//		growingCircles(g);
	}
	
	public void nCircles(Graphics g, int n) {
		int x = 0, y = 100;
		for (int count = 0; count < n; count++) {
			g.fillOval(x, y, 50, 50);
			x += 50;
			
			if (x >= 600) {
				y += 50;
				x = 0;
			}
		}
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

		FamilyWeekend test = new FamilyWeekend();
		test.startGraphics();
		
	}
}
