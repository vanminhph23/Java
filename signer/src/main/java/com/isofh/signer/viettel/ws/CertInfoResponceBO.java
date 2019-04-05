
package com.isofh.signer.viettel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for certInfoResponceBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="certInfoResponceBO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.viettel.com/}responceWsBO">
 *       &lt;sequence>
 *         &lt;element name="certBO" type="{http://ws.viettel.com/}certBO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "certInfoResponceBO", propOrder = {
    "certBO"
})
public class CertInfoResponceBO
    extends ResponceWsBO
{

    protected CertBO certBO;

    /**
     * Gets the value of the certBO property.
     * 
     * @return
     *     possible object is
     *     {@link CertBO }
     *     
     */
    public CertBO getCertBO() {
        return certBO;
    }

    /**
     * Sets the value of the certBO property.
     * 
     * @param value
     *     allowed object is
     *     {@link CertBO }
     *     
     */
    public void setCertBO(CertBO value) {
        this.certBO = value;
    }

}
