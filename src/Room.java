public class Room {

    //*** ATTRIBUTES ***//
    private final String name;
    private final String description;

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
    public void setNeighbour (Room north, Room east, Room west, Room south) {
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

    public Room getNorth (){
        return north;
    }
    public Room getEast (){
        return east;
    }
    public Room getWest (){
        return west;
    }
    public Room getSouth (){
        return south;
    }

    @Override
    public String toString(){
        return "You are currently in " + name + "."+"\nDescription: " + description;
    }
}

