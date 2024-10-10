public class RangedWeapon extends Weapon {

    // To print the weapons name, when trying to equip and fire I need Override  ToString method:
    @Override
    public String toString() {
        return getItemName();
    }

    private int ammo;//number of ammo available

    // CONSTRUCTOR - calling the parent class Item //
    public RangedWeapon(String itemName, String itemDescription, int damage, int ammo) {
        super(itemName, itemDescription, damage);
        this.ammo = ammo; // initialize with starting ammo
    }


    @Override
    // Method to decrease ammo when firing
    public String attack() {
        if (ammo > 0) {
            ammo--; //use 1 ammo per shot, decrease count by 1
            return "shooting with " + getItemName() + ". Ammo left: " + ammo;
        } else {
            return "Out of ammo!";
        }

    }

    @Override
    public boolean canUse() {
        return ammo > 0; // Can only use if there are remaining shots
    }

    @Override
    public int getAmmo() {
        return ammo;//return current ammo count
    }

}

