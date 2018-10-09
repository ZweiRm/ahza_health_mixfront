package com.zweirm.ahza_health_mixfront.repository;

import com.zweirm.ahza_health_mixfront.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
    Food findFirstByUsernameOrderByDateDesc(String username);
}
