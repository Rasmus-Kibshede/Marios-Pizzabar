import java.util.ArrayList;
import java.util.Scanner;

public class UI {

  private Scanner scanner = new Scanner(System.in);

  //Rasmus + Alex
  public String printPizzaMenu(String messege){
    return messege;
  }
  //Alex
  public int printPizzaNumber(int pizzaNumber){
    return pizzaNumber;
  }
  //Rasmus + Alex
  public void printOrders(Order order){
    System.out.println(order.getId());
    System.out.println(order.getOrderList());
    System.out.println(order.getTotalPrice());
  }

  //Rasmus + Alex

  public int printOptionsMenu(Menu menu){
    System.out.println(menu.getMenuHeader());
    System.out.println(menu.getMenuItems());
    System.out.println(menu.getLeadText());

    return scanner.nextInt();
  }
}
