package pokemonChoices;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Move {

	String name;
	int type, damage, effect;
	Image img;
	
	public Move(String name, int type, int damage, int effect, String imgName) {
		this.name = name; 
		this.type = type;
		this.damage = damage;
		this.effect = effect;
		img = new ImageIcon(getClass().getClassLoader().getResource("resources/"+imgName)).getImage();

	}
	
}
