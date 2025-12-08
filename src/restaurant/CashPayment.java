package restaurant;
public class CashPayment implements PaymentMethod{
    public void pay(double amount){ System.out.println("Paid "+amount+" EGP in Cash"); }
    public String getMethodName(){ return "Cash"; }
}
