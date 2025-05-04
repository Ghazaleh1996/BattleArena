package org.battlearena.bonuses;

import org.battlearena.heros.Hero;

public class HealthBoost implements IBonus {
    private int boostAmount;

    public HealthBoost(int boostAmount) {
        this.boostAmount = boostAmount;
    }

    @Override
    public void apply(Hero hero) {
        int newHealth = hero.gethealthPointsRemaining() + boostAmount;
        hero.sethealthPointsRemaining(newHealth);
        System.out.println(" Health Boost applied: +" + boostAmount + " HP");
    }

    @Override
    public String getBonusName() {
        return "Health Boost";
    }
}
