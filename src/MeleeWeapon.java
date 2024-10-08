public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String itemName, String itemDescription) {
        super(itemName, itemDescription);
    }

    @Override
    public String toString() {
        return getItemName();
    }

    @Override
    public String attack() {
        return "swinging " + getItemName();
    }

    @Override
    public int getAmmo() {
        return -1;
    }
}
