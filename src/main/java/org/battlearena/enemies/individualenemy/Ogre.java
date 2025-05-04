package org.battlearena.enemies.individualenemy;

import org.battlearena.enemies.Enemy;
import org.battlearena.enemies.strategy.MultiTargetAttackStrategy;

public class Ogre extends Enemy implements IOgre {
    public Ogre(int healthPoints, int attackDamage) {
        super(healthPoints, attackDamage);
        setStrategy(new MultiTargetAttackStrategy());
    }

    @Override
    public void specialAttack() {
        if (Math.random() < 0.2) {
            setAttackDamage(getAttackDamage() + 4);
            System.out.println("Ogre's attack increased by four");
        }
    }

    @Override
    public void stareDown() {
        System.out.println("Ogre stares intensely and drops to all four limbs");
    }

    @Override
    public void talk() {
        System.out.println("Ogre is slamming hands all over");
    }
}
