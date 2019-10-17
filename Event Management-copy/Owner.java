
/**
 * Write a description of class Owner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Owner extends User
{
    // instance variables - replace the example below with your own
    private ArrayList<Hall> halls = new ArrayList<Hall>();
    public static final String lineBreak = "*****************************************************************************************";
    /**
     * Constructor for objects of class Owner
     */
    public Owner(String firstName, String lastName, String email, String password,
                 String contact, String address)
    {
        // initialise instance variables
        super(firstName, lastName, email, password, contact, address);
    }
    
    public ArrayList<Hall> getHalls() {
        return this.halls;
    }

    public void setHall(ArrayList<Hall> halls) {
        this.halls = halls;
    }
}
