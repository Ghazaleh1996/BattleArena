package org.battlearena.heros.weapons;

public class Weapon implements IWeapon {
    private final String weaponType;
    private final int attackIncrease;

    public Weapon(String weaponType, int attackIncrease) {
        this.weaponType = weaponType;
        this.attackIncrease = attackIncrease;
    }

    public String getWeaponType() { return weaponType; }
    public int getAttackIncrease() { return attackIncrease; }
}
