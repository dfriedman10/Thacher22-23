package objects;
import java.awt.Color;

public class ShrinkingBall extends BouncingBall{

	private int count = 0;
	
	public ShrinkingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	
	public void move() {
		if (getRad() >= 5) {
			if (count == 10) {
				setRad(getRad()-1);
				count = 0;
			}
			count ++;
		}
		super.move();
	}

}
