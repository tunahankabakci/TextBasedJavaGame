package Models.Monsters;

public abstract class Monster implements IMonster{
    private int id;
    private String name;
    private int damage;
    private int health;
    private MonsterType monsterType;
    private int gold;


    public Monster(int id, String name, int damage, int health, MonsterType monsterType, int gold) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.monsterType = monsterType;
        this.gold = gold;
    }

    public static Monster getMonsterByType(MonsterType monsterType){
        switch (monsterType){
            case TIGER:
                return new Tiger();
            case SCORPION:
                return new Scorpion();
            case YETI:
                return new Yeti();
            case SHAMAN:
                return new Shaman();
            default:
                return new Yeti();
        }
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(MonsterType monsterType) {
        this.monsterType = monsterType;
    }
}
