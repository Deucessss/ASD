
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class CustomerInterface
{
    public static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
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
        System.out.println("Welcome to the Event Management System  Hello, " +
                            this.customerController.getCustomer().getFirstName());
        System.out.println("*****************************************************************************************");

        System.out.println("Please select from the following options:");
        System.out.println("Press 1 to View All Halls");
        System.out.println("Press 2 to Search for Hall");
        System.out.println("Press 3 to View Quotations(" + customerController.countRepliedQuotations() + " newly replied)");
        System.out.println("Press 4 to View Bookings");
        System.out.println("Press 5 to Update a Booking");
        System.out.println("Press 6 to view booking History");
        System.out.println("Press 7 to Update personal Details");
        System.out.println("Press 8 to Logout");
        System.out.println("press 9 to Exit");
        System.out.println("Please enter your choice:");
        int choice;
        while (true)
        {
            try{
                choice = sc.nextInt();
                if (choice < 1 || choice > 9)
                {
                    System.out.println("Invalid Option. Please re-enter a number between 1 and 9");
                    continue;
                }
                else
                {
                    break;
                }
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid option. Please re-enter a number between 1 and 9");
                continue;
            }
        }
        switch(choice)
        {
            case 1:
                displayViewAllHalls();
                break;
            case 2:
                displaySearchPage();
                break;
            case 3:
                displayQuotationsPage();
                break;
            case 4:
                displayBookingsPage();
                break;
            case 5:
                displayCustomerPage();
                break;
            case 6:
                displayCustomerPage();
                break;
            case 7:
                displayCustomerPage();
                break;
            case 8:
                customerController.logout();
                break;
            case 9:
                HomeController.exitSoftware();
                break;
        }
    }

    public void displayViewAllHalls()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - View Halls");
        System.out.println("*****************************************************************************************");
        customerController.viewAllHalls();
        System.out.println("Enter hall name to view hall details");
        System.out.println("Enter 0 to go back");
        String hallName = sc.nextLine();

        while(!customerController.checkHallExist(hallName) && !hallName.equalsIgnoreCase("0"))
        {
            System.out.println("Sorry, there is no hall named "+ hallName);
            System.out.println("Please re-enter a hall name:");
            hallName = sc.nextLine();
        }
        switch(hallName)
        {
            case "0":
                displayCustomerPage();
                break;
            default:
                displayHallPage(hallName);
                break;
        }
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
        while (!customerController.checkHallExist(hallName))
        {
          System.out.println("Sorry, there is no hall named '" + hallName + "'");
          System.out.println("Enter a hall name to search again");
          System.out.println("Enter 0 to go back to homepage");
          hallName = sc.nextLine();
        }
        switch (hallName)
        {
            case "0":
                displayCustomerPage();
                break;
            default:
                displayHallPage(hallName);
                break;
        }
    }

    public void displayHallPage(String hallName)
    {
        System.out.print('\u000C');
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Hall: " + hallName);
        System.out.println("*****************************************************************************************");
        Scanner sc = new Scanner(System.in);
        HomeController.displayHallDetail(hallName);
        System.out.println();
        System.out.println("Enter 1 to ask for quotation");
        System.out.println("Enter 2 to go back to home page");

        int choice;
        while (true)
        {
            try{
                choice = sc.nextInt();
                if (choice != 1 && choice !=2)
                {
                    System.out.println("Invalid option. Please re-enter a number from 1 to 2");
                    continue;
                }
                else
                {
                    break;
                }
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid option. Please re-enter a number from 1 to 2");
                continue;
            }
        }
        switch(choice)
        {
            case 1:
                displaySendQuotationPage(hallName);
                break;
            case 2:
                displayCustomerPage();
                break;
        }
    }

    public void displaySendQuotationPage(String hallName)
    {
        System.out.print('\u000C');
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Hall: " + hallName);
        System.out.println("*****************************************************************************************");
        Scanner sc = new Scanner(System.in);
        boolean catering = false;
        boolean photography = false;
        boolean decoration = false;
        String choice;
        String occasion;
        int guestNum;
        String sStartDate;
        int duration;
        Date startDate;
        String sEndDate;
        Date endDate;
        float budget;

        HomeController.displayHallDetail(hallName);

        System.out.println("Enter the occasion for the event:");
        occasion = sc.nextLine();
        System.out.println("Enter the number of guest that will attend the event:");
        while (true)
        {
            try{
                guestNum = sc.nextInt();
                if (guestNum < 0)
                {
                    System.out.println("Invalid input. Please enter a number that is greater than 0");
                    continue;
                }
                else
                {
                    break;
                }
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid input. Please enter a number that is greater than 0");
                continue;
            }
        }
        sc.nextLine();
        System.out.println("Enter the start date for the event(dd/mm/yyyy):");
        sStartDate = sc.nextLine();
        formatter.setLenient(false);
        while(true)
        {
            try
            {
                startDate = formatter.parse(sStartDate);
                if (customerController.checkDate(hallName, startDate))
                {
                    break;
                }
                else
                {
                    System.out.println("Entered date is unavailable");
                    System.out.println("Please Re-Enter a date:");
                    sStartDate = sc.nextLine();
                    continue;
                }

            } catch (ParseException e){
                sc.nextLine();
                System.out.println("Invalid date format. Date format must be dd/mm/yyyy");
                System.out.println("Please re-enter a date according to the format:");
                sStartDate = sc.nextLine();
                continue;
            }
        }

        System.out.println("Enter the duration of the event in days:");
        while (true)
        {
            try{
                duration = sc.nextInt();
                if (duration < 0)
                {
                    System.out.println("Duration must be greater than 0. Please re-enter:");
                    continue;
                }
                else
                {
                    Calendar c = Calendar.getInstance();
                    c.setTime(startDate);
                    c.add(Calendar.DATE, duration);
                    endDate = c.getTime();
                    if (customerController.checkDate(hallName, endDate))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Entered date is unavailable");
                        System.out.println("Please Re-enter duration:");
                        sc.nextLine();
                    }
                }
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Duration must be a number greater than 0. Please re-enter:");
                continue;
            }
        }


        System.out.println("Enter your budget:");
        while (true)
        {
            try{
                budget = sc.nextFloat();
                if (budget < 0)
                {
                    System.out.println("Duration must be a number greater than 0. Please re-enter:");
                    continue;
                }
                else
                {
                    break;
                }
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Duration must be a number greater than 0. Please re-enter:");
                continue;
            }
        }
        sc.nextLine();
        if (customerController.serviceProvided(hallName).get(0))
        {
            System.out.println("Do you require catering service for the event?(y/n)");
            choice = sc.nextLine();
            while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
            {
                System.out.println("Please enter either \"y\" or \"n\" for catering service:");
                choice = sc.nextLine();
            }
            if (choice.equalsIgnoreCase("y"))
            {
                catering = true;
            }
            else
            {
                catering = false;
            }

        }

        if (customerController.serviceProvided(hallName).get(1))
        {
            System.out.println("Do you require photography service for the event?(y/n)");
            choice = sc.nextLine();
            while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
            {
                System.out.println("Please enter either \"y\" or \"n\" for photography service:");
                choice = sc.nextLine();
            }
            if (choice.equalsIgnoreCase("y"))
            {
                photography = true;
            }
        }

        if (customerController.serviceProvided(hallName).get(2))
        {
            System.out.println("Do you require decoration service for the event?(y/n)");
            choice = sc.nextLine();
            while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
            {
                System.out.println("Please enter either \"y\" or \"n\" for decoration service:");
                choice = sc.nextLine();
            }
            if (choice.equalsIgnoreCase("y"))
            {
                decoration = true;
            }
        }

        customerController.requestQuotation(hallName, occasion, guestNum, catering, photography,
                                            decoration, startDate, endDate, budget);

        System.out.println("Quotation successfully sent!");

        try{
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException ie){
            Thread.currentThread().interrupt();
        }

        displayHallPage(hallName);
    }

    public void displayQuotationsPage()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Quotations Page");
        System.out.println("*****************************************************************************************");

        if (customerController.getCustomer().getQuotations().size()>0)
        {
          customerController.displayQuotations();
          System.out.println("Enter a quotation id to accept");
        }
        else
        {
          System.out.println();
          System.out.println("You haven't sent any quotations yet.");
          System.out.println("To send a quotation, please go to a hall page "+
                             "and choose send quotation");
          System.out.println();
        }
        System.out.println("Enter 0 to go back");
        int quotId;
        while (true)
        {
            try{
                quotId = sc.nextInt();
                break;
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid option. Input must be a number");
                continue;
            }
        }
        switch(quotId)
        {
            case 0:
                displayCustomerPage();
                break;
            default:
                if (customerController.searchAcceptableQuotation(quotId) == null)
                {
                    System.out.println("Quotation does not exist or has not been replied by the hall owner "+
                                "or has been accepted already");
                    System.out.println("Taking you back to quotation page");
                    try{
                    TimeUnit.SECONDS.sleep(2);
                    } catch(InterruptedException ie){
                        Thread.currentThread().interrupt();
                    }
                    displayQuotationsPage();
                }

                else
                {
                    displayAcceptQuotationPage(quotId);
                }
                break;
        }

    }

    public void displayAcceptQuotationPage(int quotationId)
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Accept Quotation");
        System.out.println("*****************************************************************************************");

        customerController.displayRepliedQuotation(customerController.searchAcceptableQuotation(quotationId));

        System.out.println("Enter y to accept quotation and make a booking");
        //System.out.println("Enter n to decline quotation and and go back");
        System.out.println("Enter 0 to go back");
        String choice = sc.nextLine();
        while (!choice.equalsIgnoreCase("0") && !choice.equalsIgnoreCase("y"))
        {
            System.out.println("Invalid Option. Please enter either \"y\" to accept quotation and make booking " +
                                                "or 0 to go back");
            choice = sc.nextLine();
        }
        switch(choice)
        {
            case "0":
                displayQuotationsPage();
                break;
            case "y":
                customerController.acceptQuotation(customerController.searchAcceptableQuotation(quotationId));
                System.out.println("Quotation has been successfully accepted!");
                System.out.println("Please pay half of the total amount to the owner as a deposit!");
                System.out.println("This booking will be made for you once the owner receives the deposit!");
                System.out.println("Taking you to your booking page");
                try{
                    TimeUnit.SECONDS.sleep(3);
                } catch(InterruptedException ie){
                    Thread.currentThread().interrupt();
                }
                displayQuotationsPage();
                break;
        }
    }

    public void displayBookingsPage()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Your Bookings");
        System.out.println("*****************************************************************************************");

        customerController.displayBookings();

        if (customerController.getCustomer().getBookings().size() > 0)
        {
            System.out.println("Enter the booking id from the active booking "+
                               "list to edit your booking:");
        }
        System.out.println("Enter 0 to go back");

        String choice = sc.nextLine();
        switch(choice)
        {
            default:
                displayCustomerPage();
        }

    }

    public CustomerController getCustomerController()
    {
        return this.customerController;
    }
}
