
package fi.csc.virta;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			Studies
 * 			* Root element for several studies
 * 		
 * 
 * <p>Java class for OpintosuorituksetTyyppi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OpintosuorituksetTyyppi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Opintosuoritus" type="{urn:mace:funet.fi:virta/2013/01/29}OpintosuoritusTyyppi" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpintosuorituksetTyyppi", propOrder = {
    "opintosuoritus"
})
@XmlSeeAlso({
    OpintosuorituksetLaajennettuTyyppi.class
})
public class OpintosuorituksetTyyppi {

    @XmlElement(name = "Opintosuoritus", required = true)
    protected List<OpintosuoritusTyyppi> opintosuoritus;

    /**
     * Gets the value of the opintosuoritus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opintosuoritus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpintosuoritus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpintosuoritusTyyppi }
     * 
     * 
     */
    public List<OpintosuoritusTyyppi> getOpintosuoritus() {
        if (opintosuoritus == null) {
            opintosuoritus = new ArrayList<OpintosuoritusTyyppi>();
        }
        return this.opintosuoritus;
    }

}
