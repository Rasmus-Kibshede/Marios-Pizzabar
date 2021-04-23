import java.util.ArrayList;

public class Menu {
  private ArrayList<Pizza> pizzaMenuList = new ArrayList<>();
  private String menuHeader;
  private String leadText;
  private ArrayList<String> menuOptions;

  // Martin
  public Menu(String menuHeader, String leadText, ArrayList<String> menuOptions) {
    this.menuHeader = menuHeader;
    this.leadText = leadText;
    this.menuOptions = menuOptions;
    createPizzaMenu();
  }

  // Martin + Rasmus
  public void createPizzaMenu() {
    pizzaMenuList.add(new Pizza("Margherita", 5.45, 1, "Tomato sauce, mozzarella, basil."));
    pizzaMenuList.add(new Pizza("Funghi", 6.45, 2, "Tomato sauce, mozzarella, mushrooms, thyme."));
    pizzaMenuList.add(new Pizza("Fiorentina", 7.00, 3, "Tomato sauce, mozzarella, parmesan, egg, fresh spinach."));
    pizzaMenuList.add(new Pizza("Giardino", 7.45, 4, "Tomato Sauce, vegan mozzarella mixed."));
    pizzaMenuList.add(new Pizza("Formaggi", 7.00, 5, "Tomato sauce, mozzarella, parmesan, mascarpone, gorgonzola."));
    pizzaMenuList.add(new Pizza("Regina", 8.00, 6, "Tomato sauce, mozzarella, parmesan, ham, mushrooms, black olives."));
    pizzaMenuList.add(new Pizza("Tropicali", 7.00, 7, "Tomato sauce, mozzarella, ham, pineapple, oregano."));
    pizzaMenuList.add(new Pizza("Pepperoni", 7.45, 8, "Tomato sauce, mozzarella, double pepperoni."));
    pizzaMenuList.add(new Pizza("Calabria", 7.45, 9, "Tomato sauce, mozzarella, mascarpone, nduja, spicy sausage, rocket."));
    pizzaMenuList.add(new Pizza("Carne", 8.00, 10, "Tomato sauce, mozzarella, chicken, beef, pepperoni, onions, rosemary."));
    pizzaMenuList.add(new Pizza("Pollo", 7.45, 11, "Tomato sauce, mozzarella, chicken, mixed, peppers, thyme."));
    pizzaMenuList.add(new Pizza("Fumo", 7.45, 12, "Tomato Sauce, Mozzarella, BBQ Sauce, Chicken, Onions"));
    pizzaMenuList.add(new Pizza("Verona", 7.45, 13, "Tomato Sauce, Mozzarella, Pepperoni, Pancetta Bacon, Green Chillies"));
    pizzaMenuList.add(new Pizza("Roma", 7.45, 14, "Tomato Sauce, Mozzarella, Gorgonzola, Pancetta Bacon, Mushrooms"));
    pizzaMenuList.add(new Pizza("Capra", 7.00, 15, "White Pizza with Mozzarella, Goats Cheese, Black Olives, Rocket"));
    pizzaMenuList.add(new Pizza("Aglio", 7.45, 16, "White Pizza with Mozzarell, Parmesan, Garlic, Rosemary"));
    pizzaMenuList.add(new Pizza("Cosacca", 8.45, 17, "Tomato sauce, red Cherry Tomatoes, Parmesan, Pecorino Romano cheeses"));
    pizzaMenuList.add(new Pizza("Luxury Marinara", 9.00, 18, "Tomato sauce, Piennolo cherry Tomatoes, Garlic, Oregano and Basil"));
    pizzaMenuList.add(new Pizza("Napoletana", 9.45, 19, "Tomato sauce, Mozzarella, Anchovies, Black, Olives,Capers, Oregano and Basil"));
    pizzaMenuList.add(new Pizza("Siciliana", 9.45, 20, "Tomato Sauce, Mozzarella, Smoked, Mozzarella, Sauteed Aubergines, Salted Rico"));
    pizzaMenuList.add(new Pizza("Diavola", 10.00, 21, "Tomato sauce, Mozzarella, Spicy Salami, Basil"));
    pizzaMenuList.add(new Pizza("Focosa", 9.45, 22, "Spicy N'duja sauce, Burrata and Basil"));
    pizzaMenuList.add(new Pizza("Vegetariana", 8.45, 23, "Mozzarella, Garlic, Black Olives, yellow Datterino Tomato"));
    pizzaMenuList.add(new Pizza("Prosciutto", 9.45, 24, "Tomato sauce, Mozzarella, herbal Ham, Mushrooms, Basil"));
    pizzaMenuList.add(new Pizza("Formaggi", 9.45, 25, "Mozzarella, Pecorino Romano, Parmesan, Smoked Mozzarella and Gorgonzola"));
    pizzaMenuList.add(new Pizza("Capricciosa", 10.00, 26, "Tomato sauce, Mozzarella, herbal Ham, Salame Napoli, Artichokes, Black Olives"));
    pizzaMenuList.add(new Pizza("Salsiccia e Friarielli", 10.45, 27, "Mozzarella, fried friarielli (broccoli rabe), Smoked Mozzarella, Italian Sausage"));
    pizzaMenuList.add(new Pizza("Vogliosa", 9.45, 28, "Mozzarella,Smoked Mozzarella,Spicy N'duja, cream, Yellow piennolo cherry tomatoes"));
    pizzaMenuList.add(new Pizza("Parma", 9.45, 29, "Tomato sauce, Mozzarella, Parma Ham, Parmesan shavings"));
    pizzaMenuList.add(new Pizza("Bufalina", 9.45, 30, "Tomato Sauce, Buffalo Mozzarella and Basil"));
  }

  public String getMenuHeader() {
    return menuHeader;
  }

  public String getLeadText() {
    return leadText;
  }

  // Rasmus
  public String getPizzaMenuList() {
    StringBuilder text = new StringBuilder();
    for (Pizza pizza : pizzaMenuList) {
      text.append("\n").append(pizza);
    }
    text.append("\n");

    return text.toString();
  }

  public String getMenuOptions() {
    StringBuilder text = new StringBuilder();
    for (String menuOption : menuOptions) {
      text.append("\n").append(menuOption);
    }
    text.append("\n");

    return text.toString();
  }

  public ArrayList<Pizza> getMenu() {
    return pizzaMenuList;
  }
}
