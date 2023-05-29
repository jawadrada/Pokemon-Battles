//berry juice class implements the item class
public class BerryJuice implements Item {
	
	@Override
	//The specified pokemon can use the berry juice power up
	//defines the use method that was in the item interface
	public void use(Pokemon p) {
		//updates the pokemon's health by 20
		int hitPoints = p.getHitPoints();
		System.out.println(p.getName() + " is using the berry Juice power up\n");
		p.setHitPoints(hitPoints + 30);
	}
}
