package questForFloyda;
/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 18th, 2018 
 *
 */

/**
 * what makes the knight a knight?
 * have a decent amount of health points and mama points
 */
public class Knight extends Player{
	private int MaxHP;
	private int curHP;
	private int MaxMP;
	private int curMP;
	public Knight(String name, int level, String[] bag, String[] equipment, int money, int exp) {
		super(name, level, bag, equipment, money, exp);
	}

	/**
	 * TODO 
	 * implement a level scaling system 
	 */
	
	//HP PLayer stuff
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
	//MP player stuff
	public int getMP() {
		return curMP;
	}
	public void useMP(int MPcost) {
		curMP -= MPcost;
	}
	public void gainMp(int MPgained) {
		curMP += MPgained;
	}
	public void FullMP() {
		curMP = MaxMP;
	}
	public boolean enoughMP(int MPcost) {
		if(curMP - MPcost < 0) {
			return false;
		}
		return true;
	}
}
