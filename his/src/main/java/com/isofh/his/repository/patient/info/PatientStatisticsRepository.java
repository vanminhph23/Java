package com.isofh.his.repository.patient.info;

import com.isofh.his.model.patient.info.PatientStatistics;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PatientStatisticsRepository extends BaseRepository<PatientStatistics, Long> {

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e where e.patientValue = ?1")
    int countOutPatientByPatientValue(String patientValue);

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e inner join PatientInsurance pi on e.id = pi.patientHistory" +
            " where e.patientValue = ?1")
    int countInsOutPatientByPatientValue(String patientValue);

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e inner join PatientInsurance pi on e.id = pi.patientHistory" +
            " where e.patientValue = :patientValue" +
            " and month(e.regDate) = :month")
    int countInsOutPatientByPatientValueMonth(@Param("patientValue") String patientValue, @Param("month") int month);

    @Transactional(readOnly = true)
    @Query("select count(e) from PatientHistory e inner join PatientInsurance pi on e.id = pi.patientHistory" +
            " where e.patientValue = :patientValue" +
            " and year(e.regDate) = :year")
    int countInsOutPatientByPatientValueYear(@Param("patientValue") String patientValue, @Param("year") int year);
}