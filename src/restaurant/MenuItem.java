package restaurant;
public abstract class MenuItem {
    protected final String name;
    protected final double basePrice;
    protected final String category;
    public MenuItem(String name, double basePrice, String category) {
        this.name = name; this.basePrice = basePrice; this.category = category;
    }
    public String getName(){return name;}
    public double getBasePrice(){return basePrice;}
    public String getCategory(){return category;}
    public abstract double getPrice();
    public abstract String getDescription();
}
