import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Order {
  // Jakob
  private final String DATETIME;
  private final int ID;
  private static int count;
  private String pickUpStatus;
  private final ArrayList<Pizza> ORDERLIST;
  DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("HH:mm:ss");

  public int getID() {
    return ID;
  }

  public void setPickUpStatus(String pickUpStatus) {
    this.pickUpStatus = pickUpStatus;
  }

  public String getPickUpStatus() {
    return pickUpStatus;
  }

  public Order(ArrayList<Pizza> thisOrder, String name) {
    ORDERLIST = thisOrder;
    setPickUpStatus(name);
    count++;
    ID = count;

    LocalDateTime timeNow = LocalDateTime.now();
    LocalDateTime timeToPickThePizza = timeNow.plusMinutes(10);
    this.DATETIME = timeToPickThePizza.format(formatDateTime);
  }

  // Martin
  public ArrayList<String> statisticsFormat() {
    ArrayList<String> lst = new ArrayList<>();
    for (Pizza pizza : ORDERLIST) {
      lst.add(pizza.getPIZZANAME() + "_" + pizza.getPIZZAPRICE());
    }
    return lst;
  }

  // Martin + Jakob
  public String toString() {
    StringBuilder text = new StringBuilder();
    text.append("#").append(ID).append(" ").append(pickUpStatus).append(" - ");
    for (int i = 0; i < ORDERLIST.size() - 1; i++) {
      text.append(ORDERLIST.get(i).getPIZZANAME()).append(", ");
    }
    text.append(ORDERLIST.get(ORDERLIST.size() - 1).getPIZZANAME()).append(" ");
    text.append("- ");
    text.append(new UI().getColorString("yellow", convertDateToString()));
    return text.toString();
  }

  // Martin
  public String convertDateToString() {
    DateFormat df = new SimpleDateFormat("HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    return df.format(today);
  }

  // Martin + Jakob
  public ArrayList<Pizza> getORDERLIST() {
    return ORDERLIST;
  }

  public double totalPricePizza() {
    double sum = 0;
    for (Pizza pizza : ORDERLIST) {
      sum += pizza.getPIZZAPRICE();
    }
    return sum;
  }
}
