package org.battlearena.enemies;

public interface IEnemy {
    void talk();
    void specialAttack();
    int getHealthPoints();
    int getHealthPointsRemaining();
    void attack();
    int getAttackDamage();
    void setAttackDamage(int attackDamage);
    void setHealthPointsRemaining(int healthPointsRemaining);
    int getID();
}
