//computer player class extends the player class
public class ComputerPlayer extends Player {
	
	//Constructor with parameters that gives access to the methods in the Player class
	//assigns the member variable to values that are passed in from main
	public ComputerPlayer(Pokemon pokemon, Item item) {
		super(pokemon, item);
	}

	@Override
	//defines the run method by printing the pokemon is running away to the console
	public void run() {
		System.out.println(super.getPokemon().getName() + " is running away from the battle!!");
		System.exit(0);
	}
}
