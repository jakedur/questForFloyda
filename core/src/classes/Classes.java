package classes;

import java.util.ArrayList;
import java.util.List;
import items.Item;

/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 18th, 2018
 *
 */
public class Classes {
	/**
	 * what does every player need to have?
	 * 	-name
	 * 	-level
	 * 	-equipment
	 * 	-bag
	 * 	-money
	 * 	-experience 
	 */

	//TODO change all of sting arrays to item arrays
	//items are objects that need to make
	private String Name;
	private int Level;
	private List<Item> Bag;
	private Item[] Equipment;
	private int Money;
	private int Exp;
	private int MagicLevel;
	private int MaxHP;
	private int curHP;
	private int MaxMP;
	private int curMP;
	private int Weapon = 0;
	private int Shield = 1;
	private int Hat = 2;
	private int Chest = 3;
	private int Boots = 4;
	private int Amulet = 5;
	private boolean alive;

	/**
	 * What does the Equipment contain in what position?
	 * 
	 * 0-Weapon
	 * 1-Shield
	 * 2-Hat
	 * 3-Chest Armor
	 * 4-Boots
	 * 5-Amulet
	 */

	public Classes(String name) {
		Name = name;
		Level = 1;
		Money = 500;
		Exp = 0;
		MagicLevel = 0;
		Bag = new ArrayList<Item>();
		Equipment = new Item[6];
		setAlive(true);
	}

	public int getPlayerLevel() {
		return Level;
	}

	public void gainLevel(int gainedLevel) {
		Level += gainedLevel;
		LvLupHPGain();
		LvLupManaGain();
	}
	
	public void LvLupHPGain() {
	}

	public void LvLupManaGain() {
	}

	//HP PLayer stuff
	public int getHP() {
		return curHP;
	}
	
	public int getMaxHP() {
		return MaxHP;
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
	
	public int getMaxMP() {
		return MaxMP;
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
	
	//copy the array to the other array
	public void copyArray(Item[] CopyTo, Item[] CopyThis) {
		for(int pos = 0; pos < CopyThis.length; pos++) {
			CopyTo[pos] = CopyThis[pos];
		}
	}
	
	//Name player stuff
	public String getPlayerName() {
		return Name;
	}

	//Magic level player stuff
	public int getMagicLevel() {
		return MagicLevel;
	}
	
	public void gainMagicLevel() {
		MagicLevel++;
	}

	//Exp player stuff
	public int getPlayerExp() {
		return Exp;
	}
	
	public void gainExp(int gainedExp) {
		Exp += gainedExp;
		CheckLvlUp();
	}
	
	public void CheckLvlUp() {
		if(Exp >= 10 * 1.5 * Level) {
			gainLevel(1);
			Exp = 0;
		}
	}

	//Money player related stuff
	public int getPlayerMoney() {
		return Money;
	}
	
	public void addMoney(int plusMoney) {
		Money += plusMoney;
	}
	
	public void subtractMoeny(int minusMoney) {
		Money -= minusMoney;
	}
	
	public boolean checkEnough(int cost) {
		if(Money - cost < 0) {
			return false;
		}
		return true;
	}
	
	//Bag player stuff
	public void addItem(Item item) {
		Bag.add(item);
	}
	
	public void removeItem(Item item) {
		int num = Bag.indexOf(item);
		Bag.remove(num);
		if(Bag.size() == 1) {
			Bag.clear();
		}
	}
	
	public List<Item> getBag(){
		return Bag;
	}
	
	//Equipment player stuff
	public void EquipWeapon(Item item) {
		addItem(Equipment[Weapon]);
		Equipment[Weapon] = item;
	}
	
	public void EquipShield(Item shield) {
		addItem(Equipment[Shield]);
		Equipment[Shield] = shield;
	}
	
	public void EquipHat(Item hat) {
		addItem(Equipment[Hat]);
		Equipment[Hat] = hat;
	}
	
	public void EquipChest(Item chest) {
		addItem(Equipment[Chest]);
		Equipment[Chest] = chest;
	}
	
	public void EquipBoots(Item boots) {
		addItem(Equipment[Boots]);
		Equipment[Boots] = boots;
	}
	
	public void EquipAmulet(Item amulet) {
		addItem(Equipment[Amulet]);
		Equipment[Amulet] = amulet;
	}
	public Item[] getEqupiment() {
		return Equipment;
	}
	
	public int getAttack() {
		if(Equipment[Weapon] != null) {
			return Equipment[Weapon].getWeaponAttack();
		}
		return 0;
	}
	public int getDefense() {
		int sum = 0;
		if(Equipment[Shield] != null) {
			sum += Equipment[Shield].getArmorDefense();
		}
		if(Equipment[Hat] != null) {
			sum += Equipment[Hat].getArmorDefense();
		}
		if(Equipment[Chest] != null) {
			sum += Equipment[Chest].getArmorDefense();
		}
		if(Equipment[Boots] != null) {
			sum += Equipment[Boots].getArmorDefense();
		}
		if(Equipment[Amulet] != null) {
			sum += Equipment[Amulet].getArmorDefense();
		}
		return sum;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
