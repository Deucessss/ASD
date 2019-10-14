
import java.util.*;
public class CustomerInterface
{
    // instance variables - replace the example below with your own
    private CustomerController customerController;

    /**
     * Constructor for objects of class CustomerInterface
     */
    public CustomerInterface()
    {
        // initialise instance variables
        customerController = new CustomerController();
    }
    
    public void displayCustomerPage()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System");
        System.out.println("*****************************************************************************************");
        
        System.out.println("Please select from the following options:");
        System.out.println("Press 1 to Search for Hall");
        System.out.println("Press 2 to Book a Hall");
        System.out.println("Press 3 to Update a Booking");
        System.out.println("Press 4 to view booking History");
        System.out.println("Press 5 to Update personal Details");
        System.out.println("Press 6 to Logout");
        System.out.println("Please enter your choice:");
        int choice = sc.nextInt();
        
        switch(choice)
        {
            // case 1:
                // searchHall();
                // break;
            case 6:
                customerController.logout();
                break;
        }
    }
    
   
}
