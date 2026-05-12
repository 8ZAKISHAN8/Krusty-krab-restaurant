package restaurant;
public class PaymentProcessor<T extends PaymentMethod>{
    public void processPayment(T method,double amount){ method.pay(amount); }
}
