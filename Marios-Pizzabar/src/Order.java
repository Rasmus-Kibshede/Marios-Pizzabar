import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;

  //Jakob
public class Order {
  LocalDateTime dateTime;
 private double totalPrice;
 private ArrayList<Pizza> orderList = new ArrayList<>();

  DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


  // Getter
  public double getTotalPrice() {
    return totalPrice;
  }

}



