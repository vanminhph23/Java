package com.isofh.his.repository.core;

import com.isofh.his.model.core.ReferenceList;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReferenceListRepository extends BaseRepository<ReferenceList, Long> {

    @Query(value = "select e from ReferenceList e inner join e.reference as r where e.value = ?1 and r.value = ?2")
    ReferenceList findByReferenceValueAndValue(String referenceValue, int value);
}
