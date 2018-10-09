package com.zweirm.ahza_health_mixfront.repository;

import com.zweirm.ahza_health_mixfront.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

    Result findFirstByUsernameOrderByDateDesc(String username);
}
