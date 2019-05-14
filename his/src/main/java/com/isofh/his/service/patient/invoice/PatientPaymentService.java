package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.invoice.PatientPaymentDto;
import com.isofh.his.model.patient.invoice.PatientPayment;
import com.isofh.his.repository.patient.invoice.PatientPaymentRepository;
import com.isofh.his.service.base.BaseService;

public interface PatientPaymentService extends BaseService<PatientPayment, PatientPaymentDto, PatientPaymentRepository> {
}
