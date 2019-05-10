package com.isofh.his.repository.patient;

import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientHistoryRepository extends BaseRepository<PatientHistory, Long> {

    @Transactional(readOnly = true)
    @Query("select e from PatientHistory e where e.deleted = 0 and e.idNo = ?1")
    List<PatientHistory> findByIdNo(String idNo, Pageable pageable);
}
