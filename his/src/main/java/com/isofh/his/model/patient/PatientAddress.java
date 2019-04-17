package com.isofh.his.model.patient;

import com.isofh.his.model.base.patient.BasePatientModel;
import com.isofh.his.model.category.Country;
import com.isofh.his.model.category.District;
import com.isofh.his.model.category.Province;
import com.isofh.his.model.category.Zone;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "his_patient_address")
public class PatientAddress extends BasePatientModel {

    @Id
    @GeneratedValue(generator = "patient_address_generator")
    @SequenceGenerator(
            name = "patient_address_generator",
            sequenceName = "patient_address_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_history_id", unique = true)
    @Audited
    private Long patientHistoryId;

    @OneToOne
    @JoinColumn(name = "patient_history_id", insertable = false, updatable = false)
    private PatientHistory patientHistory;

    @Column(name = "country_id")
    @Audited
    private Long countryId;

    @ManyToOne
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    private Country country;

    @Column(name = "province_id")
    @Audited
    private Long provinceId;

    @ManyToOne
    @JoinColumn(name = "province_id", insertable = false, updatable = false)
    private Province province;

    @Column(name = "district_id")
    @Audited
    private Long districtId;

    @ManyToOne
    @JoinColumn(name = "district_id", insertable = false, updatable = false)
    private District district;

    @Column(name = "zone_id")
    @Audited
    private Long zoneId;

    @ManyToOne
    @JoinColumn(name = "zone_id", insertable = false, updatable = false)
    private Zone zone;

    @Column(name = "detail_address")
    @Audited
    private String detailAddress;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
