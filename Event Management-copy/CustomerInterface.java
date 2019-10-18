
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
        System.out.println("Press 5 to view booking History");
        System.out.println("Press 6 to Update personal Details");
        System.out.println("Press 7 to Logout");
        System.out.println("press 8 to Exit");
        System.out.println("Please enter your choice:");
        int choice;
        while (true)
        {
            try{
                choice = sc.nextInt();
                if (choice < 1 || choice > 8)
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
                displayBookingHistory();
                break;
            case 6:
                displayCustomerPage();
                break;
            case 7:
                customerController.logout();
                break;
            case 8:
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
                sc.nextLine();
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
        System.out.println("Enter the start date for the event(dd/mm/yyyy):");
        sStartDate = sc.nextLine();
        formatter.setLenient(false);
        while(true)
        {
            try
            {
                startDate = formatter.parse(sStartDate);
                if (customerController.checkDate(hallName, startDate,0))
                {
                    break;
                }
                else
                {
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
                sc.nextLine();
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
                    if (customerController.checkDate(hallName, endDate,0))
                    {
                        break;
                    }
                    else
                    {
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
                sc.nextLine();
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
          System.out.println("Enter a quotation id to view detail");
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
                               "list to view booking detail:");
        }
        System.out.println("Enter 0 to go back");

        int bookingId;
        while(true)
        {
            try{
                bookingId = sc.nextInt();
                if (bookingId < 0 &&
                    bookingId > customerController.getCustomer().getBookings().size())
                {
                    System.out.println("There is no such booking. Please re-enter a booking id");
                    System.out.println("Enter 0 to go back");
                    continue;
                }
                else
                {
                    break;
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Your choice must be a number. Please re-enter: ");
                continue;
            }
        }
        switch(bookingId)
        {
            case 0:
                displayCustomerPage();
                break;
            default:
                displayBookingPage(bookingId);
                break;
        }
    }

    public void displayBookingPage(int bookingId)
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Your Bookings");
        System.out.println("*****************************************************************************************");

        customerController.displayBooking(customerController.getBookingByIdCust(bookingId));

        ArrayList<String> updatableAttributes = new ArrayList<String>();
        updatableAttributes.add("Occasion");
        updatableAttributes.add("Guest Number");
        updatableAttributes.add("Event Date");
        updatableAttributes.add("Catering Service");
        updatableAttributes.add("Photography Service");
        updatableAttributes.add("Decoration Service");

        String updatedOccasion = null;
        int updatedGuestNumber = 0;
        Date updatedStartDate = null;
        Date updatedEndDate = null;

        System.out.println("Enter 0 to go back");
        for (int i = 1; i <= updatableAttributes.size(); i++ )
        {
            System.out.println("Enter "+i+" to Update "+
                                updatableAttributes.get(i-1));
        }
        int attribute;
        while(true)
        {
            try{
                attribute = sc.nextInt();
                sc.nextLine();
                break;
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid input."+
                                    " You must enter a number between 0 and 8");
                System.out.println("Please re-enter:");
                continue;
            }
        }
        switch(attribute)
        {
            case 0:
                displayBookingsPage();
                break;
            case 1:
                System.out.println("Please enter an occasion:");
                updatedOccasion = sc.nextLine();
                if(updatedOccasion.equalsIgnoreCase(customerController.getBookingByIdCust(bookingId)
                                                                      .getOccasion()))
                {
                    System.out.println("Your entered occasion is the same as the current occasion");
                    System.out.println("Occasion is not updated!");
                    updatedOccasion = null;
                }
                else
                {
                    customerController.updateOccasion(bookingId, updatedOccasion);
                    System.out.println("Request to update occasion has been sent!");
                }
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch(InterruptedException ie){
                    Thread.currentThread().interrupt();
                }
                displayBookingPage(bookingId);
                break;
            case 2:
                System.out.println("Please enter a guest number:");
                while(true)
                {
                    try{
                        updatedGuestNumber = sc.nextInt();
                        sc.nextLine();
                        if (updatedGuestNumber == customerController.getBookingByIdCust(bookingId)
                                                                    .getGuestNum())
                        {
                            System.out.println("Your entered guest number is the same as the current guest number");
                            System.out.println("Guest number is not updated!");
                            updatedGuestNumber = 0;
                        }
                        else
                        {
                            customerController.updateGuestNumber(bookingId, updatedGuestNumber);
                            System.out.println("Request to update guest number has been sent!");
                        }
                        break;
                    }catch(java.util.InputMismatchException e){
                        sc.nextLine();
                        System.out.println("Please enter a number:");
                        continue;
                    }
                }
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch(InterruptedException ie){
                    Thread.currentThread().interrupt();
                }
                displayBookingPage(bookingId);
                break;
            case 3:
                System.out.println("Please enter a start date in the form of dd/mm/yyyy");
                String sStartDate = sc.nextLine();
                formatter.setLenient(false);
                while(true)
                {
                    try
                    {
                        updatedStartDate = formatter.parse(sStartDate);
                        if (customerController.checkDate(
                        customerController.getBookingByIdCust(bookingId)
                                          .getHall().getName(),
                                           updatedStartDate, bookingId))
                        {
                            System.out.println("Please Enter a duration for the event:");
                            break;
                        }
                        else
                        {
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
                while (true)
                {
                    try{
                        int duration = sc.nextInt();
                        sc.nextLine();
                        if (duration < 0)
                        {
                            System.out.println("Duration must be greater than 0. Please re-enter:");
                            continue;
                        }
                        else
                        {
                            Calendar c = Calendar.getInstance();
                            c.setTime(updatedStartDate);
                            c.add(Calendar.DATE, duration);
                            updatedEndDate = c.getTime();
                            if (customerController.checkDate(customerController.getBookingByIdCust(bookingId)
                                              .getHall().getName(),
                                               updatedEndDate, bookingId))
                            {
                                customerController.updateEventDate(bookingId, updatedStartDate, updatedEndDate);
                                System.out.println("Request to change the event date has been sent!");
                            }
                            else
                            {
                                System.out.println("Event date is not updated!");
                                updatedStartDate = null;
                                updatedEndDate = null;
                                sc.nextLine();
                            }
                            break;
                        }
                    }catch (java.util.InputMismatchException e){
                        sc.nextLine();
                        System.out.println("Duration must be a number greater than 0. Please re-enter:");
                        continue;
                    }
                }
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch(InterruptedException ie){
                    Thread.currentThread().interrupt();
                }
                displayBookingPage(bookingId);
                break;
            case 4:
                if(customerController.getBookingByIdCust(bookingId)
                                     .getHall().getCateringService())
                {
                    System.out.println("Are you sure that you want to change catering service?(y/n)");
                    String choice = sc.nextLine();
                    while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
                    {
                        System.out.println("Please enter either \"y\" or \"n\":");
                        choice = sc.nextLine();
                    }
                    if (choice.equalsIgnoreCase("y"))
                    {
                        customerController.updateCateringService(bookingId);
                        System.out.println("Request to update catering service has been sent!");
                    }
                    else
                    {
                        System.out.println("Catering service is not updated!");
                    }
                }
                else
                {
                    System.out.println("Sorry, this hall does not provide catering service!");
                }
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch(InterruptedException ie){
                    Thread.currentThread().interrupt();
                }
                displayBookingPage(bookingId);
                break;
            case 5:
                if(customerController.getBookingByIdCust(bookingId)
                                     .getHall().getPhotographyService())
                {
                    System.out.println("Are you sure that you want to change photography service?(y/n)");
                    String choice = sc.nextLine();
                    while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
                    {
                        System.out.println("Please enter either \"y\" or \"n\":");
                        choice = sc.nextLine();
                    }
                    if (choice.equalsIgnoreCase("y"))
                    {
                        customerController.updatePhotographyService(bookingId);
                        System.out.println("Request to update photography service has been sent!");
                    }
                    else
                    {
                        System.out.println("Photography service is not updated!");
                    }
                }
                else
                {
                    System.out.println("Sorry, this hall does not provide Photography service!");
                }
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch(InterruptedException ie){
                    Thread.currentThread().interrupt();
                }
                displayBookingPage(bookingId);
                break;
            case 6:
                if(customerController.getBookingByIdCust(bookingId)
                                     .getHall().getDecorationService())
                {
                    System.out.println("Are you sure that you want to change photography service?(y/n)");
                    String choice = sc.nextLine();
                    while(!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"))
                    {
                        System.out.println("Please enter either \"y\" or \"n\":");
                        choice = sc.nextLine();
                    }
                    if (choice.equalsIgnoreCase("y"))
                    {
                        customerController.updateDecorationService(bookingId);
                        System.out.println("Request to update decoration service has been sent!");
                    }
                    else
                    {
                        System.out.println("Decoration service is not updated!");
                    }
                }
                else
                {
                    System.out.println("Sorry, this hall does not provide Decoration service!");
                }
                try{
                    TimeUnit.SECONDS.sleep(2);
                } catch(InterruptedException ie){
                    Thread.currentThread().interrupt();
                }
                displayBookingPage(bookingId);
                break;
            default:
                System.out.println("Inpute must be a number between 0 and 8");
                System.out.println("Please re-enter:");
                break;
        }

    }

    public void displayBookingHistory()
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System -  Booking History");
        System.out.println("*****************************************************************************************");

        if (customerController.getCustomer().getPastBookings().size()>0)
        {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.format("| %-10s | %-8s | %-12s | %-10s | %-10s | %-13s | %-16s | %-15s | %-10s | %-12s | %-5s |\n",
                               "Booking Id", "Occasion", "Guest Number",
                               "Start Date", "End Date", "Catering Cost",
                               "Photography Cost", "Decoration Cost",
                               "Venue Cost", "Total Amount", "Rated");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < customerController.getCustomer().getPastBookings().size(); i++)
            {
                System.out.format("| %-10s | %-8s | %-12s | %-10s | %-10s | %-13s | %-16s | %-15s | %-10s | %-12s | %-5s |\n",
                                  customerController.getCustomer().getPastBookings().get(i).getIdCust(),
                                  customerController.getCustomer().getPastBookings().get(i).getOccasion(),
                                  customerController.getCustomer().getPastBookings().get(i).getGuestNum(),
                                  formatter.format(customerController.getCustomer().getPastBookings().get(i).getStartDate()),
                                  formatter.format(customerController.getCustomer().getPastBookings().get(i).getEndDate()),
                                  customerController.getCustomer().getPastBookings().get(i).getCateringCost(),
                                  customerController.getCustomer().getPastBookings().get(i).getPhotographyCost(),
                                  customerController.getCustomer().getPastBookings().get(i).getDecorationCost(),
                                  customerController.getCustomer().getPastBookings().get(i).getVenueCost(),
                                  customerController.getCustomer().getPastBookings().get(i).getTotalAmount(),
                                  (customerController.getCustomer().getPastBookings().get(i).isRated()) ? "yes" : "no");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");

            }
        }
        else
        {
            System.out.println("You don't have any completed bookings!");
        }

        System.out.println("Enter 0 to go back");
        System.out.println("Enter booking id to view details");

        int bookingId;

        while(true)
        {
            try{
                bookingId = sc.nextInt();
                if (bookingId != 0 && bookingId > customerController.getCustomer().getPastBookings().size())
                {
                    System.out.println("The booking you requested doesn't exist!");
                    System.out.println("Please re-enter:");
                    continue;
                }
                else
                {
                    break;
                }
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid input. Please enter a number: ");
                continue;
            }
        }

        switch(bookingId)
        {
            case 0:
                displayCustomerPage();
                break;
            default:
                displayPastBookingDetailPage(bookingId);
                break;
        }
    }

    public void displayPastBookingDetailPage(int bookingId)
    {
        System.out.print('\u000C');
        Scanner sc = new Scanner(System.in);
        System.out.println("*****************************************************************************************");
        System.out.println("Welcome to the Event Management System - Past Booking");
        System.out.println("*****************************************************************************************");

        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Id",
                         customerController.getPastBookingByIdCust(bookingId).getHall().getId());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Booking Id",
                         customerController.getPastBookingByIdCust(bookingId).getIdCust());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Name",
                         customerController.getPastBookingByIdCust(bookingId).getHall().getName());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Start Date",
                         CustomerInterface.formatter.format(customerController.getPastBookingByIdCust(bookingId).getStartDate()));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "End Date",
                         CustomerInterface.formatter.format(customerController.getPastBookingByIdCust(bookingId).getEndDate()));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Occasion",
                         customerController.getPastBookingByIdCust(bookingId).getOccasion());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42d|\n", "Guest Number", customerController.getPastBookingByIdCust(bookingId).getGuestNum());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Catering Service",
                            ((customerController.getPastBookingByIdCust(bookingId).isCateringService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Catering Cost", customerController.getPastBookingByIdCust(bookingId).getCateringCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Photography Service",
                            ((customerController.getPastBookingByIdCust(bookingId).isPhotographyService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Photography Cost", customerController.getPastBookingByIdCust(bookingId).getPhotographyCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Decoration Service",
                            ((customerController.getPastBookingByIdCust(bookingId).isDecorationService()) ? "Required" : "Not Required")) ;
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Decoration Cost", customerController.getPastBookingByIdCust(bookingId).getDecorationCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Venue Cost", customerController.getPastBookingByIdCust(bookingId).getVenueCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Total Amount", customerController.getPastBookingByIdCust(bookingId).getTotalAmount());
        System.out.println("-----------------------------------------------------------------------------");
        if(customerController.getPastBookingByIdCust(bookingId).isRated())
        {
            if (customerController.getPastBookingByIdCust(bookingId).isCateringService())
            {
                System.out.format("|  %-28s|  %-42s|\n", "Catering Rating", customerController.getPastBookingByIdCust(bookingId).getRating().getCateringRating());
                System.out.println("-----------------------------------------------------------------------------");
            }
            if (customerController.getPastBookingByIdCust(bookingId).isPhotographyService())
            {
                System.out.format("|  %-28s|  %-42s|\n", "Photography Rating", customerController.getPastBookingByIdCust(bookingId).getRating().getPhotographyRating());
                System.out.println("-----------------------------------------------------------------------------");
            }
            if (customerController.getPastBookingByIdCust(bookingId).isDecorationService())
            {
                System.out.format("|  %-28s|  %-42s|\n", "Decoration Rating", customerController.getPastBookingByIdCust(bookingId).getRating().getDecorationRating());
                System.out.println("-----------------------------------------------------------------------------");
            }
            System.out.format("|  %-28s|  %-42s|\n", "Overall Rating", customerController.getPastBookingByIdCust(bookingId).getRating().getHallRating());
            System.out.println("-----------------------------------------------------------------------------");
        }
            System.out.println();
        if (!customerController.getPastBookingByIdCust(bookingId).isRated())
        {
            System.out.println("Enter 0 to go back");
            System.out.println("Enter 1 to rate this booking");
            int choice;
            while(true)
            {
                try{
                    choice = sc.nextInt();
                    if (choice !=0 && choice != 1)
                    {
                        continue;
                    }
                    else
                    {
                        break;
                    }
                }catch(java.util.InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Invalid Input. Please re-enter either 0 or 1");
                    continue;
                }
            }
            sc.nextLine();
            switch(choice)
            {
                case 0:
                    displayBookingHistory();
                    break;
                case 1:
                    if (customerController.getPastBookingByIdCust(bookingId).isCateringService())
                    {
                        System.out.println("Enter your rating for the catering service of this hall:");
                        int cateringRating;
                        while(true)
                        {
                            try{
                                cateringRating = sc.nextInt();
                                if(cateringRating<0 || cateringRating > 5)
                                {
                                    System.out.println("Rating must be between 0 and 5. Please Re-enter:");
                                    continue;
                                }
                                else{
                                    customerController.getPastBookingByIdCust(bookingId).getRating().setCateringRating(cateringRating);
                                    break;
                                }
                            }catch(java.util.InputMismatchException e){
                                System.out.println("Please Enter a number");
                                sc.nextLine();
                                continue;
                            }
                        }
                    }
                    if (customerController.getPastBookingByIdCust(bookingId).isPhotographyService())
                    {
                        System.out.println("Enter your rating for the photography service of this hall:");
                        int photographyRating;
                        while(true)
                        {
                            try{
                                photographyRating = sc.nextInt();
                                if(photographyRating<0 || photographyRating > 5)
                                {
                                    System.out.println("Rating must be between 0 and 5. Please Re-enter:");
                                    continue;
                                }
                                else{
                                    customerController.getPastBookingByIdCust(bookingId).getRating().setPhotographyRating(photographyRating);
                                    break;
                                }
                            }catch(java.util.InputMismatchException e){
                                System.out.println("Please Enter a number");
                                sc.nextLine();
                                continue;
                            }
                        }
                    }
                    if (customerController.getPastBookingByIdCust(bookingId).isDecorationService())
                    {
                        System.out.println("Enter your rating for the decoration service of this hall:");
                        int decorationRating;
                        while(true)
                        {
                            try{
                                decorationRating = sc.nextInt();
                                if(decorationRating<0 || decorationRating > 5)
                                {
                                    System.out.println("Rating must be between 0 and 5. Please Re-enter:");
                                    continue;
                                }
                                else{
                                    customerController.getPastBookingByIdCust(bookingId).getRating().setDecorationRating(decorationRating);
                                    break;
                                }
                            }catch(java.util.InputMismatchException e){
                                System.out.println("Please Enter a number");
                                sc.nextLine();
                                continue;
                            }
                        }
                    }
                    System.out.println("Enter your overall rating for this hall:");
                    int hallRating;
                    while(true)
                    {
                        try{
                            hallRating = sc.nextInt();
                            if(hallRating<0 || hallRating > 5)
                            {
                                System.out.println("Rating must be between 0 and 5. Please Re-enter:");
                                continue;
                            }
                            else{
                                customerController.getPastBookingByIdCust(bookingId).getRating().setHallRating(hallRating);
                                break;
                            }
                        }catch(java.util.InputMismatchException e){
                            System.out.println("Please Enter a number");
                            sc.nextLine();
                            continue;
                        }
                    }
                    customerController.getPastBookingByIdCust(bookingId).setRated(true);
                    customerController.getPastBookingByIdCust(bookingId).getHall().calculateAverageRating();
                    System.out.println("This hall has been rated! Thank you!");
                    try{
                        TimeUnit.SECONDS.sleep(2);
                    } catch(InterruptedException ie){
                        Thread.currentThread().interrupt();
                    }
                    displayPastBookingDetailPage(bookingId);
                    break;
            }
        }
        else
        {
            System.out.println("Enter 0 to go back");
            int choice;
            while(true)
            {
                try{
                    choice = sc.nextInt();
                    if (choice == 0)
                    {
                        displayBookingHistory();
                        break;
                    }
                    else{
                        System.out.println("Invalid Input. Enter 0 to go back");
                        continue;
                    }
                }catch(java.util.InputMismatchException e){
                    System.out.println("Invalid Input. Enter 0 to go back");
                    sc.nextLine();
                    continue;
                }
            }
        }
    }

    public CustomerController getCustomerController()
    {
        return this.customerController;
    }
}
