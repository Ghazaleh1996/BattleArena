package org.battlearena.enemies.strategy;

import org.battlearena.heros.Hero;
import org.battlearena.enemies.Enemy;

import java.util.List;

public interface AttackStrategy {
    void execute(Enemy enemy, List<Hero> heroes);
}