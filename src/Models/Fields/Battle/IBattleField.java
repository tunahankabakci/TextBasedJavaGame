package Models.Fields.Battle;

import Models.Monsters.Monster;

public interface IBattleField {
    BattleField getBattleFieldById(int id);
    BattleField[] getAllBattleFields();
    boolean combat(Monster[] monsters);
}
