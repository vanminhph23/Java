package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.invoice.PatientInvoiceDto;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.invoice.PatientInvoice;
import com.isofh.his.repository.patient.invoice.PatientInvoiceRepository;
import com.isofh.his.service.base.BaseService;
import com.isofh.his.service.base.IEnum;

public interface PatientInvoiceService extends BaseService<PatientInvoice, PatientInvoiceDto, PatientInvoiceRepository> {

    PatientInvoice findByPatientHistory(PatientHistory history, Integer invoiceType, Long patientTypeId, boolean contract, boolean paid);

    enum PatientInvoiceTypeEnum implements IEnum {
        DICH_VU(1), BAO_HIEM(2);

        private int value;

        PatientInvoiceTypeEnum(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }
}
