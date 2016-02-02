
package fi.csc.virta;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Opiskelija" type="{urn:mace:funet.fi:virta/2013/01/29}OpiskelijaLaajennettuTyyppi" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:mace:funet.fi:virta/2013/01/29}JuuriElementtiLaajennusTyyppi"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "opiskelija"
})
@XmlRootElement(name = "Virta")
public class Virta {

    @XmlElement(name = "Opiskelija", required = true)
    protected List<OpiskelijaLaajennettuTyyppi> opiskelija;

    /**
     * Gets the value of the opiskelija property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the opiskelija property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpiskelija().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OpiskelijaLaajennettuTyyppi }
     * 
     * 
     */
    public List<OpiskelijaLaajennettuTyyppi> getOpiskelija() {
        if (opiskelija == null) {
            opiskelija = new ArrayList<OpiskelijaLaajennettuTyyppi>();
        }
        return this.opiskelija;
    }

}
