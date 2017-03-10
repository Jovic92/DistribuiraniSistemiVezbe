
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rasporedFaultType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rasporedFaultType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rasporedFault" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rasporedFaultType", propOrder = {
    "rasporedFault"
})
public class RasporedFaultType {

    @XmlElement(required = true)
    protected String rasporedFault;

    /**
     * Gets the value of the rasporedFault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRasporedFault() {
        return rasporedFault;
    }

    /**
     * Sets the value of the rasporedFault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRasporedFault(String value) {
        this.rasporedFault = value;
    }

}
