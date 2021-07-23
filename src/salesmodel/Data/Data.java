package salesmodel.Data;

import java.util.ArrayList;
import java.util.Arrays;

import salesmodel.Business.Business;
import salesmodel.MarketModel.Channel;
import salesmodel.MarketModel.Market;
import salesmodel.MarketModel.MarketChannelAssignment;
import salesmodel.OrderManagement.OrderBundle;
import salesmodel.Personnel.EmployeeDirectory;
import salesmodel.Personnel.PersonDirectory;
import salesmodel.ProductManagement.SolutionBundle;
import salesmodel.ProductManagement.SolutionBundleAssignment;
import salesmodel.ProductManagement.SolutionOffer;
import userbusiness.Account;
import userbusiness.AccountDirectory;
import userbusiness.UserLogin;

public class Data {

    private PersonDirectory persons;
    private EmployeeDirectory employees;
    private Business b;
    private AccountDirectory accounts;
    private UserLogin login;

    public Data() {
        this.persons = null;
        this.b = null;
        this.accounts = null;
        this.login = null;
    }

    public void loadData() {
        
        //create bussiness
        this.persons = new PersonDirectory();
        this.b = new Business("education");
        this.accounts = new AccountDirectory();
        
        //create Supplier dummy data
        this.b.sd.newSupplier(persons.newPerson("S-001"), "book");
        this.b.sd.newSupplier(persons.newPerson("S-002"), "software");

        //create Products dummy data
        this.b.sd.findSupplier("S-001").pc.newProduct("book-001", "Java", 20, 35, 30);
        this.b.sd.findSupplier("S-001").pc.newProduct("book-002", "Python", 15, 25, 20);
        this.b.sd.findSupplier("S-002").pc.newProduct("software-001", "Office", 99, 120, 100);
        this.b.sd.findSupplier("S-002").pc.newProduct("software-002", "Photoshop", 50, 80, 65);
        
        //create Market List
        this.b.addMarket(new Market("Student")).addCharacter("Adult");
        this.b.addMarket(new Market("Teacher"));
        this.b.addMarket(new Market("Student"));

        //create Channel List
        this.b.addChannel(new Channel("TV"));
        this.b.addChannel(new Channel("Facebook"));
        this.b.addChannel(new Channel("Youtube"));

        //create MarketChannelAssignment
        this.b.market_list.findMostMatchMarket(new ArrayList<String>(Arrays.asList("Student")))
                .addChannel(this.b.channel_list.findChannel("TV"));
        this.b.market_list.findMostMatchMarket(new ArrayList<String>(Arrays.asList("Student")))
                .addChannel(this.b.channel_list.findChannel("Facebook"));
        this.b.market_list.findMostMatchMarket(new ArrayList<String>(Arrays.asList("Teacher")))
                .addChannel(this.b.channel_list.findChannel("TV"));
        this.b.market_list.findMostMatchMarket(new ArrayList<String>(Arrays.asList("Teacher")))
                .addChannel(this.b.channel_list.findChannel("Youtube"));
        
        //create ads for channels
        this.b.market_list.findMostMatchMarket(new ArrayList<String>(Arrays.asList("Student")))
                .findAssignment(this.b.channel_list.findChannel("TV"))
                .setAds("Hello Student, We have special offers for you.");
        this.b.market_list.findMostMatchMarket(new ArrayList<String>(Arrays.asList("Teacher")))
                .findAssignment(this.b.channel_list.findChannel("TV"))
                .setAds("Hello Teacher, We have special offers for you."); 

        //create Customer dummy data
        this.b.cd.newCustomerProfile(persons.newPerson("C-001"));
        this.b.cd.findCustomer("C-001").setName("Kevin");
        this.b.cd.findCustomer("C-001").addCharacter("Student");
        this.b.cd.findCustomer("C-001").getCredentials().setUser("kevin@gmail.com");
        this.b.cd.findCustomer("C-001").getCredentials().setPassword(456);
        this.b.cd.findCustomer("C-001").getCredentials().setRole("customer");
        accounts.addAccount(this.b.cd.findCustomer("C-001").getCredentials());

        this.b.cd.newCustomerProfile(persons.newPerson("C-002"));
        this.b.cd.findCustomer("C-002").addCharacter("Student");
        this.b.cd.findCustomer("C-002").getCredentials().setUser("Customer User02");
        this.b.cd.findCustomer("C-002").getCredentials().setPassword(123);
        this.b.cd.findCustomer("C-002").getCredentials().setRole("customer");
        accounts.addAccount(this.b.cd.findCustomer("C-002").getCredentials());

        this.b.cd.newCustomerProfile(persons.newPerson("C-003"));
        this.b.cd.findCustomer("C-003").setName("Ryan");
        this.b.cd.findCustomer("C-003").addCharacter("Teacher");
        this.b.cd.findCustomer("C-003").getCredentials().setUser("ryan@yahoo.com");
        this.b.cd.findCustomer("C-003").getCredentials().setPassword(789);
        this.b.cd.findCustomer("C-003").getCredentials().setRole("customer");
        accounts.addAccount(this.b.cd.findCustomer("C-003").getCredentials()); 
        
        
         //create Employee dummy data
        this.employees = new EmployeeDirectory(this.b);
        this.employees.newEmployeeProfile(persons.newPerson("E-001"));
        this.employees.findEmployee("E-001").setName("Faye");
        this.employees.findEmployee("E-001").getCredentials().setUser("faye@sales.com");
        this.employees.findEmployee("E-001").getCredentials().setPassword(456);
        this.employees.findEmployee("E-001").getCredentials().setRole("sales");
        accounts.addAccount(this.employees.findEmployee("E-001").getCredentials());

        this.employees.newEmployeeProfile(persons.newPerson("E-002"));
        this.employees.findEmployee("E-002").setName("Jeff");
        this.employees.findEmployee("E-002").getCredentials().setUser("jeff@sales.com");
        this.employees.findEmployee("E-002").getCredentials().setPassword(123);
        this.employees.findEmployee("E-002").getCredentials().setRole("sales");
        accounts.addAccount(this.employees.findEmployee("E-002").getCredentials());

        this.employees.newEmployeeProfile(persons.newPerson("E-003"));
        this.employees.findEmployee("E-003").setName("Tony");
        this.employees.findEmployee("E-003").getCredentials().setUser("tony@sales.com");
        this.employees.findEmployee("E-003").getCredentials().setPassword(789);
        this.employees.findEmployee("E-003").getCredentials().setRole("sales");
        accounts.addAccount(this.employees.findEmployee("E-003").getCredentials());

        

        //create solution bundle assignment
        MarketChannelAssignment ma = this.b.market_list.findMostMatchMarket(new ArrayList<String>(Arrays.asList("Student")))
                .findAssignment(this.b.channel_list.findChannel("TV"));
        SolutionOffer s_offer = new SolutionOffer(ma.getMarket());
        s_offer.addProduct(this.b.sd.findSupplier("S-001").pc.findProduct("book-001"),32,2); 
        SolutionBundle s_bundle = new SolutionBundle(this.employees.findEmployee("E-001"));
        s_bundle.addOffer(s_offer);
        s_bundle.setAds("Hello Student, We have special offers for you.");
        this.b.sc.addSolutionBundle(s_bundle);
        SolutionBundleAssignment sa = new SolutionBundleAssignment(ma, s_bundle); 
        this.b.addBundleAssigment(sa);
        
        //Enable the ordering of solution bundles by customers
        this.getBusiness().order_list.addOrder(new OrderBundle(sa, this.b.cd.findCustomer("C-001")).createOrder());
        
        //create additional dummy order, add ads/descption to each offer
        ma = this.b.market_list.findMostMatchMarket(new ArrayList<String>(Arrays.asList("Teacher")))
                .findAssignment(this.b.channel_list.findChannel("TV"));
        s_offer = new SolutionOffer(ma.getMarket());
        s_offer.addProduct(this.b.sd.findSupplier("S-001").pc.findProduct("book-002"),22,5); 
        s_bundle = new SolutionBundle(this.employees.findEmployee("E-002"));
        s_bundle.addOffer(s_offer);
        s_bundle.setAds("Hello Teacher, We have special offers for you.");
        this.b.sc.addSolutionBundle(s_bundle);
        sa = new SolutionBundleAssignment(ma, s_bundle);
        this.getBusiness().order_list.addOrder(new OrderBundle(sa, this.b.cd.findCustomer("C-003")).createOrder());
        this.b.addBundleAssigment(sa);
        
        ma = this.b.market_list.findMostMatchMarket(new ArrayList<String>(Arrays.asList("Student")))
                .findAssignment(this.b.channel_list.findChannel("TV"));
        s_offer = new SolutionOffer(ma.getMarket());
        s_offer.addProduct(this.b.sd.findSupplier("S-001").pc.findProduct("book-002"),25,2);
        s_offer.addProduct(this.b.sd.findSupplier("S-002").pc.findProduct("software-001"),110,2); 
        s_bundle = new SolutionBundle(this.employees.findEmployee("E-001"));
        s_bundle.addOffer(s_offer);
        s_bundle.setAds("Software Bundle!");
        this.b.sc.addSolutionBundle(s_bundle);
        sa = new SolutionBundleAssignment(ma, s_bundle);
        this.getBusiness().order_list.addOrder(new OrderBundle(sa, this.b.cd.findCustomer("C-001")).createOrder());
        this.b.addBundleAssigment(sa);
        
        //complete the order requests
        this.b.order_list.getOrders().get(0).setStatus("approved");
        this.b.order_list.getOrders().get(1).setStatus("approved");

        this.login = new UserLogin(accounts);
 
        System.out.println("# of bundle assignments: " + this.b.bundle_assignment.size());
    }

    public PersonDirectory getPersons() {
        return this.persons;
    }

    public EmployeeDirectory getEmployees() {
        return this.employees;
    }

    public Business getBusiness() {
        return this.b;
    }
//	public AccountDirectory  getAccounts() {
//		return this.accounts;
//	} 
}
