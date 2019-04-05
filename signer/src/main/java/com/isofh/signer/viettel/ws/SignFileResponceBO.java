
package com.isofh.signer.viettel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for signFileResponceBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="signFileResponceBO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.viettel.com/}responceWsBO">
 *       &lt;sequence>
 *         &lt;element name="signedFileBase64" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "signFileResponceBO", propOrder = {
    "signedFileBase64"
})
public class SignFileResponceBO
    extends ResponceWsBO
{

    protected String signedFileBase64;

    /**
     * Gets the value of the signedFileBase64 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSignedFileBase64() {
        return signedFileBase64;
    }

    /**
     * Sets the value of the signedFileBase64 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSignedFileBase64(String value) {
        this.signedFileBase64 = value;
    }

}
