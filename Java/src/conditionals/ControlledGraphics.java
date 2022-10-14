package conditionals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlledGraphics {
	
	int x = 300, y = 300, xVel = 0, yVel = 0;
	
	int screenWidth = 900, screenHeight = 600; 
	
	int boxSize = 50;
	
	public void draw(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, screenWidth, screenHeight);
		
		g.setColor( new Color(255, 0, 0)   );
		
		g.fillRect(x, y, boxSize, boxSize);
		
	}
	
	public void move() {

		x += xVel;
		y += yVel; 
		
	}
	

	public void startGraphics() {
		
		JFrame window = new JFrame("Graphics 1.0");
		
		window.setSize(screenWidth, screenHeight);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel canvas = new JPanel() {
			
			public void paint(Graphics g) {
				
				draw(g);
			}
		};
		
		window.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyChar() == 'w') { 
					yVel = -5;
				}
				if (e.getKeyChar() == 's') { 
					yVel = 5;
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) { 
					xVel = -5;
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { 
					xVel = 5;
				}	
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyChar() == 'w') { 
					yVel = 0;
				}
				if (e.getKeyChar() == 's') { 
					yVel = 0;
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) { 
					xVel = 0;
				}
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) { 
					xVel = 0;
				}
				
			}
			
		});
		
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

		ControlledGraphics test = new ControlledGraphics();
		test.startGraphics();
		
	}
}
