package com.isofh.his.repository.base;

import com.isofh.his.model.base.BaseCategoryModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@NoRepositoryBean
public interface BaseCategoryRepository<T extends BaseCategoryModel, ID extends Long> extends BaseRepository<T, ID> {

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deleted = false and e.name = ?1")
    Optional<T> findByName(String name);

    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.deleted = false and e.value = ?1")
    Optional<T> findByValue(String value);

    @Transactional(readOnly = true)
    @Query("select e.id from #{#entityName} e where e.deleted = false and e.name = ?1")
    Optional<Long> findIdByName(String name);

    @Transactional(readOnly = true)
    @Query("select e.id from #{#entityName} e where e.deleted = false and e.value = ?1")
    Optional<Long> findIdByValue(String value);

    @Transactional(readOnly = true)
    default boolean existsByValue(String value) {
        return findIdByValue(value).orElse(Long.valueOf(0)) > 0;
    }

    @Transactional(readOnly = true)
    default boolean existsByName(String name) {
        return findIdByName(name).orElse(Long.valueOf(0)) > 0;
    }

    @Override
    <S extends T> S save(S entity);
}
