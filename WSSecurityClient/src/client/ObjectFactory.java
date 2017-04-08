
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

    private final static QName _NazivFakulteta_QNAME = new QName("http://new.webservice.namespace", "naziv_fakulteta");
    private final static QName _PronadjiStudentaFault_QNAME = new QName("http://new.webservice.namespace", "pronadjiStudentaFault");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link Student.Fakultet }
     * 
     */
    public Student.Fakultet createStudentFakultet() {
        return new Student.Fakultet();
    }

    /**
     * Create an instance of {@link Studenti }
     * 
     */
    public Studenti createStudenti() {
        return new Studenti();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://new.webservice.namespace", name = "naziv_fakulteta")
    public JAXBElement<String> createNazivFakulteta(String value) {
        return new JAXBElement<String>(_NazivFakulteta_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://new.webservice.namespace", name = "pronadjiStudentaFault")
    public JAXBElement<String> createPronadjiStudentaFault(String value) {
        return new JAXBElement<String>(_PronadjiStudentaFault_QNAME, String.class, null, value);
    }

}
