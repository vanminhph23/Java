package com.isofh.his.repository.patient;

import com.isofh.his.repository.base.BaseRepository;
import com.isofh.his.service.patient.PatientStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PatientStatisticsRepository extends BaseRepository<PatientStatistics, Long> {

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e where e.deleted = 0" +
            " and e.patientValue = ?1")
    int countOutPatientByPatientValue(String patientValue);

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e inner join PatientInsurance pi on pi.deleted = 0 and e.id = pi.patientHistory" +
            " where e.deleted = 0" +
            " and e.patientValue = ?1")
    int countInsOutPatientByPatientValue(String patientValue);

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e inner join PatientInsurance pi on pi.deleted = 0 and e.id = pi.patientHistory" +
            " where e.deleted = 0" +
            " and e.patientValue = :patientValue" +
            " and month(e.regDate) = :month")
    int countInsOutPatientByPatientValueMonth(@Param("patientValue") String patientValue, @Param("month") int month);

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e inner join PatientInsurance pi on pi.deleted = 0 and e.id = pi.patientHistory" +
            " where e.deleted = 0" +
            " and e.patientValue = :patientValue" +
            " and year(e.regDate) = :year")
    int countInsOutPatientByPatientValueYear(@Param("patientValue") String patientValue, @Param("year") int year);
}