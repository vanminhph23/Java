package com.isofh.his.repository.patient;

import com.isofh.his.model.patient.PatientType;
import com.isofh.his.repository.base.BaseRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PatientTypeRepository extends BaseRepository<PatientType, Long> {

}