import java.util.*;
import java.util.concurrent.TimeUnit;
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
    System.out.print('\u000C');
    Scanner sc = new Scanner(System.in);
    System.out.printf("%s\n",lineBreak);
    System.out.println("Welcome to the Event Management System - Hello, " + ownerController.getOwner().getLastName());
    System.out.printf("%s\n",lineBreak);
    System.out.println("Please select from the following options:");
    System.out.println("Press 1 to Add Hall");
    System.out.println("Press 2 to Update a Hall");
    System.out.println("Press 3 to Delete a Hall");
    System.out.println("Press 4 to Update personal Details");
    System.out.println("Press 5 to View Unreplied Quotations("+ ownerController.unrepliedQuotationsCount() +
                       " unreplied quotations)");
    System.out.println("Press 6 to View Replied Quotations("+ ownerController.acceptedQuotationsCount() +
                        " accepted quoations)");
    System.out.println("Press 7 to View Bookings");
    System.out.println("Press 8 to Logout");
    System.out.println("Press 9 to Exit");
    System.out.println("Please enter your choice:");
    int choice;
    while (true)
    {
        try{
            choice = sc.nextInt();
            if (choice < 1 || choice > 9)
            {
                System.out.println("Invalid input. Please re-enter a number between 1 and 9");
                continue;
            }
            else
            {
                break;
            }
        } catch (java.util.InputMismatchException e){
            sc.nextLine();
            System.out.println("Invalid input. Please re-enter a number between 1 and 9");
        }
    }

    switch(choice)
    {
        case 1:
            displayAddHallPage();
            break;
        case 2:
            displayUpdateHallPage();
            break;
        case 3:
            displayDeleteHallPage();
            break;
        case 4:
            displayOwnerPage();
            break;
        case 5:
            displayUnrepliedQuotationsPage();
            break;
        case 6:
            displayRepliedQuotationsPage();
            break;
        case 7:
            displayBookingsPage();
            break;
        case 8:
            ownerController.logout();
            break;
        case 9:
            HomeController.exitSoftware();
            break;
    }
}

public void displayAddHallPage()
{
    System.out.print('\u000C');
    System.out.printf("%s\n",lineBreak);
    System.out.println("Event Management System - Add a hall");
    System.out.printf("%s\n",lineBreak);
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter hall name:");
    String name = sc.nextLine();
    while(name.length() < 1 || name.length() > 25)
    {
        System.out.println("Please re-enter a name between 1 and 25 characters");
        name = sc.nextLine();
    }
    System.out.println("Enter the address of the hall:");
    String address = sc.nextLine();
    while(address.length() < 1 || address.length() > 50)
    {
        System.out.println("Please re-enter an address between 1 and 50 characters");
        address = sc.nextLine();
    }
    System.out.println("Enter the contact phone number for this hall:");
    String contact = sc.nextLine();
    while(contact.length() != 10)
    {
        System.out.println("Invalid contact number. Must be 10 digits");
        contact = sc.nextLine();
    }
    System.out.println("Enter the description of the hall:");
    String description = sc.nextLine();
    while(description.length() > 250)
    {
        System.out.println("Description character limit is 250. Please re-enter");
        description = sc.nextLine();
    }
    System.out.println("Enter the Photography Serice of the hall (y/n):");
    String photography = sc.nextLine();
    boolean photographyService;
    while(!(photography.equalsIgnoreCase("y") || photography.equalsIgnoreCase("n")))
    {
     System.out.println("Please re-enter the photography service of the hall(y/n):");
     photography = sc.nextLine();
    }
    if(photography.equalsIgnoreCase("y") )
    {
        photographyService = true;
    }
    else
    {
        photographyService = false;
    }
    System.out.println("Enter the Catering Serice of the hall (y/n):");
    String catering = sc.nextLine();
    boolean cateringService;
    while(!(catering.equalsIgnoreCase("y") || catering.equalsIgnoreCase("n")))
    {
     System.out.println("Please re-enter the catering service of the hall(y/n):");
     catering = sc.nextLine();
    }
    if(catering.equalsIgnoreCase("y") )
    {
        cateringService = true;
    }
    else
    {
        cateringService = false;
    }

    System.out.println("Enter the Decoration Serice of the hall(y/n):");
    String decoration = sc.nextLine();
    boolean decorationService;
    while(!(decoration.equalsIgnoreCase("y") || decoration.equalsIgnoreCase("n")))
    {
         System.out.println("Please re-enter the decoration service of the hall(y/n):");
         decoration = sc.nextLine();
    }
    if(decoration.equalsIgnoreCase("y") )
    {
        decorationService = true;
    }
    else
    {
        decorationService = false;
    }
    System.out.println("Please Enter the Capacity of the Hall");
    int hallCapacity;// = sc.nextInt();
    while (true)
    {
        try{
            hallCapacity = sc.nextInt();
            if (hallCapacity < 50)
            {
                System.out.println("The minimum capacity of the hall must be 50");
                continue;
            }
            else
            {
                break;
            }
        }catch (java.util.InputMismatchException e){
            sc.nextLine();
            System.out.println("Hall capacity must be a number greater than 50");
            continue;
        }
    }

    System.out.println("Please Enter the Price of the Hall");
    float price;
    while (true)
    {
        try{
            price = sc.nextFloat();
            break;
        }catch(java.util.InputMismatchException e){
            sc.nextLine();
            System.out.println("Price must be a numbers");
            continue;
        }
    }
    System.out.println("Enter hall Discount:");
    float hallDiscount;

    while (true)
    {
        try{
            hallDiscount = sc.nextFloat();
            if (hallDiscount > 100 || hallDiscount < 0)
            {
                System.out.println("Hall discount must be between 1 and 100");
                continue;
            }
            else
            {
                break;
            }
        }catch(java.util.InputMismatchException e){
            sc.nextLine();
            System.out.println("Hall discount must be a number");
            continue;
        }
    }
    ownerController.addHall(name,address,contact,description,
                            hallDiscount,cateringService,decorationService,
                            photographyService,price,hallCapacity);

    System.out.println("Hall has been successfully added!");
    System.out.println("Taking you back to your home page");
    try{
        TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException ie){
            Thread.currentThread().interrupt();
        }

    displayOwnerPage();

}

public void displayUpdateHallPage()
{
    System.out.print('\u000C');
    System.out.printf("%s\n",lineBreak);
    System.out.println("Event Management System - Update a hall");
    System.out.printf("%s\n",lineBreak);
    Scanner sc = new Scanner(System.in);
    if (ownerController.getOwner().getHalls().size() == 0)
    {
        System.out.println("Sorry, you have not added any hall yet");
        System.out.println("Press 1 to add a hall");
        System.out.println("Press 2 to go back");
        int option;
        while (true)
        {
            try{
                option = sc.nextInt();
                if (option != 1 && option != 2)
                {
                    System.out.println("Invalid option. Please choose from 1 and 2");
                    continue;
                }
                else
                {
                    break;
                }
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid option. Please choose from 1 and 2");
                continue;
            }
        }
        switch(option)
        {
            case 1:
                displayAddHallPage();
                break;
            case 2:
                displayOwnerPage();
                break;
        }
    }
    else
    {
        ownerController.printHalls();
        System.out.println("Enter a hall number to update");
        System.out.println("Press 0 to go back");
        int hallNum;
        while (true)
        {
            try{
                hallNum = sc.nextInt();
                if (hallNum > ownerController.getOwner().getHalls().size())
                {
                    System.out.println("Hall does not exist. Please enter another hall number:");
                    continue;
                }
                else
                {
                    break;
                }
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Hall number is a number." +
                            "Please re-enter a hall number or go back by entering 0");
                continue;
                }
        }
        switch(hallNum)
        {
            case 0:
                displayOwnerPage();
                break;
            default:
                displayEditHallPage(hallNum);
                break;
        }
    }
}

public void displayEditHallPage(int hallNum)
{
    System.out.print('\u000C');
    System.out.printf("%s\n",lineBreak);
    System.out.println("Event Management System - Edit " +
                        ownerController.getOwner().getHalls().get(hallNum-1).getName() +
                        " hall");
    System.out.printf("%s\n",lineBreak);
    Scanner sc = new Scanner(System.in);
    System.out.println("Press 1 to change hall name");
    System.out.println("Press 2 to change hall address");
    System.out.println("Press 3 to change hall contact");
    System.out.println("Press 4 to change hall description");
    System.out.println("Press 5 to choose go back");
    int attribute = sc.nextInt();
    while (true)
    {
        try{
            attribute = sc.nextInt();
            if (attribute < 1 || attribute > 5)
            {
                System.out.println("Please enter a number from 1 to 5");
                continue;
            }
            else
            {
                break;
            }
        }catch(java.util.InputMismatchException e){
            sc.nextLine();
            System.out.println("Please enter a number from 1 to 5");
            continue;
        }
    }
    switch(attribute)
    {
        case 1:
            System.out.printf("Current name of the hall: %s\n", ownerController.getOwner().getHalls().get(hallNum-1).getName());
            System.out.println("Enter a new name:");
            String newName = sc.next();
            while(newName.length() < 1 || newName.length() > 25)
            {
                System.out.println("Please re-enter a name between 1 and 25 characters");
                newName = sc.next();
            }
            ownerController.getOwner().getHalls().get(hallNum-1).setName(newName);
            System.out.println("Name changed successfully");
            break;
        case 2:
            System.out.println("Enter a new address:");
            String newAddress = sc.next();
            while(newAddress.length() < 1 || newAddress.length() > 50)
            {
                System.out.println("Please re-enter an address between 1 and 50 characters");
                newAddress = sc.next();
            }
            ownerController.getOwner().getHalls().get(hallNum-1).setAddress(newAddress);
            break;
        case 3:
            System.out.println("Enter a new contact:");
            String newContact = sc.next();
            while(newContact.length() != 10)
            {
                System.out.println("Invalid contact number. Must be 10 digits");
                newContact = sc.next();
            }
            ownerController.getOwner().getHalls().get(hallNum-1).setContact(newContact);
            break;
        case 4:
        // !!!keep track of description input !!!
            System.out.println("Enter a new description:");
            String newDesc = sc.next();
            while (newDesc.length() > 250)
            {
                System.out.println("Description character limit is 250. Please re-enter");
                newDesc = sc.next();
            }
            ownerController.getOwner().getHalls().get(hallNum-1).setDescription(newDesc);
            break;
        case 5:
            displayUpdateHallPage();
            break;
    }
    System.out.printf("%s\n",lineBreak);
    if (attribute != 5)
    {
        displayEditHallPage(hallNum);
    }
}

public void displayDeleteHallPage()
{
    System.out.print('\u000C');
    System.out.printf("%s\n",lineBreak);
    System.out.println("Event Management System - Remove a hall");
    System.out.printf("%s\n",lineBreak);
    Scanner sc = new Scanner(System.in);
    if (ownerController.getOwner().getHalls().size() == 0)
    {
        System.out.println("Sorry, you have nt added any hall yet");
        System.out.println("Press 1 to add a hall");
        System.out.println("Press 2 to go back");
        int option = sc.nextInt();
        while (true)
        {
            try{
                option = sc.nextInt();
                if (option < 1 || option > 2)
                {
                    continue;
                }
                else
                {
                    break;
                }
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid Input. Please enter a number from 1 to 2");
                continue;
            }
        }
        switch(option)
        {
            case 1:
                displayAddHallPage();
                break;
            case 2:
                displayOwnerPage();
                break;
        }
        }
    else
    {
        ownerController.printHalls();
        System.out.println("Enter a hall number to delete");
        System.out.println("Press 0 to go back");
        int hallNum;
        while (true)
        {
            try{
                hallNum = sc.nextInt();
                if (hallNum > ownerController.getOwner().getHalls().size())
                {
                    System.out.println("Hall does not exist. Please re-enter a number: ");
                    continue;
                }
                else
                {
                    break;
                }
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Invalid input. Please re-enter a hall number or go back by entering 0");
                continue;
            }
        }
        switch(hallNum)
        {
            case 0:
                displayOwnerPage();
                break;
            default:
                System.out.println("Hall to delete is:");
                System.out.println("*****************************************************************************************");
                ownerController.printHall(hallNum-1);
                System.out.println();
                System.out.println("Confirm delete this hall(y/n):");
                String confirmDelete = sc.next();
                while (confirmDelete.equalsIgnoreCase("y") && confirmDelete.equalsIgnoreCase("n"))
                {
                    System.out.println("Please re-enter y or n");
                    confirmDelete = sc.next();
                }
                if(confirmDelete.equalsIgnoreCase("y"))
                {
                    ownerController.getOwner().getHalls().remove(hallNum-1);
                    if (ownerController.getOwner().getHalls().size() > 0){
                        for (int i = 0; i < ownerController.getOwner().getHalls().size(); i ++)
                        {
                            ownerController.getOwner().getHalls().get(i).setId(i+1);
                        }
                    }
                    System.out.println("Hall has successfully been removed");
                    displayOwnerPage();
                }
                else
                {
                    System.out.println("Hall not removed");
                    displayOwnerPage();
                }
        }
    }
    }

    public void displayUnrepliedQuotationsPage()
    {
        System.out.print('\u000C');
        System.out.printf("%s\n",lineBreak);
        System.out.println("Event Management System - Unreplied Quotations");
        System.out.printf("%s\n",lineBreak);
        Scanner sc = new Scanner(System.in);

        ownerController.displayUnrepliedQuotations();

        System.out.println("Enter a Hall Id to view quotation details");
        System.out.println("Enter 0 to go back");
        int hallId;

        while(true)
        {
            try{
                hallId = sc.nextInt();
                break;
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Hall Id must be a number");
                continue;
            }
        }
        switch(hallId)
        {
            case 0:
                displayOwnerPage();
                break;
            default:
                System.out.println("Enter a Quotation Id to View Quotation Details");
                int quotId;
                while(true)
                {
                    try{
                        quotId = sc.nextInt();
                        break;
                    }catch(java.util.InputMismatchException e){
                        sc.nextLine();
                        System.out.println("Quotation ID must be a number");
                        continue;
                    }
                }
                if (ownerController.searchUnrepliedQuotation(hallId, quotId) == null)
                {
                    System.out.print('\u000C');
                    System.out.println("Quotation requested does not exist");
                    System.out.println("Please Retry");
                    System.out.println("Taking you back to quotation page");
                    try{
                    TimeUnit.SECONDS.sleep(2);
                    } catch(InterruptedException ie){
                        Thread.currentThread().interrupt();
                    }
                    displayUnrepliedQuotationsPage();
                }
                else
                {
                    displayUnrepliedQuotationDetailsPage(hallId, quotId);
                    //displayReplyQuotationPage(hallId, quotId);
                }
                break;
        }

    }

    public void displayUnrepliedQuotationDetailsPage(int hallId, int quotId)
    {
        System.out.print('\u000C');
        System.out.printf("%s\n",lineBreak);
        System.out.println("Event Management System - Unreplied Quotations");
        System.out.printf("%s\n",lineBreak);
        Scanner sc = new Scanner(System.in);

        ownerController.displayUnrepliedQuotation(ownerController.searchUnrepliedQuotation(hallId, quotId));
        System.out.println("Enter 1 to reply to this quotation");
        System.out.println("Enter 2 to go back to quotation pages");
        int choice;
        while (true)
        {
            try{
                choice = sc.nextInt();
                if (choice != 1 && choice != 2)
                {
                    System.out.println("Input must be either 1 or 2");
                    System.out.println("Please re-enter:");
                    continue;
                }
                else
                {
                    break;
                }
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Input must be either 1 or 2");
                System.out.println("Please re-enter:");
                continue;
            }
        }
        switch(choice)
        {
            case 1:
                displayReplyQuotationPage(hallId, quotId);
                break;
            case 2:
                displayUnrepliedQuotationsPage();
                break;
        }
    }

    public void displayReplyQuotationPage(int hallID, int quotID)
    {
        System.out.print('\u000C');
        System.out.printf("%s\n",lineBreak);
        System.out.println("Event Management System - Reply to a quotation");
        System.out.printf("%s\n",lineBreak);
        Scanner sc = new Scanner(System.in);

        ownerController.displayUnrepliedQuotation(ownerController.searchUnrepliedQuotation(hallID, quotID));
        float cateringCost = 0;
        float photographyCost = 0;
        float decorationCost = 0;
        float venueCost;
        if (ownerController.searchUnrepliedQuotation(hallID, quotID).getCateringService())
        {
            System.out.println("Enter the cost for catering");
            while(true)
            {
                try{
                    cateringCost = sc.nextFloat();
                    break;
                }catch(java.util.InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Cost must be numers. Please re-enter cost for catering");
                    continue;
                }
            }
        }
        if (ownerController.searchUnrepliedQuotation(hallID, quotID).getPhotographyService())
        {
            System.out.println("Enter the cost for photography");
            while(true)
            {
                try{
                    photographyCost = sc.nextFloat();
                    break;
                }catch(java.util.InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Cost must be numers. Please re-enter cost for photography");
                    continue;
                }
            }
        }
        if (ownerController.searchUnrepliedQuotation(hallID, quotID).getDecorationService())
        {
            System.out.println("Enter the cost for decoration");
            while(true)
            {
                try{
                    decorationCost = sc.nextFloat();
                    break;
                }catch(java.util.InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Cost must be numers. Please re-enter cost for decoration");
                    continue;
                }
            }
        }
        System.out.println("Enter the venue cost");
        while(true)
            {
                try{
                    venueCost = sc.nextFloat();
                    break;
                }catch(java.util.InputMismatchException e){
                    sc.nextLine();
                    System.out.println("Cost must be numers. Please re-enter cost for catering");
                    continue;
                }
            }

        ownerController.replyQuotation(ownerController.searchUnrepliedQuotation(hallID, quotID),
                                    cateringCost, photographyCost, decorationCost, venueCost);

        System.out.println("Quotation Successfully replied!");
        System.out.println("Taking you back to quotation page");

        try{
        TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException ie){
            Thread.currentThread().interrupt();
        }

        displayRepliedQuotationsPage();

    }

    public void displayRepliedQuotationsPage()
    {
        System.out.print('\u000C');
        System.out.printf("%s\n",lineBreak);
        System.out.println("Event Management System - Replied Quotations");
        System.out.printf("%s\n",lineBreak);
        Scanner sc = new Scanner(System.in);

        ownerController.displayRepliedQuotations();
        System.out.println("Enter a Hall ID to Confirm Receiving Deposit");
        System.out.println("Enter 0 to go back");
        int hallId;
        while(true)
        {
            try{
                hallId = sc.nextInt();
                break;
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Hall Id must be a number");
                continue;
            }
        }
        switch(hallId)
        {
            case 0:
                displayOwnerPage();
                break;
            default:
                System.out.println("Enter a Quotation Id to Make a booking for this Quotation");
                int quotId;
                while(true)
                {
                    try{
                        quotId = sc.nextInt();
                        break;
                    }catch(java.util.InputMismatchException e){
                        sc.nextLine();
                        System.out.println("Quotation ID must be a number");
                        continue;
                    }
                }
                if (ownerController.searchRepliedQuotation(hallId, quotId) == null)
                {
                    System.out.println("Quotation requested does not exist");
                    System.out.println("Please Retry");
                    System.out.println("Taking you back to quotation page");
                    try{
                    TimeUnit.SECONDS.sleep(2);
                    } catch(InterruptedException ie){
                        Thread.currentThread().interrupt();
                    }
                    displayRepliedQuotationsPage();
                }
                else
                {
                    if (ownerController.searchRepliedQuotation(hallId, quotId).getQuotationAccepted())
                    {
                        displayAcceptQuotationPage(hallId, quotId);
                    }
                    else
                    {
                        System.out.println("This quotation has not been accepted by the customer!");
                        System.out.println("Please try again later");
                        try{
                        TimeUnit.SECONDS.sleep(2);
                        } catch(InterruptedException ie){
                            Thread.currentThread().interrupt();
                        }
                        displayRepliedQuotationsPage();
                        }
                }
                break;
        }
    }

    public void displayAcceptQuotationPage(int hallId, int quotId)
    {
        System.out.print('\u000C');
        System.out.printf("%s\n",lineBreak);
        System.out.println("Event Management System - Confirm Bookings");
        System.out.printf("%s\n",lineBreak);
        Scanner sc = new Scanner(System.in);

        ownerController.displayRepliedQuotation(ownerController.searchRepliedQuotation(hallId, quotId));
        System.out.println();
        System.out.println("Enter \"Confirm\" to confirm that you have received the deposit");
        System.out.println("Enter \"Reject\" to reject this booking");
        System.out.println("Enter 0 to go back");
        String choice = sc.nextLine();
        while (true)
        {
            if (choice.equalsIgnoreCase("confirm"))
            {
                ownerController.confirmBooking(ownerController.searchRepliedQuotation(hallId, quotId));
                System.out.println("Booking has been successfully made");
                System.out.println("Taking you to the the booking page");
                try{
                    TimeUnit.SECONDS.sleep(2);
                    } catch(InterruptedException ie){
                        Thread.currentThread().interrupt();
                }
                displayBookingsPage();
                break;
            }
            else if(choice.equalsIgnoreCase("reject"))
            {
                System.out.println("Booking has been successfully rejected");
                System.out.println("Taking you to the the replied quotations page");
                displayRepliedQuotationsPage();
                break;
            }
            else if (choice.equalsIgnoreCase("0"))
            {
                displayRepliedQuotationsPage();
                break;
            }
            else
            {
                System.out.println("Invalid Input. Please enter \"Confirm\", \"Reject\" or 0");
                System.out.println("Please Re-enter:");
                choice = sc.nextLine();
            }
        }
    }

    public void displayBookingsPage()
    {
        System.out.print('\u000C');
        System.out.printf("%s\n",lineBreak);
        System.out.println("Event Management System - Bookings Page");
        System.out.printf("%s\n",lineBreak);
        Scanner sc = new Scanner(System.in);

        ownerController.displayBookings();
        System.out.println("Enter 0 to go back");
        System.out.println("Enter a hall id to choose a hall");
        int hallId;
        while (true)
        {
            try{
                hallId = sc.nextInt();
                break;
            }catch(java.util.InputMismatchException e){
                sc.nextLine();
                System.out.println("Hall id must be a number. Please re-enter a hall id");
                continue;
            }
        }
        switch (hallId)
        {
            case 0:
                displayOwnerPage();
                break;
            default:
                System.out.println("Enter a booking id to manage");
                int bookingId;
                while (true)
                {
                    try{
                        bookingId = sc.nextInt();
                        break;
                    }catch(java.util.InputMismatchException e){
                        sc.nextLine();
                        System.out.println("Booking id must be a number. Please re-enter a booking id");
                        continue;
                    }
                }
                if (ownerController.searchBooking(hallId, bookingId) == null)
                {
                    System.out.println("Sorry, we can't find the booking you requested. Please try again");

                    try{
                    TimeUnit.SECONDS.sleep(2);
                    } catch(InterruptedException ie){
                        Thread.currentThread().interrupt();
                    }

                    displayBookingsPage();
                }
                else
                {
                    displayBookingPage(hallId, bookingId);
                }
                break;
        }
    }

    public void displayBookingPage(int hallId,int bookingId)
    {
        System.out.print('\u000C');
        System.out.printf("%s\n",lineBreak);
        System.out.println("Event Management System - Booking Detail Page");
        System.out.printf("%s\n",lineBreak);
        Scanner sc = new Scanner(System.in);

        ownerController.displayBookingDetails(ownerController.searchBooking(hallId, bookingId));

        if (ownerController.searchBooking(hallId, bookingId).isUpdated())
        {
            System.out.println("Enter 0 to go back");
            System.out.println("Enter \"Accept\" to accept update");
            System.out.println("Enter \"Reject\" to reject update");

            String choice = sc.nextLine();
            while (!choice.equalsIgnoreCase("0") &&
                   !choice.equalsIgnoreCase("Accept") &&
                   !choice.equalsIgnoreCase("Reject"))
            {
                System.out.println("Invalid Input");
                System.out.println("Enter 0 to go back");
                System.out.println("Enter \"Accept\" to accept update");
                System.out.println("Enter \"Reject\" to reject update");
            }

            switch(choice)
            {
                case "0":
                    displayBookingsPage();
                    break;
                case "accept":
                    ownerController.acceptUpdate(ownerController.searchBooking(hallId, bookingId));
                    System.out.println("Update has been successfully updated!");
                    try{
                    TimeUnit.SECONDS.sleep(2);
                    } catch(InterruptedException ie){
                        Thread.currentThread().interrupt();
                    }
                    displayBookingPage(hallId, bookingId);
                    break;
                case "reject":
                    ownerController.rejectUpdate(ownerController.searchBooking(hallId,bookingId));
                    System.out.println("Update has been successfully rejected!");
                    try{
                    TimeUnit.SECONDS.sleep(2);
                    } catch(InterruptedException ie){
                        Thread.currentThread().interrupt();
                    }
                    displayBookingPage(hallId, bookingId);

                    break;
            }
        }
        else
        {
            System.out.println("Enter 0 to go back");
            String choice = sc.nextLine();
            while (!choice.equalsIgnoreCase("0"))
            {
                System.out.println("Enter 0 to go back");
            }
            displayBookingsPage();
        }


    }

    public OwnerController getOwnerController()
    {
        return this.ownerController;
    }
}
