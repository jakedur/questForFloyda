package enemy;
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
	private int MaxHP;
	private int curHP;
	private int attack;
	private int defense;
	private int expGiven;
	public Enemy() {
	}
	public String getEnemyName() {
		return Name;
	}
	//attack stuff
	public int getAttack() {
		return attack;
	}
	
	//defense stuff
	public int getDefense() {
		return defense;
	}
	
	//exp stuff
	public int getExp() {
		return expGiven;
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
