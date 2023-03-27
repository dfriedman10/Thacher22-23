package pokemonChoices;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import pokemon.PokeBattleRunner;

public class PokemonBattler {

	public Image background, pokeballImg;
	public static int WIDTH = 950, HEIGHT = WIDTH*700/1280;
	public static int POKEWIDTH, POKEHEIGHT;
	public static int HEALTHWIDTH, HEALTHHEIGHT;
	public static int ATTACKWIDTH, ATTACKHEIGHT;
	public static final int POISONDAMAGE = 7, CONFUSEDAMAGE = 15;
	public static int[] POKEX, POKEY;
	public Pokemon[] pokes = new Pokemon[2];
	private int turn = (int)(Math.random()*2);
	public JPanel canvas;
	public JTextArea text;
	private Move currAttack = null;
	private int attackX, attackY;
	
	public static final Status[] stati = {null, new Status("asleep", "put to sleep", "ASP", Color.GRAY), new Status("poisoned", "poisoned", "PSN", new Color(200,0,250)), 
			new Status("confused", "confused", "CNF", Color.red)};

	public static final String[] types = {"normal","fire","water","grass"};
	public static final double[][] effectiveness = {{1,1,1,1},{1,.5,.5,2},{1,2,.5,.5},{1,.5,2,.5}};
	public static final Image[] attackImgs = new Image[types.length];
	
	public PokemonBattler() {		
		
		loadPokemon();
		initGraphics();
		battle();
	}
	
	public void battle() {

		text.setText(pokes[0].getName() +" vs "+ pokes[1].getName());
		rest(1);
		while (pokes[0].getHealth()>0 && pokes[1].getHealth()>0) {
			
			displayTurn();
			if (displayStatus())
				runAttack();
			
			turn = (turn+1)%2;
		}
		
		int fainted = pokes[0].getHealth()==0 ? 0:1;
		text.setText(pokes[fainted].getName() +" fainted.");
		canvas.repaint();
	}
	
	public void displayTurn() {
		text.setText(pokes[turn].getName()+"'s turn!");
		canvas.repaint();
		rest(1);
	}
	
	public void drawBattle(Graphics g) { 
		for (int i=0; i<pokes.length; i++) pokes[i].draw(g,i==1);
		
		if (currAttack != null) {
			g.drawImage(currAttack.img,attackX, attackY, ATTACKWIDTH,ATTACKHEIGHT,null);
		}
	}
	
	public void animateAttack() {
		attackX = POKEX[turn]+POKEWIDTH/2;
		attackY = POKEY[turn]+POKEHEIGHT/4;
		while (turn==0 ? attackX < POKEX[1] : attackX > POKEX[0]+POKEWIDTH/2) {
			attackX += (POKEX[turn]-POKEX[(turn+1)%2]+(turn==0?-1:1)*POKEWIDTH/2)/-20;
			attackY += (POKEY[turn]-POKEY[(turn+1)%2])/-20;
			canvas.repaint();
			rest(.05);
		}
		currAttack = null;
	}
	
	public void runAttack() {
		currAttack = pokes[turn].attack(pokes[(turn+1)%2]);
		
		text.setText(pokes[turn].getName() + " used " + currAttack.name+".\n");
		animateAttack();
		
		String output = "";
		double multiplier = effectiveness[currAttack.type][pokes[(turn+1)%2].getType()];
		
		if (multiplier == .5)
			output += "Not very effective...\n";
		else if (multiplier == 2)
			output += "super effective!\n";
		
		pokes[(turn+1)%2].reduceHealth((int)(currAttack.damage*multiplier));
		
		if (currAttack.effect != 0) {
			pokes[(turn+1)%2].setStatus(currAttack.effect);
			output += pokes[(turn+1)%2].getName() + " was " +stati[currAttack.type].message;
		}
	
		text.setText(text.getText()+output);

		canvas.repaint();
		rest(1);
	}
	
	public boolean displayStatus() {
		int status = pokes[turn].getStatus();
		String currName = pokes[turn].getName();
		boolean canMove = true;
		if (status != 0) {
			
			text.setText(pokes[turn].getName() + " is " + stati[pokes[turn].getStatus()]);
			
			canvas.repaint();
			rest(1);
			
			String output = "";
			if (status == 1) {
				if (Math.random() < .33) {
					output += currName +" woke up!\n";
					status = 0;
				}else {
					canMove = false;
					output += currName +" is asleep.\n";
				}
			}
			else if (status == 2) {
				output += name +" is hurt by poison.\n";
				takeDamage(PokeBattleRunner.POISONDAMAGE);
				if (health == 0) {
					canMove = false;
					return output;
				}
			}
			else if (status == 3) {
				if (Math.random() < .25) {
					output += name +" snapped out of confusion!\n";
					status = 0;
				}
				output += name +" is confused.\n";
				if (Math.random() < .5) {
					output += name + " hurt itself in its confusion.\n";
					takeDamage(PokeBattleRunner.CONFUSEDAMAGE);
					canMove = false;
					return output;
				}
			}
			else if (status == 4) {
				if (Math.random() < .3) {
					canMove = false;
					return name + " is paralyzed!\n";
				}
			}
		}
		return true;
	}
	
	public void rest(double time) {
		try {
			Thread.sleep((int)(time*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void loadPokemon() {
		try {
			String p1 = "pokemonChoices."+JOptionPane.showInputDialog("Enter the first Pokemon Name");
			String p2 = "pokemonChoices."+JOptionPane.showInputDialog("Enter the second Pokemon Name");
			Class cls = Class.forName(p1);
			pokes[0] = (Pokemon) cls.getDeclaredConstructor().newInstance();
			cls = Class.forName(p2);
			pokes[1] = (Pokemon) cls.getDeclaredConstructor().newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("Pokemon does not exist..");
			System.exit(1);
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("serial")
	public void initGraphics() {
		text = new JTextArea();
		text.setEditable(false);
		text.setText("hello everyone");
		updateSizes();
		background = new ImageIcon(getClass().getClassLoader().getResource("resources/pokeBG.png")).getImage();
		pokeballImg = new ImageIcon(getClass().getClassLoader().getResource("resources/pokeball.png")).getImage();
		JFrame frame = new JFrame("Pokemon Battle");
		frame.setSize(WIDTH, HEIGHT);
		
		canvas = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, PokemonBattler.WIDTH, PokemonBattler.HEIGHT, null);
				super.paintComponents(g);
				drawBattle(g);
			}
		};
		canvas.setLayout(null);
		canvas.add(text);
		frame.add(canvas);
		canvas.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {
				WIDTH = canvas.getWidth();
				HEIGHT = canvas.getHeight();
				updateSizes();
				canvas.repaint();
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setVisible(true);
	}
	
	public void updateSizes() {
		POKEWIDTH = WIDTH*4/15;
		POKEHEIGHT = HEIGHT*10/24;
		HEALTHWIDTH = WIDTH/5;
		HEALTHHEIGHT = HEIGHT/45;
		ATTACKWIDTH = POKEWIDTH/4;
		ATTACKHEIGHT = POKEHEIGHT/4;
		POKEX = new int[]{WIDTH/10,WIDTH*6/10}; POKEY = new int[]{HEIGHT*8/24,HEIGHT*3/40};
		text.setFont(new Font("Courier",Font.PLAIN, PokemonBattler.HEIGHT/20));
		text.setBounds(WIDTH/20,HEIGHT*78/100,WIDTH*17/20,HEIGHT/5);
	}
	
	static class Status {
		String condition, message, label;
		Color color;
		
		public Status(String condition, String message, String label, Color color) {
			this.condition = condition;
			this.message = message;
			this.label = label;
			this.color = color;
		}
	}
	
	public static void main(String[] args) {
		new PokemonBattler();
	}
}
