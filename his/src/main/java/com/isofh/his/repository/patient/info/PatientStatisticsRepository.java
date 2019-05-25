package com.isofh.his.repository.patient.info;

import com.isofh.his.model.patient.info.PatientStatistics;
import com.isofh.his.repository.base.BaseRepository;
import com.isofh.his.service.patient.info.PatientService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PatientStatisticsRepository extends BaseRepository<PatientStatistics, Long> {

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e where e.patientValue = ?1")
    int countOutPatientByPatientValue(String patientValue);

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e inner join e.patientTypes as t" +
            " where e.patientValue = ?1 and t.patientType = 2")
    int countInsOutPatientByPatientValue(String patientValue);

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e inner join e.patientTypes as t" +
            " where e.patientValue = ?1" +
            " and month(e.regDate) = ?2 and t.patientType = 2")
    int countInsOutPatientByPatientValueMonth(String patientValue, int month);

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e inner join e.patientTypes as t" +
            " where e.patientValue = ?1" +
            " and year(e.regDate) = ?2 and t.patientType = 2")
    int countInsOutPatientByPatientValueYear(String patientValue, int year);
}