package items;

/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 18th, 2018 
 *
 */
public class WeaponItem extends Item{
	/**
	 * what does every weapon need?
	 * 	-name
	 * 	-cost
	 * 	-attack
	 */
	private int Attack;
	public WeaponItem(String name, int cost, int attack) {
		super(name, cost);
		Attack = attack;
	}
	public int getWeaponAttack() {
		return Attack;
	}
}
