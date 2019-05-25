package com.isofh.his.repository.patient.invoice;

import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.invoice.PatientInvoice;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PatientInvoiceRepository extends BaseRepository<PatientInvoice, Long> {

    @Transactional(readOnly = true)
    @Query("select e from PatientInvoice e" +
            " where e.patientHistory = ?1" +
            " and e.invoiceType = ?2 and coalesce(e.patientTypeId, 0) = ?3" +
            " and e.contract = ?4 and e.paid = ?5")
    PatientInvoice findByPatientHistory(PatientHistory history, Integer invoiceType, Long patientTypeId, boolean contract, boolean paid);
}