
/**
 * Write a description of class Hall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Hall
{
    // instance variables - replace the example below with your own
    private String name;
    private String address;
    private String contact;
    private String description;
    private int id;
    private boolean availability;
    private float hallDiscount;
    private boolean cateringService;
    private boolean decorationService;
    private boolean photographyService;
    private float price;
    private int hallCapacity;
    private int hallRating;
    private ArrayList<Quotation> quotations = new ArrayList<Quotation>();
    private ArrayList<Quotation> pastQuotations = new ArrayList<Quotation>();
    // private OwnerDiscount ownerDiscount;
    // private AdminDiscount adminDiscount;

    /**
     * Constructor for objects of class Hall
     */
    public Hall(String name, String address, String contact, String description, boolean availability,
                float hallDiscount,boolean cateringService,boolean decorationService,
                boolean photographyService,float price, int hallCapacity)
    {
        // initialise instance variables
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.description = description.replaceAll("(.{50})", String.format("$1|\n|%22s|  ", ""));
        this.availability = availability;
        this.hallDiscount = hallDiscount;
        this.cateringService = cateringService;
        this.decorationService = decorationService;
        this.photographyService = photographyService;
        this.price =price;
        this.hallCapacity = hallCapacity;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String newName)
    {
        this.name = newName;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    public void setAddress(String newAddress)
    {
        this.address = newAddress;
    }
    
    public boolean getAvailabity()
    {
        return this.availability;
    }
    
    public void setAvailability(boolean availability)
    {
        this.availability = availability;
    }
    
    public String getContact()
    {
        return this.contact;
    }
    
    public void setContact(String newContact)
    {
        this.contact = newContact;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public void setDescription(String newDescription)
    {
        this.description = newDescription;
    }
    
    public float getHallDiscount()
    {
        return this.hallDiscount;
    }
    
    public void setHallDiscount(float hallDiscount)
    {
        this.hallDiscount = hallDiscount;
    }
    
    public boolean getPhotographyService()
    {
        return this.photographyService;
    }
    
    public void setPhotographyService(boolean photographyService)
    {
        this.photographyService = photographyService;
    }
    
    public boolean getCateringService()
    {
        return this.cateringService;
    }
    
    public void setCateringService(boolean cateringService)
    {
        this.cateringService = cateringService;
    }
    
    public boolean getDecorationService()
    {
        return this.decorationService;
    }
    
    public void setDecorationService(boolean decorationService)
    {
        this.decorationService = decorationService;
    }
    
    public int getHallRating() {
        return hallRating;
    }

    public void setHallRating(int hallRating) {
        this.hallRating = hallRating;
    }
    
    public int getHallCapacity()
    {
        return hallCapacity;
    }
    
    public void setHallCapacity(int hallCapacity)
    {
        this.hallCapacity = hallCapacity;
    }
    
    public float getPrice()
    {
        return this.price;
    }
    
    public void setPrice(float price)
    {
        this.price = price;
    }
    
    public ArrayList<Quotation> getQuotations()
    {
        return this.quotations;
    }
    
    public ArrayList<Quotation> getPastQuotations()
    {
        return this.pastQuotations;
    }
}
