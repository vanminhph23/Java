package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.invoice.PatientInvoiceDto;
import com.isofh.his.model.patient.invoice.PatientInvoice;
import com.isofh.his.repository.patient.invoice.PatientInvoiceRepository;
import com.isofh.his.service.base.BaseService;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PatientInvoiceService extends BaseService<PatientInvoice, PatientInvoiceDto, PatientInvoiceRepository> {
}
