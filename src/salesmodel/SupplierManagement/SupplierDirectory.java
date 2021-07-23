/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.SupplierManagement;
import salesmodel.Business.Business;
import salesmodel.Personnel.Person;

import java.util.ArrayList;
/**
 *
 * @author fayelu
 */

public class SupplierDirectory {
    public ArrayList<Supplier> supplier_list;
    public Business d;
    public SupplierDirectory(Business d){
        this.d = d;
        this.supplier_list = new ArrayList<Supplier>();
    }
    
    public Supplier newSupplier(Person p, String pc_name) {

    	Supplier sp = new Supplier(p, pc_name);
    	supplier_list.add(sp);
        return sp;
    }

    public Supplier findSupplier(String id) {

        for (Supplier sp : supplier_list) {

            if (sp.isMatch(id)) {
                return sp;
            }
        }
        return null; //not found after going through the whole list
    }
    
    public ArrayList<Supplier> getSuppliers(){
    	return this.supplier_list;
    }
}
