package com.zweirm.ahza_health_mixfront.repository;

import com.zweirm.ahza_health_mixfront.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Integer> {
    Sport findFirstByUsernameOrderByDateDesc(String username);
}
