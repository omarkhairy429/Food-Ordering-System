package System;

public class Customer {
    private String name;
    private String location;

    // Constructor
    public Customer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    /* View System.Menu Items */
    public void viewItems(Menu menu) {
        menu.showItems();
    }

    /* Add items to an order */
    public void addItem(Order order, Item item) {
        order.addItem(item);
    }

    /* Choose Payment.Payment Plan */
    public void choosePaymentPlan(Order order, String paymentMethod) {
        order.setPaymentMethod(paymentMethod);
    }

}
