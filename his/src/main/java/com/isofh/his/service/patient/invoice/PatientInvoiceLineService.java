package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.service.PatientInvoiceLineDto;
import com.isofh.his.model.patient.info.Patient;
import com.isofh.his.model.patient.invoice.PatientInvoiceLine;
import com.isofh.his.repository.patient.invoice.PatientInvoiceLineRepository;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.base.IEnum;

import java.util.List;

public interface PatientInvoiceLineService extends BaseService<PatientInvoiceLine, PatientInvoiceLineDto, PatientInvoiceLineRepository> {

    enum StatusEnum implements IEnum {
        THUONG(10), CHO_HUY(20), DA_HUY(30);

        private int value;

        StatusEnum(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

    List<PatientInvoiceLine> findNotPaidServiceByPatient(Patient patient, Long patientHistoryId);

    List<PatientInvoiceLine> findNotPaidServiceByInsuranceNumber(String insuranceNumber, Long patientHistoryId);
}
