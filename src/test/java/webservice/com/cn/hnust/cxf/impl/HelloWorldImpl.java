
package webservice.com.cn.hnust.cxf.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloWorldImpl", targetNamespace = "http://impl.cxf.hnust.cn.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloWorldImpl {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "say", targetNamespace = "http://impl.cxf.hnust.cn.com/", className = "com.cn.hnust.cxf.impl.Say")
    @ResponseWrapper(localName = "sayResponse", targetNamespace = "http://impl.cxf.hnust.cn.com/", className = "com.cn.hnust.cxf.impl.SayResponse")
    public String say(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}