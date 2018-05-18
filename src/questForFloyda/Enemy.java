package questForFloyda;
/**
*
* Me trying to see if I can set up a basic outline for an enemy object
*
* @author Ryan Adelman-Drummond
* @version 1.0
* @date May 18th, 2018
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
	private int Level;
	
	public Enemy(String name, int level) {
		Name = name;
		Level = level;
	}
	public String getEnemyName() {
		return Name;
	}
	public int getEnemyLevel() {
		return Level;
	}
}
