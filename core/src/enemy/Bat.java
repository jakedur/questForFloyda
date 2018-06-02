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
    private String name;
    private int MaxHP;
	private int curHP;
	private int attack;
	private int defense;
	private int expGiven;
	private boolean alive;
	public Bat() {
	    name = "Bat";
		MaxHP = 6;
		curHP = MaxHP;
		attack = 5;
		defense = 2;
		expGiven = 6;
		alive = true;
	}
	@Override
	public String getName(){
        return name;
    }
    @Override
    public void setAlive(boolean Alive){
        alive = Alive;
    }
    @Override
    public boolean getAlive(){
       return alive;
    }
    @Override
    public int getAttack() {
        return attack;
    }
    @Override
    public int getDefense() {
        return defense;
    }
    @Override
    public int getExp() {
        return expGiven;
    }
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
        if(curHP - damage < 1) 
            return true;
		return false;
	}
}
