package objects;
import java.awt.Color;

public class BouncingBall extends Ball {
	
	public BouncingBall(int startx, int starty, int startrad, 
			int startxspeed, int startyspeed, Color startcolor) {
		
		super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}

	
	public void move() {
		
		super.move();
		
		if (getX() < 0 || getX() > WIDTH-getRad()) {
			setXSpeed(-getXSpeed());
		}
		if (getY() < 0 || getY() > HEIGHT-getRad()) {
			setYSpeed(-getYSpeed());
		}
		
		
	}
	
	
	
}
	

