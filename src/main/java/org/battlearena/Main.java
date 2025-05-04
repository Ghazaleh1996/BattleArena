package org.battlearena;

import org.battlearena.bonuses.IBonus;
import org.battlearena.enemies.Enemy;
import org.battlearena.factories.BonusFactory;
import org.battlearena.factories.EnemyFactory;
import org.battlearena.factories.ObstacleFactory;
import org.battlearena.factories.TitanHeroFactory;
import org.battlearena.heros.Hero;
import org.battlearena.levels.Difficulty;
import org.battlearena.levels.Level;
import org.battlearena.levels.LevelManager;
import org.battlearena.obstacles.IObstacle;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Difficulty difficulty = Difficulty.MEDIUM;

        List<Hero> heroes = TitanHeroFactory.createHeroes(difficulty);
        List<Enemy> enemies = EnemyFactory.createEnemies(difficulty);
        List<IBonus> bonuses = BonusFactory.createBonuses(difficulty);
        List<IObstacle> obstacles = ObstacleFactory.createObstacles(difficulty);


        Level level1 = new Level(1,
                EnemyFactory.createEnemies(difficulty),
                BonusFactory.createBonuses(difficulty),
                ObstacleFactory.createObstacles(difficulty),
                difficulty);
        Level level2 = new Level(2,
                EnemyFactory.createEnemies(difficulty),
                BonusFactory.createBonuses(difficulty),
                ObstacleFactory.createObstacles(difficulty),
                difficulty);
        Level level3 = new Level(3,
                EnemyFactory.createEnemies(difficulty),
                BonusFactory.createBonuses(difficulty),
                ObstacleFactory.createObstacles(difficulty),
                difficulty);

        LevelManager manager = new LevelManager(List.of(level1, level2, level3));


        try {
            manager.runLevels(heroes);
        } catch (Exception e) {
            System.out.println(" Unexpected error: " + e.getMessage());
        }
    }
}