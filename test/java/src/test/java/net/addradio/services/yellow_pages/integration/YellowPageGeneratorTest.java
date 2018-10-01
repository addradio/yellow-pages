package net.addradio.services.yellow_pages.integration;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Test;
import org.xmlunit.matchers.CompareMatcher;

import net.addradio.services.yellow_pages.YellowPageGenerator;
import net.addradio.services.yellow_pages.factories.BroadcasterFactory;
import net.addradio.services.yellow_pages.factories.ChannelFactory;
import net.addradio.services.yellow_pages.factories.ContactFactory;
import net.addradio.services.yellow_pages.factories.LocationFactory;
import net.addradio.services.yellow_pages.factories.LogoFactory;
import net.addradio.services.yellow_pages.factories.StationFactory;
import net.addradio.services.yellow_pages.factories.StreamFactory;
import net.addradio.services.yellow_pages.factories.YellowPageFactory;
import net.addradio.services.yellow_pages.helpers.FileHelper;

import https.addradio_net.services.yellow_pages.v1.ChannelType;
import https.addradio_net.services.yellow_pages.v1.ContactType;
import https.addradio_net.services.yellow_pages.v1.ImageType;
import https.addradio_net.services.yellow_pages.v1.LocationType;
import https.addradio_net.services.yellow_pages.v1.YellowPage;
import https.addradio_net.services.yellow_pages.v1.YellowPage.Broadcaster;
import https.addradio_net.services.yellow_pages.v1.StationType;
import https.addradio_net.services.yellow_pages.v1.StreamType;

public class YellowPageGeneratorTest {

    private static final boolean VERBOSE = false;
    // private static final boolean VERBOSE = true;

    private static final String FIXTURE_FILE = "/fixtures/full.xml";

    public YellowPageGeneratorTest() {
    }

    @Test
    public void itRendersExpectedXml() {
        YellowPage yellowPage = buildYellowPage();

        String result = exportXml(yellowPage);
        String expected = getExpectedXml();

        if (VERBOSE) {
            System.out.println(result);
        }

        assertThat(
            result,
            CompareMatcher.isIdenticalTo(expected)
                .normalizeWhitespace()
                .ignoreComments()
        );
    }

    protected YellowPage buildYellowPage() {
        StationType station = buildStation();

        Broadcaster broadcaster = new BroadcasterFactory()
            .withId("broadcaster_id")
            .withName("Westdeutscher Rundfunk (WDR)")
            .withStation(station)
            .build();

        YellowPage yellowPage = new YellowPageFactory()
            .withAggregatorId("f0a1")
            .withBroadcaster(broadcaster)
            .build();

        return yellowPage;
    }

    protected StationType buildStation() {
        ChannelType channel = buildChannel();

        ContactType contact = new ContactFactory()
            .withAddress(
                "1LIVE\n" +
                "Westdeutscher Rundfunk Köln\n" +
                "50600 Köln"
            )
            .withEmail("test@example.invalid")
            .withPhone("0049(0)12345 12345")
            .build();

        ImageType logo = new LogoFactory()
            .withMimeType("image/png")
            .withDimensions(624, 624)
            .withUrl("http://www1.wdr.de/radio/logo-1live-100~_v-Podcast.png")
            .build();

        StationType station = new StationFactory()
            .withId("station_id")
            .withName("1 Live")
            .withWebsite(getWebsiteUrl())
            .withLogo(logo)
            .withContact(contact)
            .withClaim("Für den Sektor")
            .withDescription(
                "1LIVE ist das unangepasste Radio des WDR: provokant, anders und immer in Bewegung.\n" +
                "Euer Freundeskreis im Sektor!"
            )
            .withLocation(buildLocation())
            .withChannel(channel)
            .build();

        return station;
    }

    protected ChannelType buildChannel() {
        List<StreamType> streams = Arrays.asList(
            new StreamFactory()
                .withId("stream_id_0")
                .withFormat("mp3")
                .withQuality(56)
                .withUrl("http://addrad.io/444yxh2")
                .build(),

            new StreamFactory()
                .withId("stream_id_1")
                .withFormat("mp3")
                .withQuality(128)
                .withUrl("http://addrad.io/444yxjj")
                .build()
        );


        ChannelType channel = new ChannelFactory()
            .withId("channel_id")
            .withName("live")
            .withWebsite(getWebsiteUrl())
            .withLocation(buildLocation())
            .withCategory("Pop")
            .withStreams(streams)
            .build();

        return channel;
    }

    protected LocationType buildLocation() {
        return new LocationFactory()
            .withCity("Köln")
            .withState("Nordrhein-Westfalen")
            .withCountry("Germany")
            .withCoordinate(50.93333, 6.95)
            .build();

    }

    protected String getWebsiteUrl() {
        return "http://www1.wdr.de/radio/1live/index.html";
    }

    protected String exportXml(YellowPage yellowPage) {
        StringWriter writer = new StringWriter();

        try
        {
            YellowPageGenerator yellowPageGenerator = new YellowPageGenerator(yellowPage);
            yellowPageGenerator.render(writer);
        }
        catch (JAXBException|IOException e)
        {
            throw new RuntimeException("An error occured rendering the yellow page: ", e);
        }

        return writer.toString();
    }

    protected String getExpectedXml() {
        try {
            String expectedXml = FileHelper.readResource(FIXTURE_FILE);
            return expectedXml;
        } catch (IOException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

}
