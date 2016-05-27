package com.isofh.hibernate.entities;
// Generated May 26, 2016 9:09:09 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * HisMedicaltestline generated by hbm2java
 */
public class HisMedicaltestline  implements java.io.Serializable {


     private long hisMedicaltestlineId;
     private Long adClientId;
     private Long adOrgId;
     private Date created;
     private Long createdby;
     private String hisMedicaltestlineUu;
     private String higherindicatorfemale;
     private String higherindicatormale;
     private Character isactive;
     private String lowerindicatorfemale;
     private String lowerindicatormale;
     private String name;
     private String note;
     private String unit;
     private Date updated;
     private Long updatedby;
     private String value;
     private Long hisMedicaltestId;
     private Long CUomId;
     private String hisLisCode;
     private String unitprint;
     private String higherindicator;
     private String lowerindicator;
     private long printorder;

    public HisMedicaltestline() {
    }

	
    public HisMedicaltestline(long hisMedicaltestlineId, String hisLisCode, long printorder) {
        this.hisMedicaltestlineId = hisMedicaltestlineId;
        this.hisLisCode = hisLisCode;
        this.printorder = printorder;
    }
    public HisMedicaltestline(long hisMedicaltestlineId, Long adClientId, Long adOrgId, Date created, Long createdby, String hisMedicaltestlineUu, String higherindicatorfemale, String higherindicatormale, Character isactive, String lowerindicatorfemale, String lowerindicatormale, String name, String note, String unit, Date updated, Long updatedby, String value, Long hisMedicaltestId, Long CUomId, String hisLisCode, String unitprint, String higherindicator, String lowerindicator, long printorder) {
       this.hisMedicaltestlineId = hisMedicaltestlineId;
       this.adClientId = adClientId;
       this.adOrgId = adOrgId;
       this.created = created;
       this.createdby = createdby;
       this.hisMedicaltestlineUu = hisMedicaltestlineUu;
       this.higherindicatorfemale = higherindicatorfemale;
       this.higherindicatormale = higherindicatormale;
       this.isactive = isactive;
       this.lowerindicatorfemale = lowerindicatorfemale;
       this.lowerindicatormale = lowerindicatormale;
       this.name = name;
       this.note = note;
       this.unit = unit;
       this.updated = updated;
       this.updatedby = updatedby;
       this.value = value;
       this.hisMedicaltestId = hisMedicaltestId;
       this.CUomId = CUomId;
       this.hisLisCode = hisLisCode;
       this.unitprint = unitprint;
       this.higherindicator = higherindicator;
       this.lowerindicator = lowerindicator;
       this.printorder = printorder;
    }
   
    public long getHisMedicaltestlineId() {
        return this.hisMedicaltestlineId;
    }
    
    public void setHisMedicaltestlineId(long hisMedicaltestlineId) {
        this.hisMedicaltestlineId = hisMedicaltestlineId;
    }
    public Long getAdClientId() {
        return this.adClientId;
    }
    
    public void setAdClientId(Long adClientId) {
        this.adClientId = adClientId;
    }
    public Long getAdOrgId() {
        return this.adOrgId;
    }
    
    public void setAdOrgId(Long adOrgId) {
        this.adOrgId = adOrgId;
    }
    public Date getCreated() {
        return this.created;
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }
    public Long getCreatedby() {
        return this.createdby;
    }
    
    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }
    public String getHisMedicaltestlineUu() {
        return this.hisMedicaltestlineUu;
    }
    
    public void setHisMedicaltestlineUu(String hisMedicaltestlineUu) {
        this.hisMedicaltestlineUu = hisMedicaltestlineUu;
    }
    public String getHigherindicatorfemale() {
        return this.higherindicatorfemale;
    }
    
    public void setHigherindicatorfemale(String higherindicatorfemale) {
        this.higherindicatorfemale = higherindicatorfemale;
    }
    public String getHigherindicatormale() {
        return this.higherindicatormale;
    }
    
    public void setHigherindicatormale(String higherindicatormale) {
        this.higherindicatormale = higherindicatormale;
    }
    public Character getIsactive() {
        return this.isactive;
    }
    
    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }
    public String getLowerindicatorfemale() {
        return this.lowerindicatorfemale;
    }
    
    public void setLowerindicatorfemale(String lowerindicatorfemale) {
        this.lowerindicatorfemale = lowerindicatorfemale;
    }
    public String getLowerindicatormale() {
        return this.lowerindicatormale;
    }
    
    public void setLowerindicatormale(String lowerindicatormale) {
        this.lowerindicatormale = lowerindicatormale;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public Date getUpdated() {
        return this.updated;
    }
    
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    public Long getUpdatedby() {
        return this.updatedby;
    }
    
    public void setUpdatedby(Long updatedby) {
        this.updatedby = updatedby;
    }
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    public Long getHisMedicaltestId() {
        return this.hisMedicaltestId;
    }
    
    public void setHisMedicaltestId(Long hisMedicaltestId) {
        this.hisMedicaltestId = hisMedicaltestId;
    }
    public Long getCUomId() {
        return this.CUomId;
    }
    
    public void setCUomId(Long CUomId) {
        this.CUomId = CUomId;
    }
    public String getHisLisCode() {
        return this.hisLisCode;
    }
    
    public void setHisLisCode(String hisLisCode) {
        this.hisLisCode = hisLisCode;
    }
    public String getUnitprint() {
        return this.unitprint;
    }
    
    public void setUnitprint(String unitprint) {
        this.unitprint = unitprint;
    }
    public String getHigherindicator() {
        return this.higherindicator;
    }
    
    public void setHigherindicator(String higherindicator) {
        this.higherindicator = higherindicator;
    }
    public String getLowerindicator() {
        return this.lowerindicator;
    }
    
    public void setLowerindicator(String lowerindicator) {
        this.lowerindicator = lowerindicator;
    }
    public long getPrintorder() {
        return this.printorder;
    }
    
    public void setPrintorder(long printorder) {
        this.printorder = printorder;
    }




}


