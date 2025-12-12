package restaurant;

public class TakeawayCustomer extends Customer implements LoyaltyPoints {
    private double loyaltyPoints;

    public TakeawayCustomer(String name) {
        super(name);
        this.loyaltyPoints = 0;
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.TAKEAWAY;
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
