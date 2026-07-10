package orders;

import helper.ItemPrinter;
import notifications.*;
import payments.*;
import system.Customer;
import system.Item;


import java.util.ArrayList;

public class Order {
    private  ArrayList<Item> items = new ArrayList<>();
    private final Customer customer;
    private Payment payment;
    private Notification notification;

    // This Constructor Access is through the package as
    // it will be used by OrderBuilder
     Order(Customer customer, Payment payment, Notification notification, ArrayList<Item> items) {
         this.customer = customer;
         this.payment = payment;
         this.notification = notification;
         this.items = items;
    }



    // Setting the payment method
    public void setPaymentMethod(Payment payment) {
        this.payment = payment;
    }

    // Getting the payment method
    public void performPayment() {
        if (payment == null) {
            throw new NullPointerException("Payment wasn't set correctly");
        }
        payment.pay();
    }

    // Setting Notification.Notification Type
    public void setNotificationType(Notification notification) {
        this.notification = notification;
    }

    // Getting the Notification.Notification Type
    public void sendNotification() {
        if (notification == null) {
            throw new NullPointerException("Notification method wasn't set correctly");
        }
        notification.sendNotification();
    }

    // Add item
    public void addItem(Item item) {
        items.add(item);
    }

    // Calculate Total Price
    public double totalPrice() {
        double total = 0;
        for (Item item: items) {
            total = total + item.getPrice();
        }
        return total;
    }



    // Printing System.Order Summary
    public void orderSummary() {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Location: " + customer.getLocation());
        System.out.println("####################");
        showItems();
        System.out.println("####################");
        System.out.println("Total Price: " + totalPrice());

    }

    private  void showItems() {
      ItemPrinter.printItems(items);
    }

}
