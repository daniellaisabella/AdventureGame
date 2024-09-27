import java.util.Scanner;
public class UI {
    // Method for menu display
    public void displayMenu() {
        System.out.println();
        System.out.println("Welcome to the forest! \nChoose your direction, look around, ask for help or exit ...");
        System.out.println();
        System.out.println("Choose your destiny!\n1. Go north \n2. Go east \n3. Go west \n4. Go south \n5. Look around \n6. Help (?) \n7. Exit Game >:( ");
        System.out.println();
    }

    // start Method: reading user commands and passing them to the Adventure class.
    public void start() {
        Adventure adventure = new Adventure(); //This is the ref to integrate with Adventure class
        Scanner input = new Scanner(System.in);

        boolean runGame = true;
        displayMenu();
        //While loop for menu
        while (runGame) {
            //Players current location
            System.out.println(adventure.getCurrentRoom().getDescription());
            System.out.println("Choose you direction");

            //User's command
            String command = input.nextLine().trim().toLowerCase();

            if (command.equals("exit")) { //If user choose to exit the game
                System.out.println("You chose to exit the forest >:( Goodbye! ... ");
                runGame = false; //Code to exit the game loop

            } else { //if user choose other options than exiting the game
                String play = adventure.moveRoom(command);
                System.out.println(play); //and printing the moveRoom method from adventure

            }

        }
    }

}

