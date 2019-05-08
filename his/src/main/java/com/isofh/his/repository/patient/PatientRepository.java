package com.isofh.his.repository.patient;

import com.isofh.his.model.patient.Patient;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PatientRepository extends BaseRepository<Patient, Long> {

    @Transactional(readOnly = true)
    @Query("select case when count(e) > 0 then true else false end from #{#entityName} e where e.deleted = 0 and e.value = ?1")
    boolean existsByPatientValue(String patientValue);
}