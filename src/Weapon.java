public abstract class Weapon extends Item {
    //attribute to check if weapon is equipped
    private boolean equipped;

    public Weapon(String itemName, String itemDescription) {
        super(itemName, itemDescription);
        this.equipped = false; // so initially it is not equipped
    }

    public void equip() {
        this.equipped = true;
    }

    public boolean isEquipped() {
        return equipped; //check if weapon is equipped
    }

    public abstract String attack();

    // Method to get ammo count
    public int getAmmo() {
        return 0;
    }
}


