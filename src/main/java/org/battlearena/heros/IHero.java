package org.battlearena.heros;

import org.battlearena.heros.weapons.Weapon;

public interface IHero {
    String getName();
    int gethealthPoints();
    int gethealthPointsRemaining();
    void sethealthPointsRemaining(int healthPointsRemaining);
    int getAttackDamage();
    Weapon getWeapon();
    void setWeapon(Weapon weapon);
    void equipWeapon();
    boolean isWeaponEquipped();
    void setWeaponEquipped(boolean isWeaponEquipped);
    void setAttackDamage(int attackDamage);
    void attack();
}
