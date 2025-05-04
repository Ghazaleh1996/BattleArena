package org.battlearena.enemies.strategy;

import org.battlearena.enemies.Enemy;
import org.battlearena.heros.Hero;

import java.util.List;

/**
 * A strategy representing a confused enemy that skips its turn.
 * Demonstrates extensibility by adding new behavior without modifying existing code.
 */
public class ConfuseStrategy implements AttackStrategy {
    @Override
    public void execute(Enemy enemy, List<Hero> heroes) {
        System.out.println("😵 " + enemy.getClass().getSimpleName() + " is confused and skips its turn.");
    }
}
