package battleGame;
//Curtis Docherty
//260769767

import java.util.Random;
public class Spell {
//initialize the private attributes
	private String name;
	private double minDammage;
	private double maxDammage;
	private double successRate;
	
	//A constructor of type spell. 
	public Spell (String name, double minDammage, double maxDammage, double successRate) {
		//If the minDammage is greater than 0 or greater than the max damage, or if sucess rate is not between 0 and 1 then it throws an illegal argument exception
		if (minDammage<0 || minDammage>maxDammage || successRate>1 || successRate < 0) {
			throw new IllegalArgumentException("error");
		}
		//Initialize all of the attributes 
		this.name=name;
		this.minDammage=minDammage;
		this.maxDammage=maxDammage;
		this.successRate=successRate;
	}
	//A method to get the name
	public String getName() {
		return this.name;
	}
	//A method that returns the damage done by a spell
	public double getMagicDamage(int seed) {
		//
		Random randy= new Random(seed);
		double chance= randy.nextDouble();
		//If the chance is greater than the success rate then the spell did not work and 0 is returned
		if (chance>this.successRate) {
			return 0.0;
			//Otherwise the damage is calculated
		} else {
			double dammage = (maxDammage-minDammage) * randy.nextDouble()+ minDammage;
			return dammage;
		}
		
	}
	// A to string method, which puts all of the information of each spell on one line
	public String toString() {
		String response="";
		response+= "Spell Name:" + this.name +" "; 
		response += " dammage: " + Double.toString(this.minDammage) + "-" + Double.toString(this.maxDammage) ;
		response += " Success rate: " + Double.toString(this.successRate);
		return response;
	}

}
