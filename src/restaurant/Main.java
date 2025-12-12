package restaurant;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // === CREATE MENU ===
        Menu<MenuItem> menu = new Menu<>();
        Burger krabby = new Burger("Krabby Patty", 120, Size.MEDIUM, true);
        Burger doubleK = new Burger("Double Krabby", 180, Size.LARGE, false);
        Drink cola = new Drink("Coral Cola", 30, Size.SMALL);
        Side fries = new Side("Kelp Fries", 45, Size.MEDIUM);
        Combo combo1 = new Combo("Krabby Combo", Arrays.asList(krabby, fries, cola), 170);

        menu.addItem(krabby);
        menu.addItem(doubleK);
        menu.addItem(cola);
        menu.addItem(fries);
        menu.addItem(combo1);

        // Display the menu
        System.out.println("=== MENU ===");
        menu.displayMenu();

        // === FIRST ORDER ===
        System.out.println("\n--- FIRST ORDER ---");
        Order order1 = new Order(new DineInCustomer("SpongeBob", 5));
        order1.addItem(krabby, 2); // 2 Krabby Patties
        order1.addItem(cola, 1);   // 1 Coral Cola
        order1.setPaymentMethod(new CashPayment());
        order1.pay();
        printOrderSummary(order1);

        // === SECOND ORDER (redeem points) ===
        System.out.println("\n--- SECOND ORDER ---");
        Order order2 = new Order(order1.getCustomer()); // same customer
        order2.addItem(fries, 3);                       // 3 Kelp Fries
        order2.setPaymentMethod(new CardPayment());
        order2.pay();
        printOrderSummary(order2);
    }

    public static void printOrderSummary(Order order) {
        System.out.println("\n====== ORDER #" + order.getOrderId() + " ======");
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("Service: " + order.getCustomer().getServiceType());

        // Display table or address if applicable
        if (order.getCustomer() instanceof DineInCustomer dine) {
            System.out.println("Table: " + dine.getTableNumber());
        } else if (order.getCustomer() instanceof DeliveryCustomer del) {
            System.out.println("Address: " + del.getAddress());
        }

        System.out.println("\nItems:");
        for (OrderItem oi : order.getItems()) {
            MenuItem item = oi.getItem();
            if (item instanceof Combo combo) {
                System.out.println("- " + combo.getName() + " - " + combo.getPrice() + " EGP");
                System.out.println("  Includes:");
                for (MenuItem ci : combo.getItems()) {
                    System.out.println("    * " + ci.getName());
                }
            } else {
                System.out.println("- " + item.getDescription() +
                                   " x" + oi.getQuantity() +
                                   " = " + oi.getSubtotal() + " EGP");
            }
        }

        System.out.println("Total (with TAX): " + order.getTotal() + " EGP");

        // Display loyalty points if the customer has them
        if (order.getCustomer() instanceof LoyaltyPoints lpCustomer) {
            System.out.println("Loyalty Points: " + lpCustomer.getPoints());
        }
    }
}
