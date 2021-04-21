import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class Register {
  private Menu menu;
  private UI ui;
  private ArrayList<Order> orders;

  // Rasmus + Martin
  public void run() {
    ArrayList<String> options = new ArrayList<>();
    options.add("1" + ". Show Menu:");
    options.add("2" + ". Create order:");
    options.add("3" + ". Delete order:");
    options.add("4" + ". Show statistics:");
    options.add("5" + ". View orders:");
    options.add("6" + ". Exit program:");

    ui = new UI();
    menu = new Menu("Options:", "Choose: ", options);
    orders = new ArrayList<>();

    int choice;
    do {
      ui.printOptionsMenuTest(menu);
      choice = ui.getInt();
      switch (choice) {
        case 1:
          showMenu();
          break;
        case 2:
          //create order
          break;
        case 3:
          deleteOrder(ui.getInt());
          break;
        case 4:
          showStatistics();
          break;
        case 5:
          // viewOrders();
          break;
        case 6:
          System.out.println("Exiting program...");
        default:
          System.out.println("Invalid choice");
      }
      System.out.println();
    } while (choice != 6);
  }


  // Martin
  public void showMenu() {
    System.out.println(menu.getPizzaMenuList());
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

  public void showOrders() {

  }

  // Martin
  public void deleteOrder(int id) {
    for (Order o : orders) {
      if (o.getId() == id) {
        orders.remove(o);
        break;
      }
    }
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
