//*** CONTROLLER ***//

//Adventure calling Map before game start
public class Adventure {
    private Map map;
    private Player player;
    private Item item;

    public Adventure(){
        map=new Map();
        player = new Player(map.getRoom());

    }

    public Player getPlayer(){
        return player;
    }


    public String checkInventory(){
        return player.checkInventory();
    }
}


