
package com.isofh.signer.viettel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for displayImageConfigBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="displayImageConfigBO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fileImageBase64" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="heightRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="locateSign" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marginBottomOfRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="marginLeftOfRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="marginRightOfRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="marginTopOfRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="numberPageSign" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pathImage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="widthRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "displayImageConfigBO", propOrder = {
    "contact",
    "fileImageBase64",
    "heightRectangle",
    "locateSign",
    "location",
    "marginBottomOfRectangle",
    "marginLeftOfRectangle",
    "marginRightOfRectangle",
    "marginTopOfRectangle",
    "numberPageSign",
    "pathImage",
    "reason",
    "signDate",
    "widthRectangle"
})
public class DisplayImageConfigBO {

    protected String contact;
    protected String fileImageBase64;
    protected float heightRectangle;
    protected int locateSign;
    protected String location;
    protected float marginBottomOfRectangle;
    protected float marginLeftOfRectangle;
    protected float marginRightOfRectangle;
    protected float marginTopOfRectangle;
    protected int numberPageSign;
    protected String pathImage;
    protected String reason;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar signDate;
    protected float widthRectangle;

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContact(String value) {
        this.contact = value;
    }

    /**
     * Gets the value of the fileImageBase64 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileImageBase64() {
        return fileImageBase64;
    }

    /**
     * Sets the value of the fileImageBase64 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileImageBase64(String value) {
        this.fileImageBase64 = value;
    }

    /**
     * Gets the value of the heightRectangle property.
     * 
     */
    public float getHeightRectangle() {
        return heightRectangle;
    }

    /**
     * Sets the value of the heightRectangle property.
     * 
     */
    public void setHeightRectangle(float value) {
        this.heightRectangle = value;
    }

    /**
     * Gets the value of the locateSign property.
     * 
     */
    public int getLocateSign() {
        return locateSign;
    }

    /**
     * Sets the value of the locateSign property.
     * 
     */
    public void setLocateSign(int value) {
        this.locateSign = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the marginBottomOfRectangle property.
     * 
     */
    public float getMarginBottomOfRectangle() {
        return marginBottomOfRectangle;
    }

    /**
     * Sets the value of the marginBottomOfRectangle property.
     * 
     */
    public void setMarginBottomOfRectangle(float value) {
        this.marginBottomOfRectangle = value;
    }

    /**
     * Gets the value of the marginLeftOfRectangle property.
     * 
     */
    public float getMarginLeftOfRectangle() {
        return marginLeftOfRectangle;
    }

    /**
     * Sets the value of the marginLeftOfRectangle property.
     * 
     */
    public void setMarginLeftOfRectangle(float value) {
        this.marginLeftOfRectangle = value;
    }

    /**
     * Gets the value of the marginRightOfRectangle property.
     * 
     */
    public float getMarginRightOfRectangle() {
        return marginRightOfRectangle;
    }

    /**
     * Sets the value of the marginRightOfRectangle property.
     * 
     */
    public void setMarginRightOfRectangle(float value) {
        this.marginRightOfRectangle = value;
    }

    /**
     * Gets the value of the marginTopOfRectangle property.
     * 
     */
    public float getMarginTopOfRectangle() {
        return marginTopOfRectangle;
    }

    /**
     * Sets the value of the marginTopOfRectangle property.
     * 
     */
    public void setMarginTopOfRectangle(float value) {
        this.marginTopOfRectangle = value;
    }

    /**
     * Gets the value of the numberPageSign property.
     * 
     */
    public int getNumberPageSign() {
        return numberPageSign;
    }

    /**
     * Sets the value of the numberPageSign property.
     * 
     */
    public void setNumberPageSign(int value) {
        this.numberPageSign = value;
    }

    /**
     * Gets the value of the pathImage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPathImage() {
        return pathImage;
    }

    /**
     * Sets the value of the pathImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPathImage(String value) {
        this.pathImage = value;
    }

    /**
     * Gets the value of the reason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReason(String value) {
        this.reason = value;
    }

    /**
     * Gets the value of the signDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSignDate() {
        return signDate;
    }

    /**
     * Sets the value of the signDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSignDate(XMLGregorianCalendar value) {
        this.signDate = value;
    }

    /**
     * Gets the value of the widthRectangle property.
     * 
     */
    public float getWidthRectangle() {
        return widthRectangle;
    }

    /**
     * Sets the value of the widthRectangle property.
     * 
     */
    public void setWidthRectangle(float value) {
        this.widthRectangle = value;
    }

}
