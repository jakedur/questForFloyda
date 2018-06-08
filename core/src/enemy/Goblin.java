package enemy;

/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 21st, 2018 
 *
 */
public class Goblin extends Enemy{
	
	/**
	 * what does a goblin need to have stats wise
	 */
	private String name;
    private int MaxHP;
	private int curHP;
	private int attack;
	private int defense;
	private int expGiven;
	private int goldGiven;
	private boolean alive;
	public Goblin() {
		name = "Goblin";
	    MaxHP = 10;
		curHP = MaxHP;
		attack = 2;
		defense = 1;
		expGiven = 5;
		alive = true;
		goldGiven = 15;
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
    @Override
    public int getGoldGiven() {
    	return goldGiven;
    }
}
