package battle.system;

import classes.Classes;
import enemy.Bat;
import enemy.Enemy;
import enemy.Goblin;

/**
 * 
 * @author Ryan Adelman-Drummond
 * @version 1.0
 * @date May 29th, 2018 
 *
 */

public class BattleSystem {
	Enemy goblin = new Goblin();
    Enemy bat = new Bat();
    public String getInitiative() {
        double random = Math.random();
        if(random < .5){
            System.out.println("Goblin goes first");
            return "Goblin";
        }
        else {
            System.out.println("Bat goes first");
            return "Bat";
        }
    }
    public Enemy attackEnemy(Enemy attacker, Enemy defender){
        int attack = attacker.getAttack();
        int defense = defender.getDefense();
        int damage = attack - defense;
        boolean killed = defender.death(damage);
        String name = defender.getName();
        if(killed == false){
            defender.loseHP(damage);
            int hp = defender.getHP();
            System.out.println(name + " lost " + damage + ". HP:" + hp);
            System.out.println();
        }else if(killed == true){
            System.out.println(name + " was killed");
            defender.setAlive(false);
        }
        return defender;
    }
    /**
     * A rough battle system that works between 2 enemies
     * it needs to be improved for the prototype game 
     * need to try and get player to work with it
     */
    public void main(){
    	 BattleSystem battle = new BattleSystem();
         while(bat.getAlive() == true && goblin.getAlive() == true){
             String Initiative = battle.getInitiative();
             if(Initiative.equals("Goblin")){
                 bat = battle.attackEnemy(goblin, bat);
                 if(bat.getAlive() == true){
                     goblin = battle.attackEnemy(bat,goblin);
                 }
             }else if(Initiative.equals("Bat")){
                 goblin = battle.attackEnemy(bat,goblin);
                 if(goblin.getAlive() == true){
                     bat = battle.attackEnemy(goblin, bat);
                 }
             }
         }
    }
}
