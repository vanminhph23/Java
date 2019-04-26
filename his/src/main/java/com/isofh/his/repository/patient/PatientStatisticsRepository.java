package com.isofh.his.repository.patient;

import com.isofh.his.model.patient.PatientInsurance;
import com.isofh.his.repository.base.BaseRepository;
import com.isofh.his.service.patient.PatientStatistics;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

public interface PatientStatisticsRepository extends BaseRepository<PatientStatistics, Long> {

    @Transactional(readOnly = true)
    @Query("select e from PatientHistory e where e.deleted = 0" +
            " and e.patientValue = ?1")
    int countOutPatientByPatientValue(String patientValue);

    @Transactional(readOnly = true)
    @Query("select e from PatientHistory e inner join PatientInsurance pi on pi.deleted = 0 and e.id = pi.patientHistory" +
            " where e.deleted = 0" +
            " and e.patientValue = ?1")
    int countInsOutPatientByPatientValue(String patientValue);

    @Transactional(readOnly = true)
    @Query("select e from PatientHistory e inner join PatientInsurance pi on pi.deleted = 0 and e.id = pi.patientHistory" +
            " where e.deleted = 0" +
            " and e.patientValue = ?1" +
            " and month(e.regDate) = month(?2)")
    int countInsOutPatientByPatientValueMonth(String patientValue, Date timeGoIn);

    @Transactional(readOnly = true)
    @Query("select e from PatientHistory e inner join PatientInsurance pi on pi.deleted = 0 and e.id = pi.patientHistory" +
            " where e.deleted = 0" +
            " and e.patientValue = ?1" +
            " and year(e.regDate) = year(?2)")
    int countInsOutPatientByPatientValueYear(String patientValue, Date timeGoIn);
}