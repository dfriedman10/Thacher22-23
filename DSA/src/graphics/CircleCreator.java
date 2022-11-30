package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleCreator {
	
	final int WIDTH = 600, HEIGHT = 600, BUTTONHEIGHT = 50;
	
	ArrayList<Point> circles = new ArrayList<Point>();
	ArrayList<Color> colors = new ArrayList<Color>();
	
	public void draw(Graphics g) {
		
		for (int i = 0; i < circles.size(); i++) {
			g.setColor(colors.get(i));
			g.fillOval(circles.get(i).x, circles.get(i).y, 25, 25);
		}
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
				
				circles.add(new Point(e.getX(), e.getY()));
				colors.add(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
				
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
		
		JButton button = new JButton("Clear");
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				circles.clear();
				colors.clear();
				
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
		new CircleCreator().startGraphics();
	}
	
	
	
}
