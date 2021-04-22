//Alexander + Rasmus
public class Pizza {
    String pizzaName;
    double pizzaPrice;
    int pizzaNumber;
    String pizzaToppings;

    //Alexander + Rasmus
    public Pizza(String pizzaName, double pizzaPrice, int pizzaNumber, String pizzaToppings){
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.pizzaNumber = pizzaNumber;
        this.pizzaToppings = pizzaToppings;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public int getPizzaNumber() {
        return pizzaNumber;
    }

    public String getPizzaToppings() {
        return pizzaToppings;
    }

    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("#")
                .append(pizzaNumber)
                .append("\t")
                .append(" $")
                .append(pizzaPrice)
                .append("\t ")
                .append(pizzaName)
                .append(":\t\t\t\t\t")
                .append(pizzaToppings);
        return text.toString();
    }
}
