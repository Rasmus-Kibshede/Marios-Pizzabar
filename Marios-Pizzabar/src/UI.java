import java.util.ArrayList;
import java.util.Scanner;

public class UI {
  Menu menu = new Menu();
  private Scanner scanner = new Scanner(System.in);

  //Rasmus + Alex
  public String printPizzaMenu(String messege){
    return messege;
  }
  // Alex
  public int printPizzaNumber(int pizzaNumber){
    return pizzaNumber;
  }
  //Rasmus
  public void printOrders(ArrayList<Order> orders){
    //ArrayList here or in main ?
  }

  //Rasmus + Alex
  // brug konstruktør fra menu
  public int readMenuChoice(){

    System.out.println("Seleckt one of the following opstions: ");
    System.out.println("1. Show Menu");
    System.out.println("2. Create Order");
    System.out.println("3. Delete Order");
    System.out.println("4. Statistics");
    System.out.println("5. Quite");

    return scanner.nextInt();
  }
}
