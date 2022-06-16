package Game;

import Models.Characters.Character;
import Models.Items.Earth;
import Models.Items.Fire;
import Models.Items.Water;
import Models.Items.Wind;
import Utils.PressAnyKey;
import Utils.Scan;

import java.util.Scanner;

public class Game {

    Character character;

    public void start(){
        System.out.println("\nGive a name for your character.");
        System.out.print("Choice:");
        String characterName = Scan.scanner.nextLine();
        clearScreen();
        character = Character.selectChar(characterName);
        boolean isDead = false;
        do{
            clearScreen();
            isDead = character.selectField();
        }while(!isDead);
    }

    public static void sleep(int m){
        try{
            Thread.sleep(m);
        }catch (Exception exception){

        }
    }

    public static void clearScreen() {
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }
    }

    public static boolean checkFinish(Character character){
        long count = character
                .getInventory()
                .getItems()
                .stream()
                .filter(item -> (item instanceof Earth || item instanceof Fire || item instanceof Water || item instanceof Wind))
                .count();
        if (count < 4){
            System.out.println("You need to get all the elements to finish the game!");
            PressAnyKey.anyKey();
            return false;
        } else {
            System.out.println("Congratulations you have successfully completed the game!");
            PressAnyKey.anyKey();
            return true;
        }
    }

}
