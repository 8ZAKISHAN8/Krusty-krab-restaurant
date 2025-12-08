package restaurant;
public class Burger extends MenuItem {
    private Size size;
    private boolean extraCheese;
    public Burger(String name,double basePrice,Size size,boolean extraCheese){
        super(name,basePrice,"Burger");
        this.size=size; this.extraCheese=extraCheese;
    }
    public double getPrice(){
        double price=basePrice;
        switch(size){ case MEDIUM -> price+=20; case LARGE -> price+=40; }
        if(extraCheese) price+=15;
        return price;
    }
    public String getDescription(){ return name+" ("+size+")"+(extraCheese?" +Cheese":"")+" - "+getPrice()+" EGP"; }
}
