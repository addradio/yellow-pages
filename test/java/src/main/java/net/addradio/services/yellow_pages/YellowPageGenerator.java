package net.addradio.services.yellow_pages;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;

import https.addradio_net.services.yellow_pages.v1.YellowPage;

public class YellowPageGenerator {

    private final static String NAMESPACE = "https://addradio.net/services/yellow-pages/v1";

    private final static String [] CDATA_ELEMENTS = new String[] {
        NAMESPACE + "^" + "address",
        NAMESPACE + "^" + "description"
    };

    private YellowPage yellowPage;
    private Marshaller marshaller;

    public YellowPageGenerator(YellowPage yellowPage) throws JAXBException
    {
        this.yellowPage = yellowPage;
        createMarshaller();
    }

    public String render(StringWriter writer) throws JAXBException, IOException
    {
        // get an Apache XMLSerializer configured to generate CDATA
        XMLSerializer serializer = getXMLSerializer(writer);

        marshaller.marshal(yellowPage, serializer.asContentHandler());

        return serializer.toString();
    }

    private Marshaller createMarshaller() throws JAXBException
    {
        JAXBContext context = JAXBContext.newInstance(YellowPage.class);
        marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

        specifyNamespaceMapper(marshaller);

        return marshaller;
    }

    /*
     * source: https://github.com/javaee/jaxb-v2/blob/master/jaxb-ri/samples/src/main/samples/namespace-prefix/src/PrefixExample.java
     */
    private void specifyNamespaceMapper(Marshaller marshaller) {
        try {
            marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NamespacePrefixMapperImpl(NAMESPACE));
        } catch( PropertyException e ) {
            // if the JAXB provider doesn't recognize the prefix mapper,
            // it will throw this exception. Since being unable to specify
            // a human friendly prefix is not really a fatal problem,
            // you can just continue marshalling without failing
            ;
        }
    }

    /*
     * source: https://javaee.github.io/jaxb-v2/doc/user-guide/download/JaxbCDATASample.java
     */
    private static XMLSerializer getXMLSerializer(StringWriter writer) {
        OutputFormat of = new OutputFormat();
        of.setCDataElements(CDATA_ELEMENTS);

        of.setIndenting(true);
        of.setIndent(2);

        XMLSerializer serializer = new XMLSerializer(of);
        serializer.setOutputCharStream(writer);

        return serializer;
    }
}
