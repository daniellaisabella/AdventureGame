//Denne klasse holder styr på hvor spilleren er

// Spiller-objekt, der kender spillerens position. Objektet er også det, som flytter sig rundt

public class Player {

    //Instance variable of type Room
    private Room current;//This variable keeps track of the current room where the player is located

   //*** Constructor ***//
    public Player(Room firstRoom) {
        current = firstRoom;//The constructor initializes the player’s starting position. It takes a Room object as a parameter (firstRoom) and sets the roomPLayerIsIn to this starting room. This means when a player is created, they start in the firstRoom.
    }

    public void moveToRoomNorth() {

        if (current.getNorth()!= null) {
            current = current.getNorth();
        } else {
            System.out.println("There is no room to the north.");
        }
    }

    public void moveToRoomEast() {

        if (current.getEast()!= null) {
            current = current.getEast();
        } else {
            System.out.println("There is no room to the east.");
        }
    }

    public void moveToRoomWest() {

        if (current.getWest()!= null) {
            current = current.getWest();
        } else {
            System.out.println("There is no room to the west.");
        }
    }

    public void moveToRoomSouth() {

        if (current.getSouth()!= null) {
            current = current.getSouth();
        } else {
            System.out.println("There is no room to the south.");
        }
    }

    // *** GET *** //
    public Room getCurrentRoom() {
        return current;

    }
    /*
    public String showItems(){
        return current.
    }

     */

    //lav get item array list
}
// Både Room og Player skal have en ArrayList af Item-objekter,
// og metoder til at tilføje og fjerne items, samt en metode til at få hele listen af items.

//Player skal også have metoder til dropItem og takeItem, der henholdsvis flytter et item fra det
// rum player er i, til player-objektet selv, og omvendt.