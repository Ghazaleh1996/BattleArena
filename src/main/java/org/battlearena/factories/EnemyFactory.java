package org.battlearena.factories;

import org.battlearena.enemies.Enemy;
import org.battlearena.enemies.individualenemy.Ogre;
import org.battlearena.enemies.individualenemy.Zombie;
import org.battlearena.enemies.strategy.AggressiveStrategy;
import org.battlearena.enemies.strategy.ConfuseStrategy;
import org.battlearena.enemies.strategy.MultiTargetAttackStrategy;
import org.battlearena.levels.Difficulty;

import java.util.ArrayList;
import java.util.List;

public class EnemyFactory {
    public static List<Enemy> createEnemies(Difficulty difficulty) {
        List<Enemy> enemies = new ArrayList<>();

        switch (difficulty) {
            case EASY -> {
                Zombie zombie = new Zombie(12, 1);
                zombie.setStrategy(new AggressiveStrategy());
                Ogre ogre = new Ogre(14, 2);
                ogre.setStrategy(new MultiTargetAttackStrategy());
                enemies.add(zombie);
                enemies.add(ogre);
            }
            case MEDIUM -> {
                Zombie zombie = new Zombie(16, 2);
                zombie.setStrategy(new AggressiveStrategy());
                Ogre ogre = new Ogre(20, 3);
                ogre.setStrategy(new MultiTargetAttackStrategy());
                enemies.add(zombie);
                enemies.add(ogre);
                // ✅ Extensibility: new strategy used without modifying Ogre/Zombie
                Zombie confusedZombie = new Zombie(10, 1);
                confusedZombie.setStrategy(new ConfuseStrategy());
                enemies.add(confusedZombie);
            }
            case HARD -> {
                Zombie zombie = new Zombie(20, 3);
                zombie.setStrategy(new AggressiveStrategy());
                Ogre ogre = new Ogre(24, 5);
                ogre.setStrategy(new MultiTargetAttackStrategy());
                enemies.add(zombie);
                enemies.add(ogre);
            }
        }

        return enemies;
    }
}
