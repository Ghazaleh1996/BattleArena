package org.battlearena.levels;

import org.battlearena.heros.Hero;
import org.battlearena.enemies.Enemy;
import org.battlearena.bonuses.IBonus;
import org.battlearena.obstacles.IObstacle;
import org.battlearena.bonuses.BonusSelector;
import org.battlearena.exceptions.CharacterDeadException;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Level {
    private int levelNumber;
    private List<Enemy> enemies;
    private List<IBonus> bonuses;
    private List<IObstacle> obstacles;
    private Difficulty difficulty;

    public Level(int levelNumber, List<Enemy> enemies, List<IBonus> bonuses, List<IObstacle> obstacles, Difficulty difficulty) {
        this.levelNumber = levelNumber;
        this.enemies = enemies;
        this.bonuses = bonuses;
        this.obstacles = obstacles;
        this.difficulty = difficulty;
    }


    public void startLevel(List<Hero> heroes) throws CharacterDeadException {
        System.out.println("\uD83C\uDF1F Starting Level " + levelNumber + " \uD83C\uDF1F");

        for (Hero hero : heroes) {
            for (IObstacle obstacle : obstacles) {
                obstacle.trigger(hero);
            }

            System.out.println("\uD83C\uDF81 Applying predefined bonuses...");
            for (IBonus bonus : bonuses) {
                if (hero.gethealthPointsRemaining() > 0) {
                    hero.receiveBonus(bonus);
                }
            }

            System.out.println("\uD83E\uDEA0 Applying smart bonus based on hero state...");
            if (hero.gethealthPointsRemaining() > 0) {
                IBonus selected = BonusSelector.chooseBonus(hero);
                hero.receiveBonus(selected);
            }
        }

        for (Enemy enemy : enemies) {
            System.out.println("\u2694\uFE0F New enemy enters: " + enemy.getClass().getSimpleName());
        }

        while (heroesAlive(heroes) && enemiesAlive(enemies)) {
            // Enemies attack using strategy
            for (Enemy enemy : enemies) {
                if (enemy.getHealthPointsRemaining() > 0) {
                    enemy.executeStrategy(heroes);
                }
            }

            // Check hero deaths
            for (Hero hero : heroes) {
                if (hero.gethealthPointsRemaining() <= 0) {
                    throw new CharacterDeadException(hero.getName() + " has fallen in battle!");
                }
            }

            // Heroes counterattack
            for (Hero hero : heroes) {
                if (hero.gethealthPointsRemaining() > 0) {
                    for (Enemy enemy : enemies) {
                        if (enemy.getHealthPointsRemaining() > 0) {
                            hero.attack();
                            enemy.setHealthPointsRemaining(
                                    enemy.getHealthPointsRemaining() - hero.getAttackDamage()
                            );
                        }
                    }
                }
            }
        }

        System.out.println(" Applying survival reward bonuses...");
        for (Hero hero : heroes) {
            if (hero.gethealthPointsRemaining() > 0) {
                for (IBonus bonus : bonuses) {
                    hero.receiveBonus(bonus);
                }
            }
        }

        System.out.println("Level " + levelNumber + " completed!\n");
    }

    private boolean heroesAlive(List<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero.gethealthPointsRemaining() > 0) return true;
        }
        return false;
    }

    private boolean enemiesAlive(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (enemy.getHealthPointsRemaining() > 0) return true;
        }
        return false;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}