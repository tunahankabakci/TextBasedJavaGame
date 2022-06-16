package Models.Equipments.Armors;

import Models.Equipments.Equipment;
import Models.Equipments.EquipmentType;

public abstract class Armor extends Equipment implements IArmor {
    private ArmorType armorType;
    private int parry;

    public Armor(int id, String name, int price, int parry, ArmorType armorType) {
        super(id, name, price, EquipmentType.ARMOR);
        this.parry = parry;
        this.armorType = armorType;
    }


    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public int getParry() {
        return parry;
    }

    public void setParry(int parry) {
        this.parry = parry;
    }
}
