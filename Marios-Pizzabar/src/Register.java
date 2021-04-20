import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Register {
  private Menu menu;
  private UI ui;
  private ArrayList<Order> orders;

  //Rasmus
  public void run() {
    showStatistics();
    ui = new UI();
    //menu = new Menu();
    orders = new ArrayList<>();

    //Menu here
  /*
    //do while here
    switch (menu.readChoice) {
      case 1:
        showMenu();
        break;
      case 2:
        //create order
        break;
      case 3:
        //delete order
        break;
      case 4:
        //statistics
        break;
      case 5:
        //quit
        break;
      default:
        //Error
    }
 */


  }


  // Martin
  public void showMenu() {
    //menu.getMenuList();
  }

  // Martin
  public void createOrder() {
    try {
      Order order = new Order(); // ID
      PrintStream ps = new PrintStream("statistics");
      //ps.append(order.statisticsFormat());
      orders.add(order);
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }

  }

  // Martin
  public void deleteOrder(int id) {
    //for (Order o : orders) {
    //  if (o.getID() == id) {
    //    orders.remove(o);
    //    break;
    //  }
    //}
  }

  // Martin
  public void showStatistics() {
    HashMap<String, Double> statisticsMap = new HashMap<>();
    int count = 0;
    try {
      Scanner input = new Scanner(new File("Marios-Pizzabar/statistics.txt"));
      while (input.hasNextLine()) {
        String text = input.nextLine();
        String[] arr = text.split("_");




      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    System.out.println(statisticsMap);

  }








}
