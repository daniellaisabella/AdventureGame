

public class Food extends Item{
private int healthGain;


    public Food(String itemName, String itemDescription, int healthGain){
        super(itemName,itemDescription);
        this.healthGain=healthGain;
        String food = null;
    }

    public int getHealthGain() {
        return healthGain;
    }

}
