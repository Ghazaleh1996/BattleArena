package org.battlearena.bonuses;

import org.battlearena.heros.Hero;

public class DamageBoost implements IBonus {
    private int boostAmount;

    public DamageBoost(int boostAmount) {
        this.boostAmount = boostAmount;
    }

    @Override
    public void apply(Hero hero) {
        hero.setAttackDamage(hero.getAttackDamage() + boostAmount);
        System.out.println("🗡️ Damage Boost applied: +" + boostAmount + " Attack");
    }

    @Override
    public String getBonusName() {
        return "Damage Boost";
    }
}
