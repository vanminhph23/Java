package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.model.category.Department;
import com.isofh.his.model.category.Room;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "his_service_technical")
public class ServiceTechnical extends BaseCategoryModel {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Service service;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "link_value")
    @Audited
    private String linkValue;

    @Column(name = "form_value")
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

    @Column(name = "decision")
    @Audited
    private String decision;

    @Column(name = "decision_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date decisionDate;

    @Column(name = "using_object")
    @Audited
    private String usingObject;

    @Column(name = "print_order")
    @Audited
    private int printOrder;

    @Column(name = "on_request", nullable = false)
    @Audited
    private boolean onRequest;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
