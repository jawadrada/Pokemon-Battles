
public class Attack {

	private String attackDescription; //represents a description of the attack
	private int powerPointsCost; //represents the cost of power points for the attack
	private String type; //represents the type for the attack
	private int baseDamage; //represents the base Damage for the attack
	
	//Constructor with parameters that assigns the member variable to values that are passed in
	public Attack(String attackDescription, int powerPointsCost, String type, int baseDamage) {
		this.attackDescription = attackDescription;
		this.powerPointsCost = powerPointsCost;
		this.type = type;
		this.baseDamage = baseDamage;
	}
	
	//returns the value stored in the attack description
	public String getAttackDescription() {
		return attackDescription;
	}

	//returns the value stored in power points
	public int getPowerPointsCost() {
		return powerPointsCost;
	}

	//returns the value stored in base damage
	public int getBaseDamage() {
		return baseDamage;
	}

	//returns the value stored in type 
	public String getType() {
		return type;
	}
	
	//sets the value for base damage by the value passed in
	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
}
