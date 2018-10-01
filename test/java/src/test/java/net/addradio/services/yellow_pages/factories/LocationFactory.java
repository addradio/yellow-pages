package net.addradio.services.yellow_pages.factories;

import java.math.BigDecimal;

import https.addradio_net.services.yellow_pages.v1.CoordinateType;
import https.addradio_net.services.yellow_pages.v1.LocationType;

public class LocationFactory extends TestFactory<LocationType> {

    public LocationFactory withCity(String value) {
        record.setCity(value);
        return this;
    }

    public LocationFactory withState(String value) {
        record.setState(value);
        return this;
    }

    public LocationFactory withCountry(String value) {
        record.setCountry(value);
        return this;
    }

    public LocationFactory withCoordinate(double latitude, double longitude) {
        CoordinateType coordinate = new CoordinateType();

        coordinate.setLatitude(BigDecimal.valueOf(latitude));
        coordinate.setLongitude(BigDecimal.valueOf(longitude));

        record.setCoordinate(coordinate);

        return this;
    }

}
