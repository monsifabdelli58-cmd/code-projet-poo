package game.units;


public abstract class Unit {
    protected int health;
    protected int attack;
    protected int defense;
    protected int range;
    protected int cost;
    protected Position position;

    public Unit(int health, int attack, int defense, int range, int cost, Position position) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.range = range;
        this.cost = cost;
        this.position = position;
    }

    
    public abstract void move(Position newPos);
    public abstract void attack(Unit target);

    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getRange() {
        return range;
    }

    public int getCost() {
        return cost;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " at " + position + " (HP: " + health + ")";
    }
}