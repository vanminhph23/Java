package com.isofh.his.repository.base;

import com.isofh.his.model.employee.User;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseCategoryRepository<T, ID> extends BaseRepository<T, ID> {
    Optional<User> findByName(String username);

    Optional<User> findByValue(String value);
}
