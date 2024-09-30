import java.util.ArrayList;

public class Room {

    //*** ATTRIBUTES ***//
    private final String name;
    private final String description;
    private ArrayList<Item> itemArrayList = new ArrayList<>();

    private Room north;
    private Room east;
    private Room west;
    private Room south;


    //*** CONSTRUCTOR ***//
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //*** METHODS ***//
    public void setNeighbour(Room north, Room east, Room west, Room south) {
        this.north = north;
        this.east = east;
        this.west = west;
        this.south = south;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public Room getSouth() {
        return south;
    }

    public void addItems(String itemName, String itemDescription){
        itemArrayList.add(new Item(itemName, itemDescription));// new item object refers ti Item class
    }

    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    @Override
    public String toString() {
        return "You are currently in " + name + ".";
    }

    // TILFØJ EN LISTE TIL ITEMS I ROOM KLASSEN
//    Item bigMushroom = new Item ("Mushroom", "Big and edible");
//    Item stick = new Item("Stick", "Magical");
//    Item tre = new Item ("tre", "Item tre");
//    Item fire = new Item ("fire", "Item fire");
//    Item fem = new Item ("fem", "Item fem");
//    Item seks = new Item ("seks", "Item seks");
//    Item syv = new Item ("syv", "Item syv");
//    Item otte = new Item ("otte", "Item otte");
//    Item ni = new Item ("ni", "Item ni");


}


//Både Room og Player skal have en ArrayList af Item-objekter, og metoder til at tilføje og fjerne items,
// samt en metode til at få hele listen af items.