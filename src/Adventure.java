//*** CONTROLLER ***//

//Adventure calling Map before game start
public class Adventure {
    private Map map;
    private Player player;

    public Adventure(){
        map=new Map();
        player = new Player(map.getRoom());
    }

    public Player getPlayer(){
        return player;
    }

}


