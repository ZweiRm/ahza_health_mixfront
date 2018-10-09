package com.zweirm.ahza_health_mixfront.controller;

import com.zweirm.ahza_health_mixfront.service.FoodService;
import com.zweirm.ahza_health_mixfront.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;

    @RequestMapping("/goHealth/result")
    public String goHealthResult(Integer water, Integer protein, Integer fat, Integer carbohydrate) throws UnsupportedEncodingException {
        String username = UserUtils.getUsername();
        foodService.saveFood(username, water, protein, fat, carbohydrate);
        return "redirect:/goHealth/saveResult";
    }
}
