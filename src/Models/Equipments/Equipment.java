package Models.Equipments;


import Models.Equipments.Armors.Armor;
import Models.Equipments.Armors.HeavyArmor;
import Models.Equipments.Armors.LightArmor;
import Models.Equipments.Armors.Robe;
import Models.Equipments.Weapons.Bow;
import Models.Equipments.Weapons.Spear;
import Models.Equipments.Weapons.Sword;
import Models.Equipments.Weapons.Weapon;

public abstract class Equipment implements IEquipment {
    private int id;
    private String name;
    private int price;
    private EquipmentType equipmentType;

    public Equipment(int id, String name, int price, EquipmentType equipmentType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.equipmentType = equipmentType;
    }

    public static Equipment[] getAllEquipments(EquipmentType equipmentType) {
        switch (equipmentType){
            case WEAPON:
                Weapon[] weapons = {new Bow(), new Sword(), new Spear()};
                return weapons;
            case ARMOR:
                Armor[] armors = {new Robe(), new LightArmor(), new HeavyArmor()};
                return armors;
            default:
                return  null;
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }
}
