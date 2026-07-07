import java.util.ArrayList;

public class Menu {
    private ArrayList<Item> items;

    // Constructor
    public Menu() {
        items = new ArrayList<>();
    }

    // Parametrized Constructor
    public Menu(ArrayList<Item> items) {
        this.items = items;
    }

    // Setter
    public void setMenu(ArrayList<Item> items) {
        this.items = items;
    }

    // Getter
    public ArrayList<Item> getMenu() {
        return items;
    }


    // Add Item to the menu
    public void addItem(Item item) {
        items.add(item);
    }

    // Show Menu items
    public void showItems() {
        ItemPrinter.printItems(items);
    }

}
