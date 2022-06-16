package Models.Fields;

import Models.Characters.Character;
import Utils.PressAnyKey;

public class Safe extends Field{

    public Safe() {
        super(1, "Safe Zone", FieldType.SAFE);
    }

    public Safe(Character character) {
        super(1, "Safe Zone", character, FieldType.SAFE);
    }


    @Override
    public boolean onField() {
        System.out.println("You are now in the safe zone.");
        System.out.println("You have recovered.");
        getCharacter().setHealth(getCharacter().getMaxHealth());
        PressAnyKey.anyKey();
        return false;
    }
}
