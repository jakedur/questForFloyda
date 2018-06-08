 package classes;

/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0 
 * @date May 21st, 2018
 */

public class Wizard extends Classes{
	private int MaxHP;
	private int curHP;
	private int MaxMP;
	private int curMP;
	public Wizard(String name) {
		super(name);
		MaxHP = 15;
		curHP = MaxHP;
		MaxMP = 20;
		curMP = MaxMP;
	}

	/** 
	 * what makes the wizard different from the other classes?
	 * 	-high mp
	 * 	-low hp
	 * 	-low defense
	 * 	-low attack
	 * 	-magic oriented 
	 */
	
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
	@Override
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
	@Override
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
		@Override
		public int getHP() {
			return curHP;
		}
		@Override
		public int getMaxHP() {
			return MaxHP;
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

		//MP player stuff
		@Override
		public int getMP() {
			return curMP;
		}
		@Override
		public int getMaxMP() {
			return MaxMP;
		}
		@Override
		public void useMP(int MPcost) {
			curMP -= MPcost;
		}
		@Override
		public void gainMp(int MPgained) {
			curMP += MPgained;
		}
		@Override
		public void FullMP() {
			curMP = MaxMP;
		}
		@Override
		public boolean enoughMP(int MPcost) {
			if(curMP - MPcost < 0) {
				return false;
			}
			return true;
		}
}
