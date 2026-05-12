package restaurant;
public class Side extends MenuItem{
    private Size size;
    public Side(String name,double basePrice,Size size){ super(name,basePrice,"Side"); this.size=size; }
    public double getPrice(){
        double price=basePrice;
        switch(size){ case MEDIUM -> price+=10; case LARGE -> price+=20; }
        return price;
    }
    public String getDescription(){ return name+" ("+size+") - "+getPrice()+" EGP"; }
}
