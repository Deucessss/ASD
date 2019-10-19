
/**
 * Write a description of class AdminController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AdminController
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class AdminController
     */
    public AdminController()
    {
        // initialise instance variable
    }

    /**
     This helps admin to logout
     */
    public void logout()
    {
        Homepage hp = new Homepage();
        hp.displayHomepage();
    }
}
