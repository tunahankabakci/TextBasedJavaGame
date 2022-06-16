package Models.Characters;

import Models.Inventory.Inventory;

public class Orc extends Character{

    public Orc(){
        super(3,"Orc", 8 , 24, 5);
    }

    public Orc(String name) {
        super(3,name, "Orc", CharacterType.ORC, 8, 24, 24,0, 5, new Inventory());
    }
}
