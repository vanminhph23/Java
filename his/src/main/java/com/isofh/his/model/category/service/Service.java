package com.isofh.his.model.category.service;

import com.isofh.his.model.base.BaseCategoryModel;
import com.isofh.his.model.category.Department;
import com.isofh.his.model.category.Room;
import com.isofh.his.model.category.UOM;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "his_service")
public class Service extends BaseCategoryModel {
    @Id
    @GeneratedValue(generator = "service_generator")
    @SequenceGenerator(
            name = "service_generator",
            sequenceName = "service_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "service_type")
    @Audited
    private int serviceType;

    @Column(name = "c9324_expense_type")
    @Audited
    private int c9324ExpenseType;

    @Column(name = "cx_value")
    @Audited
    private String cxValue;

    @Column(name = "cx_name")
    @Audited
    private String cxName;

    @Column(name = "decision")
    @Audited
    private String decision;

    @Column(name = "decision_date")
    @Audited
    private Timestamp decisionDate;

    @Column(name = "pay_rate")
    @Audited
    private int payRate;

    @Column(name = "uom_id")
    @Audited
    private Long uomId;

    @ManyToOne
    @JoinColumn(name = "uom_id", insertable = false, updatable = false)
    private UOM uom;

    @Column(name = "service_group_level1_id")
    @Audited
    private Long serviceGroupLevel1Id;

    @ManyToOne
    @JoinColumn(name = "service_group_level1_id", insertable = false, updatable = false)
    private ServiceGroupLevel1 serviceGroupLevel1;

    @Column(name = "service_group_level2_id")
    @Audited
    private Long serviceGroupLevel2Id;

    @ManyToOne
    @JoinColumn(name = "service_group_level2_id", insertable = false, updatable = false)
    private ServiceGroupLevel1 serviceGroupLevel2;

    @Column(name = "service_group_level3_id")
    @Audited
    private Long serviceGroupLevel3Id;

    @ManyToOne
    @JoinColumn(name = "service_group_level3_id", insertable = false, updatable = false)
    private ServiceGroupLevel1 serviceGroupLevel3;

    @Column(name = "unit_price_service")
    @Audited
    private Double unitPriceService;

    @Column(name = "unit_price_insurance")
    @Audited
    private Double unitPriceInsurance;

    @Column(name = "unit_price_difference")
    @Audited
    private Double unitPriceDifference;

    @Column(name = "old_value")
    @Audited
    private String oldValue;

    @Column(name = "short_name")
    @Audited
    private String shortName;

    @Column(name = "description")
    @Audited
    private String description;

    @Column(name = "using_object")
    @Audited
    private String usingObject;

    @Column(name = "print_order")
    @Audited
    private int printOrder;

    @Column(name = "high_tech", nullable = false)
    @Audited
    private boolean highTech;

    @Column(name = "not_counted", nullable = false)
    @Audited
    private boolean notCounted;

    @Column(name = "on_request", nullable = false)
    @Audited
    private boolean onRequest;

    @Column(name = "service_in_hospital", nullable = false)
    @Audited
    private boolean serviceInHospital;

    @Column(name = "not_used", nullable = false)
    @Audited
    private boolean notUsed;

    @Column(name = "not_control", nullable = false)
    @Audited
    private boolean notControl;

    @Column(name = "create_odd", nullable = false)
    @Audited
    private boolean createOdd;

    @Column(name = "change_source", nullable = false)
    @Audited
    private boolean changeSource;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}