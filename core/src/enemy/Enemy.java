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

	private String name;
	private int MaxHP;
	private int curHP;
	private int attack;
	private int defense;
	private int expGiven;
	private boolean alive;
	public Enemy() {
		alive = true;
	}
	public String getName(){
		return name;
	}
	public void setAlive(boolean Alive){
		alive = Alive;
	}
	public boolean getAlive(){
		return alive;
	}
	public int getAttack() {
		return attack;
	}
	public int getDefense() {
		return defense;
	}
	public int getExp() {
		return expGiven;
	}
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
		if(curHP - damage < 1) 
			return true;
		return false;
	}
}
