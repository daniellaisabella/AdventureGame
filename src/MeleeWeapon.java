public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String itemName, String itemDescription, int damage) {
        super(itemName, itemDescription, damage);
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
    public boolean canUse() {
        return true; // Melee weapons can always be used
    }
    @Override
    public int getAmmo() {
        return -1;
    }

}
