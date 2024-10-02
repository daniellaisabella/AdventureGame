// *** Denne klasse holder styr på hvor spilleren er ***//

import java.util.ArrayList;

public class Player {

    // *** Instance variables *** //
    private Room current;//This variable keeps track of the current room where the player is located
    private int health;

    private ArrayList<Item> inventory;

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
            current += item.toString() + ".\n";
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

//        for (Item item : inventory ) {
//            if(item.getItemName().equalsIgnoreCase(itemName)){// Checking in inventory for the Food
//            if (item instanceof Food) {
//                itemEat= (Food) item; //Assign food item
//                health += ((Food) itemEat).getHealthGain(); //Update health
//                inventory.remove(itemEat);//Remove from inventory list
//            }
//                return "You are now eating the " + item.getItemName() + " from your inventory list" + "\nHealth gained: " + ((Food) itemEat).getHealthGain();
//            } else {
//                return " You cannot eat the " + item.getItemName();
//            }
//        }
//        for (Item item : current.getItemArrayList()) { // Checking in current room for the Food
//            if (item.getItemName().equalsIgnoreCase(itemName)) {
//                if (item instanceof Food) {
//                    itemEat= (Food) item; //Assign food item
//                    health += ((Food) itemEat).getHealthGain(); //Update health
//                    current.getItemArrayList().remove(itemEat);
//                    return "You are now eating the " + item.getItemName() +  "\nHealth gained: " + ((Food) itemEat).getHealthGain();
//                } else {
//                    return " You cannot eat the " + item.getItemName();
//                }
//            }
//        }
//
//        return "The food you wish to eat is not in your inventory or in the forest area ...";
//    }

}


