// *** Denne klasse holder styr på hvor spilleren er ***//

import java.util.ArrayList;

public class Player {

    //Instance variables
    private Room current;//This variable keeps track of the current room where the player is located
    private Item currentItem;

    private ArrayList<Item> inventory;


    //*** Constructor ***//
    public Player(Room currentRoom) {
        current = currentRoom;//The constructor initializes the player’s starting position. It takes a Room object as a parameter (firstRoom) and sets the roomPLayerIsIn to this starting room. This means when a player is created, they start in the firstRoom.
        inventory = new ArrayList<>();


    }


    // *** GET *** //
    public Room getCurrentRoom() {
        return current;

    }

    public Item getItem() {
        return currentItem;
    }

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
            if(item.getItemName().equalsIgnoreCase(itemName)){
                itemDrop=item;
                break;

        }
    }
        if(itemDrop!=null) {
            inventory.remove(itemDrop);
            current.getItemArrayList().add(itemDrop);
            return "You have dropped the " + itemDrop.getItemName();
        }else{
            return "You don't posses the item you wish to drop";
        }
}


//lav take og drop item her


//lav get item array list
//
// public String showItems(){
//        return ArrayList<Item> inventory;
//
//    }


}
// Både Room og Player skal have en ArrayList af Item-objekter,
// og metoder til at tilføje og fjerne items, samt en metode til at få hele listen af items.

//Player skal også have metoder til dropItem og takeItem, der henholdsvis flytter et item fra det
// rum player er i, til player-objektet selv, og omvendt.