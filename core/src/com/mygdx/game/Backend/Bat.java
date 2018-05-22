package com.mygdx.game.Backend;

/**
 * 
 * @author Ryan Adelmna-Drummond 
 * @version 1.0
 * @date May 21st, 2018
 * @updated May 21st, 2018
 */
public class Bat extends Enemy{
	/**
	 * The bat is a low level cave enemy that has low health and medium attack 
	 */
	private int MaxHP;
	private int curHP;
	private int attack;
	private int defense;
	private int expGiven;
	public Bat(String name) {
		super(name);
		MaxHP = 7;
		curHP = MaxHP;
		attack = 4;
		defense = 2;
		expGiven = 6;
	}
	
	//attack stuff
	public int getAttack() {
		return attack;
	}
	
	//defense stuff
	public int getDefense() {
		return defense;
	}
	
	//exp stuff
	public int getExp() {
		return expGiven;
	}
	
	//health stuff
	public int getHP() {
		return curHP;
	}
	public void loseHP(int damage) {
		curHP -= damage;
	}
	public void gainHP(int heal) {
		curHP += heal;
	}
	public void FullHP() {
		curHP = MaxHP;
	}
	public boolean death(int damage) {
		if(curHP - damage < 0) {
			return true;
		}
		return false;
	}

}
