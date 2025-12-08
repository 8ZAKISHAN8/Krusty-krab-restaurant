package restaurant;
public class TakeawayCustomer extends Customer{
    public TakeawayCustomer(String name){ super(name); }
    public ServiceType getServiceType(){ return ServiceType.TAKEAWAY; }
}
