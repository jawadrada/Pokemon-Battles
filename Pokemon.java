import java.util.ArrayList;

public abstract class Pokemon {
	
	private int hitPoints; //represents the Pokemon's health
	private int powerPoints; //represents the amount of points the Pokemon has available for attacking
	private String name; //represents the name of the pokemon
	private String type; //represents the type of the pokemon
	private ArrayList<Attack> attacks = new ArrayList<Attack>(); //an Array list holding attack objects that contain the attack and all the information on it
	
	//Constructor with parameters that sets all the values passed in
	public Pokemon(int hitpoints, int powerPoints, String name, String type, ArrayList<Attack> attacks) {
		this.hitPoints = hitpoints;
		this.powerPoints = powerPoints;
		this.name = name;
		this.type = type;
		this.attacks = attacks;
	}
	
	//a attack abstract method. It attacks the other pokemon based upon the specified attack index different for all pokemon
	//a speak abstract method. It prints out the pokemon speaking different for all pokemon
	public abstract void attack(Pokemon other, int attackIndex);
	public abstract void speak();
	
	//returns the value stored in hit points
	public int getHitPoints() {
		return hitPoints;
	}
	
	//sets the hit points to the value passed in
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	//returns the value stored in power points
	public int getPowerPoints() {
		return powerPoints;
	}
	
	//sets the power points to the value passed in
	public void setPowerPoints(int powerPoints) {
		this.powerPoints = powerPoints;
	}
	
	//returns the value stored in name
	public String getName() {
		return name;
	}
	
	//sets the name to the value passed in
	public void setName(String name) {
		this.name = name;
	}
	
	//returns the value stored in the type
	public String getType() {
		return type;
	}
	
	//sets the type to the value passed in
	public void setType(String type) {
		this.type = type;
	}

	//returns the value stored in the getAttacks arrayList 
	public ArrayList<Attack> getAttacks() {
		return attacks;
	}
	
	//checks to see if the enemy's pokemon's health is below or equal to zero returns true or false 
	public Boolean hpBool(Pokemon other) {
		if(other.getHitPoints() <= 0) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	//checks to see if the enemy's pokemon's health is below or equal to zero
	//if the case is met a message is outputted to the console and the program is ended
	public void hpCheck(Pokemon other) {
		if(other.getHitPoints() <= 0) {
			System.out.println(other.getName() + " has been defeated :(");
			System.exit(0);
		}
	}
	
	//checks to see if the type of the attack is strong against the enemy's type returns true or false
	public boolean isStrong(String attackType, String pokemonType) {
		
		if(attackType.equals("bug")){
			return pokemonType.equals("fire") || pokemonType.equals("flying") || pokemonType.equals("poison") || pokemonType.equals("rock");
		}
		
		else if (attackType.equals("dragon")) {
	        return pokemonType.equals("ice");
		} 
		
		else if (attackType.equals("electric")) {
	        return pokemonType.equals("ground");
		} 
		
		else if (attackType.equals("fighting")) {
	        return pokemonType.equals("flying") || pokemonType.equals("psychic");
		} 
		
		else if (attackType.equals("fire")) {
		        return pokemonType.equals("ground") || pokemonType.equals("rock") || pokemonType.equals("water");
		} 
		
		else if (attackType.equals("flying")) {
	        return pokemonType.equals("electric") || pokemonType.equals("ice") || pokemonType.equals("rock");
		} 
		
		 else if (attackType.equals("grass")) {
		        return pokemonType.equals("bug") || pokemonType.equals("fire") || pokemonType.equals("flying") || pokemonType.equals("ice") || pokemonType.equals("poison");
		} 
		
		else if (attackType.equals("ground")) {
	        return pokemonType.equals("grass") || pokemonType.equals("ice") || pokemonType.equals("water");
		} 
		
		else if (attackType.equals("ice")) {
	        return pokemonType.equals("fighting") || pokemonType.equals("fire") || pokemonType.equals("rock");
		} 
		
		else if (attackType.equals("normal")) {
	        return pokemonType.equals("fighting");
		} 
		
		else if (attackType.equals("poison")) {
	        return pokemonType.equals("bug") || pokemonType.equals("ground") || pokemonType.equals("psychic");
		} 
		
		else if (attackType.equals("psychic")) {
	        return pokemonType.equals("bug");
		} 
		 
		else if (attackType.equals("rock")) {
	        return pokemonType.equals("fighting") || pokemonType.equals("grass") || pokemonType.equals("ground") || pokemonType.equals("water");
		} 
		 
		 else if (attackType.equals("water")) {
		        return pokemonType.equals("electric") || pokemonType.equals("grass");
		 } 
		
		 else {
		        return false;
		 }
	}

	//checks to see if the type of the attack is weak against the enemy's type returns true or false
	public boolean isWeak(String attackType, String pokemonType) {
		
		if(attackType.equals("bug")){
			return pokemonType.equals("grass");
		}
		
		else if (attackType.equals("electric")) {
	        return pokemonType.equals("electric");
		} 
		
		else if (attackType.equals("fighting")) {
	        return pokemonType.equals("rock");
		} 
		
		else if (attackType.equals("fire")) {
		        return pokemonType.equals("bug") || pokemonType.equals("grass");
		} 
		
		else if (attackType.equals("flying")) {
	        return pokemonType.equals("bug") || pokemonType.equals("fighting") || pokemonType.equals("grass");
		} 
		
		 else if (attackType.equals("grass")) {
		        return pokemonType.equals("electric") || pokemonType.equals("grass") || pokemonType.equals("ground") || pokemonType.equals("water");
		} 
		
		else if (attackType.equals("ground")) {
	        return pokemonType.equals("poison");
		} 
		
		else if (attackType.equals("ice")) {
	        return pokemonType.equals("ice") || pokemonType.equals("water");
		} 
		
		else if (attackType.equals("poison")) {
	        return pokemonType.equals("grass") || pokemonType.equals("poison");
		} 
		
		else if (attackType.equals("psychic")) {
	        return pokemonType.equals("fighting") || pokemonType.equals("psychic");
		} 
		 
		else if (attackType.equals("rock")) {
	        return pokemonType.equals("bug") || pokemonType.equals("fire") || pokemonType.equals("flying") || pokemonType.equals("psychic") || pokemonType.equals("rock");
		} 
		 
		 else if (attackType.equals("water")) {
		        return pokemonType.equals("fire") || pokemonType.equals("ice");
		} 
		
		 else {
		        return false;
		}
	}
	
	//checks to see if the type of the attack has no effect against the enemy's type returns true or false
	public Boolean noEffect(String attackType, String pokemonType) {
	
		if (attackType.equals("flying")) {
	        return pokemonType.equals("ground");
		} 
		
		else if (attackType.equals("ghost")) {
		        return pokemonType.equals("fighting") || pokemonType.equals("normal");
		} 
		
		else if (attackType.equals("ground")) {
	        return pokemonType.equals("electric");
		} 
		
		else if (attackType.equals("normal")) {
	        return pokemonType.equals("ghost");
		} 
		
		else if (attackType.equals("psychic")) {
	        return pokemonType.equals("ghost");
		} 
		
		 else {
		        return false;
		 }
	}
	
	//
	public int changeDamage(Attack attack, Pokemon other) {
		int superEffective;
		int notVeryEffective; 
		 
		//if the attack type is strong against the enemy's type then
		//the base damage is multiplied by 2
		 if (isStrong(attack.getType(), other.getType()) == true) {
			 	superEffective = attack.getBaseDamage() * 2;
			 	return superEffective;
		    } 
		//if the attack type is weak against the enemy's type then
		//the base damage is divided by 2
		 else if (isWeak(attack.getType(), other.getType()) == true) {
			 	notVeryEffective = attack.getBaseDamage() / 2;
			 	return notVeryEffective;
		    } 
		//if the attack type has no effect against the enemy's type then
		//the base damage is set to 0
		 else if(noEffect(attack.getType(), other.getType()) == true) {
			 	return 0;
		    }	
		//if the attack type is not strong weak or has no effect against the enemy's type then
		//the base damage stays as is
		 else {
			 return attack.getBaseDamage();
		 }
	}
}