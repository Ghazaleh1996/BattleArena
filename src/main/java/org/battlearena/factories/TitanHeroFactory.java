package org.battlearena.factories;
import org.battlearena.heros.Hero;
import org.battlearena.heros.weapons.Weapon;
import org.battlearena.levels.Difficulty;

import java.util.List;
import java.util.ArrayList;
public class TitanHeroFactory {
    public static List<Hero> createHeroes(Difficulty difficulty) {
        List<Hero> heroes = new ArrayList<>();

        switch (difficulty) {
            case EASY -> {
                Hero hero1 = new Hero("Ares", 18, 2);
                Hero hero2 = new Hero("Luna", 17, 2);
                hero1.setWeapon(new Weapon("Sword", 2));
                hero2.setWeapon(new Weapon("Axe", 2));
                hero1.equipWeapon();
                hero2.equipWeapon();
                heroes.add(hero1);
                heroes.add(hero2);
            }
            case MEDIUM -> {
                Hero hero1 = new Hero("Ares", 20, 3);
                Hero hero2 = new Hero("Luna", 18, 3);
                hero1.setWeapon(new Weapon("Sword", 2));
                hero2.setWeapon(new Weapon("Axe", 2));
                hero1.equipWeapon();
                hero2.equipWeapon();
                heroes.add(hero1);
                heroes.add(hero2);
            }
            case HARD -> {
                Hero titan = new Hero("Titan", 33, 5);
                titan.setWeapon(new Weapon("GodBlade", 3));
                titan.equipWeapon();
                heroes.add(titan);
            }
        }

        return heroes;
    }
}
