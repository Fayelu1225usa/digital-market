/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.SupplierManagement;

import java.util.ArrayList;
import salesmodel.ProductManagement.ProductCatalog;
import salesmodel.Personnel.Person;
import salesmodel.ProductManagement.Product;

/**
 *
 * @author fayelu
 */
public class Supplier {

    public ProductCatalog pc;
    public Person person;

    public Supplier(Person p, String pc_name) {
        this.person = p;
        this.pc = new ProductCatalog(pc_name, this);
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    public ArrayList<Product> getProducts() {

        return this.pc.getProducts();
    }
}
