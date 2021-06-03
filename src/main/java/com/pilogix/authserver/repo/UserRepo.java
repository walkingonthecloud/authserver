package com.pilogix.authserver.repo;

import com.pilogix.authserver.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
}
