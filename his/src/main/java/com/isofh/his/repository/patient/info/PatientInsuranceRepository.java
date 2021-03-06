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
            " where e.insuranceNumber = ?1" +
            " and case when h.regDate > t.fromDate then h.regDate else t.fromDate end <= ?2" +
            " and case when h.timeGoOut < t.toDate then h.timeGoOut else t.toDate end >= ?2 and h.id <> ?3")
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