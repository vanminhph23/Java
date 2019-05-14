package com.isofh.his.repository.patient.info;

import com.isofh.his.model.patient.info.Patient;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface PatientRepository extends BaseRepository<Patient, Long> {

    @Transactional(readOnly = true)
    @Query("select e.id from #{#entityName} e where e.deleted = 0 and e.patientValue = ?1")
    Optional<Long> findIdByPatientValue(String patientValue);

    default boolean existsByPatientValue(String patientValue) {
        return findIdByPatientValue(patientValue).orElse(Long.valueOf(0)) > 0;
    }

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deleted = 0 and e.patientValue = ?1")
    Optional<Patient> findByPatientValue(String patientValue);
}