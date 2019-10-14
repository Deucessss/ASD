
import java.util.*;
public class OwnerController
{
// instance variables - replace the example below with your own
    private Owner owner;
    /**
     * Constructor for objects of class OwnerController
     */
    public OwnerController()
    {
        // initialise instance variables
    }
    
    public void addHall(String name, String address, String contact, String description, boolean availability,
                        float hallDiscount,boolean cateringService,boolean decorationService,
                        boolean photographyService,float price, int hallCapacity)
    {
        this.owner.getHalls().add(new Hall(name,address,contact,description, availability,
                                           hallDiscount,cateringService,decorationService,
                                           photographyService,price,hallCapacity));
    }
    
    public void printHalls()
    {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-25s %-15s %-30s", "id","Hall Name", "Hall Address",
                          "Contact Number", "Description");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < this.owner.getHalls().size(); i++)
        {
            printHall(i);
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
    }
    
    public void printHall(int index)
    {
        String name = this.owner.getHalls().get(index).getName();
            String address = this.owner.getHalls().get(index).getAddress();
            String contact = this.owner.getHalls().get(index).getContact();
            String description = this.owner.getHalls().get(index).getDescription();
            
            System.out.printf("%-5d %-15s %-25s %-15s %-30s",
                            index+1,name,address,contact,description);
    }
    
    public void logout()
    {
        Homepage hp = new Homepage();
        hp.displayHomepage();
    }
    
    public Owner getOwner()
    {
        return this.owner;
    }
    
    public void setOwner(Owner owner)
    {
        this.owner = owner;
    }
}
