import java.util.ArrayList;

public class Enemy {
    // *** ATTRIBUTES *** //
    private final String enemyName;
    private final String enemyDesc;
    private int healthLevel;
    private Weapon weapon;
    private boolean isAlive; // alive status

    // *** CONSTRUCTOR *** //

    public Enemy(String enemyName, String enemyDesc, int healthLevel, Weapon weapon) {
        this.enemyName = enemyName;
        this.enemyDesc = enemyDesc;
        this.healthLevel = healthLevel;
        this.weapon = weapon;
        this.isAlive = healthLevel > 0;
    }

    // *** GET METHODS ***//
    public String getEnemyName() {
        return enemyName;
    }

    public String getEnemyDesc() {
        return enemyDesc;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public Weapon getWeapon() {
        return weapon;
    }

// *** METHODS *** //

    // *** CHECK IF ENEMY IS ALIVE *** //
    public boolean isAlive() {
        return isAlive && healthLevel > 0; // Enemy is alive if health is greater than 0
    }

    //Method enemy TAKE damage from player attack
    public Weapon takeDamage(int damage, Room currentRoom) {
        healthLevel -= damage; // subtracting damage from health level

        if (healthLevel < 0) {
            healthLevel = 0;// Prevent negative health
            isAlive = false; // false when health is <=0 enemy is dead

            System.out.println("(DEBUG)Enemy " + enemyName + " has been defeated."); // Debug message

            //drop weapon
            if(weapon!=null){
                Weapon droppedWeapon = weapon; //store weapon to return the weapon
                weapon = null; //remove weapon from enemy

                System.out.println("(DEBUG)" + enemyName + " dropped their weapon: " + droppedWeapon.getItemName()); // Debug message
                currentRoom.addItems(droppedWeapon);
                return droppedWeapon;
            }

        }
        return null;
    }

    // enemy attack player
    public String attackPlayer(Player player) {
        if (player.isAlive()) {
            int damage = weapon.getDamage();
            player.playerDamage(damage);
            return enemyName + " attacks you for " + damage + "damage";
        } else {
            return "The player is already defeated";
        }

    }

}
