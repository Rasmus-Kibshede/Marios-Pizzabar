import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    options.add("6" + ". Finish order:");
    options.add("7" + ". Clear orders:");
    options.add("9" + ". Exit program:");

    ui = new UI();
    menu = new Menu("Options:", "Choose: ", options);
    orders = new ArrayList<>();
    loadOrder();

    int choice;
    do {
      ui.printOptionsMenu(menu);
      choice = validateChoice("Invalid choice");
      switch (choice) {
        case 1:
          showMenu();
          break;
        case 2:
          createOrder();
          break;
        case 3:
          deleteOrder(ui.getInt());
          break;
        case 4:
          showStatistics();
          break;
        case 5:
          viewOrders();
          break;
        case 6:
          finishOrder(ui.getInt());
          break;
        case 7:
          clearOrders();
          break;
        case 9:
          ui.printString("Exiting program...");
          break;
        default:
          ui.printString("Invalid choice");
      }
      ui.printString("");
    } while (choice != 9);
  }

  // Martin
  public void showMenu() {
    ui.printString(menu.getPizzaMenuList());
  }

  // Martin
  public void finishOrder(int id) {
    try {
      Order order = findOrder(id);
      PrintStream ps = new PrintStream(new FileOutputStream("statistics.txt", true));
      ArrayList<String> orderStats = order.statisticsFormat();

      for (String s : orderStats) {
        ps.append(s);
        ps.append("\n");
      }
      ps.close();
    } catch (FileNotFoundException e) {
      ui.printString("File not found");
    }
    deleteOrder(id);
  }

  // Martin
  public void createOrder() {
    ArrayList<Pizza> pizzas = new ArrayList<>();
    ui.printString("Select your order - type 0 to finish");
    int count = 1;

    // Finds pizzas from the menu with pizzaNumbers that matches the choice(s)
    int choice = -1;
    while (choice != 0) {
      ui.printStringAppend("Pizza " + count + ": ");
      choice = validateChoice("Invalid choice");

      //Validate range
      if (isValidRange(1,30,choice)) {

        for (Pizza p : menu.getMenu()) {
          if (p.getPizzaNumber() == choice && choice != 0) {
            pizzas.add(p);
          }
        }
        count++;
        orders.add(new Order(pizzas));
        saveOrder();
      }
    }

  }

  // Martin
  public void saveOrder() {
    try {
      PrintStream ps = new PrintStream(new FileOutputStream("orders.txt"));
      for (Order o : orders) {
        for (Pizza p : o.getOrderList()) {
          ps.append(String.valueOf(p.getPizzaNumber()));
          ps.append("_");
        }
        ps.append("\n");
      }
    } catch (FileNotFoundException e) {
      ui.printString("File not found");
    }
  }

  // Martin
  public void loadOrder() {
    ArrayList<String> storage = new ArrayList<>();
    ArrayList<Pizza> pizzas = new ArrayList<>();

    try {
      Scanner input = new Scanner(new File("orders.txt"));
      while (input.hasNextLine()) {
        String text = input.nextLine();
        storage.add(text);
      }
    } catch (FileNotFoundException e) {
      ui.printString("File not found");
    }

    for (String s : storage) {
      String[] temp = s.split("_");
      for (String s2 : temp) {
        for (Pizza p : menu.getMenu()) {
          if (Integer.parseInt(s2) == p.getPizzaNumber()) {
            pizzas.add(p);
          }
        }
      }
      orders.add(new Order(new ArrayList<>(pizzas)));
      pizzas.clear();
    }
  }

  // Martin
  public void viewOrders() {
    for (Order o : orders) {
      ui.printString(o.toString());
    }
  }

  // Martin
  public void deleteOrder(int id) {
    orders.remove(findOrder(id));
    saveOrder();
  }

  // Martin
  public Order findOrder(int id) {
    for (Order o : orders) {
      if (o.getId() == id) {
        return o;
      }
    }
    return null;
  }

  // Martin
  public void showStatistics() {
    ArrayList<String> storage = fileToList();
    HashMap<String, Double> map = addToMap(storage);
    iterateMap(map);

  }

  // Martin
  public ArrayList<String> fileToList() {
    ArrayList<String> storage = new ArrayList<>();

    try {
      Scanner input = new Scanner(new File("statistics.txt"));
      while (input.hasNextLine()) {
        String text = input.nextLine();
        storage.add(text);
      }
      input.close();
    } catch (FileNotFoundException e) {
      ui.printString("File not found");
    }
    return storage;
  }

  // Martin
  public HashMap<String, Double> addToMap(ArrayList<String> storage) {
    HashMap<String, Double> statistic = new HashMap<>();

    // Split every element in storage, then add to map. Key values get multiplied by the occurrences of the same key name
    for (int i = 0; i < storage.size(); i++) {
      String[] arr = storage.get(i).split("_");
      String name = arr[0];
      double price = Double.parseDouble(arr[1]);
      statistic.put(name, price * Collections.frequency(storage, storage.get(i)));
    }
    return statistic;
  }

  // Martin
  public void iterateMap(HashMap<String, Double> statistic) {
    ArrayList<String> lst = new ArrayList<>();

    // Iterates over the map, then adds it to lst
    Iterator it = statistic.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      String s = "$" + pair.getValue() + " \t " + pair.getKey();
      lst.add(s);
      it.remove();
    }

    for (int i = 0; i < lst.size(); i++) {
      ui.printString((i + 1) + ": " + lst.get(i));
    }
  }

  // Martin
  public void clearOrders() {
    orders.clear();
    saveOrder();
  }

  public int validateChoice(String text) {
    int choice = -1;
    while (choice == -1) {
      if (ui.hasNextInt()) {
        choice = ui.getInt();
        ui.getString();
      } else {
        ui.printString(text);
        //ui.printString();
        ui.getString();
      }
    }
    return choice;
  }
  public boolean isValidRange(int range1 ,int range2, int choice){
    boolean flag = choice>=range1 && choice<=range2;
    if (flag){
      return true;
    }
    else if (!flag && choice != 0){
      ui.printString("Invalid Range");
      return false;
    }else {
      return false;
    }
  }
}
