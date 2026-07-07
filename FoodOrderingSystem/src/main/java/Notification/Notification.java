package Notification;
import System.Customer;

public abstract class Notification {
    protected Customer customer;

    public Notification(Customer customer) {
        this.customer = customer;
    }
    public abstract void sendNotification();
}
