package conditionals;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovingGraphics {
	
	int x = 0, y = 300, xVel = 5, yVel = 7;
	
	public void draw(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 600, 600);
		
		g.setColor( new Color(255, 0, 0)   );
		
		g.fillRect(x, y, 50, 50);
		
	}
	
	public void move() {
		x += xVel;
		
		if (x >= 550 || x <= 0) {
			xVel = -xVel;
		}
		
		y += yVel;
		
		if (y >= 550 || y <= 0) {
			yVel = -yVel;
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
		
		while (true) {
			
			move();
			canvas.repaint();
			
			try {
				Thread.sleep(33);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
	}

	public static void main(String[] args) {

		MovingGraphics test = new MovingGraphics();
		test.startGraphics();
		
	}
}
