package salesmodel.CustomerManagement;

import java.util.ArrayList;

import salesmodel.OrderManagement.OrderBundle;

public class ShopCart {

    ArrayList<OrderBundle> order_bundles;
    CustomerProfile cp;

    public ShopCart(CustomerProfile cp) {
        this.cp = cp;
        this.order_bundles = new ArrayList<OrderBundle>();
    }

    public void addOrderBundle(OrderBundle order_bundle) {
        this.order_bundles.add(order_bundle);
    }

    public void removeOrderBundle(OrderBundle order_bundle) {
        if (this.order_bundles.contains(order_bundle)) {
            this.order_bundles.remove(this.order_bundles.indexOf(order_bundle));
        }
    }

    public void submitOrderBundle(OrderBundle order_bundle) {
        if (this.order_bundles.contains(order_bundle)) {
            this.cp.account.submitOrderRequest(order_bundle);
            removeOrderBundle(order_bundle);
        }

    }
    
    public ArrayList<OrderBundle> getBundles(){
        return this.order_bundles;
    }

    public void clear() {
        this.order_bundles.clear();
    }
}
