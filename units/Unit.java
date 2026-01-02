package units;


public abstract class Unit {

    protected int hp;
    protected int attack;

    public Unit(int hp, int attack) {
        this.hp = hp;
        this.attack = attack;
    }

    public void attack(Unit enemy) {
        enemy.hp -= attack;
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
