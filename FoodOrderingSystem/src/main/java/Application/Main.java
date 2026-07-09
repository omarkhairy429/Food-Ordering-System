package Application;

import java.util.ArrayList;
import java.util.List;

import notifications.EmailNotification;
import notifications.Notification;
import payments.Cash;
import payments.Payment;
import system.*;



public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Omar Fayed", "Egypt, Cairo");
        Payment payment = new Cash();
        Notification notification = new EmailNotification(customer1);


        /* 1) Creating The Restaurant System.Menu   */
        Item item1 = new Item("Burger", 300);
        Item item2 = new Item("Steak", 450);
        Item item3 = new Item("Fries", 100);
        Item item4 = new Item("Pizza", 500);
        Item item5 = new Item("BBQ Sauce", 50);
        Item item6 = new Item("Pepsi", 30);
        ArrayList<Item> items = new ArrayList<Item>(List.of(item1, item2, item3, item4, item5, item6));
        Menu restaurant1 = new Menu(items);

        /* 2) Customer views the menu */
        restaurant1.showItems();
        System.out.println("\n");

        /* 3) System.Customer adds Items to his System.Order */
        Order order1 = new Order.OrderBuilder(customer1)
                .payment(payment)
                .notification(notification)
                .build();

        customer1.addItem(order1, item2);
        customer1.addItem(order1, item6);

        /* 4) System.Customer chooses the payment method */
        customer1.choosePaymentPlan(order1, payment);


        /* 5) Printing System.Order Summary */
        order1.orderSummary();

        /* 6) Sending Notification */
        order1.sendNotification();


    }

}


