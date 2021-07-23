/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmodel.MarketModel;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class Market {

    ArrayList<MarketChannelAssignment> channels;
    ArrayList<String> characteristics;
    int size;

    public Market(String s) {
        this.channels = new ArrayList<MarketChannelAssignment>();
        characteristics = new ArrayList<String>();
        characteristics.add(s);
    }

    public Market(String[] arr) {
        this.channels = new ArrayList<MarketChannelAssignment>();
        characteristics = new ArrayList<String>();
        for (String s : arr) {
            if (!s.trim().isEmpty()) {
                characteristics.add(s);
            }

        }
    }
    
    public Market(ArrayList<String> arr) {
        this.channels = new ArrayList<MarketChannelAssignment>();
        characteristics = new ArrayList<String>();
        for (String s : arr) {
            if (!s.trim().isEmpty()) {
                characteristics.add(s);
            }

        }
    }

    public void addCharacter(String s) {
        this.characteristics.add(s);
    }

    public boolean hasCharacter(String s) {
        return this.characteristics.contains(s);
    }

    public ArrayList<String> getCharacters() {
        return this.characteristics;
    }

    public MarketChannelAssignment findAssignment(Channel channel) {
        MarketChannelAssignment assignment = null;
        for (MarketChannelAssignment ma : this.channels) {
            if (ma.market.equals(this) && ma.channel.equals(channel)) {
                assignment = ma;
            }
        }
        return assignment;
    }

    public void addChannel(Channel channel) {
        
        boolean hasChannel = false;
        for(MarketChannelAssignment ma : this.channels){
            if(ma.channel.type.equals(channel.type)){
                hasChannel = true;
            }
        }
        if(!hasChannel){
            this.channels.add(new MarketChannelAssignment(this, channel));
        }
        
    }
}
