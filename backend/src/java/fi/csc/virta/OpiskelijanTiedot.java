
package fi.csc.virta;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "OpiskelijanTiedot", targetNamespace = "http://tietovaranto.csc.fi/luku")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface OpiskelijanTiedot {


    /**
     * 
     * @param opintosuorituksetRequest
     * @return
     *     returns fi.csc.virta.OpintosuorituksetResponse
     */
    @WebMethod(operationName = "Opintosuoritukset")
    @WebResult(name = "OpintosuorituksetResponse", targetNamespace = "http://tietovaranto.csc.fi/luku", partName = "OpintosuorituksetResponse")
    public OpintosuorituksetResponse opintosuoritukset(
        @WebParam(name = "OpintosuorituksetRequest", targetNamespace = "http://tietovaranto.csc.fi/luku", partName = "OpintosuorituksetRequest")
        OpintosuorituksetRequest opintosuorituksetRequest);

    /**
     * 
     * @param opiskelijanTiedotRequest
     * @return
     *     returns fi.csc.virta.OpiskelijanTiedotResponse
     */
    @WebMethod(operationName = "OpiskelijanTiedot")
    @WebResult(name = "OpiskelijanTiedotResponse", targetNamespace = "http://tietovaranto.csc.fi/luku", partName = "OpiskelijanTiedotResponse")
    public OpiskelijanTiedotResponse opiskelijanTiedot(
        @WebParam(name = "OpiskelijanTiedotRequest", targetNamespace = "http://tietovaranto.csc.fi/luku", partName = "OpiskelijanTiedotRequest")
        OpiskelijanTiedotRequest opiskelijanTiedotRequest);

    /**
     * 
     * @param opiskeluoikeudetRequest
     * @return
     *     returns fi.csc.virta.OpiskeluoikeudetResponse
     */
    @WebMethod(operationName = "Opiskeluoikeudet")
    @WebResult(name = "OpiskeluoikeudetResponse", targetNamespace = "http://tietovaranto.csc.fi/luku", partName = "OpiskeluoikeudetResponse")
    public OpiskeluoikeudetResponse opiskeluoikeudet(
        @WebParam(name = "OpiskeluoikeudetRequest", targetNamespace = "http://tietovaranto.csc.fi/luku", partName = "OpiskeluoikeudetRequest")
        OpiskeluoikeudetRequest opiskeluoikeudetRequest);

    /**
     * 
     * @param opiskelijanKaikkiTiedotRequest
     * @return
     *     returns fi.csc.virta.OpiskelijanKaikkiTiedotResponse
     */
    @WebMethod(operationName = "OpiskelijanKaikkiTiedot")
    @WebResult(name = "OpiskelijanKaikkiTiedotResponse", targetNamespace = "http://tietovaranto.csc.fi/luku", partName = "OpiskelijanKaikkiTiedotResponse")
    public OpiskelijanKaikkiTiedotResponse opiskelijanKaikkiTiedot(
        @WebParam(name = "OpiskelijanKaikkiTiedotRequest", targetNamespace = "http://tietovaranto.csc.fi/luku", partName = "OpiskelijanKaikkiTiedotRequest")
        OpiskelijanKaikkiTiedotRequest opiskelijanKaikkiTiedotRequest);

    /**
     * 
     * @param lukukausiIlmoittautumisetRequest
     * @return
     *     returns fi.csc.virta.LukukausiIlmoittautumisetResponse
     */
    @WebMethod(operationName = "LukukausiIlmoittautumiset")
    @WebResult(name = "LukukausiIlmoittautumisetResponse", targetNamespace = "http://tietovaranto.csc.fi/luku", partName = "LukukausiIlmoittautumisetResponse")
    public LukukausiIlmoittautumisetResponse lukukausiIlmoittautumiset(
        @WebParam(name = "LukukausiIlmoittautumisetRequest", targetNamespace = "http://tietovaranto.csc.fi/luku", partName = "LukukausiIlmoittautumisetRequest")
        LukukausiIlmoittautumisetRequest lukukausiIlmoittautumisetRequest);

}
