
package fi.csc.virta;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "OpiskelijanTiedotService", targetNamespace = "http://tietovaranto.csc.fi/luku", wsdlLocation = "http://virtawstesti.csc.fi/luku/opiskelijatiedot.wsdl")
public class OpiskelijanTiedotService
    extends Service
{

    private final static URL OPISKELIJANTIEDOTSERVICE_WSDL_LOCATION;
    private final static WebServiceException OPISKELIJANTIEDOTSERVICE_EXCEPTION;
    private final static QName OPISKELIJANTIEDOTSERVICE_QNAME = new QName("http://tietovaranto.csc.fi/luku", "OpiskelijanTiedotService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://virtawstesti.csc.fi/luku/opiskelijatiedot.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        OPISKELIJANTIEDOTSERVICE_WSDL_LOCATION = url;
        OPISKELIJANTIEDOTSERVICE_EXCEPTION = e;
    }

    public OpiskelijanTiedotService() {
        super(__getWsdlLocation(), OPISKELIJANTIEDOTSERVICE_QNAME);
    }

    public OpiskelijanTiedotService(WebServiceFeature... features) {
        super(__getWsdlLocation(), OPISKELIJANTIEDOTSERVICE_QNAME, features);
    }

    public OpiskelijanTiedotService(URL wsdlLocation) {
        super(wsdlLocation, OPISKELIJANTIEDOTSERVICE_QNAME);
    }

    public OpiskelijanTiedotService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, OPISKELIJANTIEDOTSERVICE_QNAME, features);
    }

    public OpiskelijanTiedotService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public OpiskelijanTiedotService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns OpiskelijanTiedot
     */
    @WebEndpoint(name = "OpiskelijanTiedotSoap11")
    public OpiskelijanTiedot getOpiskelijanTiedotSoap11() {
        return super.getPort(new QName("http://tietovaranto.csc.fi/luku", "OpiskelijanTiedotSoap11"), OpiskelijanTiedot.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OpiskelijanTiedot
     */
    @WebEndpoint(name = "OpiskelijanTiedotSoap11")
    public OpiskelijanTiedot getOpiskelijanTiedotSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://tietovaranto.csc.fi/luku", "OpiskelijanTiedotSoap11"), OpiskelijanTiedot.class, features);
    }

    private static URL __getWsdlLocation() {
        if (OPISKELIJANTIEDOTSERVICE_EXCEPTION!= null) {
            throw OPISKELIJANTIEDOTSERVICE_EXCEPTION;
        }
        return OPISKELIJANTIEDOTSERVICE_WSDL_LOCATION;
    }

}