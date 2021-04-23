import java.util.Scanner;

public class UI {
    private Scanner scanner = new Scanner(System.in);
    private Color colorClass = new Color();

    public String getColorString(String color, String message) {
        return colorClass.colorText(color, message);
    }

    //Alex + Rasmus
    public String getString(){
        return scanner.nextLine();
    }

    //Alex
    public int getInt() {
        return scanner.nextInt();
    }

    //Alex
    public void printString(String message) {
        System.out.println(message);
    }

    public void printStringAppend(String message) {
        System.out.print(message);
    }

    public void printColorString(String color, String message) {
        System.out.println(colorClass.colorText(color, message));
    }

    //Rasmus + Alex
    public void printOptionsMenu(Menu menu) {
        System.out.print(menu.getMenuHeader());
        System.out.print(menu.getMenuOptions());
        System.out.print(menu.getLeadText());
    }

    // Rasmus
    public boolean hasNextInt(){
        return scanner.hasNextInt();
    }
}
