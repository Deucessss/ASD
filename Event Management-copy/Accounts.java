import java.util.*;
public class Accounts
{
    // instance variables - replace the example below with your own
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    private static ArrayList<Owner> owners = new ArrayList<Owner>();
    private static Admin admin = new Admin();
    /**
     * Constructor for objects of class Accounts
     */
    public Accounts()
    {
        // initialise instance variables
    }

    public static void initialiseAccounts()
    {
        String firstName = "a";
        String lastName = "a";
        String email1 = "qwe@qwe.com";
        String email2 = "asd@asd.com";
        String email3 = "zxc@zxc.com";
        String password = "qweqwe";
        String contact = "1234567890";
        String address1 = "1 Victoria Street Melbourne VIC 3000";
        String address2 = "2 Victoria Street Melbourne VIC 3000";
        String address3 = "3 Victoria Street Melbourne VIC 3000";
        String address4 = "4 Victoria Street Melbourne VIC 3000";
        String address5 = "5 Victoria Street Melbourne VIC 3000";
        String address6 = "6 Victoria Street Melbourne VIC 3000";
        String address7 = "7 Victoria Street Melbourne VIC 3000";
        String address8 = "8 Victoria Street Melbourne VIC 3000";
        String address9 = "9 Victoria Street Melbourne VIC 3000";
        String address10 = "10 Victoria Street, Melbourne VIC 3000";
        String concession = "none";
        String answer = "a";


        Customer customer = new Customer(firstName,lastName,email1,password,
                                         contact,address1,concession,answer,answer);
        customers.add(customer);
        Owner owner1 = new Owner(firstName,lastName,email1,password,contact,
                                 address1);
        Owner owner2 = new Owner(firstName,lastName,email2,password,contact,
                                 address1);
        Owner owner3 = new Owner(firstName,lastName,email3,password,contact,
                                address1);
        Hall hall1 = new Hall("Hall1",address1,contact,"hall1",10,true,true,true,
                             100,120);
        Hall hall2 = new Hall("Hall2",address2,contact,"hall2",10,true,true,true,
                              100,120);
        Hall hall3 = new Hall("Hall3",address3,contact,"hall3",10,true,true,true,
                              100,120);
        Hall hall4 = new Hall("Hall4",address4,contact,"hall4",10,true,true,true,
                              100,120);
        Hall hall5 = new Hall("Hall5",address5,contact,"hall5",10,true,true,true,
                              100,120);
        Hall hall6 = new Hall("Hall6",address6,contact,"hall6",10,true,true,true,
                              100,120);
        Hall hall7 = new Hall("Hall7",address7,contact,"hall7",10,true,true,true,
                              100,120);
        Hall hall8 = new Hall("Hall8",address8,contact,"hall8",10,true,true,true,
                              100,120);
        Hall hall9 = new Hall("Hall9",address9,contact,"hall9",10,true,true,true,
                               100,120);
        Hall hall10 = new Hall("Hall10",address10,contact,"hall10",10,true,true,true,
                               100,120);
        owner1.getHalls().add(hall1);
        hall1.setId(1);
        owner1.getHalls().add(hall2);
        hall2.setId(2);
        owner1.getHalls().add(hall3);
        hall3.setId(3);

        owner2.getHalls().add(hall4);
        hall4.setId(1);
        owner2.getHalls().add(hall5);
        hall5.setId(2);
        owner2.getHalls().add(hall6);
        hall6.setId(3);
        owner3.getHalls().add(hall7);
        hall7.setId(1);
        owner3.getHalls().add(hall8);
        hall8.setId(2);
        owner3.getHalls().add(hall9);
        hall9.setId(3);
        owner3.getHalls().add(hall10);
        hall10.setId(4);

        owners.add(owner1);
        owners.add(owner2);
        owners.add(owner3);

        Booking booking = new Booking("asd",2,true,20,true,20,true,20,20,new Date(),new Date(),hall1,customer);
        customer.getPastBookings().add(booking);
        hall1.getPastBookings().add(booking);
    }

    public static ArrayList<Customer> getCustomers()
    {
        return customers;
    }

    public static void addCustomer(Customer customer)
    {
        customers.add(customer);
    }

    public static ArrayList<Owner> getOwners()
    {
        return owners;
    }

    public static void addOwner(Owner owner)
    {
        owners.add(owner);
    }

    public static Admin getAdmin()
    {
        return admin;
    }

    public static Hall searchHall(String hallName)
    {
        for (Owner owner : owners)
        {
            for (Hall hall : owner.getHalls())
            {
                if (hall.getName().equalsIgnoreCase(hallName))
                {
                    return hall;
                }
            }
        }
        return null;
    }

    public static void viewHalls()
    {
        int count = 0;
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-40s | %-14s | %-9s | %-11s | %-11s | %-6s |\n", "Hall Name","Hall Address",
                          "Contact Number", "Catering", "Photography", "Decoration", "Rating");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < owners.size(); i++)
        {
            for (int j = 0; j< owners.get(i).getHalls().size(); j++)
            {
                String hallName = owners.get(i).getHalls().get(j).getName();
                String hallAddress = owners.get(i).getHalls().get(j).getAddress();
                String contactNum = owners.get(i).getHalls().get(j).getContact();
                String catering = (owners.get(i).getHalls().get(j).getCateringService() ? "yes" : "no");
                String photography = (owners.get(i).getHalls().get(j).getPhotographyService() ? "yes" : "no");
                String decoration = (owners.get(i).getHalls().get(j).getDecorationService() ? "yes" : "no");
                float averageRating = (owners.get(i).getHalls().get(j).getAverageRating());
                System.out.format("| %-10s | %-40s | %-14s | %-9s | %-11s | %-11s | %-6.2f |\n", hallName, hallAddress,
                                    contactNum, catering, photography, decoration, averageRating);
                System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                count++;
            }
        }

        if (count == 0)
        {
            System.out.println("Sorry, there is not hall yet!");
        }
    }


}
