/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.ProductManagement;

import java.util.ArrayList;
import java.util.HashMap;

import salesmodel.MarketModel.Market;

/**
 *
 * @author kal bugrara
 */
public class SolutionOffer {
    //ArrayList<Product> products;

    ArrayList<SolutionItem> items;
    int price;
    Market market;

    public SolutionOffer(Market m) {
        market = m;
        this.items = new ArrayList<SolutionItem>();
        price = 0;
    }

    public void addProduct(Product p, int price, int quantity) {
        this.items.add(new SolutionItem(p, price, quantity));
    }

    public void setPrice(int p) {
        price = p;
    }

    public int getTotal(){
        
        int sum = 0;
        for(SolutionItem item:this.items){
            sum += item.getActualPrice()*item.getQuantity();
        }
        return sum;
    }
//    public HashMap<Product, Integer> getProducts() {
//        HashMap<Product, Integer> products_counter = new HashMap<Product, Integer>();
//        for (Product product : this.products) {
//            if (products_counter.containsKey(product)) {
//                products_counter.put(product, products_counter.get(product) + 1);
//            } else {
//                products_counter.put(product, 1);
//            }
//        }
//        return products_counter;
//    }

    public ArrayList<SolutionItem> getProducts() { 
        return this.items;
    } 
    
    public int getPrice() {
        return price;
    }

}
