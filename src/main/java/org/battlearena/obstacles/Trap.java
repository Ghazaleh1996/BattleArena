package org.battlearena.obstacles;

import org.battlearena.heros.Hero;

public class Trap implements IObstacle {
    private int damage;

    public Trap(int damage) {
        this.damage = damage;
    }

    @Override
    public void trigger(Hero hero) {
        hero.sethealthPointsRemaining(hero.gethealthPointsRemaining() - damage);
        System.out.println("Trap triggered! -" + damage + " HP");
    }

    @Override
    public String getObstacleName() {
        return "Trap";
    }
}
