package com.mygdx.game;
/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 18th, 2018 
 *
 */
public class Item {
	/**
	 * what does every item need to have?
	 * 	-name
	 * 	-cost
	 */
	private String ItemName;
	private int ItemCost;
	public Item(String name, int cost) {
		ItemName = name;
		ItemCost = cost;
	}
	public String getItemName() {
		return ItemName;
	}
	public int getItemCost() {
		return ItemCost;
	}
}
