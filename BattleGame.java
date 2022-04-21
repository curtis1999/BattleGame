package battleGame;
//Curtis Docherty
//260769767

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
public class BattleGame {
	private static Random r = new Random();

	public static void playGame(String filePlayer, String fileMonster, String fileSpells) {
		ArrayList<Spell> spells = FileIO.readSpells(fileSpells);
		if(spells == null) {
			System.out.println("THE GAME WILL BE PLAYED WITHOUT SPELLS"); 
			//Initialize the player
			Character player = FileIO.readCharacter(filePlayer);
			//initialize a Character monster
			Character monster = FileIO.readCharacter(fileMonster);



			//Display info of the player
			String playerName = player.getName();
			System.out.println("Name: " + playerName);
			double playerHealth = player.getCurrHealth();
			System.out.println("Health: " + playerHealth);
			double playerStrength = player.getAttackValue();
			System.out.println("Attack: " + playerStrength);
			int playerRecord = player.getNumWins();
			System.out.println("Number of wins: " + playerRecord);
			System.out.println(" ");

			//Display info of the monster
			String monsterName = monster.getName();
			System.out.println("Name: " + monsterName);
			double monsterHealth = monster.getCurrHealth();
			System.out.println("Health " + monsterHealth);
			double monsterStrength = monster.getAttackValue();
			System.out.println("Attack: " + monsterStrength);
			int monsterRecord = monster.getNumWins();
			System.out.println("Number of wins: " + monsterRecord);
			System.out.println();


			//Create an infinite for loop 
			for (;;) {
				//Create a scanner object
				Scanner read= new Scanner(System.in);
				//Ask for the user's command
				System.out.println("Enter a command");
				//Store the user's input into a variable
				String decision = read.nextLine();
				if (decision.equalsIgnoreCase("attack")) {
					//Create a double representing the attack done by the player using a random r to create a random integer to use as a seed
					Random attackDammage = r;
					int seed = attackDammage.nextInt();
					double strike = player.getAttackDamage(seed);
					//Print the amount of dammage done
					System.out.println(playerName + " Attacks for: " + strike + " dammage! ");

					//If the monster's health is less than 0, print a congratulations message and update the player's number of wins
					if (monsterHealth<=0) {
						System.out.println("Congratulations! You have slain the monster!!");
						System.out.println(player.getName() + " Has Won " + player.getNumWins() + " times");
						break;
					}
					//If monster's health is greater than 0, the monsters current health is subtracted by the damage done by the attack
					if (monsterHealth>0) {
						monsterHealth = monsterHealth-strike;
						System.out.println(monsterName + " current health is " + monsterHealth);
						System.out.println();
					}
					//Create a double calling on the attackDammage method from the Character class using a random int
					int monsterSeed = attackDammage.nextInt();
					double monsterStrike = player.getAttackDamage(monsterSeed);
					//Print the amount of damage done
					System.out.println(monsterName + " Attack for " + monsterStrike + " dammage");
					//If the player's health is less than 0, print out a messgae saying that the monster won and add the number of wins of the monster
					if (playerHealth<=0) {
						System.out.println("Sorry you were defeated by the monster :(  Better luck next time!!");
						System.out.println(monster.getName() + " Has Won " + monster.getNumWins() + " times");
						break;
					}
					if (playerHealth > 0) {
						playerHealth = playerHealth - monsterStrike;
						System.out.println(playerName + " Your current health is " + playerHealth);
					}
				}
				//If the decision was quit the A send off message is printed and we break out of the loop
				else if (decision.equalsIgnoreCase("quit")) {
					System.out.println("Thanks for player BattleGame :) Have a good day!!");
					break;
				}
				//If neither attack or quit was printed then an error message appears and the loop restarts
				else {
					System.out.println("Error, input options are: attack or quit");
					continue;
				}	
			}
			//If the spell file was not null 
		}else {
			//Initialize the player
			Character player = FileIO.readCharacter(filePlayer);
			//initialize a Character monster
			Character monster = FileIO.readCharacter(fileMonster);


			//Display info of the player
			String playerName = player.getName();
			System.out.println("Name: " + playerName);
			double playerHealth = player.getCurrHealth();
			System.out.println("Health: " + playerHealth);
			double playerStrength = player.getAttackValue();
			System.out.println("Attack: " + playerStrength);
			int playerRecord = player.getNumWins();
			System.out.println("Number of wins: " + playerRecord);
			System.out.println(" ");

			//Display info of the monster
			String monsterName = monster.getName();
			System.out.println("Name: " + monsterName);
			double monsterHealth = monster.getCurrHealth();
			System.out.println("Health " + monsterHealth);
			double monsterStrength = monster.getAttackValue();
			System.out.println("Attack: " + monsterStrength);
			int monsterRecord = monster.getNumWins();
			System.out.println("Number of wins: " + monsterRecord);
			System.out.println();

			//Set and Display the spells 
			player.setSpells(spells);
			player.displaySpells();
			//Same code as above, see above for more in detail comments
			for (;;) {
				Scanner read= new Scanner(System.in);
				System.out.println("Enter a command");
				String decision = read.nextLine();
				if (decision.equalsIgnoreCase("attack")) {
					Random attackDammage = r;
					int seed = attackDammage.nextInt();
					double strike = player.getAttackDamage(seed);
					System.out.println(playerName + " Attacks for: " + strike + " dammage! ");
					if (monsterHealth<=0) {
						System.out.println("Congratulations! You have slain the monster!!");
						System.out.println(player.getName() + " Has Won " + player.getNumWins() + " times");
						break;
					}
					if (monsterHealth>0) {
						monsterHealth = monsterHealth-strike;
						System.out.println(monsterName + " current health is " + monsterHealth);
						System.out.println();
					}
					int monsterSeed = attackDammage.nextInt();
					double monsterStrike = player.getAttackDamage(monsterSeed);
					System.out.println(monsterName + " Attack for " + monsterStrike + " dammage");
					playerHealth = playerHealth - monsterStrike;
					if (playerHealth<=0) {
						System.out.println("Sorry you were defeated by the monster :(  Better luck next time!!");
						System.out.println(monster.getName() + " Has Won " + monster.getNumWins() + " times");
						break;
					}
					if (playerHealth > 0) {
						System.out.println(playerName + " Your current health is " + playerHealth);
					}
				}
				else if (decision.equalsIgnoreCase("quit")) {
					System.out.println("Thanks for player BattleGame :) Have a good day!!");
					break;
				}
				//If the input was not attack or quit we assume they are trying to case a spell
				else {
					//Initialize a spell to null
					Spell chosenSpell = null; 
					//store the input into the chosenSpell object
					for(int i=0; i<spells.size(); i++) {
						if(spells.get(i).getName().equalsIgnoreCase(decision)) {
							chosenSpell = spells.get(i); 
						}
					}
					//If the chosen spell is null, print an error message
					if(chosenSpell == null) {
						System.out.println("ERROR: NOT A VALID STRING, PLEASE TRY AGAIN");
						continue; 
					}
					//If the input is equal to one of the spells in the ArrayList then it is stored in chosenSpell
					Random ran = r; 
					int seed = ran.nextInt(); 
					//THe damage is stored into a double using a random as seed
					double damage = chosenSpell.getMagicDamage(seed); 
					//If the damage was 0 or less, an error message appears
					if(damage <= 0.0) {
						System.out.println(playerName + " Casts spell for: 0 dammage! ");
						//If the moster's health is less than 0, congratulations message is written and numWins is increased.
						if (monsterHealth<=0) {
							System.out.println("Congratulations! You have slain the monster!!");
							System.out.println(player.getName() + " Has Won " + monster.getNumWins()+ " times");
							break;
						}
						//If monster Health is greater than 0 then it the spell's damage is subtracted from the current health
						if (monsterHealth>0) {
							monsterHealth = monsterHealth-damage;
							System.out.println(monsterName + " current health is " + monsterHealth);
							System.out.println();
						}
						//The monster attacks after the spell is cast
						Random attackDammage = r; 
						int monsterSeed = attackDammage.nextInt();
						double monsterStrike = player.getAttackDamage(monsterSeed);
						System.out.println(monsterName + " Attack for " + monsterStrike + " dammage");
						playerHealth = playerHealth - monsterStrike;
						if (playerHealth<=0) {
							System.out.println("Sorry you were defeated by the monster :(  Better luck next time!!");
							System.out.println(monster.getName() + " Has Won " + monster.getNumWins() + " times");
							break;
						}
						//Same as above
						if (playerHealth > 0) {
							System.out.println(playerName + " Your current health is " + playerHealth);
						}
					}else {

						System.out.println(playerName + " Casts spell for: " + damage + " dammage! ");

						if (monsterHealth<=0) {
							System.out.println("Congratulations! You have slain the monster!!");
							System.out.println(player.getName() + " Has Won " + monster.getNumWins()+ " times");
							break;
						}
						if (monsterHealth>0) {
							monsterHealth = monsterHealth-damage;
							System.out.println(monsterName + " current health is " + monsterHealth);
							System.out.println();
						}
						Random attackDammage = r; 
						int monsterSeed = attackDammage.nextInt();
						double monsterStrike = player.getAttackDamage(monsterSeed);
						System.out.println(monsterName + " Attack for " + monsterStrike + " dammage");
						playerHealth = playerHealth - monsterStrike;
						if (playerHealth<=0) {
							System.out.println("Sorry you were defeated by the monster :(  Better luck next time!!");
							System.out.println(monster.getName() + " Has Won " + monster.getNumWins());
							break;
						}
						if (playerHealth > 0) {
							System.out.println(playerName + " Your current health is " + playerHealth);
						}
					}

				}	

			}		
		}

	}
}

