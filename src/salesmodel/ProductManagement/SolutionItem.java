/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.ProductManagement;

/**
 *
 * @author Faye
 */
public class SolutionItem {

    Product p;
    int price;
    int quantity;

    public SolutionItem(Product p, int price, int quantity) {
        this.p = p;
        this.price = price;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.p;
    }

    public int getActualPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
