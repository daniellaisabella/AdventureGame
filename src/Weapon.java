public abstract class Weapon extends Item {
    //attribute to check if weapon is equipped
    private boolean equipped;
    private int damage;

    public Weapon(String itemName, String itemDescription, int damage) {
        super(itemName, itemDescription);
        this.equipped = false; // so initially it is not equipped
        this.damage = damage;
    }

    public void equip() {
        this.equipped = true;
    }

    public abstract boolean canUse();

    public abstract String attack();

    // Method to get ammo count
    public int getAmmo() {
        return 0;
    }

    public int getDamage() {
        return damage;
    }
}


