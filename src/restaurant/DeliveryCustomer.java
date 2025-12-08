package restaurant;
public class DeliveryCustomer extends Customer{
    private String address;
    public DeliveryCustomer(String name,String addr){ super(name); this.address=addr; }
    public ServiceType getServiceType(){ return ServiceType.DELIVERY; }
    public String getAddress(){ return address; }
}
