
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
        System.out.println("Press 0 to View All Halls");
        System.out.println("Press 1 to Search for Hall");
        System.out.println("Press 2 to View Quotations");
        System.out.println("Press 3 to View Bookings");
        System.out.println("Press 3 to Update a Booking");
        System.out.println("Press 4 to view booking History");
        System.out.println("Press 5 to Update personal Details");
        System.out.println("Press 6 to Logout");
        System.out.println("Please enter your choice:");
        int choice;
        while (true)
        {
            try{
                choice = sc.nextInt();
                if (choice < 0 || choice > 6)
                {
                    throw(new java.util.InputMismatchException());
                }
                else
                {
                    break;
                }
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid option. Please re-enter a number between 1 and 6");
                continue;
            }
        }
        switch(choice)
        {
            case 0:
                displayViewAllHalls();
                break;
            case 1:
                displaySearchPage();
                break;
            case 2:
                displayQuotationsPage();
                break;
            case 6:
                customerController.logout();
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
        switch (hallName)
        {
            case "0":
                displayCustomerPage();
                break;
            default:
                customerController.searchHall(hallName);
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

        System.out.println("Sorry, there is no hall named '" + hallName + "'");
        System.out.println("Enter a hall name to search again");
        System.out.println("Press 0 to go back to homepage");
        String newHallName = sc.nextLine();
        switch(newHallName)
        {
            case "0":
                displayCustomerPage();
                break;
            default:
                customerController.searchHall(newHallName);
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
        System.out.println("Enter 0 to ask for quotation");
        System.out.println("Enter 1 to go back to home page");
        
        int choice;
        while (true)
        {
            try{
                choice = sc.nextInt();
                if (choice != 0 && choice !=1)
                {
                    throw(new java.util.InputMismatchException());
                }
                else
                {
                    break;
                }
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid option. Please re-enter a number from 0 to 1");
                continue;
            }
        }
        switch(choice)
        {
            case 0:
                displaySendQuotationPage(hallName);
                break;
            case 1:
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
        Boolean catering = false;
        Boolean photography = false;
        Boolean decoration = false;
        String choice;
        String occasion;
        int guestNum;
        String sStartDate;
        int duration;
        Date startDate;
        String sEndDate;
        Date endDate;
        float budget;
        System.out.println("Enter the occasion for the event:");
        occasion = sc.nextLine();
        System.out.println("Enter the number of guest that will attend the event:");
        guestNum = sc.nextInt();
        while (true)
        {
            try{
                guestNum = sc.nextInt();
                if (guestNum < 0)
                {
                    throw(new java.util.InputMismatchException());
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
                break;
            } catch (ParseException e){
                sc.nextLine();
                System.out.println("Invalid date format. Date format must be dd/mm/yyyy");
                System.out.println("Please re-enter a date according to the format:");
                sStartDate = sc.nextLine();
            }
        }
        
        System.out.println("Enter the duration of the event in days:");
        while (true)
        {
            try{
                duration = sc.nextInt();
                if (duration < 0)
                {
                    throw(new java.util.InputMismatchException());
                }
                else
                {
                    break;
                }
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid input. Duration must be a number greater than 0");
                continue;
            }
        }
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.DATE, duration);
        endDate = c.getTime();
        
        System.out.println("Enter your budget:");
        while (true)
        {
            try{
                budget = sc.nextFloat();
                if (budget < 0)
                {
                    throw(new java.util.InputMismatchException());
                }
                else
                {
                    break;
                }
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid input. Budget must be a number greater than 0");
                continue;
            }
        }
        sc.nextLine();
        if (customerController.serviceProvided(hallName).get(0))
        {
            System.out.println("Do you require catering service for the event?(y/n)");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y"))
            {
                catering = true;
            }
        }
        
        if (customerController.serviceProvided(hallName).get(1))
        {
            System.out.println("Do you require photography service for the event?(y/n)");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y"))
            {
                photography = true;
            }
        }
        
        if (customerController.serviceProvided(hallName).get(2))
        {
            System.out.println("Do you require decoration service for the event?(y/n)");
            choice = sc.nextLine();
            if (choice.equalsIgnoreCase("y"))
            {
                decoration = true;
            }
        }
        
        customerController.requestQuotation(hallName, occasion, guestNum, catering, photography,
                                            decoration, startDate, endDate, budget);
        System.out.print('\u000C');          
        System.out.println("Quotation successfully sent!");
        
        try{
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException ie){
            Thread.currentThread().interrupt();
        }
        
        displayHallPage(hallName);
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
    
    public void displayQuotationsPage()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Quotations Page");
        System.out.println("*****************************************************************************************");
        
        customerController.displayQuotations();
        System.out.println("Enter a hall id to accept");
        System.out.println("Enter 0 to go back");
        int hallId;
        while (true)
        {
            try{
                hallId = sc.nextInt();
                break;
            }catch (java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid option. Input must be a number");
                continue;
            }
        }
        switch(hallId)
        {
            case 0:
                displayCustomerPage();
                break;
            default:
                System.out.println("Enter a quotation id to accept");
                int quotationId;
                while (true)
                {
                    try{
                        quotationId = sc.nextInt();
                        break;
                    }catch (java.util.InputMismatchException e){
                        sc.nextLine();
                        System.out.println("Invalid option. Input must be a number");
                        continue;
                    }
                }
                if (customerController.searchAcceptableQuotation(hallId, quotationId) == null)
                {
                    System.out.print('\u000C');
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
                    displayAcceptQuotationPage(hallId, quotationId);
                }
        }
        
    }
    
    public void displayAcceptQuotationPage(int hallId, int quotationId)
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Accept Quotation");
        System.out.println("*****************************************************************************************");
        
        customerController.displayRepliedQuotation(customerController.searchAcceptableQuotation(hallId, quotationId));
        
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
                customerController.acceptQuotation(customerController.searchAcceptableQuotation(hallId, quotationId));
                System.out.print('\u000C');
                System.out.println("Quotation has been successfully accepted and a booking has been made for you!");
                System.out.println("Taking you back to quotation page");
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch(InterruptedException ie){
                    Thread.currentThread().interrupt();
                }
                
                displayQuotationsPage();
                
                break;
        }
    }
    
    public CustomerController getCustomerController()
    {
        return this.customerController;
    }
}
