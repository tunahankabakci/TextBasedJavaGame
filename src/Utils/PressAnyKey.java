package Utils;

public class PressAnyKey {
    public static void anyKey(){
        System.out.println("\nPress Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e) {}
    }
}
