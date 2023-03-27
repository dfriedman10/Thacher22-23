package winterExam; 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BrickBreaker_YourName {
	
	// screen dimensions
	final int WIDTH = 500, HEIGHT = 700; 
	
	// constants for the bricks & ball
	final int NUMBRICKS = 20, BRICKWIDTH = 100, BRICKHEIGHT = 40, PADDLESPEED = 5, 
			BALL_DIAM = 15, PADDLEWIDTH = BRICKWIDTH, PADDLEHEIGHT = BRICKHEIGHT/2; 
	
	// arrays to represent locations/colors/status of the bricks
	int[] brickx = new int[NUMBRICKS], bricky = new int[NUMBRICKS];
	boolean[] hit = new boolean[NUMBRICKS];
	Color[] brickColors = new Color[NUMBRICKS];
	
	// coordinates of the paddle
	int paddlex = WIDTH/2 - BRICKWIDTH/2, paddley = HEIGHT - 2*BRICKHEIGHT, paddleSpeedx = 0;
	
	// coordinates of the ball
	int ballx = WIDTH/2, bally = HEIGHT/2;
	
	// generates a random speed between 3 and 6 for both ball speeds
	double ballSpeedx = (Math.random()*3+3) * (Math.random() > .5 ? -1:1), ballSpeedy = Math.random()*3+3;
	
	// status tracker for the game
	boolean gameOver = false;
	
	// score
	int score = 0;
	
	// checks to see if any bricks have been hit. If a brick is hit, it should disappear, 
	// the score should increase, and the ball should speed up slightly.
	// if this is the final brick, end the game.
	public void brickHit() {
		
		// your code here
	}
	
	// resets the game
	public void reset() {
		
		// your code here
	}
	
	// bounces the ball off the left/right/top walls. 
	// ends the game if the ball reaches the bottom of the screen. 
	public void wallBounce() {

		// your code here
	}
	
	// draws the bricks, ball, and paddle
	public void draw(Graphics g) {
		
		// white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		

		// your code here
	}
	
// ******* MY METHODS - FEEL FREE TO EXPLORE BUT DON'T CHANGE ********
	
	// moves the ball and paddle
	public void move() {
		paddlex += paddleSpeedx;
		ballx += ballSpeedx;
		bally += ballSpeedy;
	}
	
	// fills in the x/y/color values of the brick array, creating a 
	// grid of bricks at the top of the window
	public void setup() {
		int x = 0, y = 0;
		for (int i = 0; i < brickx.length; i++) {
			brickx[i] = x; bricky[i] = y;
			brickColors[i] = new Color((int)(Math.random()*255),
					(int)(Math.random()*255),(int)(Math.random()*255));
			x += BRICKWIDTH;
			if (x >= WIDTH) {
				y += BRICKHEIGHT;
				x=0;
			}
		}
	}
	
	// bounces the ball off the paddle
	public void paddleBounce() {
		if (ballx >= paddlex && ballx <= paddlex + BRICKWIDTH 
				&& bally+BALL_DIAM >= paddley && bally <= paddley + BRICKHEIGHT/4) {
			ballSpeedy = - ballSpeedy;
		}
	}
	
	// runs game initialization. 
	public BrickBreaker_YourName() {
		setup();
		JFrame frame = new JFrame("Brick Breaker");
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new JPanel() {
			public void paint(Graphics g) {
				draw(g);
			}
		});
		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) paddleSpeedx = -PADDLESPEED;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) paddleSpeedx = PADDLESPEED;				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT) paddleSpeedx = 0;
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) paddleSpeedx = 0;			}
		});
		
		frame.setVisible(true);
		
		while (true) {
			move();
			paddleBounce();
			brickHit();
			wallBounce();
			frame.getContentPane().repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e1) {}
			if (gameOver) {
				int i = JOptionPane.showConfirmDialog(null, (score < NUMBRICKS ? 
						"Game Over. Score: " + score + ". " : "You win! ") + "Play again?",
						"", JOptionPane.YES_NO_OPTION);
				if (i == 0) {
					reset();
				}
				else {
					System.exit(0);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new BrickBreaker_YourName();
	}
}
