
import java.util.Scanner;

public class UI {

    private Scanner scanner = new Scanner(System.in);
    private Color colorClass = new Color();


    public void printColor(String color, String message) {
        System.out.println(colorClass.colorText(color, message));
    }
    public String getColorString(String color, String message) {
        return colorClass.colorText(color, message);
    }

    //Alex
    public void printString(String message) {
        System.out.println(message);
    }

    public void printStringAppend(String message) {
        System.out.print(message);
    }

    //Alex + Rasmus
    public String getString(){
        return scanner.nextLine();
    }
    //Alex
    public int getInt() {
        return scanner.nextInt();
    }


    // Rasmus
    public boolean hasNextInt(){
        return scanner.hasNextInt();
    }

    //Alex
    public void printInt(int pizzaNumber) {
        System.out.println(pizzaNumber);
    }



    //Jakob + Alex
    public void printOrders(Order order) {
        System.out.println(order.getId());
        //System.out.println(order.getOrderList());
        System.out.println(order.getTotalPrice());
    }

    //Rasmus + Alex

    public void printOptionsMenu(Menu menu) {
        System.out.print(menu.getMenuHeader());
        System.out.print(menu.getMenuOptions());
        System.out.print(menu.getLeadText());
    }

    //public void printOptionsMenuTest(Menu menu) {
    //    System.out.println(menu.getMenuHeader());
    //    for (String s : menu.getMenuOptions()) {
    //        System.out.println(s);
    //    }
    //    System.out.println(menu.getLeadText());
    //}
}
