// *** CONTROLLER ***//

public class Adventure {
    private Room current;

    // *** Constructor ***//
    public Adventure() {
        this.buildUniverse();
    }

    private void buildUniverse() {
        Room room1 = new Room("Room 1", "Description of room 1");
        Room room2 = new Room("Room 2", "Description of room 2");
        Room room3 = new Room("Room 3", "Description of room 3");
        Room room4 = new Room("Room 4", "Description of room 4");
        Room room5 = new Room("Room 5", "Description of room 5");
        Room room6 = new Room("Room 6", "Description of room 6");
        Room room7 = new Room("Room 7", "Description of room 7");
        Room room8 = new Room("Room 8", "Description of room 8");
        Room room9 = new Room("Room 9", "Description of room 9");

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

    public String moveRoom(String command) {
        String result;

        switch (command.toLowerCase()) {
            case "go north", "north", "n":
                if(this.current.getNorth()!=null) { //Checking if there is a neighbour north
                    current = current.getNorth();
                    result = current.toString();
                }else{
                    result = "Invalid command. Try again or ask for help"; //if no neighbour return (after switch scope) String type result
                }
                break;
            case "go east", "east", "e":
                if(this.current.getEast()!=null){
                current = current.getEast();
                result = current.toString();
                }else{
                    result = "Invalid command. Try again or ask for help";
                }
                break;
            case "go west", "west", "w":
                if(this.current.getWest()!=null){
                current = current.getWest();
                result = current.toString();
                }else{
                    result = "Invalid command. Try again or ask for help";
                }
                break;
            case "go south", "south", "s":
                if(this.current.getSouth()!=null){
                current = current.getSouth();
                result = current.toString();
                }else{
                    result = "Invalid command. Try again or ask for help";
                }
                break;
            case "look":
                result = current.getName();// getting the name of the current room
                break;
            case "help":
                result = "Choose your direction or look around ... ";
                break;

            default:
                result = "unknown command";//if input doesn't match the options
        }
        return result;
    }
    // *** GET *** //
    public Room getCurrentRoom() {
        return this.current;

    }

}


