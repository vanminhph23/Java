package com.isofh.his.repository.patient;

import com.isofh.his.model.patient.PatientInsurance;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

public interface PatientInsuranceRepository extends BaseRepository<PatientInsurance, Long> {

    @Transactional(readOnly = true)
    @Query("select e from PatientInsurance e where e.deleted = 0 and e.appliedFromDate <= ?2 and e.appliedToDate >= ?2 and e.patientHistory = ?1 order by e.percent")
    Optional<PatientInsurance> findByValidDate(Long patientHistoryId, Date actDate);
}