package org.battlearena.levels;

import org.battlearena.heros.Hero;
import org.battlearena.enemies.Enemy;
import org.battlearena.enemies.EnemyState;
import org.battlearena.bonuses.IBonus;
import org.battlearena.obstacles.IObstacle;
import org.battlearena.bonuses.BonusSelector;
import org.battlearena.exceptions.CharacterDeadException;
import org.battlearena.enemies.strategy.*;
import org.battlearena.enemies.individualenemy.IOgre;
import org.battlearena.enemies.individualenemy.IZombie;

import java.util.List;

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
        System.out.println("🌟 Starting Level " + levelNumber + " 🌟");

        for (Hero hero : heroes) {
            for (IObstacle obstacle : obstacles) {
                obstacle.trigger(hero);
            }

            System.out.println("🎁 Applying predefined bonuses...");
            for (IBonus bonus : bonuses) {
                if (hero.gethealthPointsRemaining() > 0) {
                    hero.receiveBonus(bonus);
                }
            }

            System.out.println("🧠 Applying smart bonus based on hero state...");
            if (hero.gethealthPointsRemaining() > 0) {
                IBonus selected = BonusSelector.chooseBonus(hero);
                hero.receiveBonus(selected);
            }
        }


        for (Enemy enemy : enemies) {
            System.out.println("⚔️ New enemy enters: " + enemy.getClass().getSimpleName());

            if (enemy instanceof IOgre) {
                ((IOgre) enemy).stareDown();
            } else if (enemy instanceof IZombie) {
                ((IZombie) enemy).battleStance();
            }
        }

        while (heroesAlive(heroes) && enemiesAlive(enemies)) {
            for (Enemy enemy : enemies) {
                if (enemy.getHealthPointsRemaining() > 0) {
                    updateEnemyStateAndStrategy(enemy);
                    enemy.executeStrategy(heroes);
                }
            }

            for (Hero hero : heroes) {
                if (hero.gethealthPointsRemaining() <= 0) {
                    throw new CharacterDeadException(hero.getName() + " has fallen in battle!");
                }
            }

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

        System.out.println("🏅 Applying survival reward bonuses...");
        for (Hero hero : heroes) {
            if (hero.gethealthPointsRemaining() > 0) {
                for (IBonus bonus : bonuses) {
                    hero.receiveBonus(bonus);
                }
            }
        }

        System.out.println("✅ Level " + levelNumber + " completed!\n");
    }

    private void updateEnemyStateAndStrategy(Enemy enemy) {
        double healthRatio = (double) enemy.getHealthPointsRemaining() / enemy.getHealthPoints();

        if (healthRatio < 0.3) {
            enemy.setState(EnemyState.FLEEING);
            enemy.setStrategy(new FleeStrategy());
        } else if (healthRatio < 0.6) {
            enemy.setState(EnemyState.DEFENSIVE);
            enemy.setStrategy(new DefensiveStrategy());
        } else {
            enemy.setState(EnemyState.AGGRESSIVE);
            enemy.setStrategy(new AggressiveStrategy());
        }
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
