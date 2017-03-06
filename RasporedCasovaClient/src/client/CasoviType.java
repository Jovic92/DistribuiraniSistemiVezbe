
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CasoviType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CasoviType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="predmet" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="dan" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CasoviType", propOrder = {
    "predmet",
    "dan"
})
public class CasoviType {

    @XmlElement(required = true)
    protected String predmet;
    @XmlElement(required = true)
    protected String dan;

    /**
     * Gets the value of the predmet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPredmet() {
        return predmet;
    }

    /**
     * Sets the value of the predmet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPredmet(String value) {
        this.predmet = value;
    }

    /**
     * Gets the value of the dan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDan() {
        return dan;
    }

    /**
     * Sets the value of the dan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDan(String value) {
        this.dan = value;
    }

}
