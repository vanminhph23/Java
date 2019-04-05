
package com.isofh.signer.viettel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for verifyFileResponceBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="verifyFileResponceBO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.viettel.com/}responceWsBO">
 *       &lt;sequence>
 *         &lt;element name="verifyFileResultBO" type="{http://ws.viettel.com/}verifyFileResultBO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "verifyFileResponceBO", propOrder = {
    "verifyFileResultBO"
})
public class VerifyFileResponceBO
    extends ResponceWsBO
{

    protected VerifyFileResultBO verifyFileResultBO;

    /**
     * Gets the value of the verifyFileResultBO property.
     * 
     * @return
     *     possible object is
     *     {@link VerifyFileResultBO }
     *     
     */
    public VerifyFileResultBO getVerifyFileResultBO() {
        return verifyFileResultBO;
    }

    /**
     * Sets the value of the verifyFileResultBO property.
     * 
     * @param value
     *     allowed object is
     *     {@link VerifyFileResultBO }
     *     
     */
    public void setVerifyFileResultBO(VerifyFileResultBO value) {
        this.verifyFileResultBO = value;
    }

}
