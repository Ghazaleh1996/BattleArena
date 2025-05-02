package org.battlearena.factories;
import org.battlearena.levels.Difficulty;
import org.battlearena.obstacles.IObstacle;
import org.battlearena.obstacles.Trap;
import org.battlearena.obstacles.Wall;

import java.util.ArrayList;
import java.util.List;

public class ObstacleFactory {
    public static List<IObstacle> createObstacles(Difficulty difficulty) {
        List<IObstacle> obstacles = new ArrayList<>();

        switch (difficulty) {
            case EASY -> {
                obstacles.add(new Trap(1));
                obstacles.add(new Wall(1));
            }
            case MEDIUM -> {
                obstacles.add(new Trap(2));
                obstacles.add(new Wall(2));
            }
            case HARD -> {
                obstacles.add(new Trap(4));
                obstacles.add(new Wall(3));
            }
        }

        return obstacles;
    }
}
