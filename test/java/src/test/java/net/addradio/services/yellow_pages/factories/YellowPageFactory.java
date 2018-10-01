package net.addradio.services.yellow_pages.factories;

import https.addradio_net.services.yellow_pages.v1.YellowPage;
import https.addradio_net.services.yellow_pages.v1.YellowPage.Broadcaster;

public class YellowPageFactory extends TestFactory<YellowPage> {

    public YellowPageFactory withAggregatorId(String value) {
        record.setAggregatorId(value);
        return this;
    }

    public YellowPageFactory withBroadcaster(Broadcaster broadcaster) {
        record.setBroadcaster(broadcaster);
        return this;
    }

}
