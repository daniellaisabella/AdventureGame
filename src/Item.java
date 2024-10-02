public class Item {

    private String itemName;
    private String itemDescription;


    // *** CONSTRUCTOR *** //
    public Item(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;

    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }


}
