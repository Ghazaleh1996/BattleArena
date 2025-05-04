package org.battlearena.obstacles;

import org.battlearena.heros.Hero;

public class Wall implements IObstacle {
    private final int blockAmount;

    public Wall(int blockAmount) {
        this.blockAmount = blockAmount;
    }

    @Override
    public void trigger(Hero hero) {
        int newDamage = hero.getAttackDamage() - blockAmount;
        if (newDamage < 0) newDamage = 0;
        hero.setAttackDamage(newDamage);
        System.out.println(" Wall blocks " + blockAmount + " attack damage from hero!");
    }

    @Override
    public String getObstacleName() {
        return "Wall";
    }
}
