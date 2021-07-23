/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.OrderManagement;

import salesmodel.ProductManagement.Product;

/**
 *
 * @author kal bugrara
 */
public class OrderItem {

    Product selectedproduct;
    int actualPrice;
    int quantity;

    public OrderItem(Product p, int q) {
        selectedproduct = p;
        p.addOrderItem(this); // make sure product links back to the item
        quantity = q;
        this.actualPrice = 0;
    }

    public void setactualPrice(int p) {
        this.actualPrice = p;
    }

    public int getOrderItemTotal() {
        return actualPrice * quantity;
    }

    // returns positive if seller is making higher margin than target
    // returns negative if seller is making lower margin than target
    // otherwise zero meaning neutral
    public int calculatePricePerformance() {
        return actualPrice - selectedproduct.getTargetPrice();
    }

    public boolean isActualAboveTarget() {
        if (actualPrice > selectedproduct.getTargetPrice()) {
            return true;
        } else {
            return false;
        }

    }

    public Product getProduct() {
        return this.selectedproduct;
    }
    
    public int getQuantity(){
        return this.quantity;
    }

}
