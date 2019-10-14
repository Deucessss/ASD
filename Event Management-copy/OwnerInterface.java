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
        System.out.println("Press 5 to Logout");
        System.out.println("Please enter your choice:");
        int choice = sc.nextInt();
        while(choice < 1 || choice > 5)
        {
            System.out.println("Invalid input. Please re-enter a number between 1 and 6");
            choice = sc.nextInt();
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
            case 5:
                ownerController.logout();
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
        System.out.println("Enter hall availability:(y/n)");
        String Availability = sc.nextLine();
        boolean availability;
        while(!(Availability.equalsIgnoreCase("y") || Availability.equalsIgnoreCase("n")))
        {
         System.out.println("Enter the Photography Serice of the hall (y/n):");
         Availability = sc.nextLine();
        }
        if(Availability.equalsIgnoreCase("y") )
        {
            availability = true;
        }
        else
        {
            availability = false;
        }
        System.out.println("Enter the Photography Serice of the hall (y/n):");
        String photography = sc.nextLine();
        boolean photographyService;
        while(!(photography.equalsIgnoreCase("y") || photography.equalsIgnoreCase("n")))
        {
         System.out.println("Enter the Photography Serice of the hall (y/n):");
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
         System.out.println("Enter the Catering Serice of the hall (y/n):");
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
             System.out.println("Enter the Decoration Serice of the hall (y/n):");
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
        int hallCapacity = sc.nextInt();
        while(hallCapacity < 100)
        {
            System.out.println("The minimum capacity of the hall must be 100");
            hallCapacity = sc.nextInt();
        }
        System.out.println("Please Enter the Price of the Hall");
        float price = sc.nextFloat();
        System.out.println("Enter hall Discount:");
        float hallDiscount = sc.nextFloat();
        while(hallDiscount < 0 && hallDiscount > 100)
        {
         System.out.println("Enter hall Discount in between 1 and 100:");
         hallDiscount = sc.nextFloat();
        }
        ownerController.addHall(name,address,contact,description, availability,
                                hallDiscount,cateringService,decorationService,
                                photographyService,price,hallCapacity);
        System.out.printf("%s\n", lineBreak);
        System.out.println("Hall successfully added!");
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
            System.out.println("Sorry, you have nt added any hall yet");
            System.out.println("Press 1 to add a hall");
            System.out.println("Press 2 to go back");
            int option = sc.nextInt();
            while (option != 1 && option != 2)
            {
                System.out.println("Invalid option. Please re-enter either 1 or 2:");
                option = sc.nextInt();
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
            int hallNum = sc.nextInt();
            while(hallNum > ownerController.getOwner().getHalls().size())
            {
                System.out.println("Invalid input. Please re-enter a hall number or go back by entering 0");
                hallNum = sc.nextInt();
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
        while(attribute < 1 || attribute > 5)
        {
            System.out.println("Invalid Input. Please enter a number from 1 to 5");
            attribute = sc.nextInt();
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
            while (option != 1 && option != 2)
            {
                System.out.println("Invalid option. Please re-enter either 1 or 2:");
                option = sc.nextInt();
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
            int hallNum = sc.nextInt();
            while(hallNum > ownerController.getOwner().getHalls().size())
            {
                System.out.println("Invalid input. Please re-enter a hall number or go back by entering 0");
                hallNum = sc.nextInt();
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
                        System.out.println("Hall has successfully been removed");
                        displayOwnerPage();
                    }
                    else
                    {
                        System.out.println("Hall nt removed");
                        displayOwnerPage();
                    }
            }
        }
    }
    
    public OwnerController getOwnerController()
    {
        return this.ownerController;
    }
}
