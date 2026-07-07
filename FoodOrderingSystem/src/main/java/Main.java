import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Omar Fayed", "Egypt, Cairo");

        /* 1) Creating The Restaurant Menu   */
        Item item1 = new Item("Burger", 300);
        Item item2 = new Item("Steak", 450);
        Item item3 = new Item("Fries", 100);
        Item item4 = new Item("Pizza", 500);
        Item item5 = new Item("BBQ Sauce", 50);
        Item item6 = new Item("Pepsi", 30);
        ArrayList<Item> items = new ArrayList<Item>(List.of(item1, item2, item3, item4, item5, item6));
        Menu restaurant1 = new Menu(items);

        /* 2) Customer adds Items to his Order */
        Order order1 = new Order(customer1);
        customer1.addItem(order1, item2);
        customer1.addItem(order1, item6);

        /* 3) Customer chooses the payment method */
        customer1.choosePaymentPlan(order1, "visa");


        /* 4) Printing Order Summary */
        order1.orderSummary();

        /* 5) Setting notification type */
        order1.setNotificationType("email");
        order1.sendNotification();


    }

}


