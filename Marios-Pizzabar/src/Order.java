import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;

//Jakob
public class Order {
  String dateTime;
  private double totalPrice;
  private int id;
  private ArrayList<Integer> orderList = new ArrayList<Integer>();

  DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


  // Getter
  public double getTotalPrice() {
    return totalPrice;

  }

  public int getId() {
    return id;

  }

  public Order(ArrayList<Pizza> thisOrder) {
    for (int i = 0; i < thisOrder.size(); i++) {
      orderList.add(thisOrder.get(i).getNumber());
    }

    LocalDateTime timeNow = LocalDateTime.now();
    LocalDateTime timeToPickThePizza = timeNow.plusMinutes(5);
    this.dateTime = timeToPickThePizza.format(formatDateTime);
  }

  public Order(ArrayList<Pizza> thisOrder, int estimatedTime) {
    for (int i = 0; i < thisOrder.size(); i++) {
      orderList.add(thisOrder.get(i).getNumber());
    }

    LocalDateTime timeNow = LocalDateTime.now();
    LocalDateTime timeToPickThePizza = timeNow.plusMinutes(10);
    this.dateTime = timeToPickThePizza.format(formatDateTime);
  }

  public double getPizzaPrice() {
    return 0;
  }


  public String toString() { // ID: #1 - Pizza Name - bestillingstidspunkt
    return null;
  }
/*
  String statisticsFormat() {
    return getName + "_" + getTotalPrice();
  }
 */
}




