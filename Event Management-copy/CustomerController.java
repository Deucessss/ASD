
/**
 * Write a description of class CustomerController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class CustomerController
{
    private Customer customer;// instance variables - replace the example below with your own
    /**
     * Constructor for objects of class CustomerController
     */
    public CustomerController()
    {
        // initialise instance variables
        
    }
    
    public void searchHall(String hallName)
    {
        CustomerInterface ci = new CustomerInterface();
        ci.getCustomerController().setCustomer(customer);
        switch(hallName)
        {
            case "0":
                ci.displayCustomerPage();
                break;
            default:
                if (Accounts.searchHall(hallName) == null)
                {
                    
                    ci.displayNoSearchResultPage(hallName);
                }
                else
                {
                   ci.displayHallPage(hallName);
                }
                break;
                
        }
    }
    
    public void requestQuotation(String hallName, String occasion, int guestNum, boolean cateringService,
                                 boolean photographyService, boolean decorationService,
                                 Date startDate, Date endDate, float budget)
    {
        Hall requestedHall = Accounts.searchHall(hallName);
        Quotation quotation = new Quotation(occasion, guestNum, cateringService, photographyService,
                                            decorationService, startDate, endDate, budget, requestedHall, customer);
        requestedHall.getQuotations().add(quotation);
        customer.getQuotations().add(quotation);
    }
    
    public ArrayList<Boolean> serviceProvided(String hallName)
    {
        Hall requestedHall = Accounts.searchHall(hallName);
        ArrayList<Boolean> services = new ArrayList<Boolean>();
        services.add(requestedHall.getCateringService());
        services.add(requestedHall.getPhotographyService());
        services.add(requestedHall.getDecorationService());
        return services;
    }
    
    public void viewAllHalls()
    {
        Accounts.viewHalls();
    }
    
    public boolean checkHallExist(String hallName)
    {
        if (Accounts.searchHall(hallName) != null)
        {
            return true;
        }
        return false;
    }
    
    public void logout()
    {
        Homepage hp = new Homepage();
        hp.displayHomepage();
    }
    
    public Customer getCustomer()
    {
        return this.customer;
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
