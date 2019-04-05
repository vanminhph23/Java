
package com.isofh.signer.viettel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responceWsBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responceWsBO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="objectError" type="{http://ws.viettel.com/}objectError" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responceWsBO", propOrder = {
    "objectError",
    "status"
})
@XmlSeeAlso({
    CertListResponceBO.class,
    SignDataBase64ResponceBO.class,
    CertInfoResponceBO.class,
    VerifyFileResponceBO.class,
    VerifySignatureBase64ResponceBO.class,
    SignFileResponceBO.class
})
public class ResponceWsBO {

    protected ObjectError objectError;
    protected boolean status;

    /**
     * Gets the value of the objectError property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectError }
     *     
     */
    public ObjectError getObjectError() {
        return objectError;
    }

    /**
     * Sets the value of the objectError property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectError }
     *     
     */
    public void setObjectError(ObjectError value) {
        this.objectError = value;
    }

    /**
     * Gets the value of the status property.
     * 
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     */
    public void setStatus(boolean value) {
        this.status = value;
    }

}
