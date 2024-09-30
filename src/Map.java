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
        Room room1 = new Room("Room 1", "Description of room 1");
        Room room2 = new Room("Room 2", "Description of room 2");
        Room room3 = new Room("Room 3", "Description of room 3");
        Room room4 = new Room("Room 4", "Description of room 4");
        Room room5 = new Room("Room 5", "Description of room 5");
        Room room6 = new Room("Room 6", "Description of room 6");
        Room room7 = new Room("Room 7", "Description of room 7");
        Room room8 = new Room("Room 8", "Description of room 8");
        Room room9 = new Room("Room 9", "Description of room 9");

        room1.addItems("item1", "item1Desc");
        room1.addItems("item1", "item1Desc");
        room2.addItems("item2", "item2Desc");
        //no items in room 3
        room4.addItems("item4", "item4Desc");
        room5.addItems("item5", "item5Desc");
        room6.addItems("item6", "item6Desc");
        room6.addItems("item6", "item6Desc");
        room7.addItems("item7", "item7Desc");
        room7.addItems("item7", "item7Desc");
        room7.addItems("item7", "item7Desc");
        room8.addItems("item8", "item8Desc");
        room9.addItems("item9", "item1Desc");
        room9.addItems("item9", "item1Desc");


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
