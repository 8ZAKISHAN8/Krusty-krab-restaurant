package restaurant;

public class DineInCustomer extends Customer implements LoyaltyPoints {
    private final int tableNumber;
    private double loyaltyPoints; // now handled via interface

    public DineInCustomer(String name, int tableNumber) {
        super(name);
        this.tableNumber = tableNumber;
        this.loyaltyPoints = 0;
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.DINE_IN;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    // LoyaltyPoints interface methods
    @Override
    public void addPoints(double points) {
        loyaltyPoints += points;
    }

    @Override
    public void usePoints(double points) {
        loyaltyPoints -= points;
        if (loyaltyPoints < 0) loyaltyPoints = 0;
    }

    @Override
    public double getPoints() {
        return loyaltyPoints;
    }
}
