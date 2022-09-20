package lists;
import java.awt.Color;

public class Block {
	private int x, y;
	private Color c;
	private int speed;
	
	public Block(int x, int y, int speed, Color c) {
		this.x = x; this.y = y; this.speed = speed;this.c = c;
	}
	
	public int getY() { return y;}
	public int getX() { return x;}
	public Color getColor() {return c;}
	
	public void move() {
		y += speed;
	}
}