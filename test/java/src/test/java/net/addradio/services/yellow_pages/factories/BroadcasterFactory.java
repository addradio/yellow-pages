package net.addradio.services.yellow_pages.factories;

import https.addradio_net.services.yellow_pages.v1.StationType;
import https.addradio_net.services.yellow_pages.v1.YellowPage.Broadcaster;
import https.addradio_net.services.yellow_pages.v1.YellowPage.Broadcaster.Stations;

import java.util.Arrays;
import java.util.List;

public class BroadcasterFactory extends TestFactory<Broadcaster> {

    public BroadcasterFactory withId(String value) {
        record.setId(value);
        return this;
    }

    public BroadcasterFactory withName(String value) {
        record.setName(value);
        return this;
    }

    public BroadcasterFactory withStations(List<StationType> stations) {
        Stations stationsWrapper = new Stations();
        record.setStations(stationsWrapper);

        List<StationType> stationList = stationsWrapper.getStation();
        stationList.addAll(stations);

        return this;
    }

    public BroadcasterFactory withStation(StationType station) {
        this.withStations(Arrays.asList(station));
        return this;
    }

}
