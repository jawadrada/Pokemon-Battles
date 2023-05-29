import java.util.ArrayList;

//Charizard class extends the Pokemon class
public class Charizard extends Pokemon{

	//Constructor with parameters that gives access to the methods in the Pokemon class
	//assigns the member variable to values that are passed in from main
	Charizard(int hitPoints, int powerPoints, String name, String type, ArrayList<Attack> attacks){
		super(hitPoints,powerPoints,name,type,attacks);
	}
	
	@Override
	public void attack(Pokemon other, int attackIndex) {
		//calculates the random number based on the arrayList size
		//picks a random attack to use
		attackIndex = (int) (Math.random() * super.getAttacks().size());
		//assigns attack to the specified attack index
		Attack attack = super.getAttacks().get(attackIndex);
		
		int powerPoints = super.getPowerPoints();
		int hp = other.getHitPoints();
		//updates the damage for the attack based on whether or not the attack is good against the enemy's pokemon's type
		int damage = super.changeDamage(attack, other);
		
		//the attack will only be executed if the player has enough power points
		if(super.getPowerPoints() > 0) {
			System.out.println(super.getName() + " is attacking");
			speak();
			System.out.println(attack.getAttackDescription() + " Attack");
			System.out.println("Damage dealt: " + damage + "\n");
			
			//updates the enemy's hit points and checks to see if it is still alive
			hp = hp - damage;
			other.setHitPoints(hp);
			super.hpCheck(other);
		}
		
		else {
			System.out.println("You have run out of power points you can no longer attack\n");
		}
		
		//subtracts the power points used
		powerPoints = powerPoints - attack.getPowerPointsCost();
		super.setPowerPoints(powerPoints);
	}

	@Override
	//defines the speak method by printing the pokemon's message to the console
	public void speak() {
		System.out.println("Roarrrr!!");
	}

}
