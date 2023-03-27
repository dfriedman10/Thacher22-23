package arrays;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocksFiller extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50;

	// instance variables (what kind of data structure should we use?)
	
	int[] x, y;
	
	public void initializeArrays() {
		x = new int[NUMBLOCKS];
		
		for (int i = 0; i < x.length; i++) {
			
			x[i] = (int)(Math.random() * WIDTH + 0);
		}
		y = new int[NUMBLOCKS];
	}
	

	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// color the rectangles blue - you can change this
		g.setColor(Color.blue);
		
		// draw your rectangles here! 
		for (int i = 0; i < x.length; i++) {
			
			g.fillRect(x[i], y[i], 20, 20);
		}
	}
	
	public void moveblocks() {
		
		
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocksFiller() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocksFiller();
	}

}