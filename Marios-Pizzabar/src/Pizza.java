//Alexander + Rasmus
public class Pizza {
    private final String PIZZANAME;
    private final double PIZZAPRICE;
    private final int PIZZANUMBER;
    private final String PIZZATOPPINGS;

    //Alexander + Rasmus
    public Pizza(String pizzaName, double pizzaPrice, int pizzaNumber, String pizzaToppings){
        this.PIZZANAME = pizzaName;
        this.PIZZAPRICE = pizzaPrice;
        this.PIZZANUMBER = pizzaNumber;
        this.PIZZATOPPINGS = pizzaToppings;
    }

    public String getPIZZANAME() {
        return PIZZANAME;
    }

    public double getPIZZAPRICE() {
        return PIZZAPRICE;
    }

    public int getPIZZANUMBER() {
        return PIZZANUMBER;
    }

    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("#")
                .append(PIZZANUMBER)
                .append("\t")
                .append(" $")
                .append(PIZZAPRICE)
                .append("\t ")
                .append(PIZZANAME)
                .append(":\t\t\t\t\t")
                .append(PIZZATOPPINGS);
        return text.toString();
    }
}
