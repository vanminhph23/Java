package com.isofh.his.repository.patient;

import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PatientHistoryRepository extends BaseRepository<PatientHistory, Long> {

    @Transactional(readOnly = true)
    @Query("select e from PatientHistory e where e.deleted = 0 and e.idNo = ?1 order by e.id desc")
    Optional<PatientHistory> findFirstByIdNo(String idNo);
}
