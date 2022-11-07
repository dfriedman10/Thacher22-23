package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsExample {
	
	final int WIDTH = 600, HEIGHT = 600, BUTTONHEIGHT = 50;
	
	public void draw(Graphics g) {
		
		g.setColor(new Color(100, 50, 25));
		g.fillRect(100, 100, 50, 50);
		
		g.fillPolygon(new int[] {400, 200, 300}, 
				new int[] {100, 100, 200}, 3);
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
		
		canvas.setSize(new Dimension(WIDTH, HEIGHT - BUTTONHEIGHT));
		
		JPanel container = new JPanel();
		
		JButton button = new JButton("Draw Circle");
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(canvas);
		container.add(button);
		
		frame.add(container);
		
		frame.setVisible(true);

	}
	
	public static void main(String[] args) {
		new GraphicsExample().startGraphics();
	}
	
	
	
}
