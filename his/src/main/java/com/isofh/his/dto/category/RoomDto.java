package com.isofh.his.dto.category;

import com.isofh.his.dto.base.BaseCategoryDto;

public class RoomDto extends BaseCategoryDto {

    public RoomDto() {
    }

    private Long departmentId;

    private int roomType;

    private Long buildingId;

    private Long specialistId;

    private boolean inpatient = false;

    private boolean outpatient = false;

    private boolean emergency = false;

    private boolean defaultRoom = false;

    private boolean autoPostVisualize = false;

    private int startNo = 0;

    private int bedQuantity = 0;

    private Long speakerId;

    private int sequenceNo = 0;

    private Long parentRoomId;

    private String note;

    private String location;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public Long getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(Long specialistId) {
        this.specialistId = specialistId;
    }

    public boolean isInpatient() {
        return inpatient;
    }

    public void setInpatient(boolean inpatient) {
        this.inpatient = inpatient;
    }

    public boolean isOutpatient() {
        return outpatient;
    }

    public void setOutpatient(boolean outpatient) {
        this.outpatient = outpatient;
    }

    public boolean isEmergency() {
        return emergency;
    }

    public void setEmergency(boolean emergency) {
        this.emergency = emergency;
    }

    public boolean isDefaultRoom() {
        return defaultRoom;
    }

    public void setDefaultRoom(boolean defaultRoom) {
        this.defaultRoom = defaultRoom;
    }

    public boolean isAutoPostVisualize() {
        return autoPostVisualize;
    }

    public void setAutoPostVisualize(boolean autoPostVisualize) {
        this.autoPostVisualize = autoPostVisualize;
    }

    public int getStartNo() {
        return startNo;
    }

    public void setStartNo(int startNo) {
        this.startNo = startNo;
    }

    public int getBedQuantity() {
        return bedQuantity;
    }

    public void setBedQuantity(int bedQuantity) {
        this.bedQuantity = bedQuantity;
    }

    public Long getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(Long speakerId) {
        this.speakerId = speakerId;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Long getParentRoomId() {
        return parentRoomId;
    }

    public void setParentRoomId(Long parentRoomId) {
        this.parentRoomId = parentRoomId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
