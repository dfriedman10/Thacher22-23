package conditionals;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MovingGraphics {
	
	int x = 0, y = 300;
	
	public void draw(Graphics g) {
		
		g.setColor( new Color(255, 0, 0)   );
		
//		g.fillPolygon(new int[] {100, 300, 300}, new int[] {100, 200, 300}, 3);
		
		g.fillRect(x, y, 50, 50);
	}
	
	public void move() {
		
		x += 8;
	}
	

	public void startGraphics() {
		
		JFrame window = new JFrame("Graphics 1.0");
		
		window.setSize(600, 600);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		window.setBackground(Color.blue);
		
		
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
