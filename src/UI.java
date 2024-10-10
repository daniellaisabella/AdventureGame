import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    // Method for menu display - not necessary, could just make sout
    public void displayMenu() {
        System.out.println();
        System.out.println("Welcome to the forest ... ");
        System.out.println("If you [search] the forest, you will find items, weapon, and food that you can choose to [eat]. You might meet enemies to [attack] but remember to [equip] your weapon first");
        System.out.println("Options: \n[1] Go north, Go east, Go west, Go south | Type: n, e, w, s \n[2] Check inventory list | Type: inv\n[3] Search for items | Type: search  \n[4] Take item | Type: take \n[5] Drop item | Type: drop \n[6] Help (?) | Type: help\n[7] Exit Game ;) | Type: exit");
        System.out.println();
    }

    // *** START Method *** // - reading user commands and passing them to the Adventure class.
    public void start() {

        Scanner input = new Scanner(System.in); //This is the user scanner
        Adventure adventure = new Adventure(); //This is the ref to integrate with Adventure class

        boolean runGame = true; // for looping or exit the game
        displayMenu(); // Consider not to make it a method? - just make a sout. whatever for now:)

        //While loop for menu and switch method for player options in game
        while (runGame) {
            System.out.println();
            System.out.println("Choose your destiny ...");

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
                    case "inventory", "inv":
                        if (adventure.checkInventory().isEmpty()) {
                            System.out.println("You have not collected any items ... ");
                        } else {
                            System.out.println(adventure.checkInventory());
                        }
                        break;
                    case "look":
                        System.out.println("You are " + adventure.getPlayer().getCurrentRoom().getName());
                        System.out.println(adventure.getPlayer().getCurrentRoom().getDescription());
                        ArrayList<Enemy> enemiesInForest = adventure.getPlayer().getCurrentRoom().getEnemyArrayList();
                        if (enemiesInForest.isEmpty()) {
                            System.out.println("No enemies are seen");
                        } else {
                            System.out.println("Look out! enemy nearby know as the ");
                            for (Enemy enemy : enemiesInForest) {
                                if (enemy.isAlive()) {
                                    System.out.println(enemy.getEnemyName() + "." + enemy.getEnemyDesc() + "\n(Enemy health: " + enemy.getHealthLevel() + ")");
                                }
                            }
                        }
                        break;
                    case "search":
                        // Get the items in the current room
                        ArrayList<Item> itemsInRoom = adventure.getPlayer().getCurrentRoom().getItemArrayList();
                        // Check if there are items in the room
                        if (!itemsInRoom.isEmpty()) {
                            System.out.println("Items in the area:");
                            for (Item roomItem : itemsInRoom) {
                                System.out.println("- " + roomItem.getItemName() + ": " + roomItem.getItemDescription());
                            }
                        } else {
                            System.out.println("There are no items in this room.");
                        }
                        break;
                    case "take":
                        System.out.println("Which item do you wish to collect?");
                        String takeItemName = input.nextLine().trim();
                        String takeResult = adventure.getPlayer().takeItem(takeItemName); // Call takeItem method from Player
                        System.out.println(takeResult);// Print the result
                        break;
                    case "drop":
                        System.out.println("Which item do you want to drop?");
                        String dropItemName = input.nextLine().trim();
                        String dropResult = adventure.getPlayer().dropItem(dropItemName); // Call dropItem method
                        System.out.println(dropResult); // Print the result
                        break;

                    case "eat":
                        System.out.println("What food do you want to eat?");
                        String eatItemName = input.nextLine().trim();
                        String eatResult = adventure.getPlayer().eatItem(eatItemName); // Call eatItem method from Player
                        System.out.println(eatResult); // Ptint result
                        break;
                    case "equip":
                        System.out.println("What weapon would you like to equip?");
                        String equipWeaponName = input.nextLine().trim();
                        String equipResult = adventure.getPlayer().equipWeapon(equipWeaponName);
                        System.out.println(equipResult);
                        break;
                    case "attack":
                        System.out.println("Who do you want to attack? (Press ENTER to attack the nearest enemy)");
                        String enemyName = input.nextLine().trim(); // Prompt for enemy name after entering "attack"
                        if (!enemyName.isEmpty()) {
                            // Attack the specified enemy
                            System.out.println(adventure.getPlayer().attack(enemyName));
                        } else {
                            // Attack the nearest enemy if no name provided
                            System.out.println(adventure.getPlayer().attack(null));
                        }
                        break;
                    case "health":
                        System.out.println("Health: " + adventure.getPlayer().getHealth());
                        break;
                    case "help":
                        System.out.println("Choose your direction or look around ... ");
                        break;
                    default:
                        System.out.println("unknown command");//if input doesn't match the options
                }
                if (!command.equalsIgnoreCase("search") && !command.equalsIgnoreCase("look") && !command.equalsIgnoreCase("take") && !command.equalsIgnoreCase("drop") && !command.equalsIgnoreCase("eat") && !command.equalsIgnoreCase("equip") && !command.equalsIgnoreCase("attack") && !command.equalsIgnoreCase("health")) {
                    System.out.println("You are " + adventure.getPlayer().getCurrentRoom().getName());//When player has moved, the position is printed
                    System.out.println(adventure.getPlayer().getCurrentRoom().getDescription());
                    ArrayList<Enemy> enemiesInForest = adventure.getPlayer().getCurrentRoom().getEnemyArrayList();
                    if (enemiesInForest.isEmpty()) {
                        System.out.println("No enemies are seen");
                    } else {
                        System.out.println("Look out! enemy nearby: ");
                        for (Enemy enemy : enemiesInForest) {
                            if (enemy.isAlive()) {
                                System.out.println(enemy.getEnemyName() + "." + "\n- " + enemy.getEnemyDesc() + "\n(Enemy health: " + enemy.getHealthLevel() + ")");
                            }
                        }
                    }
                }


            }

        }

    }
}



