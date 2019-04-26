package com.isofh.his.repository.category;

import com.isofh.his.model.category.InsuranceCard;
import com.isofh.his.model.patient.PatientHistory;
import com.isofh.his.repository.base.BaseCategoryRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface InsuranceCardRepository extends BaseCategoryRepository<InsuranceCard, Long> {

}
