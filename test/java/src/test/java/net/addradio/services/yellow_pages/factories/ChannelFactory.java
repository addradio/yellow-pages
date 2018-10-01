package net.addradio.services.yellow_pages.factories;

import java.util.Arrays;
import java.util.List;

import https.addradio_net.services.yellow_pages.v1.ChannelType;
import https.addradio_net.services.yellow_pages.v1.ChannelType.Website;
import https.addradio_net.services.yellow_pages.v1.ChannelType.Categories;
import https.addradio_net.services.yellow_pages.v1.ChannelType.Streams;
import https.addradio_net.services.yellow_pages.v1.LocationType;
import https.addradio_net.services.yellow_pages.v1.StreamType;

public class ChannelFactory extends TestFactory<ChannelType> {

    public ChannelFactory withId(String value) {
        record.setId(value);
        return this;
    }

    public ChannelFactory withName(String value) {
        record.setName(value);
        return this;
    }

    public ChannelFactory withWebsite(String url) {
        Website website = new Website();
        website.setUrl(url);

        record.setWebsite(website);
        return this;
    }

    public ChannelFactory withLocation(LocationType location) {
        record.setLocation(location);
        return this;
    }

    public ChannelFactory withCategories(List<String> categoryNames) {
        Categories categoriesWrapper = new Categories();
        record.setCategories(categoriesWrapper);

        List<String> categories = categoriesWrapper.getCategory();
        categories.addAll(categoryNames);

        return this;
    }

    public ChannelFactory withCategory(String categoryName) {
        withCategories(Arrays.asList(categoryName));
        return this;
    }

    public ChannelFactory withStreams(List<StreamType> streams) {
        Streams streamsWrapper = new Streams();
        record.setStreams(streamsWrapper);

        List<StreamType> streamList = streamsWrapper.getStream();
        streamList.addAll(streams);

        return this;
    }

    public ChannelFactory withStream(StreamType stream) {
        withStreams(Arrays.asList(stream));
        return this;
    }

}
