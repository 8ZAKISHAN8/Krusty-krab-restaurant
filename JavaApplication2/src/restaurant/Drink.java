package restaurant;
public class Drink extends MenuItem {
    private Size size;
    public Drink(String name,double basePrice,Size size){ super(name,basePrice,"Drink"); this.size=size; }
    public double getPrice(){
        double price=basePrice;
        switch(size){ case MEDIUM -> price+=5; case LARGE -> price+=10; }
        return price;
    }
    public String getDescription(){ return name+" ("+size+") - "+getPrice()+" EGP"; }
}
