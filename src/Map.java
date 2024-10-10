// *** CREATOR *** //
// Creator is called by Controller before the game starts.

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
        Room room2 = new Room("on a mysterious path", "Go back or continue?");
        Room room3 = new Room("in an open forest area", "It's cold and windy");
        Room room4 = new Room("at a sticky cold bog", "Be careful not to get stuck");
        Room room5 = new Room("in a cold wet cave", "There is one entrance, and one way out ...");
        Room room6 = new Room("at a creepy small cottage", "Do not get seen, but consider looking at their belongings ...");
        Room room7 = new Room("at a lake", "Smart players would look for food");
        Room room8 = new Room("down in a big hole", "look for tools to get out");// make a lock, you can only exit room 8 with ladder?//Extra del 1
        Room room9 = new Room("at a slightly lit bonfire", "Someone was here ... ");

        Food mushrooms = new Food("mushrooms", "Family of edible mushrooms", 80);
        room1.addItems(mushrooms);

        Item blanket = new Item("blanket", "Wool blanket");
        room1.addItems(blanket);

        Item compass = new Item("compass", "Good use if you want out");
        room2.addItems(compass);

        //no items in room 3
        Item stick = new Item("stick", "Use stick to not get stuck");
        room4.addItems(stick);

        RangedWeapon pistol = new RangedWeapon("pistol", "bullet will hit you hard",120, 30);
        Enemy rat = new Enemy("Rat", "Stinky talking rat", 15, pistol);
        room4.addEnemy(rat);

        Food magicMoss = new Food("Magic moss", "The most nutritous eating found in the forest", 70);
        room5.addItems(magicMoss);

        MeleeWeapon mudThrow = new MeleeWeapon("Mud", "stinky mud will make you suffer", 1); // MeleeWeapon for enemy
        Enemy troll = new Enemy("Forest Troll", "Throwing mud", 5, mudThrow); // new enemy
        room5.addEnemy(troll); // add enemy to room 5

        RangedWeapon mudPistol = new RangedWeapon("Mud pistol", "mud will hit you hard",1, 5);
        Enemy badger = new Enemy("Badger", "Stinky talking badger", 15, mudPistol);
        room5.addEnemy(badger);

        Food applePie = new Food("apple pie", "Be careful, who baked this pie?",-30);
        room6.addItems(applePie);

        Food waterTank = new Food("trash", "You must be hungry ... ",-40);
        room6.addItems(waterTank);

        RangedWeapon rifle = new RangedWeapon("rifle" ,"lightweight riffle", 5, 5);
        room6.addItems(rifle);

        Food salmon = new Food("salmon", "It's already dead, \nare you hungry? take a chance ...",-60);
        room7.addItems(salmon);

        Item stickLine = new Item("long stick and line", "With this you can fish a some fresh food");
        room7.addItems(stickLine);

        Item ladder = new Item("ladder", "You want to get out, right?");
        room8.addItems(ladder);

        MeleeWeapon machete = new MeleeWeapon ("machete","Good for getting through the forest, or defending yourself ...", 5);
        room9.addItems(machete);

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
