import java.util.ArrayList;
import java.util.Scanner;

public class PokemonRunner {
	
	//print info method that prints the pokemons name, hit points and power points to the console
	public static void printInfo(Pokemon pokeOne, Pokemon PokeTwo) {
		System.out.println(pokeOne.getName() + "		Vs		" + PokeTwo.getName());
		System.out.println("Hp: " + pokeOne.getHitPoints() + "				" + "HP: " + PokeTwo.getHitPoints());
		System.out.println("PP: " + pokeOne.getPowerPoints() + "				" + "PP: " + PokeTwo.getPowerPoints());
		System.out.println();
	}
	
	//the CPU method chooses a random choice either attack use item or run
	public static void CPU(ComputerPlayer cpu, Item item, Pokemon poke,Pokemon other) {
		int randomNum = (int) (Math.random() * other.getAttacks().size()) + 1;
		
		if(randomNum == 1) {
			other.attack(poke,randomNum);
		}
		
		else if(randomNum == 2) {
			item.use(other);
		}
		
		else {
			cpu.run();
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to my Pokemon battle's Game!!!\n");
		//creating three different attacks for Pikachu
		Attack attackOne = new Attack("ThunderBolt",15,"electric",90); 
		Attack attackTwo = new Attack("Thunder Punch",15,"electric",75); 
		Attack attackThree = new Attack("Tail Whip",30,"normal",35); 
		
		//adding the attacks to the Attack array list
		ArrayList<Attack>attackList = new ArrayList<Attack>();
		attackList.add(attackOne);
		attackList.add(attackTwo);
		attackList.add(attackThree);
		
		//creating three different attacks for Charizard
		Attack attackFour = new Attack("FlameThrower",15,"fire",90);
		Attack attackFive = new Attack("Inferno",30,"fire",100);
		Attack attackSix = new Attack("Fire Fang",15,"fire",65);
		
		//adding the attacks to the Attack array list
		ArrayList<Attack>attackListTwo = new ArrayList<Attack>();
		attackListTwo.add(attackFour);
		attackListTwo.add(attackFive);
		attackListTwo.add(attackSix);
		
		//Creating the pika pokemon with all the different information
		//Creating the charz pokemon with all the different information
		Pikachu pika = new Pikachu(150,60,"Pikachu","electric", attackList);
		Charizard charz = new Charizard(200,60,"Charizard","fire", attackListTwo);
		
		//Creating the berry Juice item for pika
		//Creating the life orb item for charz
		BerryJuice pikaItem = new BerryJuice();
		LifeOrb charzItem = new LifeOrb();
		
		//Creating the human player that controll's pika and his item
		//Creating the computer player that controll's charz and his item 
		HumanPlayer human = new HumanPlayer(pika, pikaItem);
		ComputerPlayer computer = new ComputerPlayer(charz, charzItem);
		
		//menu system that continues until either one of the pokemon dies
		while(pika.hpBool(charz) == false && charz.hpBool(pika) == false) {
			Scanner scanner = new Scanner(System.in);
			int attackIndex;
			
			printInfo(pika,charz);
			System.out.println("Select one of the three choices\n" + "1) Attack " + charz.getName() + "\n2) Use Item\n" + "3) Run away from battle\n");
			System.out.print("Enter choice: ");
			String choice = scanner.nextLine();
			System.out.println();
			
			//allows the user to pick his selection to either attack run or use item
			switch(choice) {
			case "1": 
				System.out.println("Select one of the attacks");
				int j = 1;
				for(int i = 0; i < attackList.size(); i++) {
					System.out.println((j + i) + ") " + attackList.get(i).getAttackDescription());
				}
				
				System.out.print("\nEnter choice: ");
				String choice2 = scanner.nextLine();
				System.out.println();
				
				attackIndex = Integer.parseInt(choice2);
				pika.attack(charz, attackIndex);
				break;
				
			case "2": 
				pikaItem.use(pika);
				break;
				
			case "3": 
				human.run();
				break;
			
				default: 
					System.out.println("Please enter a valid choice");
					break;
			}
			//only executes if charz is still alive
			if(charz.getHitPoints() > 0) {
				printInfo(pika,charz);
				CPU(computer,charzItem,pika,charz);
			}
			
			//closes the program if either of the pokemon dies
			else if(pika.getHitPoints() <= 0 || charz.getHitPoints() <= 0) {
				scanner.close();
				System.exit(0);
			}
		
		}
		
	}
}
