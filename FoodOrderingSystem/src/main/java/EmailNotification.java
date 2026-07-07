public class EmailNotification extends Notification {
    public EmailNotification(Customer customer) {
        super(customer);
    }
    public void sendNotification() {
        System.out.println ("Sending Notification by email to customer: " + customer.getName());
    }
}
