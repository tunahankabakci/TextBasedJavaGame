package Models.Fields.Battle;

import Game.Game;
import Models.Characters.Character;
import Models.Items.Earth;
import Models.Monsters.MonsterType;
import Utils.ConsoleColor;

public class Jangan extends BattleField{

    public Jangan() {
        super(1,"Jangan", new Earth());
    }

    public Jangan( Character character) {
        super(1, "Jangan", character, BattleFieldType.JANGAN, generateMonster(MonsterType.TIGER, 3), new Earth());
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
