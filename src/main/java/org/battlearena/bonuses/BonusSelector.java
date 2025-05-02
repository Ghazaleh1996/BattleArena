package org.battlearena.bonuses;

import org.battlearena.heros.Hero;

public class BonusSelector {
    public static IBonus chooseBonus(Hero hero) {
        double roll = Math.random();

        if (roll < 0.5) {
            if (hero.gethealthPointsRemaining() < 5) {
                int boost = 2 + (int)(Math.random() * 3);
                return new HealthBoost(boost);
            } else {
                int boost = 1 + (int)(Math.random() * 2);
                return new DamageBoost(boost);
            }
        } else {
            if (Math.random() < 0.5) {
                return new HealthBoost(2 + (int)(Math.random() * 3));
            } else {
                return new DamageBoost(1 + (int)(Math.random() * 2));
            }
        }
    }
}
