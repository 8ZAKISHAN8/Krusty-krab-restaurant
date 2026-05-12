/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant;
/**
 *
 * @author Noura
 */
public class DeliveryCustomer extends Customer implements LoyaltyPoints {
    private final String address;

    public DeliveryCustomer(String address) {
        this.address = address;
        // Use the setter from the parent Customer class
        this.setLoyaltyPoints(0); 
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.DELIVERY;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public void addPoints(int points) { 
        int current = getLoyaltyPoints();
        setLoyaltyPoints(current + points);
    }

    @Override
    public void usePoints(int points) { // Changed double to int
        int current = getLoyaltyPoints();
        int updated = current - points;
        setLoyaltyPoints(updated < 0 ? 0 : updated);
    }

    @Override
    public int getPoints() { // Changed return type to int
        return getLoyaltyPoints();
    }
}
