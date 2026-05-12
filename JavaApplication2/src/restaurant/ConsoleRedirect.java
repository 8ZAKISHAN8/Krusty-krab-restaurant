package restaurant;

import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleRedirect {

    private static JLabel label; 
    private static final StringBuilder buffer = new StringBuilder();

    public static void attachLabel(JLabel lbl) {
        label = lbl;
       
        updateLabel();
    }

    public static void init() {
        PrintStream ps = new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                buffer.append((char) b);
                updateLabel();
            }

            @Override
            public void write(byte[] b, int off, int len) {
                buffer.append(new String(b, off, len));
                updateLabel();
            }
        });

        System.setOut(ps);
        System.setErr(ps);
    }

    private static void updateLabel() {
        if (label == null) return; // 
        SwingUtilities.invokeLater(() -> {
            label.setText("<html>" + buffer.toString().replace("\n", "<br>") + "</html>");
        });
    }
    
      public static void resetOrder() {
    // Empty the cart
    OrderBurger.cart.clear();

    // Reset all counters
    OrderBurger.ItemCount = 0;
    OrderBurger.smallBurgerCount = 0;
    OrderBurger.mediumBurgerCount = 0;
    OrderBurger.largeBurgerCount = 0;

    // Reset combo flags
    OrderBurger.smallIsCombo = false;
    OrderBurger.mediumIsCombo = false;
    OrderBurger.largeIsCombo = false;

    // Reset extra cheese
    OrderBurger.ExtraCheese = false;

    // If you have any selected burger size
    OrderBurger.selectedBurgerSize = null;
    
    // Clear console buffer
    buffer.setLength(0);

    // Clear the JLabel if attached
    if (label != null) {
        SwingUtilities.invokeLater(() -> label.setText(""));
    }
}
      public static void printOrderSummary(Order order) {
        System.out.println("\n====== ORDER #" + order.getOrderId() + " ======");
        
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
            System.out.println("Loyalty Points: " + (int)(Math.random() * 100));
        }
    }

}
