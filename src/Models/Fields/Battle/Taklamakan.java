package Models.Fields.Battle;

import Game.Game;
import Models.Characters.Character;
import Models.Items.Wind;
import Models.Monsters.MonsterType;
import Utils.ConsoleColor;

public class Taklamakan extends BattleField{
    public Taklamakan() {
        super(4,"Taklamakan",new Wind());
    }

    public Taklamakan(Character character) {
        super(4, "Taklamakan", character, BattleFieldType.TAKLAMAKAN, generateMonster(MonsterType.SHAMAN,3), new Wind());
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
