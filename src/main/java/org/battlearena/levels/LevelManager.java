package org.battlearena.levels;

import org.battlearena.heros.Hero;
import org.battlearena.heros.HeroUtils;
import org.battlearena.heros.IHero;
import org.battlearena.exceptions.CharacterDeadException;

import java.util.List;

public class LevelManager {
    private List<Level> levels;

    public LevelManager(List<Level> levels) {
        this.levels = levels;
    }

    public void runLevels(List<Hero> heroes) {
        System.out.println(" Starting Game with " + levels.size() + " levels\n");

        // Polymorphism by inclusion: client code using interface
        IHero polyHero = new Hero("PolyHero", 22, 3);
        polyHero.attack();
        HeroUtils.printHeroNames(heroes);

        for (Level level : levels) {
            try {
                level.startLevel(heroes);
            } catch (CharacterDeadException e) {
                System.out.println("danger!!" + e.getMessage());
                System.out.println("Level " + level.getLevelNumber() + "Game Over.");
                return;
            }

            if (allHeroesDefeated(heroes)) {
                System.out.println("All heroes have been defeated. Game over.");
                return;
            }
        }

        System.out.println("All levels completed! You win!");
    }

    private boolean allHeroesDefeated(List<Hero> heroes) {
        for (Hero hero : heroes) {
            if (hero.gethealthPointsRemaining() > 0) {
                return false;
            }
        }
        return true;
    }
}
