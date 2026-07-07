import java.util.ArrayList;

public class Order {
    private ArrayList<Item> items = new ArrayList<>();
    private Customer customer;
    private Payment payment;
    private Notification notification;

    // Constructor
    public Order(Customer customer) {
        this.customer = customer;
    }

    // Setting the payment method
    public void setPaymentMethod(String typeOfPayment) {
        if (typeOfPayment.equals("cash")) {
            payment = new Cash();
        }
        else if (typeOfPayment.equalsIgnoreCase("visa")) {
            payment = new Visa();
        }
        else {
            throw new IllegalArgumentException(typeOfPayment + " is not supported");
        }
    }

    // Getting the payment method
    public String getPaymentMethod() {
        if (payment == null) {
            throw new NullPointerException("Payment wasn't set correctly");
        }
        return payment.pay();
    }

    // Setting Notification Type
    public void setNotificationType(String notificationType) {
        if (notificationType.equalsIgnoreCase("email")) {
            notification = new EmailNotification(customer);
        }
        else if (notificationType.equalsIgnoreCase("sms")) {
            notification = new SmsNotification(customer);
        }
        else {
            throw new IllegalArgumentException(notificationType + " is not supported");
        }
    }

    // Getting the Notification Type
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



    // Printing Order Summary
    public void orderSummary() {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Customer: " + customer.getLocation());
        System.out.println("####################");
        showItems();
        System.out.println("####################");
        System.out.println("Total Price: " + totalPrice());

        System.out.println("\n");
        System.out.println(getPaymentMethod());

    }

    private  void showItems() {
      ItemPrinter.printItems(items);
    }
}
