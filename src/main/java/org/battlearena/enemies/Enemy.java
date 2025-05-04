package org.battlearena.enemies;

import org.battlearena.enemies.strategy.AttackStrategy;
import org.battlearena.heros.Hero;
import java.util.List;

public abstract class Enemy implements IEnemy {
    private int ID;
    private int healthPoints;
    private int healthPointsRemaining;
    private int attackDamage;
    private static int numberofEnemies;
    private AttackStrategy strategy;
    private EnemyState state;

    public void setState(EnemyState state) {
        this.state = state;
    }

    public EnemyState getState() {
        return state;
    }


    public Enemy(int healthPoints, int attackDamage) {
        this.healthPoints = healthPoints;
        this.healthPointsRemaining = healthPoints;
        this.attackDamage = attackDamage;
        numberofEnemies++;
        this.ID = numberofEnemies;
    }


    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }

    public AttackStrategy getStrategy() {
        return strategy;
    }

    @Override
    public void attack() {
        System.out.println("Enemy attacks with " + attackDamage + " damage.");
    }

    public void attack(Hero target) {
        System.out.println(getClass().getSimpleName() + " attacks " + target.getName() + " for " + attackDamage + " damage.");
        target.sethealthPointsRemaining(target.gethealthPointsRemaining() - attackDamage);
    }

    public void attack(List<Hero> targets) {
        System.out.println(getClass().getSimpleName() + " attacks multiple heroes!");
        for (Hero target : targets) {
            if (target.gethealthPointsRemaining() > 0) {
                System.out.println(" -> Hits " + target.getName() + " for " + attackDamage + " damage.");
                target.sethealthPointsRemaining(target.gethealthPointsRemaining() - attackDamage);
            }
        }
    }

    public void executeStrategy(List<Hero> heroes) {
        if (strategy != null) {
            strategy.execute(this, heroes);
        } else {
            Hero fallback = heroes.stream().filter(h -> h.gethealthPointsRemaining() > 0).findFirst().orElse(null);
            if (fallback != null) attack(fallback);
        }
    }

    @Override
    public int getHealthPoints() { return healthPoints; }
    @Override
    public int getHealthPointsRemaining() { return healthPointsRemaining; }
    @Override
    public void setHealthPointsRemaining(int hp) { this.healthPointsRemaining = hp; }
    @Override
    public int getAttackDamage() { return attackDamage; }
    @Override
    public void setAttackDamage(int dmg) { this.attackDamage = dmg; }
    @Override
    public int getID() { return ID; }
    @Override
    public void specialAttack() {
        System.out.println("Enemy does not have a special attack");
    }
    @Override
    public void talk() {
        System.out.println("I am an enemy, be prepared to fight.");
    }
}
