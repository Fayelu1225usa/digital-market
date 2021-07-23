package salesmodel.MarketModel;

import java.util.ArrayList;

import salesmodel.Business.Business;

/**
 *
 * @author fayelu
 */
public class ChannelList {

    ArrayList<Channel> channels;
    Business d;

    public ChannelList(Business d) {
        this.channels = new ArrayList<Channel>();
        this.d = d;
    }

    public void add(Channel channel) {
        if (!this.channels.contains(channel)) {
            this.channels.add(channel);
        }

    }
    
    public ArrayList<Channel> getChannels(){
        return this.channels;
    }

    public Channel findChannel(String type) {
        Channel res = null;
        for (Channel channel : this.channels) {
            if (channel.type.equals(type)) {
                res = channel;
                break;
            }
        }
        return res;
    }
}
