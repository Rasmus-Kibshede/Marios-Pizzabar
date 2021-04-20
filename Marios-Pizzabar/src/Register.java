import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

public class Register {
  private Menu menu;
  private UI ui;
  private ArrayList<Order> orders;

  // Rasmus + Martin
  public void run() {
    ui = new UI();
    //menu = new Menu();
    orders = new ArrayList<>();

    //Menu here
    int choice;
    do {
      // ui.printOptionsMenu();
      choice = ui.getInt();
      switch (choice) {
        case 1:
          //showMenu();
          break;
        case 2:
          //create order
          break;
        case 3:
          //delete order
          break;
        case 4:
          showStatistics();
          break;
        case 5:
          // showOrders();
          break;
        default:
          System.out.println("Invalid choice");
      }
      System.out.println();
    } while (choice != 6);
  }


  // Martin
  public void showMenu() {
    //menu.getMenuList();
  }

  // Martin
  public void createOrder(ArrayList<Pizza> pizzas) {
    try {
      Order order = new Order(pizzas); // ID
      PrintStream ps = new PrintStream("Marios-Pizzabar/statistics.txt");
      ArrayList<String> orderStats = order.statisticsFormat();
      for (String s : orderStats) {
        ps.append(s);
      }

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
    ArrayList<String> storage = new ArrayList<>();
    HashMap<String, Double> statistic = new HashMap<>();

    // Add each line of the file to storage as strings
    try {
      Scanner input = new Scanner(new File("Marios-Pizzabar/statistics.txt"));
      while (input.hasNextLine()) {
        String text = input.nextLine();
        storage.add(text);
      }
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }

    // Split every element in storage, then add to map. Key values get multiplied by the occurrences of the same key name
    for (int i = 0; i < storage.size(); i++) {
      String[] arr = storage.get(i).split("_");
      String name = arr[0];
      double price = Double.parseDouble(arr[1]);
      statistic.put(name, price * Collections.frequency(storage, storage.get(i)));
    }

    ArrayList<String> sorted = new ArrayList<>();

    // Iterates over the map, then adds it to sorted
    Iterator it = statistic.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      String s = "$" + pair.getValue() + " \t " + pair.getKey();
      sorted.add(s);
      it.remove();
    }

    sorted.sort(Collections.reverseOrder());

    for (int i = 0; i < sorted.size(); i++) {
      System.out.println((i + 1) + ": " + sorted.get(i));
    }
  }
}
