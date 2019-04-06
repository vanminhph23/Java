package com.isofh.his.repository.base;

import com.isofh.his.model.base.BaseCategoryModel;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseCategoryRepository<T extends BaseCategoryModel, ID> extends BaseRepository<T, ID> {
    Optional<T> findByName(String username);

    Optional<T> findByValue(String value);

    boolean existsByValue(String value);

    @Override
    <S extends T> S save(S entity);
}
