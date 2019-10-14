
/**
 * Write a description of class HomeController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class HomeController
{
// instance variables - replace the example below with your own
    
    /**
     * Constructor for objects of class HomeController
     */
    public HomeController()
    {
        // initialise instance variables
        
    }
    
    public void registerCustomer(String firstName, String lastName, 
                    String email, String password,
                    String contact, String address, String concession,
                    String answer1, String answer2, String answer3)
    {
        Customer customer = new Customer(firstName, lastName, email, password, contact, 
                                         address, concession, answer1, answer2, answer3);
        Accounts.addCustomer(customer);
    }
    
    public boolean checkCustomerEmail(String email)
    {
        if (Accounts.getCustomers().size() !=0 )
        {
            for (int i = 0; i < Accounts.getCustomers().size(); i++)
            {
                if (Accounts.getCustomers().get(i).getEmail().equalsIgnoreCase(email))
                {
                    System.out.println("This email as already been registered. Please re-enter");
                    return false;
                }
            }
        }
        return true; 
    }
    
    public void registerOwner(String firstName, String lastName, String email, String password,
                 String contact, String address)
    {
        ArrayList<Hall> halls = new ArrayList<Hall>();
        Owner owner = new Owner(firstName,lastName, email, password, contact, address, halls);
        Accounts.addOwner(owner);
    }
    
    public boolean checkOwnerEmail (String email)
    {
        if (Accounts.getOwners().size() != 0 )
        {
            for (int i = 0; i < Accounts.getOwners().size(); i++)
            {
                if (Accounts.getOwners().get(i).getEmail().equalsIgnoreCase(email))
                {   
                    System.out.println("This email as already been registered. Please re-enter");
                    return false;
                }
            }
        }
        return true;
    }
    
    public void checkLoginInfo(int userType, String email, String password)
    {
        boolean loginSuccess = false;
        if (userType == 3)
        {
            if (Accounts.getCustomers().size() != 0)
            {
                for (int i = 0; i < Accounts.getCustomers().size(); i++)
                {
                    if (Accounts.getCustomers().get(i).getEmail().equalsIgnoreCase(email) &&
                    Accounts.getCustomers().get(i).getPassword().equalsIgnoreCase(password))
                    {
                        loginSuccess = true;
                        CustomerInterface ci = new CustomerInterface();
                        ci.displayCustomerPage();
                    }
                }
            }
            else
            {
                System.out.println("There is no account registered yet. Please head to account registration");
                Homepage hp = new Homepage();
                hp.displayHomepage();
            }
        }
        if (userType == 4)
        {
            if (Accounts.getOwners().size() != 0)
            {
                for (int i = 0; i < Accounts.getOwners().size(); i++)
                {
                    if (Accounts.getOwners().get(i).getEmail().equalsIgnoreCase(email) &&
                        Accounts.getOwners().get(i).getPassword().equalsIgnoreCase(password))
                    {
                        loginSuccess = true;
                        OwnerInterface oi = new OwnerInterface(Accounts.getOwners().get(i));
                        oi.displayOwnerPage();
                    }
                }
            }
            else
            {
                System.out.println("There is no account registered yet. Please head to account registration");
                Homepage hp = new Homepage();
                hp.displayHomepage();
            }
        }
        if (!loginSuccess)
        {
            System.out.println("Invalid email or password. Please re-try");
            Homepage hp = new Homepage();
            hp.displayUserLoginPage(userType);
        }
    }
    
    public void adminLogin(String adminName, String adminPwd)
    {
        if (adminName.equals(Accounts.getAdmin().getEmail()) &&
            adminPwd.equals(Accounts.getAdmin().getPassword()))
        {
            AdminInterface ai = new AdminInterface();
            ai.displayAdminPage();
        }
        else
        {
            System.out.println("Invalid email or password. Please re-try");
            Homepage hp = new Homepage();
            hp.displayAdminLoginPage();
        }
    }
    
    public void searchHall(String hallName)
    {
        Homepage hp = new Homepage();
        switch(hallName)
        {
            case "0":
                hp.displayHomepage();
                break;
            default:
                hp.displaySearchResult(Accounts.searchHall(hallName));
                break;
        }
    }
    
    public void viewAllHalls()
    {
        Accounts.viewHalls();
    }
    
    public void exitSoftware()
    {
        System.exit(0);
    }
}
