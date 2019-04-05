
package com.isofh.signer.viettel.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for displayTableConfigBO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="displayTableConfigBO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="alignmentArray" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="backgroundColorTitle" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fontPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fontSizeTitlePageSign" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="heightRowTitlePageSign" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="heightTitle" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="isDisplayTitlePageSign" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="marginBottomOfTable" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="marginRightOfTable" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="marginTopOfTable" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="maxPageSign" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pageSize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="sizeFont" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="textArray" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="titlePageSign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="titles" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="totalPageSign" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="widthsPercen" type="{http://www.w3.org/2001/XMLSchema}float" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "displayTableConfigBO", propOrder = {
    "alignmentArray",
    "backgroundColorTitle",
    "fontPath",
    "fontSizeTitlePageSign",
    "heightRowTitlePageSign",
    "heightTitle",
    "isDisplayTitlePageSign",
    "marginBottomOfTable",
    "marginRightOfTable",
    "marginTopOfTable",
    "maxPageSign",
    "pageSize",
    "signDate",
    "sizeFont",
    "textArray",
    "titlePageSign",
    "titles",
    "totalPageSign",
    "widthsPercen"
})
public class DisplayTableConfigBO {

    @XmlElement(nillable = true)
    protected List<Integer> alignmentArray;
    @XmlElement(nillable = true)
    protected List<Integer> backgroundColorTitle;
    protected String fontPath;
    protected int fontSizeTitlePageSign;
    protected float heightRowTitlePageSign;
    protected float heightTitle;
    protected boolean isDisplayTitlePageSign;
    protected float marginBottomOfTable;
    protected float marginRightOfTable;
    protected float marginTopOfTable;
    protected int maxPageSign;
    protected String pageSize;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar signDate;
    protected int sizeFont;
    @XmlElement(nillable = true)
    protected List<String> textArray;
    protected String titlePageSign;
    @XmlElement(nillable = true)
    protected List<String> titles;
    protected int totalPageSign;
    @XmlElement(nillable = true)
    protected List<Float> widthsPercen;

    /**
     * Gets the value of the alignmentArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alignmentArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlignmentArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getAlignmentArray() {
        if (alignmentArray == null) {
            alignmentArray = new ArrayList<Integer>();
        }
        return this.alignmentArray;
    }

    /**
     * Gets the value of the backgroundColorTitle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the backgroundColorTitle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBackgroundColorTitle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getBackgroundColorTitle() {
        if (backgroundColorTitle == null) {
            backgroundColorTitle = new ArrayList<Integer>();
        }
        return this.backgroundColorTitle;
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
     * Gets the value of the fontSizeTitlePageSign property.
     * 
     */
    public int getFontSizeTitlePageSign() {
        return fontSizeTitlePageSign;
    }

    /**
     * Sets the value of the fontSizeTitlePageSign property.
     * 
     */
    public void setFontSizeTitlePageSign(int value) {
        this.fontSizeTitlePageSign = value;
    }

    /**
     * Gets the value of the heightRowTitlePageSign property.
     * 
     */
    public float getHeightRowTitlePageSign() {
        return heightRowTitlePageSign;
    }

    /**
     * Sets the value of the heightRowTitlePageSign property.
     * 
     */
    public void setHeightRowTitlePageSign(float value) {
        this.heightRowTitlePageSign = value;
    }

    /**
     * Gets the value of the heightTitle property.
     * 
     */
    public float getHeightTitle() {
        return heightTitle;
    }

    /**
     * Sets the value of the heightTitle property.
     * 
     */
    public void setHeightTitle(float value) {
        this.heightTitle = value;
    }

    /**
     * Gets the value of the isDisplayTitlePageSign property.
     * 
     */
    public boolean isIsDisplayTitlePageSign() {
        return isDisplayTitlePageSign;
    }

    /**
     * Sets the value of the isDisplayTitlePageSign property.
     * 
     */
    public void setIsDisplayTitlePageSign(boolean value) {
        this.isDisplayTitlePageSign = value;
    }

    /**
     * Gets the value of the marginBottomOfTable property.
     * 
     */
    public float getMarginBottomOfTable() {
        return marginBottomOfTable;
    }

    /**
     * Sets the value of the marginBottomOfTable property.
     * 
     */
    public void setMarginBottomOfTable(float value) {
        this.marginBottomOfTable = value;
    }

    /**
     * Gets the value of the marginRightOfTable property.
     * 
     */
    public float getMarginRightOfTable() {
        return marginRightOfTable;
    }

    /**
     * Sets the value of the marginRightOfTable property.
     * 
     */
    public void setMarginRightOfTable(float value) {
        this.marginRightOfTable = value;
    }

    /**
     * Gets the value of the marginTopOfTable property.
     * 
     */
    public float getMarginTopOfTable() {
        return marginTopOfTable;
    }

    /**
     * Sets the value of the marginTopOfTable property.
     * 
     */
    public void setMarginTopOfTable(float value) {
        this.marginTopOfTable = value;
    }

    /**
     * Gets the value of the maxPageSign property.
     * 
     */
    public int getMaxPageSign() {
        return maxPageSign;
    }

    /**
     * Sets the value of the maxPageSign property.
     * 
     */
    public void setMaxPageSign(int value) {
        this.maxPageSign = value;
    }

    /**
     * Gets the value of the pageSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageSize() {
        return pageSize;
    }

    /**
     * Sets the value of the pageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageSize(String value) {
        this.pageSize = value;
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
     * Gets the value of the textArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTextArray() {
        if (textArray == null) {
            textArray = new ArrayList<String>();
        }
        return this.textArray;
    }

    /**
     * Gets the value of the titlePageSign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitlePageSign() {
        return titlePageSign;
    }

    /**
     * Sets the value of the titlePageSign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitlePageSign(String value) {
        this.titlePageSign = value;
    }

    /**
     * Gets the value of the titles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the titles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTitles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTitles() {
        if (titles == null) {
            titles = new ArrayList<String>();
        }
        return this.titles;
    }

    /**
     * Gets the value of the totalPageSign property.
     * 
     */
    public int getTotalPageSign() {
        return totalPageSign;
    }

    /**
     * Sets the value of the totalPageSign property.
     * 
     */
    public void setTotalPageSign(int value) {
        this.totalPageSign = value;
    }

    /**
     * Gets the value of the widthsPercen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the widthsPercen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWidthsPercen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Float }
     * 
     * 
     */
    public List<Float> getWidthsPercen() {
        if (widthsPercen == null) {
            widthsPercen = new ArrayList<Float>();
        }
        return this.widthsPercen;
    }

}
