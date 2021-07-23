package salesmodel.OrderManagement;

import salesmodel.ProductManagement.SolutionBundleAssignment;
import salesmodel.ProductManagement.SolutionOffer;
import java.util.HashMap;
import salesmodel.CustomerManagement.CustomerProfile;
import salesmodel.ProductManagement.Product;
import salesmodel.ProductManagement.SolutionItem;

public class OrderBundle {

    SolutionBundleAssignment sa; 
    CustomerProfile customer;

    public OrderBundle(SolutionBundleAssignment sa, CustomerProfile customer) {
        this.sa = sa;
        this.customer = customer;
    }

    public Order createOrder() {
        Order order = new Order(customer, this.sa);
        for (SolutionOffer offer : this.sa.getBundle().getOffers()) {
            for (SolutionItem item : offer.getProducts()) {
                order.newOrderItem(item.getProduct(), item.getQuantity()).setactualPrice(item.getActualPrice());
            }
        }

        return order;
    }

    public void addToCart() {
        this.customer.getAccount().getCart().addOrderBundle(this);
    }
    
    public SolutionBundleAssignment getAssigment(){
        return this.sa;
    } 
}
