
package com.isofh.signer.viettel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timestampConfig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="timestampConfig">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tsa_acc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tsa_pass" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tsa_url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="useTimestamp" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timestampConfig", propOrder = {
    "tsaAcc",
    "tsaPass",
    "tsaUrl",
    "useTimestamp"
})
public class TimestampConfig {

    @XmlElement(name = "tsa_acc")
    protected String tsaAcc;
    @XmlElement(name = "tsa_pass")
    protected String tsaPass;
    @XmlElement(name = "tsa_url")
    protected String tsaUrl;
    protected boolean useTimestamp;

    /**
     * Gets the value of the tsaAcc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTsaAcc() {
        return tsaAcc;
    }

    /**
     * Sets the value of the tsaAcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTsaAcc(String value) {
        this.tsaAcc = value;
    }

    /**
     * Gets the value of the tsaPass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTsaPass() {
        return tsaPass;
    }

    /**
     * Sets the value of the tsaPass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTsaPass(String value) {
        this.tsaPass = value;
    }

    /**
     * Gets the value of the tsaUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTsaUrl() {
        return tsaUrl;
    }

    /**
     * Sets the value of the tsaUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTsaUrl(String value) {
        this.tsaUrl = value;
    }

    /**
     * Gets the value of the useTimestamp property.
     * 
     */
    public boolean isUseTimestamp() {
        return useTimestamp;
    }

    /**
     * Sets the value of the useTimestamp property.
     * 
     */
    public void setUseTimestamp(boolean value) {
        this.useTimestamp = value;
    }

}
