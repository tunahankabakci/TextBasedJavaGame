package Models.Fields;

import Game.Game;
import Models.Characters.Character;
import Models.Equipments.Armors.Armor;
import Models.Equipments.Equipment;
import Models.Equipments.EquipmentType;
import Models.Equipments.Weapons.Weapon;
import Models.Inventory.Inventory;
import Utils.PressAnyKey;
import Utils.Scan;

import java.util.HashMap;

public class Store extends Field {

    public Store() {
        super(2, "Store", FieldType.STORE);
    }

    public Store(Character character) {
        super(2, "Store", character, FieldType.STORE);
    }

    @Override
    public boolean onField() {
        System.out.println("#####   Store   #####");
        HashMap<Integer, String> dict = new HashMap();
        dict.put(1, "Weapons");
        dict.put(2, "Armors");
        dict.put(3, "Inventory");
        dict.put(4, "Back");
        System.out.println("------------------------------------");
        dict.forEach((k, v) -> System.out.println(k + ". " + v));
        System.out.println("------------------------------------");
        System.out.print("Choice: ");
        int selection = Scan.scanner.nextInt();
        switch (selection) {
            case 1:
                Game.clearScreen();
                showEquipments(EquipmentType.WEAPON);
                break;
            case 2:
                Game.clearScreen();
                showEquipments(EquipmentType.ARMOR);
                break;
            case 3:
                Game.clearScreen();
                getCharacter().getInventory().printInventoryInfo();
                PressAnyKey.anyKey();
                break;
            default:
                return false;
        }


        return false;
    }

    private void showEquipments(EquipmentType equipmentType) {
        getCharacter().printCharacterInfo();
        System.out.println();
        Equipment[] equipments = Equipment.getAllEquipments(equipmentType);
        switch (equipmentType) {
            case WEAPON:
                System.out.println("#####   Weapons   #####");
                break;
            case ARMOR:
                System.out.println("#####   Armors   #####");
                break;
        }
        System.out.println("------------------------------------");
        for (Equipment equipment : equipments) {
            String s;
            if (equipment instanceof Weapon) {
                Weapon weapon = (Weapon) equipment;
                s = "\t\tDamage: " + weapon.getDamage();
            } else if (equipment instanceof Armor) {
                Armor armor = (Armor) equipment;
                s = "\t\tParry: " + armor.getParry();
            } else {
                s = "No such equipment is available.";
            }
            System.out.println(equipment.getId() + ". \tType: " + equipment.getName() + s + "\t\tPrice: " + equipment.getPrice());
        }
        System.out.println((equipments.length + 1) + ". \tBack\n");
        System.out.print("Choice: ");
        int selection = Scan.scanner.nextInt();
        switch (selection) {
            case 1:
            case 2:
            case 3:
                Game.clearScreen();
                buyEquipment(equipments[selection - 1]);
                onField();
                break;
            default:
                Game.clearScreen();
                onField();
        }


    }


    private boolean buyEquipment(Equipment equipment) {
        if (equipment.getPrice() < getCharacter().getGold()) {
            if (equipment instanceof Weapon){
                Weapon weapon = (Weapon)equipment;
                getCharacter().setGold(getCharacter().getGold() - weapon.getPrice());
                getCharacter().getInventory().setWeapon(weapon);
            } else if(equipment instanceof Armor){
                Armor armor = (Armor) equipment;
                getCharacter().setGold(getCharacter().getGold() - armor.getPrice());
                getCharacter().getInventory().setArmor(armor);
            } else {
                System.out.println("No such equipment is available.");
                return false;
            }
            System.out.println(equipment.getName() + " successfully purchased.");
            Game.sleep(2000);
            Game.clearScreen();
            getCharacter().printCharacterInfo();
            Game.sleep(2000);
            Game.clearScreen();
            return true;
        }
        System.out.println("You don't have enough gold.");
        Game.sleep(2000);
        Game.clearScreen();
        return false;

    }









    /*
    private void showWeapons(){
        Weapon[] weapons = { new Bow(), new Sword(), new Spear()};
        System.out.println("#####   Silahlar   #####");
        System.out.println("------------------------------------");
        for (Weapon weapon : weapons) {
            System.out.println(weapon.getId() + ". \tTip: " + weapon.getName() + "\t\tHasar: " + weapon.getDamage() + "\t\tFiyat: " + weapon.getPrice());
        }
        System.out.println((weapons.length + 1) + ". \tGeri");
        System.out.println("------------------------------------");
        System.out.print("Seçimini Yap: ");
        int selection = Scan.scanner.nextInt();
        switch (selection){
            case 1:
            case 2:
            case 3:
                Game.clearScreen();
                buyWeapon(weapons[selection-1]);
                onField();
                break;
            default:
                Game.clearScreen();
                onField();
        }
    }

    private void showArmors(){
        Armor[] armors = { new Robe(), new LightArmor(), new HeavyArmor()};
        System.out.println("#####   Zırhlar   #####");
        System.out.println("------------------------------------");
        for (Armor armor : armors) {
            String s = String.format("%d. \t Tip: %s \t\t Hasar Düşürme: %d \t\t Fiyat: %d",armor.getId(), armor.getName(), armor.getParry(), armor.getPrice());
            System.out.println(s);
        }
        System.out.println((armors.length + 1) + ". \tGeri");
        System.out.println("------------------------------------");
        System.out.print("Seçimini Yap: ");
        int selection = Scan.scanner.nextInt();
        switch (selection){
            case 1:
            case 2:
            case 3:
                Game.clearScreen();
                buyArmor(armors[selection-1]);
                onField();
                break;
            default:
                Game.clearScreen();
                onField();
        }
    }


    private boolean buyWeapon(Weapon weapon){
        if (weapon.getPrice() < getCharacter().getGold()){
            System.out.println(weapon.getName() + " başarıyla satın alındı.");
            Game.sleep(1000);
            return true;
        }
        System.out.println("Yeterli altınınız yok.");
        Game.sleep(1000);
        return false;
    }

    private boolean buyArmor(Armor armor){
        if (armor.getPrice() < getCharacter().getGold()){
            System.out.println(armor.getName() + " başarıyla satın alındı.");
            Game.sleep(1000);
            return true;
        }
        System.out.println("Yeterli altınınız yok.");
        Game.sleep(1000);
        return false;
    }
    */

}
