package items;
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
	private String Name;
	private int Cost;
	public Item(String name, int cost) {
		Name = name;
		Cost = cost;
	}
	public String getItemName() {
		return Name;
	}
	public int getItemCost() {
		return Cost;
	}
	public int getArmorDefense() {
		return 0;
	}
	public int getWeaponAttack() {
		return 0;
	}
}
