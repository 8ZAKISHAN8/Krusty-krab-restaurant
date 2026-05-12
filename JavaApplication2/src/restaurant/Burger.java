package restaurant;
public class Burger extends MenuItem {
    private Size size;
    private boolean extraCheese;
    private boolean isCombo;
    
    public Burger(String name,double basePrice,Size size,boolean extraCheese){
        super(name,basePrice,"Burger");
        this.size=size; this.extraCheese=extraCheese;
    }
    public double getPrice(){
        double price=basePrice;
        switch(size){ case MEDIUM -> price+=20; case LARGE -> price+=50; }
        if(extraCheese) price+=15;
        return price;
    }
    public boolean isCombo() { // This is the method the database calls
        return isCombo;
    }
    
    public void setCombo(boolean isCombo) {
        this.isCombo = isCombo;
    }
    
    @Override
public String getDescription() {
    String desc = name + " (" + size + ")";
    // If the user picked a combo, add it to the string!
    if (this.isCombo) { 
        desc += " + Fries & Drink Combo";
    }
    return desc;
}
}
