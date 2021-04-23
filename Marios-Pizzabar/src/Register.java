import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Register {
  private Menu menu;
  private UI ui;
  private ArrayList<Order> orders;
  private Color color = new Color();

  // Rasmus + Martin
  public void run() {
    ArrayList<String> options = new ArrayList<>();
    options.add("1" + ". Show Menu:");
    options.add("2" + ". Create order:");
    options.add("3" + ". View orders:");
    options.add("4" + ". Finish order:");
    options.add("5" + ". Delete order:");
    options.add("6" + ". Show statistics:");
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
        case 1 -> showMenu(); // SHOW
        case 2 -> createOrder(); // CREAT
        case 3 -> viewOrders(); // VIEW
        case 4 -> finishOrder(); // FINISH
        case 5 -> deleteOrder(); // DELETE
        case 6 -> showStatistics(); // STATS
        case 7 -> clearOrders(); // CLEAR
        case 9 -> ui.printString("Exiting program...");
        default -> ui.printString("Invalid choice");
      }
      ui.printString("");
    } while (choice != 9);
  }

  // Martin
  public void showMenu() {
    ui.printString(menu.getPizzaMenuList());
  }

  // Martin
  public void finishOrder() {
    int id = getValidId();
    if (id != 0) {
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

    ui.printString("Finished order #" + id);

  }

  // Martin + Rasmus
  public void createOrder() {
    ArrayList<Pizza> pizzas = new ArrayList<>();
    String temp;

    ui.printStringAppend("Pick up? (y/n) : ");
    String pickUp = ui.getString();
    if (pickUp.equals("y")) {
      temp = ui.getColorString("blue", "Called");
    } else {
      temp = ui.getColorString("cyan", "In store");
    }
    ui.printString("Select your order - type 0 to finish");

    int count = 1;

    // Finds pizzas from the menu with pizzaNumbers that matches the choice(s)
    int choice = -1;
    while (choice != 0) {
      ui.printStringAppend("Pizza " + count + ": ");
      choice = validateChoice("Invalid choice");

      //Validate range
      while (!isValidRange(1, 30, choice)){
        ui.printColor("red", "Out of range");
        choice = validateChoice("Invalid choice");
      }

        for (Pizza p : menu.getMenu()) {
          if (p.getPizzaNumber() == choice && choice != 0) {
            pizzas.add(p);
          }
        }
      count++;
      }
    Order order = new Order(pizzas, temp);

    ui.printStringAppend("Total price: ");
    ui.printStringAppend(ui.getColorString("green", "$" + String.valueOf(order.totalPricePizza())));
    ui.printString("");
    orders.add(order);

    saveOrder();
  }

  // Martin
  public void saveOrder() {
    try {
      PrintStream ps = new PrintStream(new FileOutputStream("orders.txt"));
      for (Order o : orders) {
        ps.append(o.getPickUpStatus());
        ps.append("_");
        for (Pizza p : o.getOrderList()) {

          ps.append(String.valueOf(p.getPizzaNumber()));
          ps.append("_");
        }
        ps.append("\n");
      }
    } catch (FileNotFoundException e) {
      ui.printColor("red","File not found");
    }
  }

  // Martin
  public void loadOrder() {
    ArrayList<String> storage = new ArrayList<>();
    ArrayList<Pizza> pizzas = new ArrayList<>();
    String status;

    try {
      Scanner input = new Scanner(new File("orders.txt"));
      while (input.hasNextLine()) {
        String text = input.nextLine();
        storage.add(text);
      }
    } catch (FileNotFoundException e) {
      ui.printColor("red","File not found");
    }

    for (String s : storage) {
      String[] temp = s.split("_");
      status = temp[0];

      for (int i = 1; i < temp.length; i++) {

        for (Pizza p : menu.getMenu()) {
          if (Integer.parseInt(temp[i]) == p.getPizzaNumber()) {
            pizzas.add(p);
          }
        }
      }
      orders.add(new Order(new ArrayList<>(pizzas), status));
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
  public int getValidId() {
    ui.printStringAppend("Enter order ID: ");
    int id = validateChoice("Invalid choice");
    if (orderIds().contains(id)) {
      return id;
    } else {
      ui.printColor("red","Not a valid ID");
    }
    return 0;
  }

  // Martin
  public ArrayList<Integer> orderIds() {
    ArrayList<Integer> ids = new ArrayList<>();
    for (Order o : orders) {
      ids.add(o.getId());
    }
    return ids;
  }

  // Martin
  public void deleteOrder() {
    int id = getValidId();
    orders.remove(findOrder(id));
    saveOrder();
  }

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
  public void clearOrders() {
    ui.printColor("yellow", "Are you sure you want to clear the orders? \"y\" to clear.");
    ui.printStringAppend("Choice: ");
    String s = ui.getString();
    if (s.equals("y")) {
      orders.clear();
      saveOrder();
    }
  }

  public void showStatistics() {
    Statistics stats = new Statistics();
    ArrayList<String> storage = stats.fileToList();
    HashMap<String, Double> map = stats.addToMap(storage);
    stats.iterateMap(map);
  }

  public int validateChoice(String text) {
    int choice = -1;
    while (choice == -1) {
      if (ui.hasNextInt()) {
        choice = ui.getInt();
      } else {
        ui.printColor("red", text);
      }
      ui.getString();
    }
    return choice;
  }
  public boolean isValidRange(int range1 ,int range2, int choice) {
    return choice >= range1 && choice <= range2 || choice == 0;
  }
}
