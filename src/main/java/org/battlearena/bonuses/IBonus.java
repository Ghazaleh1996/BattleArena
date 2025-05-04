package org.battlearena.bonuses;

import org.battlearena.heros.Hero;
import org.battlearena.heros.IHero;

public interface IBonus {
    void apply(Hero hero);
    String getBonusName();
}
