package com.isofh.his.repository.patient.invoice;

import com.isofh.his.model.patient.info.PatientInsurance;
import com.isofh.his.model.patient.invoice.PatientInvoice;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PatientInvoiceRepository extends BaseRepository<PatientInvoice, Long> {

    @Transactional(readOnly = true)
    @Query("select e from PatientInvoice e" +
            " inner join e.patientHistory as h" +
            " inner join e.patientType as t" +
            " inner join t.patientInsurance as i" +
            " where e.deleted = 0 and i.insuranceNumber = ?1 and trunc(e.payTime) = trunc(?2) and h.id <> ?3")
    List<PatientInvoice> findByInsuranceNumberAndPayTime(String insuranceNumber, Date regDate, Long patientHistoryId, Pageable pageable);
}