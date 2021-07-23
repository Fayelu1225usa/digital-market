/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.ProductManagement;

import java.util.ArrayList;
import salesmodel.SupplierManagement.Supplier;

/**
 *
 * @author kal bugrara
 */
public class ProductCatalog {

    String type;
    ArrayList<Product> products;
    Supplier supplier;

    public ProductCatalog(String n, Supplier supplier) {
        type = n;
        products = new ArrayList<Product>();
        this.supplier = supplier;
    }

    public Product newProduct(String id, String desc, int fp, int cp, int tp) {
        Product p = new Product(id, desc, fp, cp, tp, this.supplier);
        products.add(p);
        return p;
    }

    public Product findProduct(String query) {
        for (Product p : this.products) {
            if (p.id.equals(query) || p.desc.equals(query)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Product> getProducts() {

        return this.products;
    }
}
