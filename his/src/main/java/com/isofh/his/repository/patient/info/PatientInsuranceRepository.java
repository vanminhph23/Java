package com.isofh.his.repository.patient.info;

import com.isofh.his.model.patient.info.PatientInsurance;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PatientInsuranceRepository extends BaseRepository<PatientInsurance, Long> {

    @Transactional(readOnly = true)
    @Query("select e from PatientInsurance e" +
            " inner join e.patientType as t" +
            " inner join t.patientHistory as h" +
            " where h.id = ?1 and e.appliedFromDate <= ?2 and e.appliedToDate >= ?2")
    List<PatientInsurance> findByValidDate(Long patientHistoryId, Date actDate, Pageable pageable);

    @Transactional(readOnly = true)
    @Query("select e from PatientInsurance e" +
            " inner join e.patientType as t" +
            " inner join t.patientHistory as h" +
            " where e.insuranceNumber = ?1" +
            " and case when h.regDate > e.appliedFromDate then h.regDate else e.appliedFromDate end <= ?2" +
            " and case when h.timeGoOut < e.appliedToDate then h.timeGoOut else e.appliedToDate end >= ?2 and h.id <> ?3")
    List<PatientInsurance> findByRegDate(String insuranceNumber, Date regDate, Long patientHistoryId, Pageable pageable);

    @Transactional(readOnly = true)
    @Query("select e from PatientInsurance e" +
            " inner join e.patientType as t" +
            " inner join t.patientHistory as h" +
            " where e.insuranceNumber = ?1 and e.keeping = ?2 and h.id <> ?3")
    List<PatientInsurance> findByKeeping(String insuranceNumber, boolean keeping, Long patientHistoryId, Pageable pageable);

    @Transactional(readOnly = true)
    @Query("select e from PatientInsurance e" +
            " inner join e.patientType as t" +
            " inner join t.patientHistory as h" +
            " inner join h.patientInvoices as i" +
            " where e.insuranceNumber = ?1 and i.payTime = ?2 and h.id <> ?3")
    List<PatientInsurance> findByInsuranceNumberAndPayTime(String insuranceNumber, Date regDate, Long patientHistoryId, Pageable pageable);
}