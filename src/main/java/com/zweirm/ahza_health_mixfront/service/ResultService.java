package com.zweirm.ahza_health_mixfront.service;

import com.zweirm.ahza_health_mixfront.domain.Food;
import com.zweirm.ahza_health_mixfront.domain.Result;
import com.zweirm.ahza_health_mixfront.domain.Sport;
import com.zweirm.ahza_health_mixfront.repository.FoodRepository;
import com.zweirm.ahza_health_mixfront.repository.ResultRepository;
import com.zweirm.ahza_health_mixfront.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ResultService {
    @Autowired
    private ResultRepository resultRepository;

    public Result findFirstByUsernameOrderByDateDesc(String username) {
        return resultRepository.findFirstByUsernameOrderByDateDesc(username);
    }

    public void saveResult(String username, Sport lastSport, Food lastFood) {
        Result result = new Result();
        result.setUsername(username);
        result.setWater(lastFood.getWater());
        result.setProtein(lastFood.getProtein());
        result.setFat(lastFood.getFat());
        result.setCarbohydrate(lastFood.getCarbohydrate());

        result.setStep(lastSport.getStep());
        result.setEnergy(lastSport.getEnergy());
        result.setFloor(lastSport.getFloor());
        result.setStand(lastSport.getStand());
        result.setDate(new Date());

        resultRepository.save(result);
    }

    public void saveDefaultResult(String username) {
        Result defaultResult = new Result();
        defaultResult.setUsername(username);

        defaultResult.setStand(0);
        defaultResult.setFloor(0);
        defaultResult.setEnergy(0);
        defaultResult.setStep(0);

        defaultResult.setCarbohydrate(0);
        defaultResult.setFat(0);
        defaultResult.setProtein(0);
        defaultResult.setWater(0);

        defaultResult.setDate(new Date());

        resultRepository.save(defaultResult);
    }
}
