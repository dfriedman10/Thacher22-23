package pokemonChoices;

public class TestPoke extends Pokemon{

	public TestPoke() {
		super("Test Poke", 1, 100, "grass.png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Move attack(Pokemon opponent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Move[] generateMoveset() {
		Move[] moves = new Move[2];
		moves[0] = new Move("fire punch", 1, 25, 0, "fire.png");
		moves[1] = new Move("water punch", 2, 25, 2, "water.png");
		return moves;
	}

}
