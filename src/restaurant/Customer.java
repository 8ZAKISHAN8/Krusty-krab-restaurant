package restaurant;
public abstract class Customer{
    protected final String name;
    public Customer(String name){ this.name=name; }
    public String getName(){ return name; }
    public abstract ServiceType getServiceType();
}
