package restaurant;

public class DeliveryCustomer extends Customer implements LoyaltyPoints {
    private final String address;
    private double loyaltyPoints;

    public DeliveryCustomer(String name, String address) {
        super(name);
        this.address = address;
        this.loyaltyPoints = 0;
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.DELIVERY;
    }

    public String getAddress() {
        return address;
    }

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
