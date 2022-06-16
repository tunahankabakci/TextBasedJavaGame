package Models.Equipments.Weapons;

import Models.Equipments.Equipment;
import Models.Equipments.EquipmentType;

public abstract class Weapon extends Equipment implements IWeapon {
    private WeaponType weaponType;
    private int damage;

    public Weapon(int id, String name, int price, int damage, WeaponType weaponType ) {
        super(id, name, price, EquipmentType.WEAPON);
        this.damage = damage;
        this.weaponType = weaponType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
