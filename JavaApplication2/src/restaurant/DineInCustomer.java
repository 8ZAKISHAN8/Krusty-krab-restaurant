package restaurant;

public class DineInCustomer extends Customer {
    private final int tableNumber;
    

    public DineInCustomer(int tableNumber) {
       
        this.tableNumber = tableNumber;
      
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.DINE_IN;
    }

    public int getTableNumber() {
        return tableNumber;
    }

}
