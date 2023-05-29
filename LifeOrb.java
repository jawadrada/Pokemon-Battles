//life orb class implements the item class
public class LifeOrb implements Item{
	
	@Override
	public void use(Pokemon p) {
		//The specified pokemon can use the life orb power up
		//defines the use method that was in the item interface
		Attack attack = p.getAttacks().get(0);
		int hitPoints = p.getHitPoints();
		int baseDamage = attack.getBaseDamage() + 25;
		
		System.out.println(p.getName() + " is using the Life orb power up\n" + "Damage dealt: 10\n");
		
		//updates the pokemon's health by -10 and adds +25 to the pokemons base damage
		attack.setBaseDamage(baseDamage);
		p.setHitPoints(hitPoints - 10);
	}

}
