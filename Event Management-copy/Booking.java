
/**
 * Write a description of class Booking here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Booking
{
    // instance variables - replace the example below with your own
    private int id;
    private String occasion;
    private int guestNum;
    private boolean cateringService;
    private boolean photographyService;
    private boolean decorationService;
    private Date startDate;
    private Date endDate;
    private float cateringCost;
    private float photographyCost;
    private float decorationCost;
    private float venueCost;
    private float totalAmount;
    private boolean updated = false;
    private boolean completed = false;
    private Hall hall;
    /**
     * Constructor for objects of class Booking
     */
    public Booking(String occasion, int guestNum, boolean cateringSerivce,
                     boolean photographyService, boolean decorationService,
                     Date startDate, Date endDate, float budget, Hall hall)
    {
        this.occasion = occasion;
        this.guestNum = guestNum;
        this.cateringService = cateringService;
        this.photographyService = photographyService;
        this.decorationService = decorationService;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hall = hall;
    }
    
    public int getId()
    {
        return this.id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
    public String getOccasion()
    {
        return this.occasion;
    }
    
    public void setOccasion(String occasion)
    {
        this.occasion = occasion;
    }
    
    public int getGuestNum()
    {
        return this.guestNum;
    }
    
    public void setGuestNum(int guestNum)
    {
        this.guestNum = guestNum;
    }
    
    public boolean getCateringService()
    {
        return this.cateringService;
    }
    
    public void setCateringService(boolean cateringService)
    {
        this.cateringService = cateringService;
    }
    
    public boolean getPhotographyService()
    {
        return this.photographyService;
    }
    
    public void setPhotographyService(boolean photographyService)
    {
        this.photographyService = photographyService;
    }
    
    public boolean getDecorationService()
    {
        return this.decorationService;
    }
    
    public void setDecorationService(boolean decorationService)
    {
        this.decorationService = decorationService;
    }
    
    public Date getStartDate()
    {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    
    public Date getEndDate()
    {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
    
    public float getCateringCost()
    {
        return this.cateringCost;
    }
    
    public void setCateringCost(float cateringCost)
    {
        this.cateringCost = cateringCost;
    }
    
    public float getPhotographyCost()
    {
        return this.photographyCost;
    }
    
    public void setPhotographyCost(float photographyCost)
    {
        this.photographyCost = photographyCost;
    }
    
    public float getDecorationCost()
    {
        return this.decorationCost;
    }
    
    public void setDecorationCost(float decorationCost)
    {
        this.decorationCost = decorationCost;
    }
    
    public float getVenueCost()
    {
        return this.venueCost;
    }
    
    public void setVenueCost(float venueCost)
    {
        this.venueCost = venueCost;
    }
    
    public float getTotalAmount()
    {
        return this.totalAmount;
    }
    
    public void setTotalAmount(float totalAmount)
    {
        this.totalAmount = totalAmount;
    }
    
    public Hall getHall()
    {
        return this.hall;
    }
    
    public Boolean getUpdated()
    {
        return this.updated;
    }
    
     
    
}
