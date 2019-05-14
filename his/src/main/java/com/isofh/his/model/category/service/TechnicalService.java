package com.isofh.his.model.category.service;

import com.isofh.his.model.category.Department;
import com.isofh.his.model.category.Room;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_technical_service")
public class TechnicalService {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @MapsId
    private Service service;

    @Column(name = "department_id")
    @Audited
    private Long departmentId;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Department department;

    @Column(name = "room_id")
    @Audited
    private Long roomId;

    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @Column(name = "link_value", nullable = false)
    @Audited
    private String linkValue;

    @Column(name = "form_value", nullable = false)
    @Audited
    private String formValue;

    @Column(name = "use_in_reception", nullable = false)
    @Audited
    private boolean useInReception;

    @Column(name = "long_take_result", nullable = false)
    @Audited
    private boolean longTakeResult;

    @Column(name = "consultation", nullable = false)
    @Audited
    private boolean consultation;

    @Column(name = "inpatient", nullable = false)
    @Audited
    private boolean inpatient;

    @Column(name = "outpatient", nullable = false)
    @Audited
    private boolean outpatient;
}
