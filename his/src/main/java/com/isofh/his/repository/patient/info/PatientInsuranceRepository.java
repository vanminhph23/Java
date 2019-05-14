package com.isofh.his.repository.patient.info;

import com.isofh.his.model.patient.info.PatientInsurance;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PatientInsuranceRepository extends BaseRepository<PatientInsurance, Long> {

    @Transactional(readOnly = true)
    @Query("select e from PatientInsurance e where e.deleted = 0 and e.appliedFromDate <= ?2 and e.appliedToDate >= ?2 and e.patientHistory = ?1 order by e.percent")
    List<PatientInsurance> findByValidDate(Long patientHistoryId, Date actDate, Pageable pageable);

    @Transactional(readOnly = true)
    @Query("select e from PatientInsurance e inner join e.patientType as t inner join t.patientHistory as h where e.deleted = 0 and e.insuranceNumber = ?1 and case when h.regDate > e.appliedFromDate then h.regDate else e.appliedFromDate end <= ?2 and case when h.timeGoOut < e.appliedToDate then h.timeGoOut else e.appliedToDate end >= ?2 and e.patientHistory <> ?3")
    List<PatientInsurance> findByRegDate(String insuranceNumber, Long patientHistoryId, Pageable pageable);

    @Transactional(readOnly = true)
    @Query("select e from PatientInsurance e where e.deleted = 0 and e.insuranceNumber = ?1 and e.keeping = ?2 and e.patientHistory <> ?3")
    List<PatientInsurance> findByKeeping(String insuranceNumber, boolean keeping, Long patientHistoryId, Pageable pageable);
}