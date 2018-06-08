package items;

/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 18th, 2018 
 *
 */
public class ArmorItem extends Item{
	/**
	 * what does every armor item need?
	 * 	-name
	 * 	-cost
	 * 	-defense
	 */
	private int Defense;
	public ArmorItem(String name, int cost, int defense) {
		super(name, cost);
		Defense = defense;
	}
	@Override
	public int getArmorDefense() {
		return Defense;
	}
}
