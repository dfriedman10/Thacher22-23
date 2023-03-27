package pokemonChoices;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public abstract class Pokemon {

	private int type, health;
	private int maxHealth, status = 0;
	private String name;
	private Move[] moves;
	private Image img;
	
	public Pokemon(String name, int type, int health, String imgName) {
		this.name = name;
		this.type = type; 
		this.health = health;
		this.maxHealth = health;
		this.moves = generateMoveset();
		img = new ImageIcon(getClass().getClassLoader().getResource("resources/"+imgName)).getImage();

	}
	
	public String getName() {
		return name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getHealth() {
		return health;
	}
	public void reduceHealth(int damage) {
		health = Math.max(0, health - damage);
	}
	public int getType() {
		return type;
	}
	
	public abstract Move attack(Pokemon opponent);
	
	// returns this pokemon's set of moves. will only be called in the constructor
	public abstract Move[] generateMoveset();
	
	public void draw(Graphics g, boolean top) {
		if (!top) {
			if (health > 0)
				g.drawImage(img, PokemonBattler.POKEX[0], PokemonBattler.POKEY[0], PokemonBattler.POKEWIDTH, PokemonBattler.POKEHEIGHT, null);
			if (health/maxHealth >= .5)
				g.setColor(Color.GREEN);
			else if (health/maxHealth >= .25)
				g.setColor(Color.orange);
			else
				g.setColor(Color.red);
			g.fillRect((int)(PokemonBattler.WIDTH/1.3), (int)(PokemonBattler.HEIGHT/1.64), (int)(PokemonBattler.HEALTHWIDTH*(health/maxHealth)), PokemonBattler.HEALTHHEIGHT);
			g.setColor(Color.black);
			g.setFont(new Font("Courier",Font.PLAIN, PokemonBattler.HEIGHT/20));
			g.drawImage(PokemonBattler.attackImgs[type],PokemonBattler.WIDTH*35/60,PokemonBattler.HEIGHT*22/40, PokemonBattler.WIDTH/30, PokemonBattler.HEIGHT/30, null);
			g.drawString(name, (int)(PokemonBattler.WIDTH*37/60 ), (int)(PokemonBattler.HEIGHT*23/40));
			g.setColor(PokemonBattler.stati[status].color);
			g.drawString(PokemonBattler.stati[status].label, (int)(PokemonBattler.WIDTH*3/5 ), (int)(PokemonBattler.HEIGHT*25/40));
		}
		else {
			if (health > 0)
				g.drawImage(img, PokemonBattler.POKEX[1], PokemonBattler.POKEY[1], PokemonBattler.POKEWIDTH, PokemonBattler.POKEHEIGHT, null);
			if (health/maxHealth >= .5)
				g.setColor(Color.GREEN);
			else if (health/maxHealth >= .25)
				g.setColor(Color.orange);
			else
				g.setColor(Color.red);
			g.fillRect((int)(PokemonBattler.WIDTH/5.22), (int)(PokemonBattler.HEIGHT/4.65), (int)(PokemonBattler.HEALTHWIDTH*(health/maxHealth)), PokemonBattler.HEALTHHEIGHT);
			g.setColor(Color.black);
			g.setFont(new Font("Courier",Font.PLAIN, PokemonBattler.HEIGHT/20));
			g.drawImage(PokemonBattler.attackImgs[type],(int)(PokemonBattler.WIDTH/200 ), (int)(PokemonBattler.HEIGHT*11/80), PokemonBattler.WIDTH/30, PokemonBattler.HEIGHT/30, null);
			g.drawString(name, (int)(PokemonBattler.WIDTH/30 ), (int)(PokemonBattler.HEIGHT*7/40));
			g.setColor(PokemonBattler.stati[status].color);
			g.drawString(PokemonBattler.stati[status].label, (int)(PokemonBattler.WIDTH/35 ), (int)(PokemonBattler.HEIGHT*9/40));
		}
	}
}
