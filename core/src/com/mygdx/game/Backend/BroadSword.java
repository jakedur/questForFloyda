package com.mygdx.game.Backend;
/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 21st, 2018
 * @updated 
 *
 */
public class BroadSword extends WeaponItem{
	/**
	 * Basic Starting Sword 
	 * What does the broad sword need for stats?
	 * 	-Cheap
	 * 	-Medium Damage for starting levels
	 */
	private int Cost;
	private int Attack;
	private String Name;
	public BroadSword(String name, int cost, int attack) {
		super(name, cost, attack);
		Cost = cost;
		Attack = attack;
		Name = name;
	}
}
