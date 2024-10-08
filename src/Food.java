

public class Food extends Item{
private int healthGain;


    public Food(String itemName, String itemDescription, int healthGain){
        super(itemName,itemDescription);
        this.healthGain=healthGain;

    }

    public int getHealthGain() {
        return healthGain;
    }

    @Override
    public String toString() {
        return getItemName();
    }

}
