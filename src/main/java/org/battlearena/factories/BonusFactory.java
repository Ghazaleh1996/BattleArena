package org.battlearena.factories;
import org.battlearena.bonuses.DamageBoost;
import org.battlearena.bonuses.HealthBoost;
import org.battlearena.bonuses.IBonus;
import org.battlearena.levels.Difficulty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class BonusFactory {
    public static List<IBonus> createBonuses(Difficulty difficulty) {
        List<IBonus> bonuses = new ArrayList<>();
        Random rand = new Random();

        switch (difficulty) {
            case EASY -> {
                bonuses.add(new HealthBoost(2));
                bonuses.add(new DamageBoost(2));
            }
            case MEDIUM -> {
                bonuses.add(new HealthBoost(1));
                bonuses.add(new DamageBoost(1));
            }
            case HARD -> {
                if (rand.nextDouble() < 0.7) {
                    bonuses.add(new DamageBoost(1));

                }
            }
        }

        return bonuses;
    }
}
