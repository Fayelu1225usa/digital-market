/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.OrderManagement;

import java.util.ArrayList;
import java.util.Date;
import salesmodel.CustomerManagement.CustomerProfile;
import salesmodel.ProductManagement.Product;
import salesmodel.ProductManagement.SolutionBundleAssignment;

/**
 *
 * @author kal bugrara
 */
public class Order {

    ArrayList<OrderItem> orderitems;
    CustomerProfile customer;
    Date date;
    String status;
    SolutionBundleAssignment bundle;

    public Order(CustomerProfile cp, SolutionBundleAssignment bundle) {
        orderitems = new ArrayList<OrderItem>();
        this.bundle = bundle;
        customer = cp;
        date = new Date(); 
        status = "pending";
    }

    public OrderItem newOrderItem(Product p, int q) {
        OrderItem oi = new OrderItem(p, q);
        orderitems.add(oi);
        return oi;
    }

    public int getOrderTotal() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();
        }
        return sum;
    }

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance() * oi.quantity; // positive and negative values
        }
        return sum;
    }

    public int getNumberOfOrderItemsAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public String getOrderDate() {
        return this.date.toString();
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public String getStatus() {
        return this.status;
    }

    public SolutionBundleAssignment getBundleAssignment() {
        return this.bundle;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return this.orderitems;
    }

    public CustomerProfile getCustomer() {
        return this.customer;
    }
}
