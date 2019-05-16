package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.model.category.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialist_id")
    private DyeMethod dyeMethod;

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

    @Column(name = "inpatient", nullable = false)
    @Audited
    private boolean inpatient;

    @Column(name = "outpatient", nullable = false)
    @Audited
    private boolean outpatient;

    @Column(name = "low_indicator")
    @Audited
    private Double lowIndicator;

    @Column(name = "high_indicator")
    @Audited
    private Double highIndicator;

    @Column(name = "male_low_indicator")
    @Audited
    private Double maleLowIndicator;

    @Column(name = "male_high_indicator")
    @Audited
    private Double maleHighIndicator;

    @Column(name = "female_low_indicator")
    @Audited
    private Double femaleLowIndicator;

    @Column(name = "female_high_indicator")
    @Audited
    private Double femaleHighIndicator;

    @Column(name = "normal_range")
    @Audited
    private String normalRange;

    @Column(name = "unit")
    @Audited
    private String unit;

    @Column(name = "report_name")
    @Audited
    private String reportName;

    @Column(name = "c43_value")
    @Audited
    private String c43Value;

    @Column(name = "c43_name")
    @Audited
    private String c43Name;

    @Column(name = "c37_value")
    @Audited
    private String c37Value;

    @Column(name = "c37_name")
    @Audited
    private String c37Name;

    @Column(name = "machine_name")
    @Audited
    private String machineName;

    @Column(name = "conclusion_template")
    @Audited
    private String conclusionTemplate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_template_id")
    @Audited
    private ReportTemplate reportTemplate;

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

    @Column(name = "time_keeping", nullable = false)
    @Audited
    private boolean timeKeeping;

    @Column(name = "specimens", nullable = false)
    @Audited
    private boolean specimens;

    @Column(name = "contract", nullable = false)
    @Audited
    private boolean contract;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
