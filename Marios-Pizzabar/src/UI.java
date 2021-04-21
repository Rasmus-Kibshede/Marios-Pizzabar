
import java.util.Scanner;

public class UI {

    private Scanner scanner = new Scanner(System.in);

    //Alex
    public void printString(String message) {
        System.out.println(message);
    }
    //Alex
    public String getString(String message){
        return message;
    }
    //Alex
    public int getInt() {
        return scanner.nextInt();
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
