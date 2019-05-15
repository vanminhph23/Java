package com.isofh.his.repository.patient.invoice;

import com.isofh.his.model.patient.info.Patient;
import com.isofh.his.model.patient.invoice.PatientInvoiceLine;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientInvoiceLineRepository extends BaseRepository<PatientInvoiceLine, Long> {

    @Transactional(readOnly = true)
    @Query("select e from PatientInvoiceLine e" +
            " inner join e.patientHistory as h" +
            " where e.deleted = 0 and e.active = true and h.patient = ?1 and h.id <> ?2 and e.serviceInHospital = true and e.notCounted = false" +
            " and ((e.insuranceTotalAmount > 0 and e.insurancePaid = false) or (e.serviceTotalAmount > 0 and e.servicePaid = false)) and e.status <> 0")
    List<PatientInvoiceLine> findNotPaidServiceByPatient(Patient patient, Long patientHistoryId);

    @Transactional(readOnly = true)
    @Query("select e from PatientInvoiceLine e" +
            " inner join e.patientType as t" +
            " inner join t.patientInsurance as i" +
            " inner join t.patientHistory as h" +
            " where e.deleted = 0 and e.active = true and i.insuranceNumber = ?1 and h.id <> ?2 and e.serviceInHospital = true and e.notCounted = false" +
            " and ((e.insuranceTotalAmount > 0 and e.insurancePaid = false) or (e.serviceTotalAmount > 0 and e.servicePaid = false)) and e.status <> 0")
    List<PatientInvoiceLine> findNotPaidServiceByInsuranceNumber(String insuranceNumber, Long patientHistoryId);
}