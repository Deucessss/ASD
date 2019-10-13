
import java.util.*;
public class OwnerInterface
{
    // instance variables - replace the example below with your own
    private OwnerController ownerController;
    public static final String lineBreak = "*****************************************************************************************";

    /**
     * Constructor for objects of class OwnerInterface
     */
    public OwnerInterface()
    {
        this.ownerController = new OwnerController();// initialise instance variables
    }
    
    
    public void displayOwnerPage()
    {
       Scanner sc = new Scanner(System.in);
        //System.out.printf("%s\n",lineBreak);
        System.out.printf("%s\n",lineBreak);
        System.out.println("Welcome to the Event Management System");
        System.out.printf("%s\n",lineBreak);
        System.out.println("Please select from the following options:");
        System.out.println("Press 1 to Add Hall");
        System.out.println("Press 2 to Update a Hall");
        System.out.println("Press 3 to Delete a Hall");
        System.out.println("Press 4 to Update personal Details");
        System.out.println("Press 5 to Get Help");
        System.out.println("Press 6 to Logout");
        System.out.println("Please enter your choice:");
        int choice = sc.nextInt();
        while(choice < 1 || choice > 6)
        {
            System.out.println("Invalid input. Please re-enter a number between 1 and 6");
            choice = sc.nextInt();
        }
        switch(choice)
        {
            // case 1:
                // System.out.printf("%s\n",lineBreak);
                // System.out.println("Event Management System - Add a hall");
                // System.out.printf("%s\n",lineBreak);
                // addHall();
                // break;
            // case 2:
                // System.out.printf("%s\n",lineBreak);
                // System.out.println("Event Management System - Update a hall");
                // System.out.printf("%s\n",lineBreak);
                // updateHall();
                // break;
            // case 3:
                // System.out.printf("%s\n",lineBreak);
                // System.out.println("Event Management System - Remove a hall");
                // System.out.printf("%s\n",lineBreak);
                // deleteHall();
                // break;
            case 6:
                ownerController.logout();
                break;
        } 
    }
}
