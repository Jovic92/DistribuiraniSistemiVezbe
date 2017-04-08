
package client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.5
 * 2017-03-28T23:10:13.872+02:00
 * Generated source version: 3.0.5
 */

@WebFault(name = "pronadjiStudentaFault", targetNamespace = "http://new.webservice.namespace")
public class PronadjiStudentaFault extends Exception {
    
    private java.lang.String pronadjiStudentaFault;

    public PronadjiStudentaFault() {
        super();
    }
    
    public PronadjiStudentaFault(String message) {
        super(message);
    }
    
    public PronadjiStudentaFault(String message, Throwable cause) {
        super(message, cause);
    }

    public PronadjiStudentaFault(String message, java.lang.String pronadjiStudentaFault) {
        super(message);
        this.pronadjiStudentaFault = pronadjiStudentaFault;
    }

    public PronadjiStudentaFault(String message, java.lang.String pronadjiStudentaFault, Throwable cause) {
        super(message, cause);
        this.pronadjiStudentaFault = pronadjiStudentaFault;
    }

    public java.lang.String getFaultInfo() {
        return this.pronadjiStudentaFault;
    }
}
