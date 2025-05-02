package org.battlearena.heros;

import org.battlearena.bonuses.IBonus;
import org.battlearena.heros.weapons.Weapon;

public class Hero implements IHero {
    private String name;
    private int healthPoints;
    private int healthPointsRemaining;
    private int attackDamage;
    private boolean isWeaponEquipped = false;
    private Weapon weapon;

    public Hero(String name, int healthPoints, int attackDamage) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.healthPointsRemaining = healthPoints;
        this.attackDamage = attackDamage;
    }

    public int gethealthPoints() { return healthPoints; }
    public int gethealthPointsRemaining() { return healthPointsRemaining; }
    public int getAttackDamage() { return attackDamage; }
    public void sethealthPointsRemaining(int hp) { this.healthPointsRemaining = hp; }
    public Weapon getWeapon() { return weapon; }
    public void setWeapon(Weapon weapon) { this.weapon = weapon; }
    public void equipWeapon() {
        if (getWeapon() != null && !isWeaponEquipped()) {
            setAttackDamage(getAttackDamage() + weapon.getAttackIncrease());
            setWeaponEquipped(true);
        }
    }
    public boolean isWeaponEquipped() { return isWeaponEquipped; }
    public void setWeaponEquipped(boolean value) { this.isWeaponEquipped = value; }
    public void setAttackDamage(int attackDamage) { this.attackDamage = attackDamage; }
    public void attack() {
        System.out.println("Hero " + name + " attacks for " + attackDamage + " damage");
    }
    public void receiveBonus(IBonus bonus) { bonus.apply(this); }
    public String getName() { return name; }
    public void receiveBonus(int bonusHealth) {
        this.healthPointsRemaining += bonusHealth;
        System.out.println("🩺 Bonus applied via overloading: +" + bonusHealth + " HP");
    }

}
