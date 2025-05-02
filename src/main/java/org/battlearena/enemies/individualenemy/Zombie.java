package org.battlearena.enemies.individualenemy;

import org.battlearena.enemies.Enemy;
import org.battlearena.enemies.strategy.DefensiveStrategy;

public class Zombie extends Enemy implements IZombie {
    public Zombie(int healthPoints, int attackDamage) {

        super(healthPoints, attackDamage);
        setStrategy(new DefensiveStrategy());
    }

    @Override
    public void talk() {
        System.out.println("Grumbling");
    }

    @Override
    public void specialAttack() {
        if (Math.random() < 0.5) {
            setHealthPointsRemaining(getHealthPointsRemaining() + 2);
            System.out.println(" Zombie regenerated two Health Points");
        }
    }

    @Override
    public void battleStance() {
        System.out.println("Zombie cracks neck and sticks arms out");
    }
}
