//*** CONTROLLER ***//
//Adventure calling Map(Creator) before game start.

public class Adventure {
    private Map map;
    private Player player;

    public Adventure(){
        map=new Map();
        player = new Player(map.getRoom(), 100);
    }

    public Player getPlayer(){
        return player;
    }

    public String checkInventory(){
        return player.checkInventory();
    }
}


