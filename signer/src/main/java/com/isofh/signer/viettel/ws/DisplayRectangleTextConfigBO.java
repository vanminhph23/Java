
package com.isofh.signer.viettel.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for displayRectangleTextConfigBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="displayRectangleTextConfigBO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contact" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateFormatString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fontPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formatRectangleText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="heightRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="locateSign" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marginBottomOfRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="marginLeftOfRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="marginRightOfRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="marginTopOfRectangle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="numberPageSign" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organizationUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="sizeFont" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "displayRectangleTextConfigBO", propOrder = {
    "contact",
    "dateFormatString",
    "displayText",
    "fontPath",
    "formatRectangleText",
    "heightRectangle",
    "locateSign",
    "location",
    "marginBottomOfRectangle",
    "marginLeftOfRectangle",
    "marginRightOfRectangle",
    "marginTopOfRectangle",
    "numberPageSign",
    "organization",
    "organizationUnit",
    "reason",
    "signDate",
    "sizeFont",
    "widthRectangle"
})
public class DisplayRectangleTextConfigBO {

    protected String contact;
    protected String dateFormatString;
    protected String displayText;
    protected String fontPath;
    protected String formatRectangleText;
    protected float heightRectangle;
    protected int locateSign;
    protected String location;
    protected float marginBottomOfRectangle;
    protected float marginLeftOfRectangle;
    protected float marginRightOfRectangle;
    protected float marginTopOfRectangle;
    protected int numberPageSign;
    protected String organization;
    protected String organizationUnit;
    protected String reason;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar signDate;
    protected int sizeFont;
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
     * Gets the value of the dateFormatString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFormatString() {
        return dateFormatString;
    }

    /**
     * Sets the value of the dateFormatString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFormatString(String value) {
        this.dateFormatString = value;
    }

    /**
     * Gets the value of the displayText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayText() {
        return displayText;
    }

    /**
     * Sets the value of the displayText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayText(String value) {
        this.displayText = value;
    }

    /**
     * Gets the value of the fontPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontPath() {
        return fontPath;
    }

    /**
     * Sets the value of the fontPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontPath(String value) {
        this.fontPath = value;
    }

    /**
     * Gets the value of the formatRectangleText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatRectangleText() {
        return formatRectangleText;
    }

    /**
     * Sets the value of the formatRectangleText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatRectangleText(String value) {
        this.formatRectangleText = value;
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
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganization(String value) {
        this.organization = value;
    }

    /**
     * Gets the value of the organizationUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationUnit() {
        return organizationUnit;
    }

    /**
     * Sets the value of the organizationUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationUnit(String value) {
        this.organizationUnit = value;
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
     * Gets the value of the sizeFont property.
     * 
     */
    public int getSizeFont() {
        return sizeFont;
    }

    /**
     * Sets the value of the sizeFont property.
     * 
     */
    public void setSizeFont(int value) {
        this.sizeFont = value;
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
