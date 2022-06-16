package Models.Characters;

import Game.Game;
import Models.Fields.Battle.BattleField;
import Models.Fields.Field;
import Models.Fields.Safe;
import Models.Fields.Store;
import Models.Inventory.Inventory;
import Utils.Scan;

import java.util.Random;

public abstract class Character implements ICharacter {
    private int id;
    private String name;
    private String typeName;
    private CharacterType characterType;
    private int damage;
    private int health;
    private int maxHealth;
    private int parry;
    private int gold;
    private Inventory inventory;

    public Character() {
    }

    public Character(int id, String name, String typeName, CharacterType characterType, int damage, int health, int maxHealth, int parry , int gold, Inventory inventory) {
        this.id = id;
        this.name = name;
        this.typeName = typeName;
        this.characterType = characterType;
        this.damage = damage;
        this.health = health;
        this.maxHealth = maxHealth;
        this.parry = parry;
        this.gold = gold;
        this.inventory = inventory;
    }

    public Character(int id, String typeName, int damage, int health, int gold) {
        this.id = id;
        this.typeName = typeName;
        this.damage = damage;
        this.health = health;
        this.gold = gold;
    }

    public static Character selectChar(String characterName) {
        Character character;
        System.out.println("Please choose a race to start the game.");
        System.out.println("------------------------------------");
        Character[] characters = {new Elf(), new Human(), new Orc()};
        for (int i = 0; i < characters.length; i++) {
            String s = String.format("%d. Race: %s \t Damage: %d \t Health: %d \t Gold: %d", characters[i].getId(), characters[i].getTypeName(), characters[i].getDamage(), characters[i].getHealth(), characters[i].getGold());
            System.out.println(s);
        }
        System.out.println("------------------------------------");
        System.out.print("Choice: ");
        int selection = Scan.scanner.nextInt();
        Game.clearScreen();
        switch (selection) {
            case 1:
                character = new Elf(characterName);
                break;
            case 2:
                character = new Human(characterName);
                break;
            case 3:
                character = new Orc(characterName);
                break;
            default:
                character = new Orc(characterName);
        }
        Game.clearScreen();
        return character;
    }

    public boolean selectField() {
        Field field;
        Field[] fields = {new Safe(), new Store(), new BattleField()};
        System.out.println("Fields");
        System.out.println("------------------------------------");
        System.out.println("0 - End your own life!");
        for (Field f : fields) {
            String s = String.format("%d - %s", f.getId(), f.getName());
            System.out.println(s);
        }
        System.out.println((fields.length + 1) + " - Elements...");
        System.out.println("------------------------------------");
        System.out.print("Choice: ");
        int selection = Scan.scanner.nextInt();
        Game.clearScreen();
        switch (selection) {
            case 0:
                Random random = new Random();
                String[] suicides = {
                        "You stabbed yourself to death.",
                        "You died jumping from a height.",
                        "A poisonous plant killed you.",
                        "You were found hanging from a tree by the neck.",
                };
                System.out.println(suicides[random.nextInt(suicides.length -1)]);
                return true;
            case 1:
                field = new Safe(this);
                break;
            case 2:
                field = new Store(this);
                break;
            case 3:
                field = new BattleField(this);
                break;
            case 4:
                return Game.checkFinish(this);
            default:
                field = new Safe(this);
                break;
        }
        return field.onField();
    }

    public void printCharacterInfo(){
        System.out.println("#####   Character   #####");
        System.out.println("------------------------------------");
        System.out.println("Gold: " + getGold());
        System.out.println("Weapon: " + getInventory().getWeapon().getName());
        System.out.println("Armor: " + getInventory().getArmor().getName());
        System.out.println("Damage: " + getTotalDamage());
        System.out.println("Health: " + (getHealth()));
        System.out.println("Parry: " + getTotalParry());
        System.out.println("------------------------------------");
    }


    public int getTotalDamage(){
        return getDamage() + getInventory().getWeapon().getDamage();
    }

    public int getTotalParry(){
        return getParry() + getInventory().getArmor().getParry();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public void setCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getParry() { return parry; }

    public void setParry( int parry) {this.parry = parry; }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Inventory getInventory() { return inventory; }

    public void setInventory(Inventory inventory) { this.inventory = inventory; }
}
