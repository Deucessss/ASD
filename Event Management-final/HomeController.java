
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

    /**
     * This method is used for the customer registration.
     */
    public void registerCustomer(String firstName, String lastName,
                                 String email, String password,
                                 String contact, String address, String concession,
                                 String answer1, String answer2)
    {
        Customer customer = new Customer(firstName, lastName, email, password, contact,
                                         address, concession, answer1, answer2);
        Accounts.addCustomer(customer);
    }

    /**
     * This method is used for checking if the email used while registration already exists.
     */
    public boolean checkCustomerEmailExist(String email)
    {
        if (Accounts.getCustomers().size() !=0 )
        {
            for (int i = 0; i < Accounts.getCustomers().size(); i++)
            {
                if (Accounts.getCustomers().get(i).getEmail().equalsIgnoreCase(email))
                {
                    System.out.println("This email as already been registered. Please re-enter");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method is used for the owner registration.
     */
    public void registerOwner(String firstName, String lastName, String email, String password,
                     String contact, String address)
    {
            Owner owner = new Owner(firstName,lastName, email, password, contact, address);
        Accounts.addOwner(owner);
    }

    /**
     * This method is used for checking if the email used while registration already exists.
     */
    public boolean checkOwnerEmailExist(String email)
    {
        if (Accounts.getOwners().size() != 0 )
        {
            for (int i = 0; i < Accounts.getOwners().size(); i++)
            {
                if (Accounts.getOwners().get(i).getEmail().equalsIgnoreCase(email))
                {
                    System.out.println("This email as already been registered. Please re-enter");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method is used for validating credentials the user inputs while logging in.
     */
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
                        ci.getCustomerController().setCustomer(Accounts.getCustomers().get(i));
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
                        OwnerInterface oi = new OwnerInterface();
                        oi.getOwnerController().setOwner(Accounts.getOwners().get(i));
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

    /**
     * This method is used for validating credentials the admin inputs while logging in.
     */
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

    /**
     * This method is used for searching hall using hall name.
     */
    public static void searchHall(String hallName)
    {
        Homepage hp = new Homepage();
        switch(hallName)
        {
            case "0":
                hp.displayHomepage();
                break;
            default:
                if (Accounts.searchHall(hallName) == null)
                {
                    hp.displayNoSearchResultPage(hallName);
                }
                else
                {
                    hp.displayHallPage(hallName);
                }
                break;

        }
    }

    /**
     * This method is used for checking if hall exists.
     */
    public static boolean checkHallExist(String hallName)
    {
        if (Accounts.searchHall(hallName) != null)
        {
            return true;
        }
        return false;

    }

    /**
     * This method is used for displaying hall details.
     */
    public static void displayHallDetail(String hallName)
    {
        Hall result = Accounts.searchHall(hallName);
        String name = result.getName();
        String address = result.getAddress();
        String contactNum = result.getContact();
        String des = result.getDescription();
        String catering = (result.getCateringService() ? "yes" : "no");
        String photography = (result.getPhotographyService() ? "yes" : "no");
        String decoration = (result.getDecorationService() ? "yes" : "no");
        int capacity = result.getHallCapacity();
        float discount = result.getHallDiscount();
        float averageCateringRating = 0;
        float averagePhotographyRating = 0;
        float averageDecorationRating = 0;
        int count = 0;
        for (Booking booking : result.getPastBookings())
        {
            if (booking.isRated())
            {
                count ++;
                if (result.getCateringService())
                {
                    averageCateringRating += booking.getRating().getCateringRating();
                }
                if (result.getPhotographyService())
                {
                    averagePhotographyRating += booking.getRating().getPhotographyRating();
                }
                if (result.getDecorationService())
                {
                    averageDecorationRating += booking.getRating().getDecorationRating();
                }
            }
        }
        if (count != 0 )
        {
            averageCateringRating = averageCateringRating/count;
            averagePhotographyRating  = averagePhotographyRating/count;
            averageDecorationRating = averageDecorationRating/count;
        }

        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-20s|  %-50s|\n", "Hall Name", name);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-20s|  %-50s|\n", "Hall Address", address);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-20s|  %-50s|\n", "Contact Number", contactNum);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-20s|  %-50s%-50s|\n", "Description", des, "|");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-20s|  %-50s|\n", "Catering Serivce", catering);
        if (result.getCateringService())
        {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.format("|  %-20s|  %-50s|\n", "Catering Rating", averageCateringRating + "("+count+")");
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-20s|  %-50s|\n", "Photography Serivce", photography);
        System.out.println("-----------------------------------------------------------------------------");
        if (result.getPhotographyService())
        {
            System.out.format("|  %-20s|  %-50s|\n", "Photography Rating", averagePhotographyRating + "("+count+")");
            System.out.println("-----------------------------------------------------------------------------");
        }
        System.out.format("|  %-20s|  %-50s|\n", "Decoration Serivce", decoration);
        System.out.println("-----------------------------------------------------------------------------");
        if (result.getDecorationService())
        {
            System.out.format("|  %-20s|  %-50s|\n", "Decoration Rating", averageDecorationRating + "("+count+")");
            System.out.println("-----------------------------------------------------------------------------");
        }
        if (result.getBookings().size() == 0)
        {
            System.out.format("|  %-20s|  %-50s|\n", "Availability", "This hall is Available");
        }
        else
        {
            System.out.format("|  %-20s|  %-50s|\n", "Availability", "This hall is unavailable between:");
            for (Booking booking : result.getBookings())
            {
                String availability =  CustomerInterface.formatter.format(booking.getStartDate()) + " - " +
                                CustomerInterface.formatter.format(booking.getEndDate());
                System.out.format("|  %-20s|  %-50s|\n", "", availability);
            }
        }
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-20s|  %-50s|\n", "Capacity", capacity);
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-20s|  %-50s|\n", "Discount", discount+"%");
        System.out.println("-----------------------------------------------------------------------------");


    }

    /**
     * This method is used for view all the halls.
     */
    public void viewAllHalls()
    {
        Accounts.viewHalls();
    }

    /**
     * This method is used for terminate the software.
     */
    public static void exitSoftware()
    {
        System.exit(0);
    }
}
