package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.service.PatientInvoiceLineDto;
import com.isofh.his.model.patient.info.Patient;
import com.isofh.his.model.patient.invoice.PatientInvoiceLine;
import com.isofh.his.repository.patient.invoice.PatientInvoiceLineRepository;
import com.isofh.his.service.base.BaseService;

import java.util.List;

public interface PatientInvoiceLineService extends BaseService<PatientInvoiceLine, PatientInvoiceLineDto, PatientInvoiceLineRepository> {

    List<PatientInvoiceLine> findNotPaidServiceByPatient(Patient patient, Long patientHistoryId);

    List<PatientInvoiceLine> findNotPaidServiceByInsuranceNumber(String insuranceNumber, Long patientHistoryId);
}
