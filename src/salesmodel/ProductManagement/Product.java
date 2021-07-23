/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.ProductManagement;

import java.util.ArrayList;
import salesmodel.OrderManagement.OrderItem;
import salesmodel.SupplierManagement.Supplier;

/**
 *
 * @author kal bugrara
 */
public class Product {

    private int floorPrice;
    private int ceilingPrice;
    private int targetPrice;
    String id;
    String desc;
    ArrayList<OrderItem> orderitems;
    Supplier supplier;

    public Product(String id, String desc, int fp, int cp, int tp, Supplier supplier) {
        this.id = id;
        this.desc = desc;
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        orderitems = new ArrayList<OrderItem>();
        this.supplier = supplier;
    }

    public String getID() {
        return this.id;
    }

    public String getDesc() {
        return this.desc;
    }

    public Product updateProduct(int fp, int cp, int tp) {
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        return this; // returns itself
    }

    public int getTargetPrice() {
        return targetPrice;
    }

    public void addOrderItem(OrderItem oi) {
        orderitems.add(oi);
    }

    // revenues won or lost because of actual vs target difference
    public int getNumberOfProductSalesAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            if (oi.isActualAboveTarget() == true) {
                sum = sum + 1;
            }
        }
        return sum;
    }

    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance(); // positive and negative values
        }
        return sum;
    }

    public Supplier getSupplier() {
        return this.supplier;
    }

    public int getCeil() {
        return this.ceilingPrice;
    }

    public int getFloor() {
        return this.floorPrice;
    }

}
