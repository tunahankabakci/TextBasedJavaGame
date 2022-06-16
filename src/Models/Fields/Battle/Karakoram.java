package Models.Fields.Battle;

import Game.Game;
import Models.Characters.Character;
import Models.Items.Water;
import Models.Monsters.MonsterType;
import Utils.ConsoleColor;

public class Karakoram extends BattleField{

    public Karakoram() {
        super(3,"Karakoram",new Water());
    }

    public Karakoram(Character character) {
        super(3, "Karakoram", character, BattleFieldType.KARAKORAM, generateMonster(MonsterType.YETI, 3), new Water());
    }

    @Override
    public boolean onField() {
        Game.clearScreen();
        System.out.println("Be careful, there is/are " + ConsoleColor.ANSI_YELLOW + getMonsters().length + ConsoleColor.ANSI_RESET + " " + ConsoleColor.ANSI_CYAN + getMonsters()[0].getName() + "/s" + ConsoleColor.ANSI_RESET + " here.\n");
        Game.sleep(2000);
        if(!combat(getMonsters())) return new BattleField(getCharacter()).onField();
        return true;
    }
}
