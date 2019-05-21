package com.isofh.his.model.category;

import com.isofh.his.model.base.BaseCategoryModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_room", uniqueConstraints={@UniqueConstraint(columnNames = {"value", "deleted"})})
public class Room extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "room_generator")
    @SequenceGenerator(
            name = "room_generator",
            sequenceName = "room_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "department_id", nullable = false)
    @Audited
    private Long departmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    @Column(name = "room_type")
    @Audited
    private int roomType;

    @Column(name = "building_id", nullable = false)
    @Audited
    private Long buildingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    private Building building;

    @Column(name = "specialist_id")
    @Audited
    private Long specialistId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialist_id", insertable = false, updatable = false)
    private Specialist specialist;

    @Column(name = "inpatient", nullable = false)
    @Audited
    private boolean inpatient = false;

    @Column(name = "outpatient", nullable = false)
    @Audited
    private boolean outpatient = false;

    @Column(name = "emergency", nullable = false)
    @Audited
    private boolean emergency = false;

    @Column(name = "default_room", nullable = false)
    @Audited
    private boolean defaultRoom = false;

    @Column(name = "auto_post_visualize", nullable = false)
    @Audited
    private boolean autoPostVisualize = false;

    @Column(name = "start_no", nullable = false)
    @Audited
    private int startNo = 0;

    @Column(name = "bed_quantity", nullable = false)
    @Audited
    private int bedQuantity = 0;

    @Column(name = "speaker_id")
    @Audited
    private Long speakerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speaker_id", insertable = false, updatable = false)
    private Speaker speaker;

    @Column(name = "sequence_no")
    @Audited
    private int sequenceNo;

    @Column(name = "parent_room_id")
    @Audited
    private Long parentRoomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_room_id", insertable = false, updatable = false)
    private Room parentRoom;

    @Column(name = "note")
    @Audited
    private String note;

    @Column(name = "location")
    @Audited
    private String location;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Long getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(Long specialistId) {
        this.specialistId = specialistId;
    }

    public Specialist getSpecialist() {
        return specialist;
    }

    public void setSpecialist(Specialist specialist) {
        this.specialist = specialist;
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

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
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

    public Room getParentRoom() {
        return parentRoom;
    }

    public void setParentRoom(Room parentRoom) {
        this.parentRoom = parentRoom;
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
