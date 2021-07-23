package ui;

import javax.swing.JFrame;
import ui.customerRole.BundleDetailScene;
import ui.customerRole.CustomerAccountScene;
import ui.customerRole.CustomerCartScene;
import ui.customerRole.CustomerDashboard;
import ui.customerRole.OrderHistoryScene;
import ui.marketingRole.CreateOfferScene;
import ui.marketingRole.MarketingDashboard;
import ui.marketingRole.ViewOrderQuestScene;
import ui.marketingRole.ViewProductScene;

public class UiControl {

    public static void boot(JFrame jf, UserLoginJPanel loginUI) {
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(680, 400);
        jf.add(loginUI);
        jf.setVisible(true);
    }

    public static void login(JFrame jf, MarketingDashboard dashboard) {
        jf.getContentPane().removeAll();
        jf.add(dashboard); 
        jf.setSize(682, 690);
    }
    
    public static void login(JFrame jf, CustomerDashboard dashboard) {
        jf.getContentPane().removeAll();
        jf.add(dashboard); 
        jf.setSize(682, 690);
    }

    public static void logout(JFrame jf, UserLoginJPanel loginUI) {
        jf.getContentPane().removeAll();
        jf.setSize(682, 400);
        jf.add(loginUI);
    }

    public static void OrderRequest(JFrame jf, ViewOrderQuestScene requests) { 
        jf.add(requests);
        jf.setSize(682, 690);
        
    }
    
    public static void dashboard(JFrame jf, MarketingDashboard dashboard){
        jf.add(dashboard); 
        jf.setSize(682, 690);
    }
    
    public static void dashboard(JFrame jf, CustomerDashboard dashboard){
        jf.add(dashboard); 
        jf.setSize(682, 690);
    }

    public static void viewProducts() {

    }

    public static void createOffer(JFrame jf, CreateOfferScene offer) {
        jf.add(offer); 
        jf.setSize(682, 690);
    }
    
    public static void viewBundleDeatail(JFrame jf, BundleDetailScene bs) {
        jf.add(bs); 
        jf.setSize(682, 690);
    }

    public static void viewCustomerOrder(JFrame jf, OrderHistoryScene order) {
        jf.add(order); 
        jf.setSize(682, 690);
    }

    public static void viewCustomerCart(JFrame jf, CustomerCartScene cart) {
        jf.add(cart); 
        jf.setSize(682, 690);//To change body of generated methods, choose Tools | Templates.
    }

    public static void viewAccount(JFrame jf, CustomerAccountScene account) {
        jf.add(account); 
        jf.setSize(682, 690);//To change body of generated methods, choose Tools | Templates.
    }

    public static void viewProduct(JFrame jf, ViewProductScene prod) {
        jf.add(prod); 
        jf.setSize(682, 690);//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

}
