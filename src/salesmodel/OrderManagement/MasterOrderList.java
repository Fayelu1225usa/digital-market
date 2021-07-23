/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.OrderManagement;
import salesmodel.Business.Business;
import java.util.ArrayList; 
/**
 *
 * @author kal bugrara
 */
public class MasterOrderList {
     
    Business d;
    ArrayList<Order> orders;
    public MasterOrderList(Business business){ 
        this.orders = new ArrayList<Order>();
        this.d = business;
    }
    
    public void addOrder(Order order){
        this.orders.add(order);
    }
    
    public ArrayList<Order> getOrders(){
    	return this.orders;
    }
    
    
}
