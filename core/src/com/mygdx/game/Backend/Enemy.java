package com.mygdx.game;
/**
*
* Me trying to see if I can set up a basic outline for an enemy object
*
* @author Ryan Adelman-Drummond
* @version 1.0
* @date May 18th, 2018
* @updated May 21st, 2018
*
*/
public class Enemy {
	/**
	 * what does a every enemy need to have?
	 * 	-name
	 * 	-level
	 * 
	 */
	private String Name;
	
	public Enemy(String name) {
		Name = name;
	}
	public String getEnemyName() {
		return Name;
	}
}
