/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import salesmodel.Business.Business;
import salesmodel.CustomerManagement.CustomerProfile;
import salesmodel.Data.Data;
import salesmodel.MarketModel.Channel;
import salesmodel.MarketModel.Market;
import salesmodel.MarketModel.MarketChannelAssignment;
import salesmodel.OrderManagement.Order;
import salesmodel.OrderManagement.OrderBundle;
import salesmodel.Personnel.EmployeeProfile;
import salesmodel.Personnel.Person;
import salesmodel.ProductManagement.Product;
import salesmodel.ProductManagement.SolutionBundle;
import salesmodel.ProductManagement.SolutionBundleAssignment;
import salesmodel.ProductManagement.SolutionOffer;
import salesmodel.SupplierManagement.Supplier;

/**
 *
 * @author faye
 */
public class DataUtil {

    public static ArrayList<String[]> getBestSalesPerformance(Business b) {
        HashMap<EmployeeProfile, Integer> performance = new HashMap<>();
        ArrayList<String[]> sale_persons_ls = new ArrayList<>();
        b.order_list.getOrders().stream().filter(order -> (order.getStatus().equals("approved"))).forEachOrdered((Order order) -> {
            EmployeeProfile ep = order.getBundleAssignment().getBundle().getSalePerson();
            if (performance.containsKey(ep)) {
                performance.put(ep, performance.get(ep) + order.getOrderPricePerformance());
            } else {
                performance.put(ep, order.getOrderPricePerformance());
            }
        });
        performance.keySet().stream().map(ep -> {
            String[] arr = new String[2];
            arr[0] = ep.getName();
            arr[1] = performance.get(ep).toString();
            return arr;
        }).forEachOrdered(arr -> {
            sale_persons_ls.add(arr);
        });
        Collections.sort(sale_persons_ls, (String[] o1, String[] o2) -> Integer.valueOf(o2[1]).compareTo(Integer.valueOf(o1[1]))); //Simple string comparison here, add more sophisticated logic if needed.

        return sale_persons_ls;
    }

    public static ArrayList<String[]> getBestProfitProds(Business b) {
        HashMap<Product, Integer> profits = new HashMap<>();
        ArrayList<String[]> profits_ls = new ArrayList<>();
        b.order_list.getOrders().stream().filter(order -> (order.getStatus().equals("approved"))).forEachOrdered(order -> {
            order.getOrderItems().forEach(item -> {
                if (profits.containsKey(item.getProduct())) {
                    profits.put(item.getProduct(), item.calculatePricePerformance() * item.getQuantity() + profits.get(item.getProduct()));
                } else {
                    profits.put(item.getProduct(), item.calculatePricePerformance() * item.getQuantity());
                }
            });
        });

        profits.keySet().stream().map(p -> {
            String[] arr = new String[3];
            arr[0] = p.getDesc();
            arr[1] = p.getSupplier().person.getName();
            arr[2] = profits.get(p).toString();
            return arr;
        }).forEachOrdered(arr -> {
            profits_ls.add(arr);
        });

        Collections.sort(profits_ls, (String[] o1, String[] o2) -> Integer.valueOf(o2[2]).compareTo(Integer.valueOf(o1[2]))); //Simple string comparison here, add more sophisticated logic if needed.

        return profits_ls;
    }

    public static ArrayList<String[]> getBestProfitCustomers(Business b) {

        HashMap<CustomerProfile, Integer> profits = new HashMap<>();
        HashMap<CustomerProfile, HashMap<MarketChannelAssignment, Integer>> best_ma_map = new HashMap<>();
        ArrayList<String[]> profits_ls = new ArrayList<>();

        b.order_list.getOrders().stream().filter(order -> (order.getStatus().equals("approved"))).forEachOrdered(order -> {
            if (profits.containsKey(order.getCustomer())) {
                profits.put(order.getCustomer(), order.getOrderPricePerformance() + profits.get(order.getCustomer()));
            } else {
                profits.put(order.getCustomer(), order.getOrderPricePerformance());
            }
            
            if(best_ma_map.containsKey(order.getCustomer())){
                HashMap<MarketChannelAssignment, Integer> best_ma = best_ma_map.get(order.getCustomer());
                MarketChannelAssignment ma = order.getBundleAssignment().getMarketAssignMent();
                if(best_ma.containsKey(order.getBundleAssignment().getMarketAssignMent())){       
                   best_ma.put(ma, best_ma.get(order.getBundleAssignment().getMarketAssignMent()) + order.getOrderPricePerformance());
                   //best_ma_map.put(order.getCustomer(), best_ma);
                }
                else { 
                   best_ma.put(ma, order.getOrderPricePerformance());
                   //best_ma_map.put(order.getCustomer(), best_ma);
                } 
            }
            else {
                MarketChannelAssignment ma = order.getBundleAssignment().getMarketAssignMent();
                HashMap<MarketChannelAssignment, Integer> best_ma = new HashMap<>();
                best_ma.put(ma, order.getOrderPricePerformance());
                best_ma_map.put(order.getCustomer(),  best_ma);
            } 
        });

        profits.keySet().stream().map(cp -> {
            HashMap<MarketChannelAssignment, Integer> ma_map = best_ma_map.get(cp);
            
            ArrayList<String[]> ma_performance = new ArrayList<String[]>();
            for(MarketChannelAssignment ma:ma_map.keySet()){
                String[] arr = new String[2];
                arr[0] = String.join(", ", ma.getMarket().getCharacters()) + " - " + ma.getChannel().getType();
                arr[1] = ma_map.get(ma).toString();
                ma_performance.add(arr);
            }
            Collections.sort(ma_performance, (String[] o1, String[] o2) -> Integer.valueOf(o2[1]).compareTo(Integer.valueOf(o1[1])));
            String[] arr = new String[4];
            arr[0] = cp.getName();
            arr[1] = ma_performance.get(0)[0] + " "+ma_performance.get(0)[1];
            arr[2] = profits.get(cp).toString(); 
            System.out.println(cp.getName() + " " + arr[1]);
            return arr;
        }).forEachOrdered(arr -> {
            profits_ls.add(arr);
        });

        Collections.sort(profits_ls, (String[] o1, String[] o2) -> Integer.valueOf(o2[2]).compareTo(Integer.valueOf(o1[2]))); //Simple string comparison here, add more sophisticated logic if needed.

        return profits_ls;
    }

    public static ArrayList<Order> getPendingRequest(Person person, CustomerProfile cp, Data data) {
        EmployeeProfile ep = data.getEmployees().findEmployee(person.getPersonId());
        ArrayList<Order> orders = new ArrayList<>();
        if (cp == null) {
            data.getBusiness().order_list.getOrders().stream().filter(order -> (order.getStatus().equals("pending"))).forEachOrdered(order -> {
                if (order.getBundleAssignment().getBundle().getSalePerson().equals(ep)) {
                    orders.add(order);
                }
            });
        } else {
            data.getBusiness().order_list.getOrders().stream().filter(order -> (order.getStatus().equals("pending"))).forEachOrdered(order -> {
                if (order.getBundleAssignment().getBundle().getSalePerson().equals(ep) && order.getCustomer().equals(cp)) {
                    orders.add(order);
                }
            });
        }
        return orders;
    }

    public static void createSolutionBundleAssignment(Data data, ArrayList<String> markets, ArrayList<String> channels, ArrayList<String[]> prods, String ads, EmployeeProfile ep) {
        //create markets
        Market market;
        if(data.getBusiness().market_list.hasSameMarket(markets)){ 
            market = data.getBusiness().market_list.findMostMatchMarket(markets);
        } 
        else{
            market = new Market(markets); 
            data.getBusiness().addMarket(market);
        }
         
        //create channels
        for (String c : channels) {
            
            Channel channel = data.getBusiness().channel_list.findChannel(c);
            if(channel==null){
                channel = new Channel(c);
                data.getBusiness().addChannel(channel);
            } 
            //create market channel assignments
            market.addChannel(data.getBusiness().channel_list.findChannel(c)); 
            
            //create bundle assginment
            //create solution bundle assignment
            MarketChannelAssignment ma = market.findAssignment(data.getBusiness().channel_list.findChannel(c));
            SolutionOffer s_offer = new SolutionOffer(ma.getMarket());
            for(String[] items : prods){
                System.out.println(c+" "+Integer.parseInt(items[3]));
                s_offer.addProduct(data.getBusiness().sd.findSupplier(items[2]).pc.findProduct(items[0]), Integer.parseInt(items[3]), Integer.parseInt(items[4]));
                System.out.println(s_offer.getProducts().get(0).getActualPrice() + " " +
                s_offer.getProducts().get(0).getProduct().getTargetPrice());
            } 
            SolutionBundle s_bundle = new SolutionBundle(data.getEmployees().findEmployee(ep.getID()));
            s_bundle.addOffer(s_offer);
            s_bundle.setAds(ads);
            data.getBusiness().sc.addSolutionBundle(s_bundle); 
            data.getBusiness().addBundleAssigment(new SolutionBundleAssignment(ma, s_bundle));
           
        }
        
        System.out.println("# of bundle assignments: " + data.getBusiness().bundle_assignment.size()); 
    }
    
    public static ArrayList<SolutionBundleAssignment> getMarketChannelBundleAssignments(Data data, CustomerProfile cp, String channel){
        MarketChannelAssignment ma = data.getBusiness().market_list.findMostMatchMarket(cp.getcharacters()).findAssignment(data.getBusiness().channel_list.findChannel(channel));
        
        return data.getBusiness().getBundleAssignments(ma);
    }
    
    public static void submitOrder(Data data,SolutionBundleAssignment sa, CustomerProfile cp){
        data.getBusiness().order_list.addOrder(new OrderBundle(sa, cp).createOrder());
    }
    
    public static void addCart(Data data,SolutionBundleAssignment sa, CustomerProfile cp){
        new OrderBundle(sa, cp).addToCart();
    }

    public static void updateCustomerProfile(String name, ArrayList<String> characters, CustomerProfile cp) {
        
        cp.setCharacters(characters);
        cp.setName(name);
    }

    public static void updateProduct(Data data, ArrayList<String[]> products, String supplier_id) {
         Supplier supplier = data.getBusiness().sd.findSupplier(supplier_id); 
         for(String[] p:products){
             if(supplier.pc.findProduct(p[0]) != null){
                supplier.pc.findProduct(p[0]).updateProduct(Integer.parseInt(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4])); 
             }
             else if(supplier.pc.findProduct(p[1]) != null){
                supplier.pc.findProduct(p[1]).updateProduct(Integer.parseInt(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4]));
             }
             else{
                supplier.pc.newProduct(p[0], p[1], Integer.parseInt(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4]));
             }
             
         }
    }
}
