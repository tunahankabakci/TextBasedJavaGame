package Models.Fields.Battle;

import Game.Game;
import Models.Characters.Character;
import Models.Fields.Field;
import Models.Fields.FieldType;
import Models.Items.Item;
import Models.Monsters.Monster;
import Models.Monsters.MonsterType;
import Utils.ConsoleColor;
import Utils.PressAnyKey;
import Utils.Scan;

import java.util.Random;

public class BattleField extends Field implements IBattleField {
    private int battleFieldId;
    private Monster[] monsters;
    private Item item;
    private BattleFieldType battleFieldType;

    public BattleField() {
        super(3, "Battlefield", FieldType.BATTLE);
    }

    public BattleField(int battleFieldId, String name, Item item) {
        super(3, name, FieldType.BATTLE);
        this.battleFieldId = battleFieldId;
        this.item = item;
    }

    public BattleField(Character character) {
        super(3, "Battlefield", character, FieldType.BATTLE);
    }

    public BattleField(int battleFieldId, String name, Character character, BattleFieldType battleFieldType, Monster[] monsters, Item item) {
        super(3, name, character, FieldType.BATTLE);
        this.battleFieldId = battleFieldId;
        this.battleFieldType = battleFieldType;
        this.monsters = monsters;
        this.item = item;
    }

    public static Monster[] generateMonster(MonsterType monsterType, int maxCount) {
        Random random = new Random();
        int count = random.nextInt(maxCount) + 1;
        Monster[] monsters = new Monster[count];

        for (int i = 0; i < count; i++) {
            monsters[i] = Monster.getMonsterByType(monsterType);
        }
        return monsters;
    }

    @Override
    public boolean onField() {
        BattleField[] battleFields = getAllBattleFields();
        Game.clearScreen();
        System.out.println("#####   Battlefields   #####");
        System.out.println("------------------------------------");
        for (BattleField battleField : battleFields) {
            System.out.println(battleField.getBattleFieldId() + ". " + battleField.getName() + "  ==> Loot: " + battleField.getItem().getName());
        }
        System.out.println((battleFields.length + 1)  + ". Back" );
        System.out.println("------------------------------------");
        System.out.print("Choice: ");
        int selection = Scan.scanner.nextInt();
        switch (selection){
            case 1:
            case 2:
            case 3:
            case 4:
                return getBattleFieldById(selection).onField();
            default:
                return false;
        }
    }

    @Override
    public BattleField getBattleFieldById(int id) {
        BattleField battleField;
        switch (id){
            case 1:
                battleField = new Jangan(this.getCharacter());
                break;
            case 2:
                battleField = new TarimBasin(this.getCharacter());
                break;
            case 3:
                battleField = new Karakoram(this.getCharacter());
                break;
            case 4:
                battleField = new Taklamakan(this.getCharacter());
                break;
            default:
                battleField = new Jangan(this.getCharacter());
        }
        return battleField;
    }

    @Override
    public BattleField[] getAllBattleFields() {
        BattleField[] battleFields = {new Jangan(), new TarimBasin(), new Karakoram(), new Taklamakan()};
        return battleFields;
    }

    @Override
    public boolean combat(Monster[] monsters) {
        int gold = monsters.length * monsters[0].getGold();
        System.out.println("The war started.\n");
        for (Monster monster : monsters) {
            do{
                if(attack(monster)) continue;
                if(defend(monster)) return true;
            } while (monster.getHealth() > 0 && getCharacter().getHealth() > 0 );
            System.out.println();
        }
        if(!getCharacter().getInventory().getItems().stream().anyMatch(item -> item.getName().equals(getItem().getName()))){
            System.out.println("\nCongratulations, you cleared the battlefield.");
            System.out.println("Gold: " + ConsoleColor.ANSI_YELLOW  + gold + ConsoleColor.ANSI_RESET);
            System.out.println("Item: " + ConsoleColor.ANSI_YELLOW + getItem().getName() + ConsoleColor.ANSI_RESET);
            getCharacter().getInventory().getItems().add(getItem());
        } else{
            System.out.println("\nCongratulations, you cleared the battlefield.");
            System.out.println("Gold: " + ConsoleColor.ANSI_YELLOW  + gold + ConsoleColor.ANSI_RESET);
        }
        getCharacter().setGold(getCharacter().getGold() + gold);
        PressAnyKey.anyKey();
        return false;
    }

    public boolean attack(Monster monster){
        Game.sleep(2000);
        if (monster.getHealth() <= getCharacter().getTotalDamage()){
            monster.setHealth(0);
            System.out.println(ConsoleColor.ANSI_GREEN + monster.getName() + " took " + getCharacter().getTotalDamage() + " damage and it is dead." + ConsoleColor.ANSI_RESET);
            Game.sleep(2000);
            return true;
        } else {
            monster.setHealth(monster.getHealth() - getCharacter().getTotalDamage());
            System.out.println(monster.getName() + " took " + ConsoleColor.ANSI_GREEN + getCharacter().getTotalDamage() + ConsoleColor.ANSI_RESET + " damage. New health: " + ConsoleColor.ANSI_BLUE + monster.getHealth() + ConsoleColor.ANSI_RESET);
            Game.sleep(2000);
            return false;
        }
    }

    public boolean defend(Monster monster){
        Game.sleep(2000);
        if(getCharacter().getHealth() <= monster.getDamage() - getCharacter().getTotalParry()){
            getCharacter().setHealth(0);
            System.out.println(ConsoleColor.ANSI_RED + "You took " + (getCharacter().getTotalParry() > monster.getDamage() ? 0 : monster.getDamage() - getCharacter().getTotalParry()) + " damage from " + monster.getName() + " and you dead." + ConsoleColor.ANSI_RESET);
            return true;
        } else {
            getCharacter().setHealth(getCharacter().getHealth() - (getCharacter().getTotalParry() > monster.getDamage() ? 0 : monster.getDamage() - getCharacter().getTotalParry()));
            System.out.println( "You took "  + ConsoleColor.ANSI_RED + (getCharacter().getTotalParry() > monster.getDamage() ? 0 : monster.getDamage() - getCharacter().getTotalParry()) + ConsoleColor.ANSI_RESET + " damage from " + monster.getName() + ". New health: " + ConsoleColor.ANSI_PURPLE + getCharacter().getHealth() + ConsoleColor.ANSI_RESET);
            return false;
        }
    }

    public int getBattleFieldId() {
        return battleFieldId;
    }

    public void setBattleFieldId(int battleFieldId) {
        this.battleFieldId = battleFieldId;
    }

    public Monster[] getMonsters() {
        return monsters;
    }

    public void setMonsters(Monster[] monsters) {
        this.monsters = monsters;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BattleFieldType getBattleFieldType() {
        return battleFieldType;
    }

    public void setBattleFieldType(BattleFieldType battleFieldType) {
        this.battleFieldType = battleFieldType;
    }
}
