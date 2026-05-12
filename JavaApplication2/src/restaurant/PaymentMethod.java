package restaurant;
public interface PaymentMethod{
    void pay(double amount);
    String getMethodName();
}
