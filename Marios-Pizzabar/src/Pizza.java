//Alexander
public class Pizza {
    String name;
    double price;
    int number;

    public void Pizza(String name, double price, int number){
        this.name=name;
        this.price=price;
        this.number=number;

    }
    public int getNumber() {
        return number;
    }
    public double getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setName(String name){
        this.name=name;
    }
}
