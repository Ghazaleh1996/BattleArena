package org.battlearena.heros;

import org.battlearena.heros.IHero;
import java.util.List;

public class HeroUtils {
    public static <T extends IHero> void printHeroNames(List<T> heroes) {
        for (T hero : heroes) {
            System.out.println("🦸 Hero: " + hero.getName());
        }
    }
}
