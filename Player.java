
public abstract class Player {
	
	private Pokemon pokemon; //represents the pokemon the player wants to use
	private Item item; //represents the item the player wants to use
	
	//constructor with parameters that sets all the values passed in
	public Player(Pokemon pokemon, Item item) {
		this.pokemon = pokemon;
		this.item = item;
	}
	
	//abstract method run. each different player defines what the run method does
	public abstract void run();
	
	//returns the value stored in Pokemon
	public Pokemon getPokemon() {
		return pokemon;
	}
	
	//returns the value stored in Item
	public Item getItem() {
		return item;
	}
}
