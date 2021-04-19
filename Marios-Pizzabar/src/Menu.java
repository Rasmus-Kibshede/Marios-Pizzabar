import java.util.ArrayList;

public class Menu {
    private ArrayList<Pizza> menuList = new ArrayList<>();
    private String menuHeader;
    private String leadText;
    private ArrayList<String> menuItems;

    // Martin
    public Menu(String menuHeader, String leadText, ArrayList<String> menuItems) {
        this.menuHeader = menuHeader;
        this.leadText = leadText;
        this.menuItems = menuItems;
    }

    // Martin
    public void addPizza(Pizza pizza) {
        menuList.add(pizza);
    }

    // Martin
    public void deletePizza(int id) {
        for (Pizza p : menuList) {
            if (p.getNumber() == id) {
                menuList.remove(p);
                break;
            }
        }
    }

    // Martin
    public ArrayList<Pizza> getMenuList() {
        return menuList;
    }
}
