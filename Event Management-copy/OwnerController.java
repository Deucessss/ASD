
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
    
    public Quotation searchUnrepliedQuotation(int hallID, int quotationID)
    {
        for (Hall hall : owner.getHalls())
        {
            if (hall.getId() == hallID)
            {
                for (Quotation quot : hall.getQuotations())
                {
                    if (quot.getId() == quotationID)
                    {
                        return quot;
                    }
                }
            }
        }
        return null;
    }
    
    public void displayQuotations()
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Quotations waiting for reply");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println();
        for (Hall hall : owner.getHalls())
        {
            for (Quotation quotation : hall.getQuotations())
            {
                displayUnrepliedQuotation(quotation);
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Replied Quotations");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println();
        for (Hall hall : owner.getHalls())
        for (Quotation quotation : hall.getPastQuotations())
        {
            System.out.format("%-8d %-13d\n",quotation.getHall().getId(), quotation.getId());
        }
        System.out.println("-----------------------------------------------------------------------------");
    }
    
    public void displayUnrepliedQuotation(Quotation quotation)
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Id", quotation.getHall().getId());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Quotation Id", quotation.getId());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Occasion", quotation.getOccasion());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42d|\n", "Guest Number", quotation.getGuestNum());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Catering Service",
                            ((quotation.getCateringService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Photography Service", 
                            ((quotation.getPhotographyService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Decoration Service", 
                            ((quotation.getDecorationService()) ? "Required" : "Not Required")) ;
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Start Date", quotation.getStartDate());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "End Date", quotation.getEndDate());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42.2f|\n", "Budget", quotation.getBudget());
        System.out.println("-----------------------------------------------------------------------------");
    }
    
    public void replyQuotation(Quotation quotation, float cateringCost, float photographyCost, float decorationCost,
                                float venueCost)
    {
        quotation.setCateringCost(cateringCost);
        quotation.setPhotographyCost(photographyCost);
        quotation.setDecorationCost(decorationCost);
        quotation.setVenueCost(venueCost);
        quotation.setTotalAmount(cateringCost + decorationCost + photographyCost + venueCost);
        quotation.setReplied(true);
        
        quotation.setId(quotation.getHall().getPastQuotations().size() + 1);
        quotation.getHall().getPastQuotations().add(quotation);
        quotation.getHall().getQuotations().remove(quotation);
    }
    
    public int unrepliedQuotationsCount()
    {
        int count = 0;
        for (Hall hall : owner.getHalls())
        {
            count = count + hall.getQuotations().size();
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
