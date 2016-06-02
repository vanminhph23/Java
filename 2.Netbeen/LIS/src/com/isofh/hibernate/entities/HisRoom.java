package com.isofh.hibernate.entities;
// Generated Jun 2, 2016 11:45:36 AM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * HisRoom generated by hbm2java
 */
public class HisRoom  implements java.io.Serializable {


     private long hisRoomId;
     private Long adClientId;
     private Long adOrgId;
     private Date created;
     private Long createdby;
     private Character isactive;
     private String name;
     private Date updated;
     private Long updatedby;
     private BigDecimal hisRoomtypeId;
     private BigDecimal hisDepartmentId;
     private String englishname;
     private Long hisSpecialistId;
     private String locationcomment;
     private String description;
     private Long bedquantity;
     private String location;
     private String value;
     private Character isready;
     private Character isemergency;
     private Character isinpatient;
     private Character isoutpatient;
     private Long hisBuildingId;
     private Long patientquantity;
     private String hisRoomtype;

    public HisRoom() {
    }

	
    public HisRoom(long hisRoomId, String name) {
        this.hisRoomId = hisRoomId;
        this.name = name;
    }
    public HisRoom(long hisRoomId, Long adClientId, Long adOrgId, Date created, Long createdby, Character isactive, String name, Date updated, Long updatedby, BigDecimal hisRoomtypeId, BigDecimal hisDepartmentId, String englishname, Long hisSpecialistId, String locationcomment, String description, Long bedquantity, String location, String value, Character isready, Character isemergency, Character isinpatient, Character isoutpatient, Long hisBuildingId, Long patientquantity, String hisRoomtype) {
       this.hisRoomId = hisRoomId;
       this.adClientId = adClientId;
       this.adOrgId = adOrgId;
       this.created = created;
       this.createdby = createdby;
       this.isactive = isactive;
       this.name = name;
       this.updated = updated;
       this.updatedby = updatedby;
       this.hisRoomtypeId = hisRoomtypeId;
       this.hisDepartmentId = hisDepartmentId;
       this.englishname = englishname;
       this.hisSpecialistId = hisSpecialistId;
       this.locationcomment = locationcomment;
       this.description = description;
       this.bedquantity = bedquantity;
       this.location = location;
       this.value = value;
       this.isready = isready;
       this.isemergency = isemergency;
       this.isinpatient = isinpatient;
       this.isoutpatient = isoutpatient;
       this.hisBuildingId = hisBuildingId;
       this.patientquantity = patientquantity;
       this.hisRoomtype = hisRoomtype;
    }
   
    public long getHisRoomId() {
        return this.hisRoomId;
    }
    
    public void setHisRoomId(long hisRoomId) {
        this.hisRoomId = hisRoomId;
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
    public Character getIsactive() {
        return this.isactive;
    }
    
    public void setIsactive(Character isactive) {
        this.isactive = isactive;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
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
    public BigDecimal getHisRoomtypeId() {
        return this.hisRoomtypeId;
    }
    
    public void setHisRoomtypeId(BigDecimal hisRoomtypeId) {
        this.hisRoomtypeId = hisRoomtypeId;
    }
    public BigDecimal getHisDepartmentId() {
        return this.hisDepartmentId;
    }
    
    public void setHisDepartmentId(BigDecimal hisDepartmentId) {
        this.hisDepartmentId = hisDepartmentId;
    }
    public String getEnglishname() {
        return this.englishname;
    }
    
    public void setEnglishname(String englishname) {
        this.englishname = englishname;
    }
    public Long getHisSpecialistId() {
        return this.hisSpecialistId;
    }
    
    public void setHisSpecialistId(Long hisSpecialistId) {
        this.hisSpecialistId = hisSpecialistId;
    }
    public String getLocationcomment() {
        return this.locationcomment;
    }
    
    public void setLocationcomment(String locationcomment) {
        this.locationcomment = locationcomment;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getBedquantity() {
        return this.bedquantity;
    }
    
    public void setBedquantity(Long bedquantity) {
        this.bedquantity = bedquantity;
    }
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    public Character getIsready() {
        return this.isready;
    }
    
    public void setIsready(Character isready) {
        this.isready = isready;
    }
    public Character getIsemergency() {
        return this.isemergency;
    }
    
    public void setIsemergency(Character isemergency) {
        this.isemergency = isemergency;
    }
    public Character getIsinpatient() {
        return this.isinpatient;
    }
    
    public void setIsinpatient(Character isinpatient) {
        this.isinpatient = isinpatient;
    }
    public Character getIsoutpatient() {
        return this.isoutpatient;
    }
    
    public void setIsoutpatient(Character isoutpatient) {
        this.isoutpatient = isoutpatient;
    }
    public Long getHisBuildingId() {
        return this.hisBuildingId;
    }
    
    public void setHisBuildingId(Long hisBuildingId) {
        this.hisBuildingId = hisBuildingId;
    }
    public Long getPatientquantity() {
        return this.patientquantity;
    }
    
    public void setPatientquantity(Long patientquantity) {
        this.patientquantity = patientquantity;
    }
    public String getHisRoomtype() {
        return this.hisRoomtype;
    }
    
    public void setHisRoomtype(String hisRoomtype) {
        this.hisRoomtype = hisRoomtype;
    }




}


