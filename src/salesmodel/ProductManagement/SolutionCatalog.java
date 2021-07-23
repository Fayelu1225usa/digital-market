/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.ProductManagement;
import salesmodel.Business.Business;
import java.util.ArrayList; 
/**
 *
 * @author fayelu
 */
public class SolutionCatalog {
    public Business d;
    public ArrayList<SolutionBundle> s_bundles;
    
    public SolutionCatalog(Business d){
        this.d = d;
        this.s_bundles = new ArrayList<SolutionBundle>();
    }
    
    public void addSolutionBundle(SolutionBundle s_bundle) {
    	this.s_bundles.add(s_bundle);
    } 
}
