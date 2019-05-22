package com.isofh.his.model.patient.info;

import com.isofh.his.model.base.BaseModel;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "his_patient",
        uniqueConstraints={@UniqueConstraint(columnNames = {"patient_value", "deleted"})},
        indexes = {@Index(name = "idx_patient_reg_date", columnList = "reg_date")})
@Where(clause = "deleted=0")
public class Patient extends BaseModel {
    @Id
    @GeneratedValue(generator = "patient_generator")
    @SequenceGenerator(
            name = "patient_generator",
            sequenceName = "patient_sq",
            initialValue = 1000000
    )
    private Long id;

    @Column(name = "patient_value", nullable = false)
    @Audited
    private String patientValue;

    @Column(name = "patient_name", nullable = false)
    @Audited
    private String patientName;

    @Column(name = "id_no")
    @Audited
    private String idNo;

    @Column(name = "phone")
    @Audited
    private String phone;

    @Column(name = "address")
    @Audited
    private String address;

    @Column(name = "insurance_number")
    @Audited
    private String insuranceNumber;

    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date birthday;

    @Column(name = "reg_date")
    @Temporal(TemporalType.TIMESTAMP)
    @Audited
    private Date regDate;

    @Column(name = "gender")
    @Audited
    private int gender;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientValue() {
        return patientValue;
    }

    public void setPatientValue(String patientValue) {
        this.patientValue = patientValue;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
