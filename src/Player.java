// *** Denne klasse holder styr på hvor spilleren er ***//

import java.util.ArrayList;
import java.util.List;

public class Player {

    // *** Instance variables *** //
    private Room current;//This variable keeps track of the current room where the player is located
    private ArrayList<Item> inventory;
    private int health; // current health
    private int maxHealth=100; // max health of the player
    private boolean isAlive; // alive status
    private Enemy currentEnemy; //one enemy in current room
    private Weapon equippedWeapon;

    // *** Constructor *** //
    public Player(Room currentRoom, int maxHealth) {
        this.current = currentRoom;// set the starting room
        this.inventory = new ArrayList<>();
        this.maxHealth = maxHealth;
        this.health = maxHealth; // initialize current health to max health
        this.isAlive = true; // initialize current alive status
    }

    // *** GET CURRENT ROOM  *** //
    public Room getCurrentRoom() {
        return current;
    }
    // *** GET HEALTH *** //
    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    // *** METHOD TO TAKE DAMAGE *** //
    public void playerDamage(int damage) {
        health -= damage; // Subtracting damage from health
        if (health < 0) {
            health = 0; // Prevent negative health
            isAlive = false; // Set alive status to false if health is <= 0
            gameOver(); // Call the game over method
        }
    }

    private boolean hasEnemies() {
        return !current.getEnemyArrayList().isEmpty();
    }

    // *** USER OPTION METHODS ***//
    public void moveToRoomNorth() {

        if (hasEnemies()) {
            System.out.println("You cannot leave the room until all enemies are defeated!");
            return;
        }
        if (current.getNorth() != null) {
            current = current.getNorth();
            System.out.println("You moved north to " + current.getName());
        } else {
            System.out.println("There is no room to the north.");
        }
    }

    public void moveToRoomEast() {

        if (hasEnemies()) {
            System.out.println("You cannot leave the room until all enemies are defeated!");
            return;
        }
        if (current.getEast() != null) {
            current = current.getEast();
            System.out.println("You moved east to " + current.getName());
        } else {
            System.out.println("There is no room to the east.");
        }
    }

    public void moveToRoomWest() {

        if (hasEnemies()) {
            System.out.println("You cannot leave the room until all enemies are defeated!");
            return;
        }
        if (current.getWest() != null) {
            current = current.getWest();
            System.out.println("You moved west to " + current.getName());
        } else {
            System.out.println("There is no room to the west.");
        }
    }

    public void moveToRoomSouth() {
        if (hasEnemies()) {
            System.out.println("You cannot leave the room until all enemies are defeated!");
            return;
        }
        if (current.getSouth() != null) {
            current = current.getSouth();
            System.out.println("You moved south to " + current.getName());
        } else {
            System.out.println("There is no room to the south.");
        }
    }



    public String checkInventory() {
        String current = "";
        for (Item item : inventory) {
            current += "- " + item.toString() + ".\n";
        }
        return current;

    }

    // *** TAKE & DROP METHODS *** //
    public String takeItem(String itemName) {
        Item itemTake = null;

        //make for loop to check if the item is in the room
        for (Item item : current.getItemArrayList()) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                itemTake = item;
                break;
            }
        }
        if (itemTake != null) {
            inventory.add(itemTake);
            current.getItemArrayList().remove(itemTake);
            return "You have collected the " + itemTake.getItemName();
        } else {
            return "Item is not in this room ...";
        }
    }

    public String dropItem(String itemName) {
        Item itemDrop = null;

        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                itemDrop = item;
                break;

            }
        }
        if (itemDrop != null) {
            inventory.remove(itemDrop);
            current.getItemArrayList().add(itemDrop);
            return "You have dropped the " + itemDrop.getItemName();
        } else {
            return "You don't posses the item you wish to drop";
        }

    }

    // *** DEL 3  *** // - FOOD
    private String gameOver() {
        isAlive = false;
        return "Game over. You died ☠ ";
    }


    public String eatItem(String itemName) {
        Food itemEat = null;
        // Check in the inventory for the Food
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                if (item instanceof Food) {
                    itemEat = (Food) item; // Assign the food item, type cast food
                    break;
                } else {
                    return "You cannot eat the " + item.getItemName() + ". It is not food.";
                }
            }
        }

        // Check in the current room for the Food
        if (itemEat == null) { // Only check if itemEat is still null
            for (Item item : current.getItemArrayList()) {
                if (item.getItemName().equalsIgnoreCase(itemName)) {
                    if (item instanceof Food) {
                        itemEat = (Food) item; // Assign the food item
                        break;
                    } else {
                        return "You cannot eat the " + item.getItemName() + ". It is not food.";
                    }
                }
            }
        }

        // Now check if we found a food item
        if (itemEat != null) {
            health += itemEat.getHealthGain();// Update health
            // health does not exceed max health
            if (health > maxHealth) {
                health = maxHealth;
            }
            //Check if player is dead
            if (health <= 0) {
                gameOver();
                return "You are dead. GAME OVER";
            }
            inventory.remove(itemEat);// Remove the item from inventory or current area
            current.getItemArrayList().remove(itemEat);
            return "You are now eating the " + itemEat.getItemName() + ". Health gained: " + itemEat.getHealthGain();
        } else {
            return "The food you wish to eat is not in your inventory or in the forest area...";
        }
    }

    // *** Del 4 *** // - WEAPON

//    public Weapon getEquippedWeapon() {
//        return equippedWeapon; // reeturns currentlu equipped weapon
//    }

    public String equipWeapon(String weaponName) {
        //initializing a weapon object itemEquip to null
        Weapon itemEquip = null; // holds the reference to the weapon found in inv, if existing

        // with for loop, checking for weapon - iterates over players inv
        for (Item item : inventory) {
            if (item.getItemName().trim().equalsIgnoreCase(weaponName.trim())) {//comparing item in the inv to weapon player want to equip
                if (item instanceof Weapon) {//check if item is of weapon class
                    itemEquip = (Weapon) item; // cast item to Weapon type and stores in itemEquip variable, player can now equip the weapon
                    break; //exit loop if the weapon is found
                } else {
                    return "It's not a weapon";
                }
            }
        }

        if (itemEquip != null) { //if weapon is found
            //Equip the weapon
            itemEquip.equip();// call equip() method on itemEquip weapon object
            this.equippedWeapon = itemEquip; // Assign the equipped weapon to the player
            return "Equipping " + itemEquip.getItemName();
        } else {
            return "The weapon you wish to equip is not in your inventory ...";
        }

    }

    // *** ATTACK METHOD *** //
    private String attackEmptySpace() {
        return "No one is here to attack. You attack nothing ...";
    }

    private String performAttack(Enemy enemy) {
        // Check if the enemy is alive before attacking
        if (!enemy.isAlive()) {
            return null;
        }

        // damage
        int damageDealt = equippedWeapon.getDamage();
       Weapon droppedWeapon = enemy.takeDamage(damageDealt, current); // enemy takes damage and drop weapon if dead

        //Check if enemy is dead after taking damage
        if (!enemy.isAlive()) {
            current.removeEnemy(enemy);

            if (droppedWeapon != null) {
                current.addItems(droppedWeapon);
                return "You attacked and defeated " + enemy.getEnemyName() + ". You can collect their weapon (take)" + droppedWeapon.getItemName();
            }
        }
        return "You attacked " + enemy.getEnemyName() + " and damaged " + damageDealt;
    }

    public String attack(String enemyName) {
        if (!isAlive) {
            return "You are dead. GAME OVER";
        }

        //Check if weapon is equipped
        if (equippedWeapon == null) {
            return "Equip weapon first";
        }

        // Check if weapon can be used (has ammo, etc.)
        String weaponAttackMessage = equippedWeapon.attack(); // Call the attack method on the equipped weapon

        // Check if the weapon is out of ammo
        if (weaponAttackMessage.equals("Out of ammo!")) {
            return weaponAttackMessage; // Return out of ammo message
        }


        // if no enemy name provided from user, attack nearest enemy
        if (enemyName == null || enemyName.isEmpty()) {
            // check if there are enemies in the forest area
            if (!current.getEnemyArrayList().isEmpty()) {
                currentEnemy = current.getEnemyArrayList().get(0); //The first enemy on place 0 is the nearest
                String result = performAttack(currentEnemy);
                // if the enemy is still alive, it attacks back
                if(currentEnemy.isAlive()){
                    return weaponAttackMessage + "\n" + result + "\n" + currentEnemy.attackPlayer(this);
                }
                return weaponAttackMessage + "\n" +  result; //return attack result if enemy is defeated
            } else {
                return attackEmptySpace();
            }
        }
        // find enemy by name
        currentEnemy = findEnemy(enemyName);
        if (currentEnemy != null) {
            String result = performAttack(currentEnemy);
            // if enemy is still alive, it attacks back
            if(currentEnemy.isAlive()){
                return result + "\n" + currentEnemy.attackPlayer(this);
            }
            return result;
        } else {
            return "No enemy named " + enemyName + " in this forest area";
        }
    }

    // find enemy by name in forest area
    private Enemy findEnemy(String enemyName) {
        for (Enemy enemy : current.getEnemyArrayList()) {
            if (enemy.getEnemyName().equalsIgnoreCase(enemyName)) {
                return enemy;
            }
        }
        return null; // if no enemy is found
    }
}


