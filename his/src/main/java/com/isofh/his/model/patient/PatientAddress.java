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

    @OneToOne(mappedBy = "patientAddress")
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

    @Column(name = "detail")
    @Audited
    private String detail;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public PatientHistory getPatientHistory() {
        return patientHistory;
    }

    public void setPatientHistory(PatientHistory patientHistory) {
        this.patientHistory = patientHistory;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
