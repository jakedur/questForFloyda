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
    public void attack(Enemy attacker, Enemy defender){
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
        }
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
                int attack = goblin.getAttack();
                int defense = bat.getDefense();
                int damage = attack - defense;
                boolean killed = bat.death(damage);
                String name = bat.getName();
                if(killed == false){
                    bat.loseHP(damage);
                    int hp = bat.getHP();
                    System.out.println(name + " lost " + damage + ". HP:" + hp);

                    attack = bat.getAttack();
                    defense = goblin.getDefense();
                    damage = attack - defense;
                    killed = goblin.death(damage);
                    name = goblin.getName();
                    if(killed == false){
                        goblin.loseHP(damage);
                        hp = goblin.getHP();
                        System.out.println(name + " lost " + damage + ". HP:" + hp);
                        System.out.println();
                    }else if(killed == true){
                        System.out.println(name + " was killed");
                        goblin.setAlive(false);
                    }
                }else if(killed == true){
                    System.out.println(name + " was killed");
                    bat.setAlive(false);
                }

            }else if(Initiative.equals("Bat")){
                int attack = bat.getAttack();
                int defense = goblin.getDefense();
                int damage = attack - defense;
                boolean killed = goblin.death(damage);
                String name = goblin.getName();
                if(killed == false){
                    goblin.loseHP(damage);
                    int hp = goblin.getHP();
                    System.out.println(name + " lost " + damage + ". HP:" + hp);

                    attack = goblin.getAttack();
                    defense = bat.getDefense();
                    damage = attack - defense;
                    killed = bat.death(damage);
                    name = bat.getName();
                    if(killed == false){
                        bat.loseHP(damage);
                        hp = bat.getHP();
                        System.out.println(name + " lost " + damage + ". HP:" + hp);
                        System.out.println();
                    }else if(killed == true){
                        System.out.println(name + " was killed");
                        goblin.setAlive(false);
                    }
                }else if(killed == true){
                    System.out.println(name + " was killed");
                    goblin.setAlive(false);
                }
            }
        }
    }
}
