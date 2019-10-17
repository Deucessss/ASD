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

    public void main()
    {
      Accounts.initialiseAccounts();
      displayHomepage();
    }

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
                sc.nextLine();
                System.out.println("Please choose from 1 to 8");
            }
        }
        switch(choice)
        {
            case 1:
                displayCustomerRegistrationPage();
                displayHomepage();
                break;
            case 2:
                displayOwnerRegistrationPage();
                displayHomepage();
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

    public void displayCustomerRegistrationPage()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Customer Registration");
        System.out.println("*****************************************************************************************");
        System.out.println("Enter Your Email");
        String email=sc.nextLine();
        while(checkEmailFormat(email) || homeController.checkCustomerEmailExist(email))
        {
            email=sc.nextLine();
        }
        System.out.println("Enter the Password");
        String password=sc.nextLine();
        while(password.length() < 6 || password.length()>20)
        {
            System.out.println("Please enter Password between 6 to 20 characters");
            password=sc.nextLine();
        }
        System.out.println("Please Enter your Password Again");
        String confirmPassword=sc.nextLine();
        while(!confirmPassword.equalsIgnoreCase(password))
        {
            System.out.println("Passsword and Confirm Password does not match. Please re-enter:");
            confirmPassword = sc.nextLine();
        }
        System.out.println("Enter your First Name");
        String firstName=sc.nextLine();
        while(firstName.length()<3 || firstName.length()>25)
        {
            System.out.println("Please enter First Name between 1 to 25 characters");
            firstName=sc.nextLine();
        }
        System.out.println("Enter your Last Name");
        String lastName=sc.nextLine();
        while(lastName.length()<1 || lastName.length()>25)
        {
            System.out.println("Please enter Last Name between 1 to 25 characters");
            lastName=sc.nextLine();
        }
        System.out.println("Enter Your Contact Number(Optional)");
        String contact=sc.nextLine();
        while(contact.length() != 0 && contact.length() != 10)
        {
            System.out.println("Contact should be 10 digits. Please re-enter");
            contact=sc.nextLine();
        }
        System.out.println("Enter your address(optional)");
        String address = sc.nextLine();
        while(address.length() > 30)
        {
            System.out.println("Address is too long.Please re-enter:");
            address = sc.nextLine();
        }
        System.out.println("Enter your concession(Senior/Veteran/None)");
        String concession = sc.nextLine();
        while(!concession.equalsIgnoreCase("Senior") && !concession.equalsIgnoreCase("Veteran") && !concession.equalsIgnoreCase("None"))
        {
            System.out.println("Invalid option. Please select from senior, veteran and none");
            concession = sc.nextLine();
        }
        System.out.println("What is your first car?");
        String answer1 =sc.nextLine();
        while(answer1.length()<1)
        {
            System.out.println("Please enter answer between 1 to 25 characters");
            answer1=sc.nextLine();
        }
        System.out.println("what is your mother maidens name?");
        String answer2 =sc.nextLine();
        while(answer2.length()<1)
        {
            System.out.println("Please enter answer between 1 to 25 characters");
            answer2=sc.nextLine();
        }

        homeController.registerCustomer(firstName, lastName, email, password, contact,
                                         address, concession, answer1, answer2);
    }

    public void displayOwnerRegistrationPage()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Owner Registration");
        System.out.println("*****************************************************************************************");
        System.out.println("Enter Your Email");
        String email=sc.nextLine();
        while(checkEmailFormat(email) || homeController.checkOwnerEmailExist(email))
        {
            email=sc.nextLine();
        }
        System.out.println("Enter the Password");
        String password=sc.nextLine();
        while(password.length() < 6 || password.length()>20)
        {
            System.out.println("Please enter Password between 6 to 20 characters");
            password=sc.nextLine();
        }
        System.out.println("Please Enter your Password Again");
        String confirmPassword=sc.nextLine();
        while(!confirmPassword.equalsIgnoreCase(password))
        {
            System.out.println("Passsword and Confirm Password does not match. Please re-enter:");
            confirmPassword = sc.nextLine();
        }
        System.out.println("Enter your First Name");
        String firstName=sc.nextLine();
        while(firstName.length()<3 || firstName.length()>25)
        {
            System.out.println("Please enter First Name between 1 to 25 characters");
            firstName=sc.nextLine();
        }
        System.out.println("Enter your Last Name");
        String lastName=sc.nextLine();
        while(lastName.length()<1 || lastName.length()>25)
        {
            System.out.println("Please enter Last Name between 1 to 25 characters");
            lastName=sc.nextLine();
        }
        System.out.println("Enter Your Contact Number");
        String contact=sc.nextLine();
        while(contact.length() != 10)
        {
            System.out.println("Contact should be 10 digits. Please re-enter");
            contact=sc.nextLine();
        }
        System.out.println("Enter your address");
        String address = sc.nextLine();
        while(address.length() < 5 || address.length() > 30)
        {
            System.out.println("Invalid address.Please re-enter:");
            address = sc.nextLine();
        }

        homeController.registerOwner(firstName,lastName, email, password,
                                     contact, address);
    }

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

    public void displaySearchPage()
    {
        System.out.print('\u000C');
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Search Hall");
        System.out.println("*****************************************************************************************");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a hall name to search:");
        System.out.println("Press 0 to go back");
        String hallName = sc.nextLine();

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
        String newHallName = sc.nextLine();
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
        System.out.println("Enter 0 to Register");
        System.out.println("Enter 1 to Log in");
        System.out.println("Enter 2 to go back to view hall page");
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
                sc.nextLine();
                System.out.println("Please choose from 0 to 2");
                continue;
            }
        }
        switch(choice)
        {
            case 0:
                displayUserLoginPage(3);
                break;
            case 1:
                displayCustomerRegistrationPage();
                break;
            case 2:
                displayViewHallPage();
                break;
        }
    }

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
        String hallName = sc.nextLine();

        while(!homeController.checkHallExist(hallName) && !hallName.equalsIgnoreCase("0"))
                {
                    System.out.println("Sorry, there is no hall named "+ hallName);
                    System.out.println("Please re-enter a hall name:");
                    hallName = sc.nextLine();
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
