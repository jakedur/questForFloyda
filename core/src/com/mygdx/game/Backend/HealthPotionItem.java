package com.mygdx.game;
/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 18th, 2018 
 *
 */
public class HealthPotionItem extends Item{
	private int heal;
	public HealthPotionItem(String name, int cost, int healthGain) {
		super(name, cost);
		heal = healthGain;
	}
	public int getHeal() {
		return heal;
	}
}
