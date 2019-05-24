package com.isofh.his.service.patient.invoice;

import com.isofh.his.dto.patient.service.PatientInvoiceLineDto;
import com.isofh.his.exception.data.InvalidDataException;
import com.isofh.his.model.category.service.ServiceSource;
import com.isofh.his.model.patient.info.Patient;
import com.isofh.his.model.patient.info.PatientHistory;
import com.isofh.his.model.patient.info.PatientType;
import com.isofh.his.model.patient.invoice.PatientInvoiceLine;
import com.isofh.his.model.patient.service.PatientServiceCheckUp;
import com.isofh.his.repository.patient.invoice.PatientInvoiceLineRepository;
import com.isofh.his.service.category.service.ServiceSourceService;
import com.isofh.his.service.patient.info.PatientHistoryService;
import com.isofh.his.service.patient.info.PatientTypeService;
import com.isofh.his.service.patient.service.*;
import com.isofh.his.storage.StorageService;
import com.isofh.his.util.DateUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientInvoiceLineServiceImpl implements PatientInvoiceLineService {

    private final static Logger logger = LoggerFactory.getLogger(PatientInvoiceLineServiceImpl.class);

    @Autowired
    private PatientInvoiceLineRepository repository;

    @Autowired
    private PatientTypeService patientTypeService;

    @Autowired
    private PatientHistoryService historyService;

    @Autowired
    private ServiceSourceService serviceSourceService;

    @Autowired
    private PatientServiceCheckUpService checkUpService;

    @Autowired
    private PatientServiceMedicalTestService medicalTestService;

    @Autowired
    private PatientServiceTechnicalService technicalService;

    @Autowired
    private PatientServiceOtherService otherService;

    @Autowired
    private PatientServiceBedService bedService;

    @Autowired
    private PatientServiceProductService productService;

    @Autowired
    private PatientServiceBloodService bloodService;

    @Override
    public PatientInvoiceLineRepository getRepository() {
        return repository;
    }

    @Autowired
    private StorageService storageService;

    @Override
    public StorageService getStorageService() {
        return storageService;
    }

    @Override
    public Class<PatientInvoiceLine> getModelClass() {
        return PatientInvoiceLine.class;
    }

    @Override
    public Class<PatientInvoiceLineDto> getDtoClass() {
        return PatientInvoiceLineDto.class;
    }

    ModelMapper modelMapper = null;

    @Override
    public ModelMapper getModelMapper() {
        if (modelMapper == null) {
            modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        }

        return modelMapper;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public List<PatientInvoiceLine> findNotPaidServiceByPatient(Patient patient, Long patientHistoryId) {
        if (patientHistoryId == null) {
            patientHistoryId = 0L;
        }

        return getRepository().findNotPaidServiceByPatient(patient, patientHistoryId);
    }

    @Override
    public List<PatientInvoiceLine> findNotPaidServiceByInsuranceNumber(String insuranceNumber, Long patientHistoryId) {
        if (patientHistoryId == null) {
            patientHistoryId = 0L;
        }

        return getRepository().findNotPaidServiceByInsuranceNumber(insuranceNumber, patientHistoryId);
    }

    @Override
    public PatientInvoiceLineDto createDto(PatientInvoiceLineDto dto) {
        PatientInvoiceLine line = create(getModel(dto));


        ServiceSource ss = line.getService();
        if (ss.getServiceType() == ServiceSourceService.ServiceTypeEnum.KHAM.getValue()) {
            PatientServiceCheckUp checkUp = new PatientServiceCheckUp();
            checkUp.setPatientInvoiceLine(line);

            checkUp.setRoomId(dto.getRoomId());
            checkUpService.create(checkUp);
        }

        return null;
    }

    @Override
    public PatientInvoiceLine create(PatientInvoiceLine line) {
        autoFillDefaultFields(line);

        fillFieldsFromServiceSource(line);

        validateQuantity(line);

        validateFromDepartment(line);

        calculatePrice(line);

        return line;
    }

    private void autoFillDefaultFields(PatientInvoiceLine line) {
        if (line.getPatientHistory() == null) {
            line.setPatientHistory(historyService.findById(line.getPatientHistoryId()));
        }

        if (line.getService() == null) {
            line.setService(serviceSourceService.findById(line.getServiceId()));
        }

        if (line.getFromDepartmentId() == null || line.getFromDepartmentId() <= 0) {
            line.setFromDepartmentId(getDepartmentId());
        }

        if (line.getDocDate() == null) {
            line.setDocDate(DateUtil.getNow());
        }

        if (line.getActDate() == null) {
            line.setActDate(DateUtil.getNow());
        }

        line.setInpatient(line.getPatientHistory().isInpatient());
    }

    private void fillFieldsFromServiceSource(PatientInvoiceLine line) {
        ServiceSource ss = line.getService();
        if (ss == null || ss.getId() == null || ss.getId() <= 0) {
            throw new InvalidDataException("serviceId is null");
        }

        line.setServiceGroupLevel1Id(ss.getServiceGroupLevel1Id());
        line.setServiceGroupLevel2Id(ss.getServiceGroupLevel2Id());
        line.setServiceGroupLevel3Id(ss.getServiceGroupLevel3Id());
    }

    private void validateQuantity(PatientInvoiceLine line) {
        if (line.getQuantity() == null || line.getQuantity() < 0) {
            throw new InvalidDataException("quantity is null");
        }
    }

    private void validateFromDepartment(PatientInvoiceLine line) {
        if (line.getFromDepartmentId() == null || line.getFromDepartmentId() <= 0) {
            throw new InvalidDataException("From department is null");
        }
    }

    private void calculatePrice(PatientInvoiceLine line) {
        if (line.getQuantity() == null || line.getQuantity() < 0) {
            throw new InvalidDataException("quantity is null");
        }

        Double serviceTotalAmount = line.getServiceTotalAmount();
        Double serviceAmount = line.getServiceTotalAmount();

        Double insuranceTotalAmount = line.getInsuranceTotalAmount();
        Double insuranceAmount = line.getInsuranceAmount();

        serviceTotalAmount = serviceTotalAmount == null ? 0 : serviceTotalAmount;
        serviceAmount = serviceAmount == null ? 0 : serviceAmount;

        insuranceTotalAmount = insuranceTotalAmount == null ? 0 : insuranceTotalAmount;
        insuranceAmount = insuranceAmount == null ? 0 : insuranceAmount;

        setPriceService(line);

        calculatePriceNoCheck(line);

        if (serviceTotalAmount.compareTo(line.getServiceTotalAmount()) != 0 || serviceAmount.compareTo(line.getServiceAmount()) != 0) {
            if (line.isServicePaid()) {
                throw new InvalidDataException("Invoice has paid");
            }

            validatePatientInHospital();
        }

        if (insuranceTotalAmount.compareTo(line.getInsuranceTotalAmount()) != 0 || insuranceAmount.compareTo(line.getInsuranceAmount()) != 0) {
            if (line.isInsurancePaid()) {
                throw new InvalidDataException("Invoice has paid");
            }

            validatePatientInHospital();
        }
    }

    private void validatePatientInHospital() {

    }

    private void setPriceService(PatientInvoiceLine line) {
        ServiceSource ss = line.getService();

        line.setServiceUnitPrice(ss.getServiceUnitPrice());
        line.setInsuranceUnitPrice(ss.getInsuranceUnitPrice());
        line.setDifferenceUnitPrice(ss.getDifferenceUnitPrice());

        line.setInsurancePayRate(ss.getInsurancePayRate());

        if (!line.isServiceInHospital()) {
            line.setInsuranceUnitPrice(0.0);
        }
    }

    private void calculatePriceNoCheck(PatientInvoiceLine line) {
        PatientType patientType = patientTypeService.findByValidDate(line.getPatientHistory().getId(), line.getActDate());
        line.setPatientType(patientType);

        boolean insurancePatient = historyService.isInsurancePatient(patientType, line.getPatientHistory().isInpatient());

        // Ty le thanh toan BH
        Integer patientPayRate = patientType.getPatientInsurance().getPercent();

        if (patientPayRate == null) {
            patientPayRate = 0;
        }

        patientPayRate = patientPayRate / 100;

        boolean notCounted = line.isNotCounted();
        boolean serviceUsed = line.isServiceUsed();

        if (serviceUsed) {
            notCounted = false;
            line.setNotCounted(false);
        }

        Integer insurancePayRate = line.getInsurancePayRate();
        Integer servicePayRate = line.getServicePayRate();

        if (insurancePayRate == null || insurancePayRate <= 0) {
            insurancePayRate = 0;
        }

        if (servicePayRate == null || servicePayRate <= 0) {
            servicePayRate = 0;
        }

        Double serviceUnitPrice = line.getServiceUnitPrice();
        Double insuranceUnitPrice = line.getInsuranceUnitPrice();
        Double differenceUnitPrice = line.getDifferenceUnitPrice();

        Double quantity = line.getQuantity();

        Double serviceTotalAmount = serviceUnitPrice * quantity;
        Double insuranceTotalAmount = insuranceUnitPrice * quantity;
        Double differenceTotalAmount = differenceUnitPrice * quantity;

        if (ServiceSourceService.ServiceTypeEnum.PHAU_THUAT_THU_THUAT.getValue() == line.getServiceType()
                || ServiceSourceService.ServiceTypeEnum.CDHA_TDCN.getValue() == line.getServiceType()
                || ServiceSourceService.ServiceTypeEnum.KHAM.getValue() == line.getServiceType()
                || ServiceSourceService.ServiceTypeEnum.GIUONG.getValue() == line.getServiceType()) {

            serviceTotalAmount = serviceTotalAmount * servicePayRate;
            differenceTotalAmount = differenceTotalAmount * servicePayRate;
            insuranceTotalAmount = insuranceTotalAmount * servicePayRate * insurancePayRate;
        }

        Double insuranceAmount;
        Double serviceAmount;

        if (serviceUsed || insurancePayRate == 0) {
            serviceAmount = serviceTotalAmount;
            insuranceTotalAmount = 0.0;
            insuranceAmount = 0.0;
        } else if (notCounted) {
            if (!insurancePatient || insuranceUnitPrice == 0) {
                insuranceTotalAmount = 0.0;
            } else {
                serviceTotalAmount = 0.0;
            }

            serviceAmount = 0.0;
            insuranceAmount = 0.0;
        } else if (!insurancePatient || insuranceUnitPrice == 0) {
            serviceAmount = serviceTotalAmount;
            insuranceTotalAmount = 0.0;
            insuranceAmount = 0.0;
        } else {
            serviceTotalAmount = differenceTotalAmount;
            serviceAmount = differenceTotalAmount;
            insuranceAmount = insuranceTotalAmount * patientPayRate;
        }

        line.setInsuranceTotalAmount(insuranceTotalAmount);
        line.setInsuranceAmount(insuranceAmount);
        line.setServiceTotalAmount(serviceTotalAmount);
        line.setServiceAmount(serviceAmount);

        line.setAmount(insuranceAmount + serviceAmount);
    }
}
