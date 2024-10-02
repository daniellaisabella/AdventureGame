// *** CREATOR *** //

// Opretter rummene og kæder dem sammen - spillets map
// Denne klasse kaldes af CONTROLLER inden spillet går i gang
public class Map {

    private Room current;

    public Room getRoom() {
        return current;
    }



    // *** Constructor ***//
    public Map() {
        buildUniverse();
    }

    public void buildUniverse() {
        Room room1 = new Room("at the forest entrance", "Do you want to continue into the forest?");
        Room room2 = new Room("on a mysterious path", "You might find a directory tool");
        Room room3 = new Room("in an open forest area", "It's cold and windy");
        Room room4 = new Room("at a sticky cold bog", "Be careful not to get stuck");
        Room room5 = new Room("Room 5", "Description of room 5");
        Room room6 = new Room("at a creepy small cottage", "Do not get seen, but consider looking at their belongings ...");
        Room room7 = new Room("at a lake", "Smart players would look for food");
        Room room8 = new Room("down in a big hole", "look for tools to get out");// make a lock, you can only exit room 8 with ladder?
        Room room9 = new Room("at a slightly lit bonfire", "Someone was here ... ");

        room1.addItems("Mushrooms", "Family of edible mushrooms");
        room1.addItems("Blanket", "Wool blanket");
        room2.addItems("compass", "Good use if you want out");
        //no items in room 3
        room4.addItems("Stick", "Use this stick to not get stuck");
        room5.addItems("item5", "item5Desc");
        room6.addItems("Apple pie", "Be careful, who baked this pie?");
        room6.addItems("Water tank", "Find a cup to collect water");
        room7.addItems("Salmon", "It's already dead, \nare you hungry? take a chance ...");
        room7.addItems("Long stick and line", "With this you can fish a some fresh food");
        room8.addItems("Ladder", "You want to get out, right?");
        room9.addItems("Dry wood", "To make fire");


        room1.setNeighbour(null, room2, null, room4);
        room2.setNeighbour(null, room3, room1, null);
        room3.setNeighbour(null, null, room2, room6);
        room4.setNeighbour(room1, null, null, room7);
        room5.setNeighbour(null, null, null, room8);
        room6.setNeighbour(room3, null, null, room9);
        room7.setNeighbour(room4, room8, null, null);
        room8.setNeighbour(room5, room9, room7, null);
        room9.setNeighbour(room6, null, room8, null);

        current = room1;
    }


}
