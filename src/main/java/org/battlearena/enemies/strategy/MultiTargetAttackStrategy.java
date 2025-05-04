package org.battlearena.enemies.strategy;

import org.battlearena.heros.Hero;
import org.battlearena.enemies.Enemy;

import java.util.List;

public class MultiTargetAttackStrategy implements AttackStrategy {
    @Override
    public void execute(Enemy enemy, List<Hero> heroes) {
        enemy.attack(heroes);
    }
}
