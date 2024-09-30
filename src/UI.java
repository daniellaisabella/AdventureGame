import java.util.Scanner;

public class UI {
    // Method for menu display
    public void displayMenu() {
        System.out.println();
        System.out.println("Welcome to the forest!");
        System.out.println();
        System.out.println("Choose your destiny!\n1. Go north \n2. Go east \n3. Go west \n4. Go south \n5. Look around \n6. Help (?) \n7. Exit Game >:( ");
        System.out.println();
    }

    // start Method: reading user commands and passing them to the Adventure class.
    public void start() {

        Scanner input = new Scanner(System.in);

        Adventure adventure = new Adventure();//This is the ref to integrate with Adventure class


        boolean runGame = true;
        displayMenu();

        //While loop for menu and switch method for moving player in direction
        while (runGame) {

            System.out.println("Choose you direction");

            //User's command
            String command = input.nextLine().trim().toLowerCase();

            if (command.equals("exit")) { //If user choose to exit the game
                System.out.println("You chose to exit the forest >:( Goodbye! ... ");
                runGame = false; //Code to exit the game loop

            } else { //if user choose other options than exiting the game

                switch (command.toLowerCase()) {
                    case "go north", "north", "n":
                        adventure.getPlayer().moveToRoomNorth();
                        break;
                    case "go east", "east", "e":
                        adventure.getPlayer().moveToRoomEast();
                        break;
                    case "go west", "west", "w":
                        adventure.getPlayer().moveToRoomWest();
                        break;
                    case "go south", "south", "s":
                        adventure.getPlayer().moveToRoomSouth();
                        break;
                    case "look":
                        System.out.println(adventure.getPlayer().getCurrentRoom().getName());
                        System.out.println(adventure.getPlayer().getCurrentRoom().getDescription());

                        break;
                    case "help":
                        System.out.println("Choose your direction or look around ... ");
                        break;

                    default:
                        System.out.println("unknown command");//if input doesn't match the options
                }

                System.out.println(adventure.getPlayer().getCurrentRoom().getName());//When player has moved, the position is printed
                System.out.println(adventure.getPlayer().getCurrentRoom().getDescription());

            }

        }
    }
}


