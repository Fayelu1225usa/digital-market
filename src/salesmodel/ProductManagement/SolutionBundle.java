package salesmodel.ProductManagement;

import java.util.ArrayList;
import salesmodel.Personnel.EmployeeProfile;

public class SolutionBundle {

    ArrayList<SolutionOffer> s_offers;
    EmployeeProfile ep;
    String ads;
    public SolutionBundle(EmployeeProfile ep) {
        this.s_offers = new ArrayList<SolutionOffer>();
        this.ep = ep;
        this.ads = "";
    }

    public void addOffer(SolutionOffer s_offer) {
        this.s_offers.add(s_offer);
    }

    public ArrayList<SolutionOffer> getOffers() {
        return this.s_offers;
    }

    public int getTotalPrice() {
        int sum = 0;
        for (SolutionOffer offer : this.s_offers) {
            sum += offer.getTotal();
        }
        return sum;
    }

    public EmployeeProfile getSalePerson() {
        return this.ep;
    }
    
    public void setAds(String ads){
        this.ads = ads;
    }
    
    public String getAds(){
        return this.ads; 
    }

}
