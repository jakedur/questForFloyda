package com.mygdx.game;

/** 
 * 
 * @author Ryan Adelmna-Drummond
 * @version 1.0
 * @date May 21st, 2018
 * @updated May 21st, 2018 
 *
 */
public class FireSpell {
	/**
	 * what is going to be the stats about the fire spell?
	 *  -the damage it does for each level
	 * 		-Fire lvl 1 does 30 Damage	(Single Target)
	 * 		-Fire lvl 2 does 70 Damage	(Single Target)
	 * 		-Fire lvl 3 does 120 Damage (Hits all enemies)
	 * 	-the amount of MP it takes for each lvl
	 * 		-Fire lvl 1 cost 7 MP
	 * 		-Fire lvl 2 cost 15 MP
	 * 		-Fire lvl 3 cost 30 MP
	 * 	-What level of fire spell
	 * 		-3 total levels for the fire spell
	 *  -What the magic level is for each level of the fire spell
	 *  	-Fire lvl 1 Magic Level of 1
	 *  	-Fire lvl 2 Magic Level of 4
	 *  	-Fire lvl 3 Magic Level of 7
	 */
	private int Damage;
	private int MPCost;
	private int Level;
	private int MagicLevel;
	private String Name;
	public FireSpell(int level) {
		if(level == 1) {
			Damage = 30;
			MPCost = 7;
			MagicLevel = 1;
			Name = "Fire";
		}
		else if(level == 2) {
			Damage = 70;
			MPCost = 15;
			MagicLevel = 4;
			Name = "Fira";
		}
		else if(level == 3) {
			Damage = 120;
			MPCost = 30;
			MagicLevel = 7;
			Name = "Firaga";
		}
		Level = level;
	}
	
	//getting the Damage of the fire spell
	public int getDamage() {
		return Damage;
	}
	
	//gettign the MP Cost
	public int getMPCost() {
		return MPCost;
	}
	
	//getting the Magic Level of the spell
	public int getMagicLevl() {
		return MagicLevel;
	}
	
	//getting the name of the fire spell
	public String getName() {
		return Name;
	}
	
	//get the level of the fire spell
	public int getLevel() {
		return Level;
	}
}
