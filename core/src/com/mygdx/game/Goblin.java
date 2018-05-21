package com.mygdx.game;

/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 21st, 2018 
 *
 */
public class Goblin extends Enemy{
	
	/**
	 * what does a goblin need to have stats wise
	 */
	
	private int MaxHP;
	private int curHP;
	private int attack;
	private int defense;
	public Goblin(String name) {
		super(name);
		MaxHP = 10;
		curHP = MaxHP;
		attack = 3;
		defense = 2;
	}
	
	//attack stuff
	public int getAttack() {
		return attack;
	}
	
	//defense stuff
	public int getDefense() {
		return defense;
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
