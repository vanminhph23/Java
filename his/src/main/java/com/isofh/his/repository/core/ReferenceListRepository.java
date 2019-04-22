package com.isofh.his.repository.core;

import com.isofh.his.model.core.ReferenceList;
import com.isofh.his.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReferenceListRepository extends BaseRepository<ReferenceList, Long> {

    @Query(value = "SELECT rl.*" +
            "\nFROM his_reference_list rl" +
            "\nINNER JOIN his_reference r ON rl.reference_id = r.id AND r.deleted = 0" +
            "\nWHERE rl.deleted = 0 AND r.value = :referenceValue AND rl.value = :value", nativeQuery = true)
    ReferenceList findByReferenceValueAndValue(@Param("referenceValue") String referenceValue, @Param("value") int value);
}
