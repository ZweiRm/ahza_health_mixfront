package com.zweirm.ahza_health_mixfront.repository;

import com.zweirm.ahza_health_mixfront.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsernameAndPassword(String username, String password);

    User findUserByUsername(String username);
}
