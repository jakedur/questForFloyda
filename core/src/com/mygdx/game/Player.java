package com.mygdx.game;
/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 18th, 2018
 *
 */
public class Player {
	/**
	 * what does every player need to have?
	 * 	-name
	 * 	-level
	 * 	-equipment
	 * 	-bag
	 * 	-money
	 * 	-experience 
	 */
	
	//TODO change all of sting arrays to item arrays
	//items are objects that need to make
	private String Name;
	private int Level;
	private String[] Bag;
	private String[] Equipment;
	private int Money;
	private int Exp;
	private int MagicLevel;
	
	public Player(String name, int level, String[] bag, String[] equipment, int money, int exp) {
		Name = name;
		Level = level;
		copyArray(Bag, bag);
		copyArray(Equipment, equipment);
		Money = money;
		Exp = exp;
		MagicLevel = 0;
	}
	//copy the array to the other array
	public void copyArray(String[] CopyTo, String[] CopyThis) {
		for(int pos = 0; pos < CopyThis.length; pos++) {
			CopyTo[pos] = CopyThis[pos];
		}
	}
	//Name player stuff
	public String getPlayerName() {
		return Name;
	}
	
	//Magic level player stuff
	public int getMagicLevel() {
		return MagicLevel;
	}
	public void gainMagicLevel() {
		MagicLevel++;
	}
	
	//Exp player stuff
	public int getPlayerExp() {
		return Exp;
	}
	public void gainExp(int gainedExp) {
		Exp += gainedExp;
	}
	
	//Money player related stuff
	public int getPlayerMoney() {
		return Money;
	}
	public void addMoney(int plusMoney) {
		Money += plusMoney;
	}public void subtractMoeny(int minusMoney) {
		Money -= minusMoney;
	}
	public boolean checkEnough(int cost) {
		if(Money - cost < 0) {
		return false;
		}
		return true;
	}
	//Bag player stuff
	
	//Equipment player stuff
}
