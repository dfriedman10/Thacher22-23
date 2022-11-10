package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GraphicsExample {
	
	final int WIDTH = 600, HEIGHT = 600, BUTTONHEIGHT = 50;
	
	int squareX = 100, squareY = 100;
	
	boolean drawTriangle = false;
	
	public void draw(Graphics g) {
		
		g.setColor(new Color(100, 50, 25));
		g.fillRect(squareX, squareY, 50, 50);
		
		if (drawTriangle)
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
		
		canvas.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				squareX = e.getX();
				squareY = e.getY();
				
				frame.getContentPane().repaint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		JPanel container = new JPanel();
		
		JButton button = new JButton("Draw Triangle");
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				drawTriangle = !drawTriangle;
				
				frame.getContentPane().repaint();
			}
			
		});
		
		
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
