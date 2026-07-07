import java.util.ArrayList;

// Helper class to showItems inside Menu class and Order class
public class ItemPrinter {
    public  static void printItems (ArrayList<Item> items) {
        int itemNumber = 1;
        for (Item item: items) {
            System.out.println("Item " + itemNumber + ": " + item.getName());
            System.out.println("Price: " + item.getPrice());

            if (itemNumber < items.size()) {
                System.out.println("####################");
            }
            itemNumber++;
        }
    }
}
