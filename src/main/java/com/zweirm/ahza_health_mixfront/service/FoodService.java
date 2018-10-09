package com.zweirm.ahza_health_mixfront.service;

import com.zweirm.ahza_health_mixfront.domain.Food;
import com.zweirm.ahza_health_mixfront.domain.Sport;
import com.zweirm.ahza_health_mixfront.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public void saveFood(String username, Integer water, Integer protein, Integer fat, Integer carbohydrate) {
        Food food = new Food();
        food.setUsername(username);
        food.setWater(water);
        food.setProtein(protein);
        food.setFat(fat);
        food.setCarbohydrate(carbohydrate);
        food.setDate(new Date());

        foodRepository.save(food);
    }

    public Food findFirstByUsernameOrderByDateDesc(String username) {
        return foodRepository.findFirstByUsernameOrderByDateDesc(username);
    }
}
