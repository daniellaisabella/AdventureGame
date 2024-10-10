import java.util.ArrayList;

public class Room {

    //*** ATTRIBUTES ***//
    private String name;
    private String description;
    private ArrayList<Item> itemArrayList = new ArrayList<>();
    private ArrayList<Enemy> enemyArrayList = new ArrayList<>();


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

    public void addItems(Item item) {
        if (item != null) {
            itemArrayList.add(item);// new item object refers ti Item class
        }
    }


    public ArrayList<Item> getItemArrayList() {
        return itemArrayList;
    }

    // *** ADD & GET ENEMY METHODS *** //
    public void addEnemy(Enemy enemy){
        enemyArrayList.add(enemy);
    }
    // Method to remove an enemy from the room
    public void removeEnemy(Enemy enemy) {
        enemyArrayList.remove(enemy);
    }

    public ArrayList<Enemy> getEnemyArrayList() {
        return enemyArrayList;
    }
    @Override
    public String toString() {
        return "You are currently in " + name + ". " + description + ". Here you can find" + itemArrayList;
    }

}
