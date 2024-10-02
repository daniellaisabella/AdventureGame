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

    public void addItems(String itemName, String itemDescription) {
        itemArrayList.add(new Item(itemName, itemDescription));// new item object refers ti Item class
    }


    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    @Override
    public String toString() {
        return "You are currently in " + name + ". " + description + ". Here you can find" + itemArrayList;
    }

}


//Både Room og Player skal have en ArrayList af Item-objekter, og metoder til at tilføje og fjerne items,
// samt en metode til at få hele listen af items.