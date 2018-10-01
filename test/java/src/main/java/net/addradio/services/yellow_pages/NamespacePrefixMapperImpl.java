package net.addradio.services.yellow_pages;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

/*
 * source: https://github.com/javaee/jaxb-v2/blob/master/jaxb-ri/samples/src/main/samples/namespace-prefix/src/NamespacePrefixMapperImpl.java
 */
class NamespacePrefixMapperImpl extends NamespacePrefixMapper {

    private String customNamespace;

    public NamespacePrefixMapperImpl(String customNamespace) {
        this.customNamespace = customNamespace;
    }

    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if( "http://www.w3.org/2001/XMLSchema-instance".equals(namespaceUri) )
            return "xsi";

        if( customNamespace.equals(namespaceUri) )
            return "yp";

        // default suggestion
        return suggestion;
    }

    public String[] getPreDeclaredNamespaceUris() {
        return new String[] { "https://addradio.net/services/yellow-pages/v1" };
    }
}

