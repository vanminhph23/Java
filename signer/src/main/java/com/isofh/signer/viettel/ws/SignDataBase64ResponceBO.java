
package com.isofh.signer.viettel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signDataBase64ResponceBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signDataBase64ResponceBO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.viettel.com/}responceWsBO">
 *       &lt;sequence>
 *         &lt;element name="signatureBase64" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signDataBase64ResponceBO", propOrder = {
    "signatureBase64"
})
public class SignDataBase64ResponceBO
    extends ResponceWsBO
{

    protected String signatureBase64;

    /**
     * Gets the value of the signatureBase64 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignatureBase64() {
        return signatureBase64;
    }

    /**
     * Sets the value of the signatureBase64 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignatureBase64(String value) {
        this.signatureBase64 = value;
    }

}
