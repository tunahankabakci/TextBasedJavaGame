package Models.Inventory;

import Models.Equipments.Armors.Armor;
import Models.Equipments.Armors.Nude;
import Models.Equipments.Weapons.Punch;
import Models.Equipments.Weapons.Weapon;
import Models.Items.Item;

import java.util.ArrayList;

public class Inventory implements IInventory{
    private Weapon weapon;
    private Armor armor;
    private ArrayList<Item> items;

    public Inventory(){
        this.weapon = new Punch();
        this.armor = new Nude();
        this.items = new ArrayList();
    }

    @Override
    public void printInventoryInfo() {
        System.out.println("Weapon: " + this.weapon.getName());
        System.out.println("Armor: " + this.armor.getName());
        System.out.print("Items: ");
        for (Item item : this.items) {
            System.out.print(item.getName() + ", ");
        }
    }




    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }


}
