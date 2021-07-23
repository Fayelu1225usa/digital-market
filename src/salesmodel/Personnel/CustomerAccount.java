package salesmodel.Personnel;

import java.util.ArrayList;

import salesmodel.CustomerManagement.CustomerProfile;
import salesmodel.CustomerManagement.ShopCart;
import salesmodel.OrderManagement.OrderBundle;

public class CustomerAccount {

    CustomerProfile cp;
    ShopCart cart;
    ArrayList<OrderBundle> order_bundles;

    public CustomerAccount(CustomerProfile cp) {
        this.cp = cp;
        this.cart = new ShopCart(this.cp);
        this.order_bundles = new ArrayList<OrderBundle>();
    }

    public ShopCart getCart() {
        return this.cart;
    }

    public void submitOrderRequest(OrderBundle bundle) {
        this.order_bundles.add(bundle);
    }

    public ArrayList<OrderBundle> getOrderBundles() {
        return this.order_bundles;
    }
}
