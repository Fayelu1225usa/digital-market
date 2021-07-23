/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.Business;

import java.util.ArrayList;
import salesmodel.CustomerManagement.*;
import salesmodel.MarketModel.*;
import salesmodel.OrderManagement.MasterOrderList;
import salesmodel.ProductManagement.SolutionBundleAssignment;
import salesmodel.SupplierManagement.SupplierDirectory;
import salesmodel.ProductManagement.SolutionCatalog;

/**
 *
 * @author fayelu
 */
public class Business {

    public CustomerDirectory cd;
    public SupplierDirectory sd;
    public MarketList market_list;
    public ChannelList channel_list;
    public MasterOrderList order_list;
    public SolutionCatalog sc;
    public String id;
    public ArrayList<SolutionBundleAssignment> bundle_assignment;

    public Business(String id) {
        this.id = id;
        this.cd = new CustomerDirectory(this);
        this.sd = new SupplierDirectory(this);
        this.market_list = new MarketList(this);
        this.channel_list = new ChannelList(this);
        this.order_list = new MasterOrderList(this);
        this.sc = new SolutionCatalog(this);
        bundle_assignment = new ArrayList<SolutionBundleAssignment>(); 
    }

    public Market addMarket(Market market) {
        
        this.market_list.add(market);
        return market;
    }

    public void addChannel(Channel channel) {
         
        this.channel_list.add(channel);
    }
    
    public SupplierDirectory getSuppliers(){
        return this.sd;
    }
    
    public void addBundleAssigment(SolutionBundleAssignment sa){
        if(!this.bundle_assignment.contains(sa)){
            this.bundle_assignment.add(sa);
        }
    }
    
    public ArrayList<SolutionBundleAssignment> getBundleAssignments(MarketChannelAssignment ma){
        
        ArrayList<SolutionBundleAssignment> res = new ArrayList<SolutionBundleAssignment>();
        for(SolutionBundleAssignment sa : this.bundle_assignment){ 
            if(sa.getMarketAssignMent().equals(ma)){
                res.add(sa);
            } 
        } 
        return res; 
    }

}
