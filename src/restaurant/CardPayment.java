package restaurant;
public class CardPayment implements PaymentMethod{
    public void pay(double amount){ System.out.println("Paid "+amount+" EGP by Card"); }
    public String getMethodName(){ return "Card"; }
}
