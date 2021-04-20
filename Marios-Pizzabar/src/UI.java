import java.util.ArrayList;
import java.util.Scanner;

public class UI {

  //Rasmus
  public void printMenu(){
    //ArrayList here or in main ?
  }

  //Rasmus
  public void printOrders(ArrayList<Order> orders){
    //ArrayList here or in main ?
  }

  //Rasmus
  public int readMenuChoice(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("Seleckt one of the following opstions: ");
    System.out.println("1. Show Menu");
    System.out.println("2. Create Order");
    System.out.println("3. Delete Order");
    System.out.println("4. Statistics");
    System.out.println("5. Quite");

    return scanner.nextInt();
  }



}
