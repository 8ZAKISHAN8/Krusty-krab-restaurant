package restaurant;
import java.util.*;

public class Order {
    private static int nextId = 1;
    private static final double TAX = 0.14;

    private int id;
    private Customer customer;
    private ArrayList<OrderItem> items = new ArrayList<>();
    private PaymentMethod paymentMethod;

    public Order(Customer customer,  List<OrderItem> cartItems) {
        this.customer = customer;
        this.id = nextId++;
         this.items.addAll(cartItems);
    }
    

    public void addItem(MenuItem item, int qty) {
        items.add(new OrderItem(item, qty));
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }

    public float getTotal() {
       float total = 0;
        for (OrderItem oi : items) total += oi.getSubtotal();
        return (float)(total * (1 + TAX));
    }

    public void setPaymentMethod(PaymentMethod pm) {
        this.paymentMethod = pm;
    }

    public void pay() {
        double total = getTotal();

        // Redeem points if customer has them
        if (customer instanceof LoyaltyPoints lpCustomer) {
            int points = lpCustomer.getPoints();
            if (points > 0) {
                System.out.println( " used " + points + " loyalty points to reduce the total.");
                total -= points;
                if (total < 0) total = 0;
                lpCustomer.usePoints(points);
            }
        }

        // Process payment
        PaymentProcessor<PaymentMethod> p = new PaymentProcessor<>();
        p.processPayment(paymentMethod, total);

        // Earn new points (10% of total paid)
        if (customer instanceof LoyaltyPoints lpCustomer2) {
            int earnedPoints = (int)(total * 0.10);
            lpCustomer2.addPoints(earnedPoints);
            System.out.println( " earned " + earnedPoints + " loyalty points.");
        }
    }

    public int getOrderId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }
}
