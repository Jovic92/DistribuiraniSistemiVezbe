
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RasporedRequest_QNAME = new QName("http://www.example.org/rasporedcasova/", "rasporedRequest");
    private final static QName _RasporedResponse_QNAME = new QName("http://www.example.org/rasporedcasova/", "rasporedResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRaspored }
     * 
     */
    public GetRaspored createGetRaspored() {
        return new GetRaspored();
    }

    /**
     * Create an instance of {@link GetRasporedResponse }
     * 
     */
    public GetRasporedResponse createGetRasporedResponse() {
        return new GetRasporedResponse();
    }

    /**
     * Create an instance of {@link RasporedRequestType }
     * 
     */
    public RasporedRequestType createRasporedRequestType() {
        return new RasporedRequestType();
    }

    /**
     * Create an instance of {@link RasporedResponseType }
     * 
     */
    public RasporedResponseType createRasporedResponseType() {
        return new RasporedResponseType();
    }

    /**
     * Create an instance of {@link CasoviType }
     * 
     */
    public CasoviType createCasoviType() {
        return new CasoviType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RasporedRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/rasporedcasova/", name = "rasporedRequest")
    public JAXBElement<RasporedRequestType> createRasporedRequest(RasporedRequestType value) {
        return new JAXBElement<RasporedRequestType>(_RasporedRequest_QNAME, RasporedRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RasporedResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/rasporedcasova/", name = "rasporedResponse")
    public JAXBElement<RasporedResponseType> createRasporedResponse(RasporedResponseType value) {
        return new JAXBElement<RasporedResponseType>(_RasporedResponse_QNAME, RasporedResponseType.class, null, value);
    }

}
