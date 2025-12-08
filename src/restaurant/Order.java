package restaurant;
import java.util.*;
public class Order{
    private static int nextId=1;
    private static final double TAX=0.14;
    private int id;
    private Customer customer;
    private ArrayList<OrderItem> items=new ArrayList<>();
    private PaymentMethod paymentMethod;

    public Order(Customer customer){ this.customer=customer; this.id=nextId++; }
    public void addItem(MenuItem item,int qty){ items.add(new OrderItem(item,qty)); }
    public List<OrderItem> getItems(){ return List.copyOf(items); }
    public double getTotal(){
        double total=0; for(OrderItem oi:items) total+=oi.getSubtotal();
        return total*(1+TAX);
    }
    public void setPaymentMethod(PaymentMethod pm){ this.paymentMethod=pm; }
    public void pay(){
        PaymentProcessor<PaymentMethod> p=new PaymentProcessor<>();
        p.processPayment(paymentMethod,getTotal());
    }
    public int getOrderId(){ return id; }
    public Customer getCustomer(){ return customer; }
}
