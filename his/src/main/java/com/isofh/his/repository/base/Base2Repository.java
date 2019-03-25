package com.isofh.his.repository.base;

import com.isofh.his.model.User;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface Base2Repository<T, ID> extends BaseRepository<T, ID> {
    Optional<User> findByName(String username);

    Optional<User> findByValue(String value);
}
