/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.MarketModel;

import java.util.ArrayList;
import salesmodel.Business.Business;

/**
 *
 * @author fayelu
 */
public class MarketList {

    ArrayList<Market> market_list;
    Business d;

    public MarketList(Business d) {
        this.d = d;
        this.market_list = new ArrayList<Market>();
    }

    public void add(Market market) {
        if (!hasSameMarket(market.characteristics)) {
            this.market_list.add(market);
        }

    }

    public ArrayList<Market> findMarkets(ArrayList<String> characteristics) {
        ArrayList<Market> markets = new ArrayList<Market>();
        for (Market market : this.market_list) {
            for (String c : characteristics) {
                if (market.hasCharacter(c)) {
                    markets.add(market);
                }
            }
        }
        return markets;
    }
    
    public boolean hasSameMarket(ArrayList<String> characteristics){
        for (Market m : this.market_list) {
            int matches = 0;
            for (String c : characteristics) {
                if (m.hasCharacter(c)) {
                    matches++;
                }
            }
            if(matches==characteristics.size() && m.characteristics.size()==characteristics.size()){ 
                return true;
            }
        }
        return false;
    }

    public Market findMostMatchMarket(ArrayList<String> characteristics) {
        Market market = null;
        int max_matches = 0;
        for (Market m : this.market_list) {
            int matches = 0;
            for (String c : characteristics) {
                if (m.hasCharacter(c)) {
                    matches++;
                }
            }
            if (matches > max_matches) {
                market = m;
                max_matches = matches;
            } else if (matches == max_matches) {
                if (m.characteristics.size() <= characteristics.size()) {
                    market = m;
                }
            }

        }
        return market;
    }
}
