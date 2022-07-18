package com.midas.auth.Repository;

import com.midas.auth.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllBy();

    User findByName(String name);

    User findByEmail(String email);

    User findByMobileNumber(String mobileNumber);
}
