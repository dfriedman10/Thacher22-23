package arrays;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocks extends JPanel {
	
	private int WIDTH = 1200, HEIGHT = 800, NUMBLOCKS = 100;

	// instance variables (what kind of data structure should we use?)
	int[] x = new int[NUMBLOCKS],y = new int[NUMBLOCKS];
	int[] speeds = new int[NUMBLOCKS];
	Color[] colors = new Color[NUMBLOCKS];
	
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		for (int i = 0; i < x.length; i++) {
			x[i] = (int)(Math.random()*WIDTH);
			y[i] = (int)(Math.random()*HEIGHT);
			speeds[i] = (int)(Math.random()*8+2);
			colors[i] = new Color((int)(Math.random()*255),
					(int)(Math.random()*255),(int)(Math.random()*255));
		}
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {
		for (int i = 0; i < x.length; i++) {
			y[i] += speeds[i];
			if (y[i] >= HEIGHT) {
				y[i] = -50;
				x[i] = (int)(Math.random()*WIDTH);
			}
		}
	}
	
	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw your rectangles here! 
		for (int i = 0; i < x.length; i++) {
			g.setColor(colors[i]);
			g.fillRect(x[i], y[i], 20, 20);
		}
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocks() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

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
		new FallingBlocks();
	}

}