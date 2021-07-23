/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.MarketModel;

/**
 *
 * @author kal bugrara
 */
public class MarketChannelAssignment {
    // Ads should put here/iphone ads, references---both together unit, add name
    // ,connection

    Market market;
    Channel channel;
    String ads;
    // e.g college students, doing price?channel combination

    public MarketChannelAssignment(Market m, Channel c) {

        market = m;
        channel = c;
        this.ads = "";
    }

    public Market getMarket() {
        return this.market;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public void setAds(String ads) {
        this.ads = ads;
    }

    public String getAds() {
        return this.ads;
    }

}
