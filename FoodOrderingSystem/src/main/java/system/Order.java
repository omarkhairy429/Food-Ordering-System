package system;

import helper.ItemPrinter;
import notifications.*;
import payments.*;


import java.util.ArrayList;

public class Order {
    private ArrayList<Item> items = new ArrayList<>();
    private Customer customer;
    private Payment payment;
    private Notification notification;

    private Order(OrderBuilder builder) {
        this.customer = builder.customer;
        this.items = builder.items;
        this.payment = builder.payment;
        this.notification = builder.notification;
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


    /* Order Builder Class */

    public static class OrderBuilder {
        private ArrayList<Item> items = new ArrayList<>();
        private Customer customer;
        private Payment payment;
        private Notification notification;

        public OrderBuilder(Customer customer) {
            this.customer = customer;
        }

        public OrderBuilder payment(Payment payment) {
            this.payment = payment;
            return this;
        }

        public OrderBuilder notification(Notification notification) {
            this.notification = notification;
            return this;
        }
        public OrderBuilder items(ArrayList<Item> items) {
            this.items = items;
            return this;
        }

        public Order build() {
            return new Order(this);
        }

    }
}
