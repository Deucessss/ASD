import java.util.*;
public class OwnerController
{
// instance variables - replace the example below with your own
    private Owner owner;
    /**
     * Constructor for objects of class OwnerController
     */
    public OwnerController()
    {
        // initialise instance variables
    }

    /**
     * This method is used for adding halls.
     */
    public void addHall(String name, String address, String contact, String description,
                        float hallDiscount,boolean cateringService,boolean decorationService,
                        boolean photographyService,float price, int hallCapacity)
    {
        int id = owner.getHalls().size()+1;
        Hall hall = new Hall(name,address,contact,description,
                             hallDiscount,cateringService,decorationService,
                             photographyService,price,hallCapacity);
        this.owner.getHalls().add(hall);
        hall.setId(id);
    }

    /**
     * This method is used for printing all hall details.
     */
    public void printHalls()
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-25s %-15s %-30s", "id","Hall Name", "Hall Address",
                          "Contact Number", "Description");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
        for (int i = 0; i < this.owner.getHalls().size(); i++)
        {
            printHall(i);
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * This method is used for printing details of particular hall.
     */
    public void printHall(int index)
    {
        String name = this.owner.getHalls().get(index).getName();
            String address = this.owner.getHalls().get(index).getAddress();
            String contact = this.owner.getHalls().get(index).getContact();
            String description = this.owner.getHalls().get(index).getDescription();

            System.out.printf("%-5d %-15s %-25s %-15s %-30s",
                            index+1,name,address,contact,description);
    }

    /**
     * This method returns a quotation object which searches for the unreplied quattaions of owner.
     */
    public Quotation searchUnrepliedQuotation(int hallID, int quotationID)
    {
        for (Hall hall : owner.getHalls())
        {
            if (hall.getId() == hallID)
            {
                for (Quotation quot : hall.getQuotations())
                {
                    if (quot.getIdOwner() == quotationID)
                    {
                        return quot;
                    }
                }
            }
        }
        return null;
    }

    /**
     * This method returns a quotation object which searches for the replied quattaions of owner.
     */
    public Quotation searchRepliedQuotation(int hallID, int quotationID)
    {
        for (Hall hall : owner.getHalls())
        {
            if (hall.getId() == hallID)
            {
                for (Quotation quot : hall.getPastQuotations())
                {
                    if (quot.getIdOwner() == quotationID)
                    {
                        return quot;
                    }
                }
            }
        }
        return null;
    }

    /**
     * This method displays all the display all the unreplied of particular owner.
     */
    public void displayUnrepliedQuotations()
    {
        for (Hall hall : owner.getHalls())
        {
            if (hall.getQuotations().size() > 0)
            {
                System.out.println("*****************************************************************************************");
                System.out.format("* %-10s: %-2d%73s\n", "Hall Id", hall.getId(), "*");
                System.out.format("* %-10s: %-10s%65s\n", "Hall Name", hall.getName(), "*");
                System.out.println("*****************************************************************************************");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.format("| %-13s | %-11s | %-13s | %-11s | %-11s | %-12s|\n",
                                  "Quotation Id", "Occasion", "Guest Number", "Start Date", " End Date", "Budget");
                System.out.println("-----------------------------------------------------------------------------------------");
                for (Quotation quotation : hall.getQuotations())
                {


                    System.out.format("| %-13d | %-11s | %-13d | %-11s | %-11s | %-12.2f|\n",
                                        quotation.getIdOwner(), quotation.getOccasion(), quotation.getGuestNum(),
                                        CustomerInterface.formatter.format(quotation.getStartDate()),
                                        CustomerInterface.formatter.format(quotation.getEndDate()),
                                        quotation.getBudget());
                    System.out.println("-----------------------------------------------------------------------------------------");
                }
            }
        }
    }

    /**
     * This method displays all the display all the replied of particular owner.
     */
    public void displayRepliedQuotations()
    {
        for (Hall hall : owner.getHalls())
        {
            if (hall.getPastQuotations().size() > 0)
            {
                System.out.println("*****************************************************************************************");
                System.out.format("* %-10s: %-2d%73s\n", "Hall Id", hall.getId(), "*");
                System.out.format("* %-10s: %-10s%65s\n", "Hall Name", hall.getName(), "*");
                System.out.println("*****************************************************************************************");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.format("| %-13s | %-11s | %-13s | %-11s | %-11s | %-12s|\n",
                                  "Quotation Id", "Occasion", "Guest Number", "Start Date", " End Date", "Accepted");
                System.out.println("-----------------------------------------------------------------------------------------");
                for (Quotation quotation : hall.getPastQuotations())
                {

                    System.out.format("| %-13d | %-11s | %-13d | %-11s | %-11s | %-12s|\n",
                                        quotation.getIdOwner(), quotation.getOccasion(), quotation.getGuestNum(),
                                        CustomerInterface.formatter.format(quotation.getStartDate()),
                                        CustomerInterface.formatter.format(quotation.getEndDate()),
                                        ((quotation.getQuotationAccepted()) ? "Yes" : "No"));
                    System.out.println("-----------------------------------------------------------------------------------------");

                }
            }
        }
    }

    /**
     * This method displays all the hall details of particular unreplied quotation.
     */
    public void displayUnrepliedQuotation(Quotation quotation)
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Id", quotation.getHall().getId());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Quotation Id", quotation.getIdOwner());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Occasion", quotation.getOccasion());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42d|\n", "Guest Number", quotation.getGuestNum());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Catering Service",
                            ((quotation.getCateringService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Photography Service",
                            ((quotation.getPhotographyService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Decoration Service",
                            ((quotation.getDecorationService()) ? "Required" : "Not Required")) ;
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Start Date", CustomerInterface.formatter.format(quotation.getStartDate()));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "End Date", CustomerInterface.formatter.format(quotation.getEndDate()));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42.2f|\n", "Budget", quotation.getBudget());
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * This method displays all the hall details of particular replied quotation.
     */
    public void displayRepliedQuotation(Quotation quotation)
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Id", quotation.getHall().getId());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Quotation Id", quotation.getIdOwner());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Name", quotation.getHall().getName());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Start Date", CustomerInterface.formatter.format(quotation.getStartDate()));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "End Date", CustomerInterface.formatter.format(quotation.getEndDate()));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Occasion", quotation.getOccasion());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42d|\n", "Guest Number", quotation.getGuestNum());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Catering Service",
                            ((quotation.getCateringService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Catering Cost", quotation.getCateringCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Photography Service",
                            ((quotation.getPhotographyService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Photography Cost", quotation.getPhotographyCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Decoration Service",
                            ((quotation.getDecorationService()) ? "Required" : "Not Required")) ;
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Decoration Cost", quotation.getDecorationCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Venue Cost", quotation.getVenueCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Total Amount", quotation.getTotalAmount());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Deposit", quotation.getDepositAmount());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42.2f|\n", "Budget", quotation.getBudget());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Accepted",
                            ((quotation.getQuotationAccepted()) ? "yes" : "no"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Deposit Paid",((quotation.getDepositPaid()) ? "yes" : "no"));
        System.out.println("-----------------------------------------------------------------------------");
    }

    /**
     * This method helps the owner to reply for the quotation.
     */
    public void replyQuotation(Quotation quotation, float cateringCost, float photographyCost, float decorationCost,
                                float venueCost)
    {
        quotation.setCateringCost(cateringCost);
        quotation.setPhotographyCost(photographyCost);
        quotation.setDecorationCost(decorationCost);
        quotation.setVenueCost(venueCost);
        quotation.setTotalAmount(cateringCost + decorationCost + photographyCost + venueCost);
        quotation.setDepositAmount(quotation.getTotalAmount()/2);
        quotation.setReplied(true);

        quotation.setIdOwner(quotation.getHall().getPastQuotations().size() + 1);
        quotation.getHall().getPastQuotations().add(quotation);
        quotation.getHall().getQuotations().remove(quotation);
        if (quotation.getHall().getQuotations().size() > 0)
        {
            for (int i = 0; i < quotation.getHall().getQuotations().size(); i++)
            {
                quotation.setIdOwner(i+1);
            }
        }
    }

    /**
     * This method adds the quotation into booking after the user accepts.
     */
    public void confirmBooking(Quotation quotation)
    {
        if (quotation.getQuotationAccepted())
        {
            quotation.setDepositPaid(true);

            Booking booking = new Booking(quotation.getOccasion(), quotation.getGuestNum(),
                                          quotation.getCateringService(), quotation.getCateringCost(),
                                          quotation.getPhotographyService(), quotation.getPhotographyCost(),
                                          quotation.getDecorationService(), quotation.getDecorationCost(),
                                          quotation.getVenueCost(), quotation.getStartDate(), quotation.getEndDate(),
                                          quotation.getHall(), quotation.getCustomer());

            quotation.getHall().getBookings().add(booking);
            booking.setIdOwner(quotation.getHall().getBookings().size());
            quotation.getCustomer().getBookings().add(booking);
            booking.setIdCust(quotation.getCustomer().getBookings().size());

            quotation.getHall().getPastQuotations().remove(quotation);
            if (quotation.getHall().getPastQuotations().size() > 0)
            {
                for (int i = 0 ; i < quotation.getHall().getPastQuotations().size(); i++)
                {
                    quotation.getHall().getPastQuotations().get(i).setIdOwner(i+1);
                }
            }

            quotation.getCustomer().getQuotations().remove(quotation);
            if (quotation.getCustomer().getQuotations().size() > 0)
            {
                for (int i = 0; i < quotation.getCustomer().getQuotations().size(); i++)
                {
                    quotation.getCustomer().getQuotations().get(i).setIdCust(i+1);
                }
            }
        }
    }

    /**
     * This method displays the count unreplied quotation.
     */
    public int unrepliedQuotationsCount()
    {
        int count = 0;
        for (Hall hall : owner.getHalls())
        {
            count += hall.getQuotations().size();
        }
        return count;
    }

    /**
     * This method displays count of accepted quotation.
     */
    public int acceptedQuotationsCount()
    {
        int count = 0;
        for (Hall hall : owner.getHalls())
        {
            if (hall.getPastQuotations().size() > 0)
            {
                for (Quotation quotation : hall.getPastQuotations())
                {
                    if (quotation.getQuotationAccepted())
                    {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * This method displays all the bookings.
     */
    public void displayBookings()
    {
        System.out.println();
        for (Hall hall: owner.getHalls())
        {
            if (hall.getBookings().size() > 0){
                System.out.println("*****************************************************************************************");
                System.out.format("* %-10s: %-2d%73s\n", "Hall id", hall.getId(), "*");
                System.out.format("* %-10s: %-10s%65s\n", "Hall Name", hall.getName(), "*");
                System.out.println("*****************************************************************************************");
                System.out.println("-----------------------------------------------------------------------------------------");
                System.out.format("| %-11s | %-10s | %-13s | %-11s | %-11s | %-13s  |\n",
                                    "Booking id", "occasion", "Guest Number", "Start Date", "End Date", "Total Amount");
                System.out.println("-----------------------------------------------------------------------------------------");
                for (Booking booking : hall.getBookings())
                {
                    System.out.format("| %-11d | %-10s | %-13d | %-11s | %-11s | %-13.1f  |\n", booking.getIdOwner(),
                                        booking.getOccasion(), booking.getGuestNum(),
                                        CustomerInterface.formatter.format(booking.getStartDate()),
                                        CustomerInterface.formatter.format(booking.getEndDate()),
                                        booking.getTotalAmount());
                    System.out.println("-----------------------------------------------------------------------------------------");
                }
                System.out.println();
            }
        }
    }


    /**
     * This method returns a particular booking object from Booking list.
     */
    public Booking searchBooking(int hallId, int bookingId)
    {
        for (Hall hall : owner.getHalls())
        {
            if (hall.getId() == hallId)
            {
                for (Booking booking : hall.getBookings())
                {
                    if (booking.getIdOwner() == bookingId)
                    {
                        return booking;
                    }
                }
            }
        }
        return null;
    }

    /**
     * This method displays all the booking details of particular booking.
     */
    public void displayBookingDetails(Booking booking)
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Id", booking.getHall().getId());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Booking Id", booking.getIdOwner());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Name", booking.getHall().getName());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Start Date", CustomerInterface.formatter.format(booking.getStartDate()));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "End Date", CustomerInterface.formatter.format(booking.getEndDate()));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Occasion", booking.getOccasion());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42d|\n", "Guest Number", booking.getGuestNum());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Catering Service",
                            ((booking.isCateringService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Catering Cost", booking.getCateringCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Photography Service",
                            ((booking.isPhotographyService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Photography Cost", booking.getPhotographyCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Decoration Service",
                            ((booking.isDecorationService()) ? "Required" : "Not Required")) ;
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Decoration Cost", booking.getDecorationCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Venue Cost", booking.getVenueCost());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Total Amount", booking.getTotalAmount());
        System.out.println("-----------------------------------------------------------------------------");

        if (booking.isUpdated())
        {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Update Request");
            System.out.println("-----------------------------------------------------------------------------");
            if(booking.isOccasionUpdated())
            {
                System.out.format("|  %-28s|  %-42s|\n", "Occasion", booking.getUpdatedOccasion());
                System.out.println("-----------------------------------------------------------------------------");
            }
            if(booking.isGuestNumUpdated())
            {
                System.out.format("|  %-28s|  %-42s|\n", "Guest Number", booking.getUpdatedGuestNum() );
                System.out.println("-----------------------------------------------------------------------------");
            }
            if (booking.isEventDateUpdated()){
                System.out.format("|  %-28s|  %-42s|\n", "Start Date", CustomerInterface.formatter.format(booking.getUpdatedStartDate()));
                System.out.println("-----------------------------------------------------------------------------");
                System.out.format("|  %-28s|  %-42s|\n", "End Date", CustomerInterface.formatter.format(booking.getUpdatedEndDate()));
                System.out.println("-----------------------------------------------------------------------------");
            }
            if(booking.getHall().getCateringService() && booking.isCateringServiceUpdated())
            {
                System.out.format("|  %-28s|  %-42s|\n", "Require Catering Service",
                                    ((booking.isCateringService()) ? "Not Required" : "Required"));
                System.out.println("-----------------------------------------------------------------------------");

            }
            if(booking.getHall().getPhotographyService() && booking.isPhotographyServiceUpdated())
            {
                System.out.format("|  %-28s|  %-42s|\n", "Require Photography Service",
                                    ((booking.isPhotographyServiceUpdated()) ? "Not Required" : "Required"));
                System.out.println("-----------------------------------------------------------------------------");
            }
            if(booking.getHall().getDecorationService() && booking.isDecorationServiceUpdated())
            {
                System.out.format("|  %-28s|  %-42s|\n", "Require Decoration Service",
                                    ((booking.isDecorationServiceUpdated()) ? "Not Required" : "Required"));
                System.out.println("-----------------------------------------------------------------------------");
            }
        }
    }

    /**
     * This method is used to update booking which is accepted.
     */
    public void acceptUpdate(Booking booking)
    {
        Scanner sc = new Scanner(System.in);
        if (booking.isOccasionUpdated())
        {
            booking.setOccasion(booking.getUpdatedOccasion());
            booking.setOccasionUpdated(false);
        }

        if (booking.isGuestNumUpdated())
        {
            booking.setGuestNum(booking.getUpdatedGuestNum());
            booking.setGuestNumUpdated(false);
        }

        if (booking.isEventDateUpdated())
        {
            booking.setStartDate(booking.getUpdatedStartDate());
            booking.setEndDate(booking.getUpdatedEndDate());
            booking.setEventDateUpdated(false);
        }
        if(booking.isCateringServiceUpdated())
        {
            booking.setCateringService(!booking.isCateringService());
            if (booking.isCateringService())
            {
                System.out.println("Enter the catering cost: ");
                float cateringCost;
                while (true)
                {
                    try{
                        cateringCost = sc.nextFloat();
                        break;
                    }catch(java.util.InputMismatchException e){
                        sc.nextLine();
                        System.out.println("Catering cost must be a number!");
                        System.out.println("Please re-enter catering cost:");
                        continue;
                    }
                }
                booking.setCateringCost(cateringCost);
                booking.setTotalAmount(booking.getTotalAmount() +
                                       booking.getCateringCost());
            }
            else
            {
                booking.setCateringCost(0);
            }
            sc.nextLine();
            booking.setCateringServiceUpdated(false);
        }


        if(booking.isPhotographyServiceUpdated())
        {
            booking.setPhotographyService(!booking.isDecorationService());
            if(booking.isPhotographyService())
            {
                System.out.println("Enter the photography cost: ");
                float photographyCost;
                while (true)
                {
                    try{
                        photographyCost = sc.nextFloat();
                        break;
                    }catch(java.util.InputMismatchException e){
                        sc.nextLine();
                        System.out.println("Photography cost must be a number!");
                        System.out.println("Please re-enter photography cost:");
                        continue;
                    }
                }
                booking.setPhotographyCost(photographyCost);
                booking.setTotalAmount(booking.getTotalAmount() +
                                       booking.getPhotographyCost());
                sc.nextLine();
            }
            else
            {
                booking.setPhotographyCost(0);
            }
            booking.setPhotographyServiceUpdated(false);
        }

        if(booking.isDecorationServiceUpdated())
        {
            booking.setDecorationService(!booking.isDecorationService());
            if(booking.isDecorationService())
            {
                System.out.println("Enter the decoration cost: ");
                float decorationCost;
                while (true)
                {
                    try{
                        decorationCost = sc.nextFloat();
                        break;
                    }catch(java.util.InputMismatchException e){
                        sc.nextLine();
                        System.out.println("Decoration cost must be a number!");
                        System.out.println("Please re-enter decoration cost:");
                        continue;
                    }
                }
                sc.nextLine();
                booking.setDecorationCost(decorationCost);
                booking.setTotalAmount(booking.getTotalAmount() +
                                       booking.getDecorationCost());
            }
            else
            {
                booking.setDecorationCost(0);
            }
            booking.setDecorationServiceUpdated(false);
        }
        booking.setUpdated(false);
    }

    /**
     * This method is used to update booking which is reject.
     */
    public void rejectUpdate(Booking booking)
    {
        booking.setOccasionUpdated(false);
        booking.setUpdatedOccasion(null);
        booking.setGuestNumUpdated(false);
        booking.setUpdatedGuestNum(0);
        booking.setEventDateUpdated(false);
        booking.setUpdatedStartDate(null);
        booking.setUpdatedEndDate(null);
        booking.setCateringServiceUpdated(false);
        booking.setPhotographyServiceUpdated(false);
        booking.setDecorationServiceUpdated(false);
        booking.setUpdated(false);
    }

    /**
     * This method helps in user to logout.
     */
    public void logout()
    {
        Homepage hp = new Homepage();
        hp.displayHomepage();
    }

    /**
     * This method gets the owner object.
     */
    public Owner getOwner()
    {
        return this.owner;
    }

    /**
     * This method sets the owner object.
     */
    public void setOwner(Owner owner)
    {
        this.owner = owner;
    }
}
