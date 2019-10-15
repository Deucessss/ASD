
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Customer extends User
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Customer
     */
    private String concession;
    
    private String answer1;
    private String answer2;
    private String answer3;
    private ArrayList<Quotation> quotations = new ArrayList<Quotation>();
    private ArrayList<Booking> bookings = new ArrayList<Booking>();
    private ArrayList<Booking> pastBookings = new ArrayList<Booking>();
    // private ArrayList<Bookings> customerBookings = new ArrayList<Bookings>();
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String firstName, String lastName, String email, String password,
                    String contact, String address, String concession,
                    String answer1, String answer2, String answer3)
    {
        // initialise instance variables
        super(firstName, lastName, email, password, contact, address);
        this.concession = concession;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }
    
    public ArrayList<Booking> getBookings()
    {
        return this.bookings;
    }
    
    public ArrayList<Booking>getPastBookings()
    {
        return this.pastBookings;
    }
     
    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }
    
    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }
    
    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }
    
    public ArrayList<Quotation> getQuotations()
    {
        return this.quotations;
    }
    // public ArrayList<Bookings> getBookings() {
        // return customerBookings;
    // }

    // public void setHall(ArrayList<Bookings> customerBookings) {
        // this.customerBookings = customerBookings;
    // }
}
