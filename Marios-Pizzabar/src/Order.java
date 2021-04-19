import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Order {
  LocalDateTime dateTime;
  double totalPrice;
  ArrayList<Pizza> orderList = new ArrayList<>();

  DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    // Getter
  public double getTotalPrice() {
    return totalPrice;
  }

}



