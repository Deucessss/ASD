
/**
 * Write a description of class Quotation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

public class Quotation
{
    // instance variables - replace the example below with your own
    private int idOwner;
    private int idCust;
    private String occasion;
    private int guestNum;
    private boolean cateringService;
    private boolean photographyService;
    private boolean decorationService;
    private Date startDate;
    private Date endDate;
    private float budget;
    private float cateringCost;
    private float photographyCost;
    private float decorationCost;
    private float venueCost;
    private float totalAmount;
    private float depositAmount;
    private boolean quotationAccepted = false;
    private boolean depositPaid = false;
    private boolean replied = false;
    private Customer customer;
    private Hall hall;
    

    /**
     * Constructor for objects of class Quotation
     */
    public Quotation(String occasion, int guestNum, boolean cateringService,
                     boolean photographyService, boolean decorationService,
                     Date startDate, Date endDate, float budget, Hall hall, Customer customer)
    {
        this.occasion = occasion;
        this.guestNum = guestNum;
        this.cateringService = cateringService;
        this.photographyService = photographyService;
        this.decorationService = decorationService;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.hall = hall;
        this.customer = customer;
        this.idOwner = hall.getQuotations().size() + 1;
        this.idCust = customer.getQuotations().size() + 1;
        
    }
    
    /**
     * The below methods are getters and setters oh the Quotation attributes
     */
    public Customer getCustomer()
    {
        return this.customer;
    }
    
    public float getDepositAmount()
    {
        return this.depositAmount;
    }
    public void setDepositAmount(float depositAmount)
    {
        this.depositAmount = depositAmount;
    }
    
    public boolean getDepositPaid()
    {
        return this.depositPaid;
    }
    
    public void setDepositPaid(boolean depositPaid)
    {
        this.depositPaid = depositPaid;
    }
    
    public int getIdOwner()
    {
        return this.idOwner;
    }
    
    public void setIdOwner(int idOwner)
    {
        this.idOwner = idOwner;
    }
    
    public int getIdCust()
    {
        return this.idCust;
    }
    
    public void setIdCust(int idCust)
    {
        this.idCust = idCust;
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
    
    public float getBudget()
    {
        return this.budget;
    }
    
    public void setBudget(float budget)
    {
        this.budget = budget;
    }
    
    public boolean getReplied()
    {
        return this.replied;
    }
    
    public void setReplied(boolean replied)
    {
        this.replied = replied;
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
    
    public boolean getQuotationAccepted()
    {
        return this.quotationAccepted;
    }
    
    public void setQuotationAccepted(boolean quotationAccepted)
    {
        this.quotationAccepted = quotationAccepted;
    }
    
    public Hall getHall()
    {
        return this.hall;
    }
    
    
}
