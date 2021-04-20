import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;

//Jakob
public class Order {
  private String dateTime;
  private double totalPrice;
  private int id;
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

  public Order(ArrayList<Pizza> thisOrder) {

    orderList = thisOrder;


    LocalDateTime timeNow = LocalDateTime.now();
    LocalDateTime timeToPickThePizza = timeNow.plusMinutes(5);
    this.dateTime = timeToPickThePizza.format(formatDateTime);
  }

  public Order(ArrayList<Pizza> thisOrder, int estimatedTime) {
    orderList = thisOrder;




    LocalDateTime timeNow = LocalDateTime.now();
    LocalDateTime timeToPickThePizza = timeNow.plusMinutes(10);
    this.dateTime = timeToPickThePizza.format(formatDateTime);
  }
  //Hvad skulle jeg lave her?
  public String toString() { // ID: #1 - Pizza Name - bestillingstidspunkt
    return null;
  }

  // Martin
  public ArrayList<String> statisticsFormat() {
    ArrayList<String> lst = new ArrayList<>();
    for (int i = 0; i < orderList.size(); i++) {
      lst.add(orderList.get(i).getPizzaName() + "_" + orderList.get(i).getPizzaPrice());
    }
    return lst;
  }



  /* Rasmus
  public String getOrderList() {
    StringBuilder text = null;
    for (int i = 0; i < orderList.size(); i++) {
      text.append("\n").append(orderList.get(i));
    }
    text.append("\n");

    return text.toString();
  }

   */
}




