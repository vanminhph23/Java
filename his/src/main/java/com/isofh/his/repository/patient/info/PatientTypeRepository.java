package com.isofh.his.repository.patient.info;

import com.isofh.his.model.patient.info.PatientType;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PatientTypeRepository extends BaseRepository<PatientType, Long> {

    @Transactional(readOnly = true)
    @Query("select e from PatientType e" +
            " inner join e.patientInsurance as i" +
            " inner join e.patientHistory as h" +
            " where h.id = ?1 and i.appliedFromDate <= ?2 and i.appliedToDate >= ?2")
    List<PatientType> findByValidDate(Long patientHistoryId, Date actDate, Pageable pageable);
}