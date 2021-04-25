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
      ui.printString("");
      switch (choice) {
        case 1 -> showMenu();
        case 2 -> createOrder();
        case 3 -> viewOrders();
        case 4 -> finishOrder();
        case 5 -> deleteOrder();
        case 6 -> new Statistic().showStatistics();
        case 7 -> clearOrders();
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
      ui.printColorString("green","Finished order #" + id);
    }
  }

  // Martin + Rasmus
  public void createOrder() {
    ArrayList<Pizza> pizzas = new ArrayList<>();

    String temp = validatePickUp();
    ui.printString("Select your order - type 0 to finish");

    int count = 1;

    // Finds pizzas from the menu with pizzaNumbers that matches the choice(s)
    int choice = -1;
    int nullValidate = 0;
    while (choice != 0) {
      ui.printStringAppend("Pizza " + count + ": ");
      choice = validRange(1, 30);

        for (Pizza p : menu.getMenu()) {
          if (p.getPIZZANUMBER() == choice && choice != 0) {
            pizzas.add(p);
            nullValidate = 1;
          }
        }
      count++;
      }

    if (nullValidate == 1) {
      Order order = new Order(pizzas, temp);
      ui.printStringAppend("Total price: ");
      ui.printStringAppend(ui.getColorString("green", "$" + order.totalPricePizza()));
      ui.printString("");
      orders.add(order);
      saveOrder();
    }
  }

  // Martin
  public void saveOrder() {
    try {
      PrintStream ps = new PrintStream(new FileOutputStream("orders.txt"));
      for (Order o : orders) {
        ps.append(o.getPickUpStatus());
        ps.append("_");
        ps.append(o.getDATETIME());
        ps.append("_");

        for (Pizza p : o.getORDERLIST()) {
          ps.append(String.valueOf(p.getPIZZANUMBER()));
          ps.append("_");
        }
        ps.append("\n");
      }
    } catch (FileNotFoundException e) {
      ui.printColorString("red","File not found");
    }
  }

  // Martin
  public void loadOrder() {
    ArrayList<String> storage = new Statistic().fileToList("orders.txt");
    ArrayList<Pizza> pizzas = new ArrayList<>();
    String status;
    String date;

    for (String s : storage) {
      String[] temp = s.split("_");
      status = temp[0];
      date = temp[1];

      for (int i = 2; i < temp.length; i++) {

        for (Pizza p : menu.getMenu()) {
          if (Integer.parseInt(temp[i]) == p.getPIZZANUMBER()) {
            pizzas.add(p);
          }
        }
      }
      orders.add(new Order(new ArrayList<>(pizzas), status, date));
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
      ui.printColorString("red","Not a valid ID");
    }
    return 0;
  }

  // Martin
  public ArrayList<Integer> orderIds() {
    ArrayList<Integer> ids = new ArrayList<>();
    for (Order o : orders) {
      ids.add(o.getID());
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
      if (o.getID() == id) {
        return o;
      }
    }
    return null;
  }

  // Martin
  public void clearOrders() {
    ui.printColorString("yellow", "Are you sure you want to clear the orders? \"y\" to clear.");
    ui.printStringAppend("Choice: ");
    String s = ui.getString();
    if (s.equals("y")) {
      orders.clear();
      saveOrder();
    }
  }

  //----------------------------------------------- Validates ---------------------------------------------

  //Rasmus
  public int validRange(int range1 , int range2) {
    int choice = validateChoice("Invalid input");

    while (!(choice >= range1 && choice <= range2 || choice == 0)) {
      ui.printColorString("red", "Out of range, enter a new number");
      choice = validateChoice("Invalid input, enter a new number");
    }

    return choice;
  }

  public int validateChoice(String text) {
    int choice = -1;
    while (choice == -1) {
      if (ui.hasNextInt()) {
        choice = ui.getInt();
      } else {
        ui.printColorString("red", text);
      }
      ui.getString();
    }
    return choice;
  }

  public String validatePickUp() {
    ui.printStringAppend("Pick up? (y/n) : ");
    String choice = " ";

    while (!(choice.equals("y") || choice.equals("n"))) {
      choice = ui.getString();
      if (!(choice.equals("y") || choice.equals("n"))) {
        ui.printColorString("red", "Invalid choice");
      }
    }

    if (choice.equals("y")) {
      return ui.getColorString("blue", "Called");
    }
    else {
      return ui.getColorString("cyan", "In store");
    }
  }
}
