package com.springboot.prometeus.tacos.data.jpa;

import com.springboot.prometeus.tacos.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}