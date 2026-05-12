package restaurant;

public class TakeawayCustomer extends Customer implements LoyaltyPoints {
 public TakeawayCustomer() {
        // Use the setter from the parent Customer class 
        this.setLoyaltyPoints(0); 
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.TAKEAWAY;
    }

    @Override
    public void addPoints(int points) { 
        int current = getLoyaltyPoints(); 
        setLoyaltyPoints(current + points); 
    }

    @Override
    public void usePoints(int points) { 
        int current = getLoyaltyPoints();
        int updated = current - points;
        setLoyaltyPoints(updated < 0 ? 0 : updated);
    }

    @Override
    public int getPoints() { // Changed return type to int
        return getLoyaltyPoints(); // Use parent getter 
    }
}
