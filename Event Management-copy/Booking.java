
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
    private int idOwner;
    private int idCust;

    private String occasion;
    private String updatedOccasion;
    private boolean occasionUpdated = false;

    private int guestNum;
    private int updatedGuestNum;
    private boolean guestNumUpdated = false;

    private boolean cateringService;
    private boolean cateringServiceUpdated = false;

    private boolean photographyService;
    private boolean photographyServiceUpdated = false;

    private boolean decorationService;
    private boolean decorationServiceUpdated = false;

    private Date startDate;
    private Date updatedStartDate;
    private Date endDate;
    private Date updatedEndDate;
    private boolean eventDateUpdated = false;

    private float cateringCost;
    private float photographyCost;
    private float decorationCost;
    private float venueCost;
    private float totalAmount;

    private boolean updated = false;
    private boolean completed = false;
    private boolean rated = false;
    private Rating rating;

    private Hall hall;
    private Customer customer;
    /**
     * Constructor for objects of class Booking
     */
    public Booking(String occasion, int guestNum, boolean cateringService, float cateringCost,
                     boolean photographyService, float photographyCost, boolean decorationService,
                     float decorationCost, float venueCost, Date startDate, Date endDate, Hall hall,
                     Customer customer)
    {
        this.occasion = occasion;
        this.guestNum = guestNum;
        this.cateringService = cateringService;
        this.cateringCost = cateringCost;
        this.photographyService = photographyService;
        this.photographyCost = photographyCost;
        this.decorationService = decorationService;
        this.decorationCost = decorationCost;
        this.venueCost = venueCost;
        this.totalAmount = cateringCost + photographyCost + decorationCost + venueCost;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hall = hall;
        this.idOwner = hall.getBookings().size() + 1;
        this.idCust = customer.getBookings().size() + 1;
        this.rating = new Rating();
    }

    public Rating getRating()
    {
        return this.rating;
    }

    public boolean isRated()
    {
        return this.rated;
    }

    public void setRated(boolean rated)
    {
        this.rated = rated;
    }


    public int getIdOwner() {
        return this.idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public int getIdCust() {
        return this.idCust;
    }

    public void setIdCust(int idCust) {
        this.idCust = idCust;
    }

    public String getOccasion() {
        return this.occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getUpdatedOccasion() {
        return this.updatedOccasion;
    }

    public void setUpdatedOccasion(String updatedOccasion) {
        this.updatedOccasion = updatedOccasion;
    }

    public boolean isOccasionUpdated() {
        return this.occasionUpdated;
    }

    public void setOccasionUpdated(boolean occasionUpdated) {
        this.occasionUpdated = occasionUpdated;
    }

    public int getGuestNum() {
        return this.guestNum;
    }

    public void setGuestNum(int guestNum) {
        this.guestNum = guestNum;
    }

    public int getUpdatedGuestNum() {
        return this.updatedGuestNum;
    }

    public void setUpdatedGuestNum(int updatedGuestNum) {
        this.updatedGuestNum = updatedGuestNum;
    }

    public boolean isGuestNumUpdated() {
        return this.guestNumUpdated;
    }

    public void setGuestNumUpdated(boolean guestNumUpdated) {
        this.guestNumUpdated = guestNumUpdated;
    }

    public boolean isCateringService() {
        return this.cateringService;
    }

    public void setCateringService(boolean cateringService) {
        this.cateringService = cateringService;
    }

    public boolean isCateringServiceUpdated() {
        return this.cateringServiceUpdated;
    }

    public void setCateringServiceUpdated(boolean cateringServiceUpdated) {
        this.cateringServiceUpdated = cateringServiceUpdated;
    }

    public boolean isPhotographyService() {
        return this.photographyService;
    }

    public void setPhotographyService(boolean photographyService) {
        this.photographyService = photographyService;
    }

    public boolean isPhotographyServiceUpdated() {
        return this.photographyServiceUpdated;
    }

    public void setPhotographyServiceUpdated(boolean photographyServiceUpdated) {
        this.photographyServiceUpdated = photographyServiceUpdated;
    }

    public boolean isDecorationService() {
        return this.decorationService;
    }

    public void setDecorationService(boolean decorationService) {
        this.decorationService = decorationService;
    }

    public boolean isDecorationServiceUpdated() {
        return this.decorationServiceUpdated;
    }

    public void setDecorationServiceUpdated(boolean decorationServiceUpdated) {
        this.decorationServiceUpdated = decorationServiceUpdated;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getUpdatedStartDate() {
        return this.updatedStartDate;
    }

    public void setUpdatedStartDate(Date updatedStartDate) {
        this.updatedStartDate = updatedStartDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getUpdatedEndDate() {
        return this.updatedEndDate;
    }

    public void setUpdatedEndDate(Date updatedEndDate) {
        this.updatedEndDate = updatedEndDate;
    }

    public boolean isEventDateUpdated() {
        return this.eventDateUpdated;
    }

    public void setEventDateUpdated(boolean eventDateUpdated) {
        this.eventDateUpdated = eventDateUpdated;
    }

    public float getCateringCost() {
        return this.cateringCost;
    }

    public void setCateringCost(float cateringCost) {
        this.cateringCost = cateringCost;
    }

    public float getPhotographyCost() {
        return this.photographyCost;
    }

    public void setPhotographyCost(float photographyCost) {
        this.photographyCost = photographyCost;
    }

    public float getDecorationCost() {
        return this.decorationCost;
    }

    public void setDecorationCost(float decorationCost) {
        this.decorationCost = decorationCost;
    }

    public float getVenueCost() {
        return this.venueCost;
    }

    public void setVenueCost(float venueCost) {
        this.venueCost = venueCost;
    }

    public float getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isUpdated() {
        return this.updated;
    }

    public void setUpdated(boolean updated) {
        this.updated = updated;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Hall getHall() {
        return this.hall;
    }


    public Customer getCustomer() {
        return this.customer;
    }

}
