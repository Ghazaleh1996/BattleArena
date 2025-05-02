package org.battlearena.enemies.strategy;

import org.battlearena.enemies.strategy.AttackStrategy;
import org.battlearena.heros.Hero;
import org.battlearena.enemies.Enemy;

import java.util.Comparator;
import java.util.List;

public class DefensiveStrategy implements AttackStrategy {
    @Override
    public void execute(Enemy enemy, List<Hero> heroes) {
        Hero target = heroes.stream()
                .filter(h -> h.gethealthPointsRemaining() > 0)
                .min(Comparator.comparingInt(Hero::getAttackDamage))
                .orElse(null);
        if (target != null) {
            enemy.attack(target);
        }
    }
}