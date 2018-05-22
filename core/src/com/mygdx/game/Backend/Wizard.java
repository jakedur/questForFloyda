package com.mygdx.game.Backend;

/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0 
 * @date May 21st, 2018
 */

public class Wizard extends Player{
	private int MaxHP;
	private int curHP;
	private int MaxMP;
	private int curMP;
	private int Level;
	public Wizard(String name, int level, Item[] bag, Item[] equipment, int money, int exp) {
		super(name, level, bag, equipment, money, exp);
		MaxHP = 15;
		curHP = MaxHP;
		MaxMP = 20;
		curMP = MaxMP;
		Level = level;
	}

	/** 
	 * what makes the wizard different from the other classes?
	 * 	-high mp
	 * 	-low hp
	 * 	-low defense
	 * 	-low attack
	 * 	-magic oriented 
	 */

	//Level player stuff
	public int getPlayerLevel() {
		return Level;
	}
	public void gainLevel(int gainedLevel) {
		Level += gainedLevel;
		//LvLupHPGain();
		//LvLupManaGain();
	}
	
	/**
	 * TODO 
	 * implement a level scaling system
	 * 
	 *  I am thinking for every level gain 10-15 hp
	 *  60% chance for a plus 7
	 *  20% chance for a plus 5
	 *  20% chance for a plus 9
	 *  
	 *  this will give you some health but not a lot of health
	 *  about mid 600's at level 100 and about 300 at level 50
	 */
	public void LvLupHPGain() {
		double RNG = Math.random();
		 if(0 <= RNG && RNG < 0.2) {
             MaxHP += 4;
         }else if(0.2 <= RNG && RNG <= 0.8) {
             MaxHP += 6;
         }else if(0.8 < RNG && RNG <= 1.0) {
             MaxHP += 8;
         }
	}
	
	/**
	 * TODO
	 * implement a MP gainning system for when the wizards levels up
	 * 
	 *  I am thinking for every level gain 7-12 mp
	 *  60% chance for a plus 10
	 *  20% chance for a plus 8
	 *  20% chance for a plus 12
	 *  
	 *  this will give you about 1,000 at level 100 so pretty good amount of mana
	 */
	public void LvLupManaGain() {
        for(int level = 2; level <= 100; level++){
            double RNG = Math.random();
            if(0 <= RNG && RNG < 0.2) {
                MaxMP += 7;
            }else if(0.2 <= RNG && RNG <= 0.8) {
                MaxMP += 10;
            }else if(0.8 < RNG && RNG <= 1.0) {
                MaxMP += 12;
            }
        }
	}
	
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
