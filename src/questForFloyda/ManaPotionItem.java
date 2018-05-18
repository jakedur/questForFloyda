package questForFloyda;
/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 18th, 2018 
 *
 */
public class ManaPotionItem extends Item{
	private int GainMana;
	public ManaPotionItem(String name, int cost,int manaGain) {
		super(name, cost);
		GainMana = manaGain;
	}
	public int getMana() {
		return GainMana;
	}
}
