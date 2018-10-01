package net.addradio.services.yellow_pages.factories;

import https.addradio_net.services.yellow_pages.v1.StationType.Logos;
import https.addradio_net.services.yellow_pages.v1.StationType.Website;
import https.addradio_net.services.yellow_pages.v1.StationType.Channels;
import https.addradio_net.services.yellow_pages.v1.ChannelType;
import https.addradio_net.services.yellow_pages.v1.ContactType;
import https.addradio_net.services.yellow_pages.v1.ImageType;
import https.addradio_net.services.yellow_pages.v1.LocationType;
import https.addradio_net.services.yellow_pages.v1.StationType;

import java.util.Arrays;
import java.util.List;

public class StationFactory extends TestFactory<StationType> {

    public StationFactory withId(String value) {
        record.setId(value);
        return this;
    }

    public StationFactory withName(String value) {
        record.setName(value);
        return this;
    }

    public StationFactory withWebsite(String url) {
        Website website = new Website();
        website.setUrl(url);

        record.setWebsite(website);
        return this;
    }

    public StationFactory withLogos(List<ImageType> logos) {
        Logos logosWrapper = new Logos();
        record.setLogos(logosWrapper);

        List<ImageType> logoList = logosWrapper.getLogo();
        logoList.addAll(logos);

        return this;
    }

    public StationFactory withLogo(ImageType logo) {
        this.withLogos(Arrays.asList(logo));
        return this;
    }

    public StationFactory withContact(ContactType contact) {
        record.setContact(contact);
        return this;
    }

    public StationFactory withClaim(String value) {
        record.setClaim(value);
        return this;
    }

    public StationFactory withDescription(String value) {
        record.setDescription(value);
        return this;
    }

    public StationFactory withLocation(LocationType location) {
        record.setLocation(location);
        return this;
    }

    public StationFactory withChannels(List<ChannelType> channels) {
        Channels channelsWrapper = new Channels();
        record.setChannels(channelsWrapper);

        List<ChannelType> channelList = channelsWrapper.getChannel();
        channelList.addAll(channels);

        return this;
    }

    public StationFactory withChannel(ChannelType channel) {
        this.withChannels(Arrays.asList(channel));
        return this;
    }
}
