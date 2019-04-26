package com.isofh.his.repository.base;

import com.isofh.his.model.base.BaseCategoryModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@NoRepositoryBean
public interface BaseCategoryRepository<T extends BaseCategoryModel, ID extends Long> extends BaseRepository<T, ID> {

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deleted = 0 and e.name = ?1")
    Optional<T> findByName(String name);

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deleted = 0 and e.value = ?1")
    Optional<T> findByValue(String value);

    @Transactional(readOnly = true)
    @Query("select e.id from #{#entityName} e where e.deleted = 0 and e.name = ?1 and e.id <> ?2")
    Optional<Long> findIdByName(String name, ID id);

    @Transactional(readOnly = true)
    @Query("select e.id from #{#entityName} e where e.deleted = 0 and e.value = ?1 and e.id <> ?2")
    Optional<Long> findIdByValue(String value, ID id);

    @Transactional(readOnly = true)
    @Query("select e.name from #{#entityName} e where e.value = ?1 and e.deleted = 0")
    Optional<String> findNameByValue(String value);

    @Transactional(readOnly = true)
    @Query("select e.name from #{#entityName} e where e.id = ?1 and e.deleted = 0")
    Optional<String> findNameById(ID id);

    @Transactional(readOnly = true)
    default boolean existsByValue(String value, ID id) {
        return findIdByValue(value, id).orElse(Long.valueOf(0)) > 0;
    }

    @Transactional(readOnly = true)
    default boolean existsByName(String name, ID id) {
        return findIdByName(name, id).orElse(Long.valueOf(0)) > 0;
    }

    @Override
    <S extends T> S save(S entity);
}
