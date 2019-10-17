
/**
 * Write a description of class CustomerController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class CustomerController
{
    private Customer customer;// instance variables - replace the example below with your own
    /**
     * Constructor for objects of class CustomerController
     */
    public CustomerController()
    {
        // initialise instance variables

    }


    public Boolean checkDate(String hallName, Date date, int idCust)
    {

        if (date.before(new Date()))
        {
            return false;
        }
        else
        {
            // idCust is introduced to check dates when customer wants to
            // update their booking
            // Updating startDate or endDate for a booking does check date with
            // the booking itself.
            for (Booking booking : Accounts.searchHall(hallName).getBookings())
            {
                if ((date.compareTo(booking.getEndDate()) <= 0) &&
                    (date.compareTo(booking.getStartDate())>=0) &&
                    booking.getIdCust() != idCust)
                {
                    System.out.println("This hall is unavailable between " +
                                       CustomerInterface.formatter.format(booking.getStartDate()) +
                                       "-" +
                                       CustomerInterface.formatter.format(booking.getEndDate()));
                    return false;
                }
            }
        }
        return true;
    }

    public void requestQuotation(String hallName, String occasion, int guestNum, boolean cateringService,
                                 boolean photographyService, boolean decorationService,
                                 Date startDate, Date endDate, float budget)
    {
        Quotation quotation = new Quotation(occasion, guestNum, cateringService, photographyService,
                                            decorationService, startDate, endDate, budget,
                                            Accounts.searchHall(hallName), customer);
        Accounts.searchHall(hallName).getQuotations().add(quotation);
        customer.getQuotations().add(quotation);
    }

    public ArrayList<Boolean> serviceProvided(String hallName)
    {

        ArrayList<Boolean> services = new ArrayList<Boolean>();
        services.add(Accounts.searchHall(hallName).getCateringService());
        services.add(Accounts.searchHall(hallName).getPhotographyService());
        services.add(Accounts.searchHall(hallName).getDecorationService());
        return services;
    }

    public void viewAllHalls()
    {
        Accounts.viewHalls();
    }

    public boolean checkHallExist(String hallName)
    {
        if (Accounts.searchHall(hallName) != null)
        {
            return true;
        }
        return false;
    }

    public int countRepliedQuotations()
    {
        int count = 0;
        for (Quotation quotation : customer.getQuotations())
        {
            // Count the number of quotations that was replied by the owner and is not accepted by the customer
            if (quotation.getReplied() && !quotation.getQuotationAccepted())
            {
                count++;
            }
        }
        return count;
    }

    public void displayQuotations()
    {

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.format("%-35s%-19s%35s\n","|","Replied Quotations","|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.format("| %-13s | %-11s | %-13s | %-11s | %-11s | %-12s|\n",
                          "Quotation Id", "Occasion", "Guest Number", "Start Date", " End Date", "Accepted");
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Quotation quotation : customer.getQuotations())
        {
            if (quotation.getReplied())
            {
                System.out.format("| %-13d | %-11s | %-13d | %-11s | %-11s | %-12s|\n",
                                        quotation.getIdCust(), quotation.getOccasion(), quotation.getGuestNum(),
                                        CustomerInterface.formatter.format(quotation.getStartDate()),
                                        CustomerInterface.formatter.format(quotation.getEndDate()),
                                        ((quotation.getQuotationAccepted()) ? "Yes" : "No"));
                System.out.println("-----------------------------------------------------------------------------------------");
            }
        }

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.format("%-30s%-29s%30s\n", "|", "Quotations Waiting for Reply", "|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.format("| %-13s | %-11s | %-13s | %-11s | %-11s | %-12s|\n",
                          "Quotation Id", "Occasion", "Guest Number", "Start Date", " End Date", "Budget");
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Quotation quotation : customer.getQuotations())
        {
            if (!quotation.getReplied())
            {
                System.out.format("| %-13d | %-11s | %-13d | %-11s | %-11s | %-12.2f|\n",
                                        quotation.getIdCust(), quotation.getOccasion(), quotation.getGuestNum(),
                                        CustomerInterface.formatter.format(quotation.getStartDate()),
                                        CustomerInterface.formatter.format(quotation.getEndDate()),
                                        quotation.getBudget());
                System.out.println("-----------------------------------------------------------------------------------------");
            }
        }

    }


    public void displayRepliedQuotation(Quotation quotation)
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Id", quotation.getHall().getId());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Quotation Id", quotation.getIdCust());
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
        System.out.format("|  %-28s|  %-42.2f|\n", "Budget", quotation.getBudget());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Deposit", quotation.getDepositAmount());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Accepted",
                            ((quotation.getQuotationAccepted()) ? "yes" : "no"));
        System.out.println("-----------------------------------------------------------------------------");
    }

    public void displayUnrepliedQuotation(Quotation quotation)
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Id", quotation.getHall().getId());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Quotation Id", quotation.getIdCust());
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
        System.out.format("|  %-28s|  %-42s|\n", "Require Photography Service",
                            ((quotation.getPhotographyService()) ? "Required" : "Not Required"));
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Require Decoration Service",
                            ((quotation.getDecorationService()) ? "Required" : "Not Required")) ;
        System.out.format("|  %-28s|  %-42.2f|\n", "Budget", quotation.getBudget());
        System.out.println("-----------------------------------------------------------------------------");
    }

    public Quotation searchUnrepliedQuotation(int quotationId)
    {
        for (Quotation quotation : customer.getQuotations())
        {
            if (quotation.getIdCust() == quotationId && !quotation.getReplied())
            {
                return quotation;
            }
        }
        return null;
    }

    public Quotation searchAcceptableQuotation(int quotationId)
    {
        for (Quotation quotation : customer.getQuotations())
        {
            if (quotation.getIdCust() == quotationId &&
                !quotation.getQuotationAccepted() && quotation.getReplied())
            {
                return quotation;
            }
        }
        return null;
    }

    public void acceptQuotation(Quotation quotation)
    {
        quotation.setQuotationAccepted(true);
    }

    public void displayBookings()
    {

        if (customer.getBookings().size() > 0)
        {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Active Booking");
            System.out.println("-----------------------------------------------------------------------------");
            for (Booking booking : customer.getBookings())
            {
                displayBooking(booking);
            }
        }
        else
        {
            System.out.println("You have no active booking yet");
        }

        if (customer.getPastBookings().size() > 0)
        {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Past Booking");
            System.out.println("-----------------------------------------------------------------------------");
            for (Booking booking : customer.getPastBookings())
            {
                displayBooking(booking);
            }
        }
        else
        {
            System.out.println("You have no past booking yet");
        }

    }

    public void displayBooking(Booking booking)
    {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Hall Id", booking.getHall().getId());
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("|  %-28s|  %-42s|\n", "Booking Id", booking.getIdCust());
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

        if (booking.isOccasionUpdated() || booking.isGuestNumUpdated() ||
            booking.isEventDateUpdated() || booking.isCateringServiceUpdated() ||
            booking.isPhotographyServiceUpdated()
            || booking.isDecorationServiceUpdated())
        {
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Update to the booking is waiting for reply from the owner");
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
    public void updateOccasion(int bookingId, String occasion)
    {
        getBookingByIdCust(bookingId).setOccasionUpdated(true);
        getBookingByIdCust(bookingId).setUpdatedOccasion(occasion);
    }
    public void updateGuestNumber(int bookingId, int guestNum)
    {
        getBookingByIdCust(bookingId).setGuestNumUpdated(true);
        getBookingByIdCust(bookingId).setUpdatedGuestNum(guestNum);
    }

    public void updateEventDate(int bookingId, Date startDate, Date endDate)
    {
        getBookingByIdCust(bookingId).setEventDateUpdated(true);
        getBookingByIdCust(bookingId).setUpdatedStartDate(startDate);
        getBookingByIdCust(bookingId).setUpdatedEndDate(endDate);
    }

    public void updateCateringService(int bookingId)
    {
        getBookingByIdCust(bookingId).setCateringServiceUpdated(true);
    }

    public void updatePhotographyService(int bookingId)
    {
        getBookingByIdCust(bookingId).setPhotographyServiceUpdated(true);

    }

    public void updateDecorationService(int bookingId)
    {

        getBookingByIdCust(bookingId).setDecorationServiceUpdated(true);

    }

    public Booking getBookingByIdCust(int idCust)
    {
        for (Booking booking : customer.getBookings())
        {
            if (booking.getIdCust() == idCust)
            {
                return booking;
            }
        }
        return null;
    }

    public void logout()
    {
        Homepage hp = new Homepage();
        hp.displayHomepage();
    }

    public Customer getCustomer()
    {
        return this.customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
