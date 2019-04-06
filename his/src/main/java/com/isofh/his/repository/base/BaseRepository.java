package com.isofh.his.repository.base;

import com.isofh.his.model.base.BaseModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel, ID> extends CrudRepository<T, ID> {
    @Override
    <S extends T> S save(S entity);
}
