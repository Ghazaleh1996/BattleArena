package org.battlearena.obstacles;

import org.battlearena.heros.Hero;

public interface IObstacle {
    void trigger(Hero hero);
    String getObstacleName();
}
