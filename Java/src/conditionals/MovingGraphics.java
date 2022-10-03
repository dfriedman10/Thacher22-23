package conditionals;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovingGraphics {
	
	int x1 = 0, y1 = 300, speedx1 = 7, speedy1 = 5;
	int x2 = 300, y2 = 0, speedx2 = 8, speedy2 = 3;
	
	public void draw(Graphics g) {
		
		g.setColor( new Color(0, 0, 255)   );
		g.fillRect(0, 0, 600, 600);

		
		g.setColor( new Color(255, 0, 0)   );
		
//		g.fillPolygon(new int[] {100, 300, 300}, new int[] {100, 200, 300}, 3);
		
		g.fillRect(x1, y1, 50, 50);
		
		g.fillRect(x2, y2, 50, 50);
	}
	
	public void move() {
		
		x1 += speedx1;
		
		if (x1 >= 600) {
			
			x1 = 0;
		}
		
		x2 += speedx2;
		y2 += speedy2;
		
		if (y2 >= 550 || y2 <= 0) {
			speedy2 = -speedy2;
		}
		if (x2 >= 550 || x2 <= 0) {
			speedx2 = -speedx2;
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
				Thread.sleep(35);
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
