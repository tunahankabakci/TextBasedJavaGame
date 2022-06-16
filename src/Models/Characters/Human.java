package Models.Characters;

import Models.Inventory.Inventory;

public class Human extends Character{

    public Human(){
        super(2,"Human", 7 , 18, 20);
    }

    public Human(String name) {
        super(2,name, "Human", CharacterType.HUMAN, 7, 18, 18, 0, 20, new Inventory());
    }
}
