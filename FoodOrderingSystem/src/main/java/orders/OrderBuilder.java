package orders;

import notifications.Notification;
import payments.Payment;
import system.Customer;
import system.Item;

import java.util.ArrayList;

public  class OrderBuilder {
    private ArrayList<Item> items = new ArrayList<>();
    private final Customer customer;
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
        return new Order(customer, payment, notification, items);
    }

}