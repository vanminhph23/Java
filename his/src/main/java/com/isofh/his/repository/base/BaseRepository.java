package com.isofh.his.repository.base;

import com.isofh.his.model.base.BaseModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel, ID extends Long> extends CrudRepository<T, ID> {
    @Override
    <S extends T> S save(S entity);

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e")
    List<T> findAll();

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.id in ?1")
    Iterable<T> findAllById(Iterable<ID> ids);

    @Override
    @Transactional(readOnly = true)
    @Query("select e from #{#entityName} e where e.id = ?1")
    Optional<T> findById(ID id);

    @Override
    @Transactional(readOnly = true)
    @Query("select case when count(e) > 0 then true else false end from #{#entityName} e where e.id = ?1")
    boolean existsById(ID id);

    @Override
    @Query("update #{#entityName} e set e.deleted = e.id where e.id = ?1")
    @Transactional
    @Modifying
    void deleteById(Long id);

    @Override
    @Transactional
    default void delete(T entity) {
        deleteById(entity.getId());
    }

    @Override
    @Transactional
    default void deleteAll(Iterable<? extends T> entities) {
        entities.forEach(entitiy -> delete(entitiy));
    }

    @Override
    @Query("update #{#entityName} e set e.deleted = e.id")
    @Transactional
    @Modifying
    void deleteAll();
}
