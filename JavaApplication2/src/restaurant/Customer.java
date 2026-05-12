package restaurant;

public abstract class Customer {
   
    private int loyaltyPoints; 


    public void setLoyaltyPoints(int points) {
        this.loyaltyPoints = points;
    }


    public int getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

    public abstract ServiceType getServiceType();
}
