package conditionals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlledMovement {
	
	int x = 300, y = 300, xVel = 0, yVel = 0;
	
	public void draw(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(x, y, 50, 50);
		
	}
	
	public void move() {

		x += xVel;
		y += yVel;
		
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
		
		window.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					xVel = 5;
				}
				else if (e.getKeyChar() == 's'){
					xVel = -5;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
				xVel = 0;
				
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

		ControlledMovement test = new ControlledMovement();
		test.startGraphics();
		
	}
}
