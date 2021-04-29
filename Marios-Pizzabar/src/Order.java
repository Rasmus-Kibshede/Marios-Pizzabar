import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

// Jakob
public class Order {
  private final String DATETIME;
  private final int ID;
  private static int count;
  private String pickUpStatus;
  private final ArrayList<Pizza> ORDERLIST;

  public Order(ArrayList<Pizza> thisOrder, String status) {
    ORDERLIST = thisOrder;
    setPickUpStatus(status);
    count++;
    ID = count;

    DateFormat df = new SimpleDateFormat("HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    DATETIME = df.format(today);
  }

  public Order(ArrayList<Pizza> thisOrder, String status, String date) {
    ORDERLIST = thisOrder;
    setPickUpStatus(status);
    count++;
    ID = count;
    DATETIME = date;
  }

  public int getID() {
    return ID;
  }

  public String getDATETIME() {
    return DATETIME;
  }

  public void setPickUpStatus(String pickUpStatus) {
    this.pickUpStatus = pickUpStatus;
  }

  public String getPickUpStatus() {
    return pickUpStatus;
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
    text.append(DATETIME);
    return text.toString();
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
