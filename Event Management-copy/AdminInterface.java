
/**
 * Write a description of class AdminInterface here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class AdminInterface
{
    // instance variables - replace the example below with your own

    private AdminController adminController;
    /**
     * Constructor for objects of class AdminInterface
     */
    public AdminInterface()
    {   
        this.adminController = new AdminController();// initialise instance variables
    }

    public void displayAdminPage()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System");
        System.out.println("*****************************************************************************************");
        
        System.out.println("Please select from the following options:");
        System.out.println("Press 1 to Add Discount");
        System.out.println("Press 2 to Delete Discount");
        System.out.println("Press 3 to Recover User Account");
        System.out.println("Press 4 to Owner Login");
        System.out.println("Press 5 to Logout");
        System.out.println("Please enter your choice:");
        int choice=sc.nextInt();
        while (choice > 5)
        {
            System.out.println("Invalid Option. Please choose again");
            choice = sc.nextInt();
        }
        switch(choice)
        {
            case 5:
                Homepage hp = new Homepage();
                hp.displayHomepage();
                break;
        }
    }

}
