package notifications;
import system.Customer;

public class SmsNotification extends Notification {
    public SmsNotification(Customer customer) {
        super(customer);
    }
    public void sendNotification() {
        System.out.println ("Sending Notification by SMS to customer: " + customer.getName());
    }
}
