package battleGame;
//Curtis Docherty
//260769767

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Character {
	//initialize the private attributes
	private String name;
	private double attackValue;
	private static double maxHealth;
	private double currentHealth;
	private int numWins;
	private static ArrayList<Spell> spells;
	
	//A constructor to initialize the attributes
	public Character (String name, double attackValue, double maxHealth, int numWins) {
		this.name=name;
		this.attackValue=attackValue;
		maxHealth=maxHealth;
		this.numWins=numWins;
		this.currentHealth=maxHealth;
	}
	
	//A method to get the name of the character
	public String getName() {
		return this.name;
	}
	//A method to get the attack value
	public double getAttackValue () {
		return this.attackValue;
	}
	////A method to get the max health.  Static because it is the same for all players
	public static double getMaxHealth () {
		return maxHealth;
	}
	//A method to get the current health of the player
	public double getCurrHealth() {
		return this.currentHealth;
	}
	//A method to get the number of Wins
	public int getNumWins() {
		return this.numWins;
	}
	public String toString() {
		return this.name + this.currentHealth;
	}
	//A method which returns the amount of damage done by an attack
	public double getAttackDamage(int seed) {
		Random strike= new Random(seed);
		//The damage done by the player is a random double between 0.7 and 1.0
		double myChance=(0.3)*strike.nextDouble()+0.7;
		double dammage=this.attackValue*myChance;
		return dammage;
	}
	//Takes the damage done to the player and subtracts their current health by the damage done
	public double takeDamage(double hit) {
		this.currentHealth=(currentHealth-hit);
		return currentHealth;
	}
	//INcreases the number of wins by 1
	public void increaseWins() {
		int numWins1=this.numWins+1;
	}
	//A void method which sets an ArrayList of spells as input
	public static void setSpells(ArrayList<Spell>inputspells) {
		spells = new ArrayList<Spell>(); 
		for (int i =0; i<inputspells.size(); i++) {
			Spell s = inputspells.get(i);
			spells.add(s); 
		}
	}
	//A method which displays the spells
	public static void displaySpells() {
		for (int i =0; i<spells.size(); i++) {
			Spell s = spells.get(i); 
			System.out.println(s.toString());
			System.out.println(); 
		}
	}
	//A method that returns the dammage done by a spell
	public double castSpell(String spellName, int seed) {
		Spell s = null; 
		for (int i =0; i<spells.size(); i++) {
			s = spells.get(i); 
			if(s.getName().equalsIgnoreCase(spellName)){
				double dammage=s.getMagicDamage(seed);
				return dammage;
			}
		}
		return -1;
	}		
}
