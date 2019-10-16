import java.util.*;
public class Accounts
{
    // instance variables - replace the example below with your own
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    private static ArrayList<Owner> owners = new ArrayList<Owner>();
    private static Admin admin = new Admin();
    /**
     * Constructor for objects of class Accounts
     */
    public Accounts()
    {
        // initialise instance variables
    }
    
    public static ArrayList<Customer> getCustomers()
    {
        return customers;
    }
    
    public static void addCustomer(Customer customer)
    {
        customers.add(customer);
    }
    
    public static ArrayList<Owner> getOwners()
    {
        return owners;
    }
    
    public static void addOwner(Owner owner)
    {
        owners.add(owner);
    }
    
    public static Admin getAdmin()
    {
        return admin;
    }
    
    public static Hall searchHall(String hallName)
    {
        for (Owner owner : owners)
        {
            for (Hall hall : owner.getHalls())
            {
                if (hall.getName().equalsIgnoreCase(hallName))
                {
                    return hall;
                }
            }
        }
        return null;
    }
    
    public static void viewHalls()
    {
        int count = 0;
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-30s | %-15s | %-9s | %-11s | %-11s |\n", "Hall Name","Hall Address",
                          "Contact Number", "Catering", "Photography", "Decoration");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < owners.size(); i++)
        {
            for (int j = 0; j< owners.get(i).getHalls().size(); j++)
            {
                String hallName = owners.get(i).getHalls().get(j).getName();
                String hallAddress = owners.get(i).getHalls().get(j).getAddress();
                String contactNum = owners.get(i).getHalls().get(j).getContact();
                String catering = (owners.get(i).getHalls().get(j).getCateringService() ? "yes" : "no");
                String photography = (owners.get(i).getHalls().get(j).getPhotographyService() ? "yes" : "no");
                String decoration = (owners.get(i).getHalls().get(j).getDecorationService() ? "yes" : "no");
                System.out.format("| %-10s | %-30s | %-15s | %-9s | %-11s | %-11s |\n", hallName, hallAddress,
                                    contactNum, catering, photography, decoration);
                System.out.println("---------------------------------------------------------------------------------------------------------");
                count++;
            }
        }
        
        if (count == 0)
        {
            System.out.println("Sorry, there is not hall yet!");
        }
        
    }
    
}
