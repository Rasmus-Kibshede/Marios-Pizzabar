import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;


public class Order {
  private String dateTime;
  private double totalPrice;
  private int id;
  private static int count;
  private String name;
  private ArrayList<Pizza> orderList = new ArrayList<>();

  DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

  // Getter
  public double getTotalPrice() {
    return totalPrice;

  }

  public int getId() {
    return id;

  }

  public String getDateTime() {
    return dateTime;

  }

  public void setName(String name) {
    this.name = name;

  }


  // Konstruktør
  public Order(ArrayList<Pizza> thisOrder) {
    orderList = thisOrder;
    count++;
    id = count;

    // Skal det beholdes eller slettes?
    LocalDateTime timeNow = LocalDateTime.now();
    LocalDateTime timeToPickThePizza = timeNow.plusMinutes(5);
    this.dateTime = timeToPickThePizza.format(formatDateTime);
  }


  public Order(ArrayList<Pizza> thisOrder, String name) {
    orderList = thisOrder;
    setName(name);
    count++;
    id = count;

    // Skal det beholdes eller slettes?
    LocalDateTime timeNow = LocalDateTime.now();
    LocalDateTime timeToPickThePizza = timeNow.plusMinutes(10);
    this.dateTime = timeToPickThePizza.format(formatDateTime);
  }

  // Martin
  public ArrayList<String> statisticsFormat() {
    ArrayList<String> lst = new ArrayList<>();
    for (int i = 0; i < orderList.size(); i++) {
      lst.add(orderList.get(i).getPizzaName() + "_" + orderList.get(i).getPizzaPrice());
    }
    return lst;

  }

  // Martin + Jakob
  public String toString() {
    StringBuilder text = new StringBuilder();
    text.append("#").append(id).append(" - ");
    for (int i = 0; i < orderList.size(); i++) {
      text.append(orderList.get(i).getPizzaName()).append(" ");
    }
    text.append(dateTime);
    return text.toString();


  }

  public ArrayList<Pizza> getOrderList() {
    return orderList;
  }

  public double totalPricePizza() {
    double sum = 0;
    for (int i = 0; i < orderList.size(); i++) {
      sum += orderList.get(i).getPizzaPrice();
    }

    return sum;
  }

}





