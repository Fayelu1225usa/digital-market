package salesmodel.ProductManagement;

import salesmodel.MarketModel.MarketChannelAssignment;

public class SolutionBundleAssignment {

    MarketChannelAssignment ma;
    SolutionBundle s_bundle;

    public SolutionBundleAssignment(MarketChannelAssignment ma, SolutionBundle s_bundle) {
        this.ma = ma;
        this.s_bundle = s_bundle;
    }

    public SolutionBundle getBundle() {
        return this.s_bundle;
    }

    public MarketChannelAssignment getMarketAssignMent() {
        return this.ma;
    }
}
