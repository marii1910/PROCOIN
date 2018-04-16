
package TipoCambio;

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
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "wsIndicadoresEconomicos", targetNamespace = "http://ws.sdde.bccr.fi.cr", wsdlLocation = "http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsIndicadoresEconomicos.asmx?WSDL")
public class WsIndicadoresEconomicos
    extends Service
{

    private final static URL WSINDICADORESECONOMICOS_WSDL_LOCATION;
    private final static WebServiceException WSINDICADORESECONOMICOS_EXCEPTION;
    private final static QName WSINDICADORESECONOMICOS_QNAME = new QName("http://ws.sdde.bccr.fi.cr", "wsIndicadoresEconomicos");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://indicadoreseconomicos.bccr.fi.cr/indicadoreseconomicos/WebServices/wsIndicadoresEconomicos.asmx?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSINDICADORESECONOMICOS_WSDL_LOCATION = url;
        WSINDICADORESECONOMICOS_EXCEPTION = e;
    }

    public WsIndicadoresEconomicos() {
        super(__getWsdlLocation(), WSINDICADORESECONOMICOS_QNAME);
    }

    public WsIndicadoresEconomicos(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSINDICADORESECONOMICOS_QNAME, features);
    }

    public WsIndicadoresEconomicos(URL wsdlLocation) {
        super(wsdlLocation, WSINDICADORESECONOMICOS_QNAME);
    }

    public WsIndicadoresEconomicos(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSINDICADORESECONOMICOS_QNAME, features);
    }

    public WsIndicadoresEconomicos(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsIndicadoresEconomicos(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WsIndicadoresEconomicosSoap
     */
    @WebEndpoint(name = "wsIndicadoresEconomicosSoap")
    public WsIndicadoresEconomicosSoap getWsIndicadoresEconomicosSoap() {
        return super.getPort(new QName("http://ws.sdde.bccr.fi.cr", "wsIndicadoresEconomicosSoap"), WsIndicadoresEconomicosSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsIndicadoresEconomicosSoap
     */
    @WebEndpoint(name = "wsIndicadoresEconomicosSoap")
    public WsIndicadoresEconomicosSoap getWsIndicadoresEconomicosSoap(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.sdde.bccr.fi.cr", "wsIndicadoresEconomicosSoap"), WsIndicadoresEconomicosSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WsIndicadoresEconomicosSoap
     */
    @WebEndpoint(name = "wsIndicadoresEconomicosSoap12")
    public WsIndicadoresEconomicosSoap getWsIndicadoresEconomicosSoap12() {
        return super.getPort(new QName("http://ws.sdde.bccr.fi.cr", "wsIndicadoresEconomicosSoap12"), WsIndicadoresEconomicosSoap.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsIndicadoresEconomicosSoap
     */
    @WebEndpoint(name = "wsIndicadoresEconomicosSoap12")
    public WsIndicadoresEconomicosSoap getWsIndicadoresEconomicosSoap12(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.sdde.bccr.fi.cr", "wsIndicadoresEconomicosSoap12"), WsIndicadoresEconomicosSoap.class, features);
    }

    /**
     * 
     * @return
     *     returns WsIndicadoresEconomicosHttpGet
     */
    @WebEndpoint(name = "wsIndicadoresEconomicosHttpGet")
    public WsIndicadoresEconomicosHttpGet getWsIndicadoresEconomicosHttpGet() {
        return super.getPort(new QName("http://ws.sdde.bccr.fi.cr", "wsIndicadoresEconomicosHttpGet"), WsIndicadoresEconomicosHttpGet.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsIndicadoresEconomicosHttpGet
     */
    @WebEndpoint(name = "wsIndicadoresEconomicosHttpGet")
    public WsIndicadoresEconomicosHttpGet getWsIndicadoresEconomicosHttpGet(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.sdde.bccr.fi.cr", "wsIndicadoresEconomicosHttpGet"), WsIndicadoresEconomicosHttpGet.class, features);
    }

    /**
     * 
     * @return
     *     returns WsIndicadoresEconomicosHttpPost
     */
    @WebEndpoint(name = "wsIndicadoresEconomicosHttpPost")
    public WsIndicadoresEconomicosHttpPost getWsIndicadoresEconomicosHttpPost() {
        return super.getPort(new QName("http://ws.sdde.bccr.fi.cr", "wsIndicadoresEconomicosHttpPost"), WsIndicadoresEconomicosHttpPost.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsIndicadoresEconomicosHttpPost
     */
    @WebEndpoint(name = "wsIndicadoresEconomicosHttpPost")
    public WsIndicadoresEconomicosHttpPost getWsIndicadoresEconomicosHttpPost(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.sdde.bccr.fi.cr", "wsIndicadoresEconomicosHttpPost"), WsIndicadoresEconomicosHttpPost.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSINDICADORESECONOMICOS_EXCEPTION!= null) {
            throw WSINDICADORESECONOMICOS_EXCEPTION;
        }
        return WSINDICADORESECONOMICOS_WSDL_LOCATION;
    }

}
