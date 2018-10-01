package net.addradio.services.yellow_pages.factories;

import java.math.BigInteger;

import https.addradio_net.services.yellow_pages.v1.StreamFormatType;
import https.addradio_net.services.yellow_pages.v1.StreamType;

public class StreamFactory extends TestFactory<StreamType> {

    public StreamFactory withId(String value) {
        record.setId(value);
        return this;
    }

    public StreamFactory withFormat(String format) {
        record.setFormat(StreamFormatType.fromValue(format));
        return this;
    }

    public StreamFactory withQuality(int quality) {
        record.setQuality(BigInteger.valueOf(quality));
        return this;
    }

    public StreamFactory withUrl(String url) {
        record.setUrl(url);
        return this;
    }

}
