package enemy;

/**
 * 
 * @author Ryan Adelmna-Drummond 
 * @version 1.0
 * @date May 21st, 2018
 * @updated May 21st, 2018
 */
public class Bat extends Enemy{
	/**
	 * The bat is a low level cave enemy that has low health and medium attack 
	 */
	private int MaxHP;
	private int curHP;
	private int attack;
	private int defense;
	private int expGiven;
	public Bat() {
		MaxHP = 7;
		curHP = MaxHP;
		attack = 4;
		defense = 2;
		expGiven = 6;
	}
	
	//attack stuff
	@Override
	public int getAttack() {
		return attack;
	}
	
	//defense stuff
	@Override
	public int getDefense() {
		return defense;
	}
	
	//exp stuff
	@Override
	public int getExp() {
		return expGiven;
	}
	
	//health stuff
	@Override
	public int getHP() {
		return curHP;
	}
	@Override
	public void loseHP(int damage) {
		curHP -= damage;
	}
	@Override
	public void gainHP(int heal) {
		curHP += heal;
	}
	@Override
	public void FullHP() {
		curHP = MaxHP;
	}
	@Override
	public boolean death(int damage) {
		if(curHP - damage < 0) {
			return true;
		}
		return false;
	}

}
