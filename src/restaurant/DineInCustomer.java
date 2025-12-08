package restaurant;
public class DineInCustomer extends Customer{
    private int tableNumber;
    public DineInCustomer(String name,int table){ super(name); this.tableNumber=table; }
    public ServiceType getServiceType(){ return ServiceType.DINE_IN; }
    public int getTableNumber(){ return tableNumber; }
}
