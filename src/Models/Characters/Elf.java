package Models.Characters;

import Models.Inventory.Inventory;

public class Elf extends Character{

    public Elf(){
        super(1,"Elf", 5 , 21, 15);
    }

    public Elf(String name) {
        super(1,name, "Elf", CharacterType.ELF, 5 , 21,21, 0, 15, new Inventory());
    }
}
