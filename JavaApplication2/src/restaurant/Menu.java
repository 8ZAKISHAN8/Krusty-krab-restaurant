package restaurant;
import java.util.*;
public class Menu<T extends MenuItem>{
    private ArrayList<T> items=new ArrayList<>();
    public void addItem(T item){ items.add(item); }
    public void displayMenu(){ items.forEach(i->System.out.println(i.getDescription())); }
    public List<T> getItems(){ return List.copyOf(items); }
}
