package classes;

import items.Item;

/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 18th, 2018 
 * @updated May 21st, 2018
 *
 */

/**
 * what makes the knight a knight?
 * have a decent amount of health points and mama points
 */
public class Knight extends Classes{
	private int MaxHP;
	private int curHP;
	private int MaxMP;
	private int curMP;
	private int Level;
	public Knight(String name, int level, Item[] bag, Item[] equipment, int money, int exp) {
		super(name, level, bag, equipment, money, exp);
		MaxHP = 20;
		curHP = MaxHP;
		MaxMP = 10;
		curMP = MaxMP;
		Level = level;
	}

	//level up stuff

	//Level player stuff
	public int getPlayerLevel() {
		return Level;
	}
	public void gainLevel(int gainedLevel) {
		Level += gainedLevel;
		LvLupHPGain();
		LvLupManaGain();
	}
	
	/**
	 * TODO 
	 * implement a level scaling system
	 * 
	 *  I am thinking for every level gain 7-12 hp
	 *  60% chance for a plus 10
	 *  20% chance for a plus 7
	 *  20% chance for a plus 12
	 *  
	 *  this will give you about your level time 10 and sometimes more or less
	 */
	public void LvLupHPGain() {
		double RNG = Math.random();
		if(0 <= RNG && RNG < 0.2) {
			MaxHP += 7;
		}else if(0.2 <= RNG && RNG <= 0.8) {
			MaxHP += 10;
		}else if(0.8 < RNG && RNG <= 1.0) {
			MaxHP += 12;
		}
	}
	
	/**
	 * TODO
	 * implement a MP gainning system for when the knight levels up
	 * 
	 *  I am thinking for every level gain 3-6 mp
	 *  60% chance for a plus 4
	 *  20% chance for a plus 2
	 *  20% chance for a plus 6
	 *  
	 *  this will give some mp but not a lot of it about 400 at level 100
	 */
	public void LvLupManaGain() {
        for(int level = 2; level <= 100; level++){
            double RNG = Math.random();
            if(0 <= RNG && RNG < 0.2) {
                MaxMP += 2;
            }else if(0.2 <= RNG && RNG <= 0.8) {
                MaxMP += 4;
            }else if(0.8 < RNG && RNG <= 1.0) {
                MaxMP += 6;
            }
        }
	}
	
	/**
	 * TODO
	 * figure out exp scaling to know when you level up
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

