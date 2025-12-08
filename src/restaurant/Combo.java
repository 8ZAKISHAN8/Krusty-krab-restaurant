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
    String description = name + " - Combo - " + comboPrice + " EGP\nIncludes:";

    for (MenuItem item : items) {
        description += "\n  * " + item.getName();
    }

    return description;
}


    // ✅ Add getter so other classes can access combo items safely
    public List<MenuItem> getItems() {
        return List.copyOf(items);
    }
}
