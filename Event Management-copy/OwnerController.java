
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
        int id = owner.getHalls().size()+1;
        Hall hall = new Hall(name,address,contact,description, availability,
                                           hallDiscount,cateringService,decorationService,
                                           photographyService,price,hallCapacity);
        this.owner.getHalls().add(hall);
        hall.setId(id);
    }
    
    public void printHalls()
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-25s %-15s %-30s", "id","Hall Name", "Hall Address",
                          "Contact Number", "Description");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for (int i = 0; i < this.owner.getHalls().size(); i++)
        {
            printHall(i);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
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
    
    public void displayQuotations()
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("");
        for (Hall hall : owner.getHalls())
        {
            for (Quotation quotation: hall.getQuotations())
            {
                System.out.println(hall.getId());
                System.out.println(quotation.getId());
                System.out.println(quotation.getGuestNum());
            }
            System.out.println("-----------------------------------------------------------------------------");
        }
        
        System.out.println();
    }
    
    public void displayQuotationDetail(int hallId, int quotationId)
    {
        
        for (Hall hall : owner.getHalls())
        {
            if (hall.getId() == hallId)
            {
                for (Quotation quot : hall.getQuotations())
                {
                    if (quot.getId() == quotationId){
                        int id = quot.getId();
                        String occasion = quot.getOccasion();
                        int guestNum = quot.getGuestNum();
                        String catering = ((quot.getCateringService()) ? "yes" : "no");
                        String photography = ((quot.getPhotographyService()) ? "yes" : "no");
                        String decoration = ((quot.getDecorationService()) ? "yes" : "no");
                        Date startDate = quot.getStartDate();
                        Date endDate = quot.getEndDate();
                        float budget = quot.getBudget();
   
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.format("|  %-28s|  %-42s|\n", "Quotation Id", id);
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.format("|  %-28s|  %-42s|\n", "Occasion", occasion);
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.format("|  %-28s|  %-42d|\n", "Guest Number", guestNum);
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.format("|  %-28s|  %-42s|\n", "Require Catering Service", catering);
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.format("|  %-28s|  %-42s|\n", "Require Photography Service", photography);
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.format("|  %-28s|  %-42s|\n", "Require Decoration Service", decoration);
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.format("|  %-28s|  %-42s|\n", "Start Date", startDate);
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.format("|  %-28s|  %-42s|\n", "End Date", endDate);
                        System.out.println("-----------------------------------------------------------------------------");
                        System.out.format("|  %-28s|  %-42.2f|\n", "Budget", budget);
                        System.out.println("-----------------------------------------------------------------------------");
                        
                        break;
                    }
                }
            }
        }

    }
    
    public int unrepliedQuotations()
    {
        int count = 0;
        for (Hall hall : owner.getHalls())
        {
            for (Quotation quot : hall.getQuotations())
            {
                if (!quot.getReplied())
                {
                    count++;
                }
            }
        }
        return count;
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
