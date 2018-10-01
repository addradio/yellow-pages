package net.addradio.services.yellow_pages.factories;

import java.math.BigInteger;

import https.addradio_net.services.yellow_pages.v1.ImageType;
import https.addradio_net.services.yellow_pages.v1.MimetypeType;

public class LogoFactory extends TestFactory<ImageType> {

    public LogoFactory withMimeType(String value) {
        record.setMimetype(MimetypeType.fromValue(value));
        return this;
    }

    public LogoFactory withDimensions(int width, int height) {
        record.setWidth(BigInteger.valueOf(width));
        record.setHeight(BigInteger.valueOf(height));
        return this;
    }

    public LogoFactory withUrl(String value) {
        record.setUrl(value);
        return this;
    }

}
