package com.zweirm.ahza_health_mixfront.controller;

import com.zweirm.ahza_health_mixfront.domain.Food;
import com.zweirm.ahza_health_mixfront.domain.Result;
import com.zweirm.ahza_health_mixfront.domain.Sport;
import com.zweirm.ahza_health_mixfront.service.FoodService;
import com.zweirm.ahza_health_mixfront.service.ResultService;
import com.zweirm.ahza_health_mixfront.service.SportService;
import com.zweirm.ahza_health_mixfront.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

@Controller
public class ResultController {
    @Autowired
    private ResultService resultService;
    @Autowired
    private SportService sportService;
    @Autowired
    private FoodService foodService;

    @RequestMapping("/goHealth/saveResult")
    public String saveResult() throws UnsupportedEncodingException {
        String username = UserUtils.getUsername();

        Sport lastSport = sportService.findFirstByUsernameOrderByDateDesc(username);
        Food lastFood = foodService.findFirstByUsernameOrderByDateDesc(username);
        resultService.saveResult(username, lastSport, lastFood);

        return "redirect:/goHealth/successResult";
    }

    @RequestMapping("/goHealth/successResult")
    public String showResult(Model model) throws UnsupportedEncodingException {
        String username = UserUtils.getUsername();
        Result result = resultService.findFirstByUsernameOrderByDateDesc(username);
        model.addAttribute("water", result.getWater());
        model.addAttribute("protein", result.getProtein());
        model.addAttribute("fat", result.getFat());
        model.addAttribute("carbohydrate", result.getCarbohydrate());
        model.addAttribute("step", result.getStep());
        model.addAttribute("energy", result.getEnergy());
        model.addAttribute("floor", result.getFloor());
        model.addAttribute("stand", result.getStand());
        return "/mainHealthResult";
    }
}
