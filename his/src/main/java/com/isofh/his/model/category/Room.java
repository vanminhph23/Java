package com.isofh.his.model.category;

import com.isofh.his.model.base.Base2Model;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_room")
public class Room extends Base2Model {
    @Id
    @GeneratedValue(generator = "room_generator")
    @SequenceGenerator(
            name = "room_generator",
            sequenceName = "room_sq",
            initialValue = 1000000
    )
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "department_id", nullable = false)
    @Audited
    private Long departmentId;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    @Column(name = "room_type")
    @Audited
    private int roomType;

    @Column(name = "building_id", nullable = false)
    @Audited
    private Long buildingId;

    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false)
    private Building building;

    @Column(name = "specialist_id")
    @Audited
    private Long specialistId;

    @ManyToOne
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

    @Column(name = "start_no", nullable = false)
    @Audited
    private int startNo = 0;

    @Column(name = "speaker_id")
    @Audited
    private Long speakerId;

    @ManyToOne
    @JoinColumn(name = "speaker_id", insertable = false, updatable = false)
    private Speaker speaker;

    @Column(name = "sequence_no", nullable = false)
    @Audited
    private int sequenceNo = 0;

    @Column(name = "parent_room_id", nullable = false)
    @Audited
    private Long parentRoomId;

    @ManyToOne
    @JoinColumn(name = "parent_room_id", insertable = false, updatable = false)
    private Room parentRoom;

    @Column(name = "note")
    @Audited
    private String note;

    @Column(name = "location")
    @Audited
    private String location;
}
