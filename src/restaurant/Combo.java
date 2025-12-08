package restaurant;

import java.util.List;

public class Combo extends MenuItem {
    private List<MenuItem> items;
    private double comboPrice;

    public Combo(String name, List<MenuItem> items, double comboPrice) {
        super(name, comboPrice, "Combo");
        this.items = items;
        this.comboPrice = comboPrice;
    }

    @Override
    public double getPrice() {
        return comboPrice;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder(name + " - Combo - " + comboPrice + " EGP\nIncludes:");
        for (MenuItem item : items) {
            sb.append("\n  * ").append(item.getName()); // just name for clarity
        }
        return sb.toString();
    }

    // ✅ Add getter so other classes can access combo items safely
    public List<MenuItem> getItems() {
        return List.copyOf(items);
    }
}
