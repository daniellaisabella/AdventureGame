// *** Denne klasse holder styr på hvor spilleren er ***//

import java.util.ArrayList;

public class Player {

    // *** Instance variables *** //
    private Room current;//This variable keeps track of the current room where the player is located
    private ArrayList<Item> inventory;
    private int health;

    // *** Constructor *** //
    public Player(Room currentRoom) {
        current = currentRoom;//The constructor initializes the player’s starting position. It takes a Room object as a parameter (firstRoom) and sets the roomPLayerIsIn to this starting room. This means when a player is created, they start in the firstRoom.
        inventory = new ArrayList<>();
        health = 100;
    }

    // *** GET CURRENT ROOM  *** //
    public Room getCurrentRoom() {
        return current;
    }

    // *** GET HEALTH *** //
    public int getHealth() {
        return this.health;
    }


    // *** USER OPTION METHODS ***//
    public void moveToRoomNorth() {

        if (current.getNorth() != null) {
            current = current.getNorth();
        } else {
            System.out.println("There is no room to the north.");
        }
    }

    public void moveToRoomEast() {

        if (current.getEast() != null) {
            current = current.getEast();
        } else {
            System.out.println("There is no room to the east.");
        }
    }

    public void moveToRoomWest() {

        if (current.getWest() != null) {
            current = current.getWest();
        } else {
            System.out.println("There is no room to the west.");
        }
    }

    public void moveToRoomSouth() {

        if (current.getSouth() != null) {
            current = current.getSouth();
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
            // Update health
            health += itemEat.getHealthGain();
            // Remove the item from inventory or current area
            inventory.remove(itemEat);
            current.getItemArrayList().remove(itemEat);
            return "You are now eating the " + itemEat.getItemName() + ". Health gained: " + itemEat.getHealthGain();
        } else {
            return "The food you wish to eat is not in your inventory or in the forest area...";
        }
    }

    // *** Del 4 *** // - WEAPON

    private Weapon equippedWeapon; // holds a reference to the currently equipped weapon for the player.

    public Weapon getEquippedWeapon(){
        return equippedWeapon; // reeturns currentlu equipped weapon
    }
    //This method of type String (having string parameter, returning a String if weapon is equipped or not),
    // let the player equip weapon from inv based on weaponName
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


    public String attack() {
        if (equippedWeapon != null && equippedWeapon.isEquipped()) {
            String attackResult = equippedWeapon.attack(); // Call the attack method
            return attackResult; // Return the result message
        } else {
            return "You must equip a weapon before attacking!"; // Message if no weapon is equipped
        }
    }
}





