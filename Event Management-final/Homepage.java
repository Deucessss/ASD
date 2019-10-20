import java.util.*;
import java.awt.event.*;
public class Homepage
{
// instance variables - replace the example below with your own
    private HomeController homeController;
    public boolean esc = false;
    /**
     * Constructor for objects of class Homepage
     */
    public Homepage()
    {
        // initialise instance variables
        this.homeController = new HomeController();
    }

    /**
     * This is the main method of the software
     */
    public void main()
    {
      Accounts.initialiseAccounts();
      displayHomepage();
    }

    /**
     * This method has the main menu which is displayed when the program runs
     */
    public void displayHomepage()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Homepage");
        System.out.println("*****************************************************************************************");

        System.out.println("Please select from the following options:");
        System.out.println("Press 1 to Register Customer");
        System.out.println("Press 2 to Register Owner");
        System.out.println("Press 3 to User Login");
        System.out.println("Press 4 to Owner Login");
        System.out.println("Press 5 to Admin Login");
        System.out.println("Press 6 to View Halls");
        System.out.println("Press 7 to Search Hall");
        System.out.println("Press 8 to Exit");
        System.out.println("Please enter your choice:");
        int choice;
        while(true)
        {
            try{
                choice = sc.nextInt();
                if (choice < 1 || choice > 8)
                {
                    throw(new java.util.InputMismatchException());
                }
                else
                {
                    break;
                }
            } catch (java.util.InputMismatchException e){
                sc.nextLine().trim();
                System.out.println("Please choose from 1 to 8");
            }
        }
        switch(choice)
        {
            case 1:
                displayCustomerRegistrationPage();
                break;
            case 2:
                displayOwnerRegistrationPage();
                break;
            case 3: case 4:
                displayUserLoginPage(choice);
                break;
            case 5:
                displayAdminLoginPage();
                break;
            case 6:
                displayViewHallPage();
                break;
            case 7:
                displaySearchPage();
                break;
            case 8:
                homeController.exitSoftware();
                break;

        }
    }

    /**
     * This method is used for the customer registration.
     */
    public void displayCustomerRegistrationPage()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Customer Registration");
        System.out.println("*****************************************************************************************");
        System.out.println("Enter Your Email");
        String email=sc.nextLine().trim();
        while(checkEmailFormat(email) || homeController.checkCustomerEmailExist(email))
        {
            email=sc.nextLine().trim();
        }
        System.out.println("Enter the Password");
        String password=sc.nextLine().trim();
        while(password.length() < 6 || password.length()>20)
        {
            System.out.println("Please enter Password between 6 to 20 characters");
            password=sc.nextLine().trim();
        }
        System.out.println("Please Enter your Password Again");
        String confirmPassword=sc.nextLine().trim();
        while(!confirmPassword.equalsIgnoreCase(password))
        {
            System.out.println("Passsword and Confirm Password does not match. Please re-enter:");
            confirmPassword = sc.nextLine().trim();
        }
        System.out.println("Enter your First Name");
        String firstName=sc.nextLine().trim();
        while(firstName.length()<3 || firstName.length()>25)
        {
            System.out.println("Please enter First Name between 1 to 25 characters");
            firstName=sc.nextLine().trim();
        }
        System.out.println("Enter your Last Name");
        String lastName=sc.nextLine().trim();
        while(lastName.length()<1 || lastName.length()>25)
        {
            System.out.println("Please enter Last Name between 1 to 25 characters");
            lastName=sc.nextLine().trim();
        }
        System.out.println("Enter Your Contact Number(Optional)");
        String contact=sc.nextLine().trim();
        while(contact.length() != 0 && contact.length() != 10)
        {
            System.out.println("Contact should be 10 digits. Please re-enter");
            contact=sc.nextLine().trim();
        }
        System.out.println("Enter your address(optional)");
        String address = sc.nextLine().trim();
        while(address.length() > 30)
        {
            System.out.println("Address is too long.Please re-enter:");
            address = sc.nextLine().trim();
        }
        System.out.println("Enter your concession(Senior/Veteran/None)");
        String concession = sc.nextLine().trim();
        while(!concession.equalsIgnoreCase("Senior") && !concession.equalsIgnoreCase("Veteran") && !concession.equalsIgnoreCase("None"))
        {
            System.out.println("Invalid option. Please select from senior, veteran and none");
            concession = sc.nextLine().trim();
        }
        System.out.println("What is your first car?");
        String answer1 =sc.nextLine().trim();
        while(answer1.length()<1)
        {
            System.out.println("Please enter answer between 1 to 25 characters");
            answer1=sc.nextLine().trim();
        }
        System.out.println("what is your mother maidens name?");
        String answer2 =sc.nextLine().trim();
        while(answer2.length()<1)
        {
            System.out.println("Please enter answer between 1 to 25 characters");
            answer2=sc.nextLine().trim();
        }

        homeController.registerCustomer(firstName, lastName, email, password, contact,
                                         address, concession, answer1, answer2);
        displayHomepage();
    }

    /**
     * This method is used for the Owner registration.
     */
    public void displayOwnerRegistrationPage()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Owner Registration");
        System.out.println("*****************************************************************************************");
        System.out.println("Enter Your Email");
        String email=sc.nextLine().trim();
        while(checkEmailFormat(email) || homeController.checkOwnerEmailExist(email))
        {
            email=sc.nextLine().trim();
        }
        System.out.println("Enter the Password");
        String password=sc.nextLine().trim();
        while(password.length() < 6 || password.length()>20)
        {
            System.out.println("Please enter Password between 6 to 20 characters");
            password=sc.nextLine().trim();
        }
        System.out.println("Please Enter your Password Again");
        String confirmPassword=sc.nextLine().trim();
        while(!confirmPassword.equalsIgnoreCase(password))
        {
            System.out.println("Passsword and Confirm Password does not match. Please re-enter:");
            confirmPassword = sc.nextLine().trim();
        }
        System.out.println("Enter your First Name");
        String firstName=sc.nextLine().trim();
        while(firstName.length()<3 || firstName.length()>25)
        {
            System.out.println("Please enter First Name between 1 to 25 characters");
            firstName=sc.nextLine().trim();
        }
        System.out.println("Enter your Last Name");
        String lastName=sc.nextLine().trim();
        while(lastName.length()<1 || lastName.length()>25)
        {
            System.out.println("Please enter Last Name between 1 to 25 characters");
            lastName=sc.nextLine().trim();
        }
        System.out.println("Enter Your Contact Number");
        String contact=sc.nextLine().trim();
        while(contact.length() != 10)
        {
            System.out.println("Contact should be 10 digits. Please re-enter");
            contact=sc.nextLine().trim();
        }
        System.out.println("Enter your address");
        String address = sc.nextLine().trim();
        while(address.length() < 5 || address.length() > 40)
        {
            System.out.println("Length of address must be greater than 5 and less than 40. Please re-enter:");
            address = sc.nextLine().trim();
        }

        homeController.registerOwner(firstName,lastName, email, password,
                                     contact, address);
        displayHomepage();
    }

    /**
     * This method is used for checking the format of the email.
     */
    public boolean checkEmailFormat(String email)
    {
        if(email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))
        {
            return false;
        }
        else
        {
            System.out.println("Invalid email format. Please re-enter");
            return true;
        }
    }

    /**
     * This method runs when the user wants to login and displays option.
     */
    public void displayUserLoginPage(int userType)
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - User Login");
        System.out.println("*****************************************************************************************");
        System.out.println("Enter your Email");
        String userEmail = sc.next();
        while(checkEmailFormat(userEmail))
        {
            userEmail = sc.next();
        }
        System.out.println("Enter your Password");
        String userPassword = sc.next();
        homeController.checkLoginInfo(userType, userEmail, userPassword);
    }

    /**
     * This method is displays the menu for the admin.
     */
    public void displayAdminLoginPage()
    {
        System.out.print('\u000C');
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Admin Login");
        System.out.println("*****************************************************************************************");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter admin name");
        String adminName = sc.next();
        System.out.println("Enter Password");
        String adminPassword = sc.next();
        homeController.adminLogin(adminName, adminPassword);
    }

    /**
     * This method is displays menu for search a hall by using hall name.
     */
    public void displaySearchPage()
    {
        System.out.print('\u000C');
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Search Hall");
        System.out.println("*****************************************************************************************");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a hall name to search:");
        System.out.println("Press 0 to go back");
        String hallName = sc.nextLine().trim();

        switch (hallName)
        {
            case "0":
                displayHomepage();
                break;
            default:
                homeController.searchHall(hallName);
                break;
        }
    }

    /**
     * This method is display message for search of halls.
     */
    public void displayNoSearchResultPage(String hallName)
    {
        System.out.print('\u000C');
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Search Result");
        System.out.println("*****************************************************************************************");
        Scanner sc = new Scanner(System.in);

        System.out.println("Sorry, there is hall named '"+hallName+ "'");
        System.out.println("Enter a hall name to search again");
        System.out.println("Press 0 to go back to homepage");
        String newHallName = sc.nextLine().trim();
        switch(newHallName)
        {
            case "0":
                displayHomepage();
                break;
            default:
                homeController.searchHall(newHallName);
                break;
        }
    }

    /**
     * This method is used for viewig halls before the user logs in.
     */
    public void displayHallPage(String hallName)
    {
        System.out.print('\u000C');
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Hal: " + hallName);
        System.out.println("*****************************************************************************************");
        Scanner sc = new Scanner(System.in);

        homeController.displayHallDetail(hallName);
        System.out.println();
        System.out.println("Please log in to book this hall");
        System.out.println("Enter 0 to bo back");
        System.out.println("Enter 1 to Log in");
        System.out.println("Enter 2 to register");
        int choice;
        while (true)
        {
            try{
                choice = sc.nextInt();
                if (choice < 0 || choice > 2)
                {
                    throw(new java.util.InputMismatchException());
                }
                else
                {
                    break;
                }
            } catch (java.util.InputMismatchException e){
                sc.nextLine().trim();
                System.out.println("Please choose from 0 to 2");
                continue;
            }
        }
        switch(choice)
        {
            case 0:
                displayViewHallPage();
                break;
            case 1:
                displayUserLoginPage(3);
                break;
            case 2:
                displayCustomerRegistrationPage();
                break;
        }
    }

    /**
     * This method is used for view all the halls.
     */
    public void displayViewHallPage()
    {

        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - View Halls");
        System.out.println("*****************************************************************************************");
        homeController.viewAllHalls();
        System.out.println("Enter hall name to view hall details");
        System.out.println("Enter 0 to go back");
        String hallName = sc.nextLine().trim();

        while(!homeController.checkHallExist(hallName) && !hallName.equalsIgnoreCase("0"))
                {
                    System.out.println("Sorry, there is no hall named "+ hallName);
                    System.out.println("Please re-enter a hall name:");
                    hallName = sc.nextLine().trim();
                }
        switch(hallName)
        {
            case "0":
                displayHomepage();
                break;
            default:
                displayHallPage(hallName);
                break;
        }

    }
}
