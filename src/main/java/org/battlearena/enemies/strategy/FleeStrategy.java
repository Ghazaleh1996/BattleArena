package org.battlearena.enemies.strategy;

import org.battlearena.enemies.strategy.AttackStrategy;
import org.battlearena.heros.Hero;
import org.battlearena.enemies.Enemy;

import java.util.List;

public class FleeStrategy implements AttackStrategy {
    @Override
    public void execute(Enemy enemy, List<Hero> heroes) {
        System.out.println(" FleeStrategy: " + enemy.getClass().getSimpleName() + " tries to flee and skips attack.");

    }
}
