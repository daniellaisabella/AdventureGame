public class Item {

    /*Start med at lave Item klassen, og tilføj en liste til items til Room klassen.
    Når I opretter og forbinder rummene, så opret også nogle items,
    og læg i de forskellige rum.*/

    private String itemName;
    private String itemDescription;

    public Item(String itemName, String itemDescription){
        this.itemName=itemName;
        this.itemDescription=itemDescription;

    }

    public String getItemName(){
        return itemName;
    }

    public String getItemDescription(){
        return itemDescription;
    }


}
