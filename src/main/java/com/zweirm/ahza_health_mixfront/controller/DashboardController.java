package com.zweirm.ahza_health_mixfront.controller;

import com.zweirm.ahza_health_mixfront.domain.Result;
import com.zweirm.ahza_health_mixfront.service.ResultService;
import com.zweirm.ahza_health_mixfront.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

@Controller
public class DashboardController {
    @Autowired
    private ResultService resultService;

    @RequestMapping("/goDashboard")
    public String getDashboard(Model model) throws UnsupportedEncodingException {
        String username = UserUtils.getUsername();
        resultService.findFirstByUsernameOrderByDateDesc(username);
        Result result = resultService.findFirstByUsernameOrderByDateDesc(username);

        BigDecimal scal = new BigDecimal("100");

        BigDecimal water = new BigDecimal(result.getWater());
        BigDecimal waterAdvice = new BigDecimal("2500");
        String waterStr = water.divide(waterAdvice, 2, BigDecimal.ROUND_HALF_UP).multiply(scal).toString();
        double waterD = Double.parseDouble(waterStr);
        waterStr = waterStr.substring(0, waterStr.length() - 3);
        model.addAttribute("water", waterD);
        model.addAttribute("waterPercent", waterStr + "%");

        BigDecimal protein = new BigDecimal(result.getProtein());
        BigDecimal proteinAdvice = new BigDecimal("90");
        String proteinStr = protein.divide(proteinAdvice, 2, BigDecimal.ROUND_HALF_UP).multiply(scal).toString();
        double proteinD = Double.parseDouble(proteinStr);
        proteinStr = proteinStr.substring(0, proteinStr.length() -3);
        model.addAttribute("protein", proteinD);
        model.addAttribute("proteinPercent", proteinStr + "%");

        BigDecimal fat = new BigDecimal(result.getFat());
        BigDecimal fatAdvice = new BigDecimal("60");
        String fatStr = fat.divide(fatAdvice, 2, BigDecimal.ROUND_HALF_UP).multiply(scal).toString();
        double fatD = Double.parseDouble(fatStr);
        fatStr = fatStr.substring(0, fatStr.length() -3);
        model.addAttribute("fat", fatD);
        model.addAttribute("fatPercent", fatStr + "%");

        BigDecimal carbohydrate = new BigDecimal(result.getCarbohydrate());
        BigDecimal carbohydrateAdvice = new BigDecimal("660");
        String carbohydrateStr = carbohydrate.divide(carbohydrateAdvice, 2, BigDecimal.ROUND_HALF_UP).multiply(scal).toString();
        double carbohydrateD = Double.parseDouble(carbohydrateStr);
        carbohydrateStr = carbohydrateStr.substring(0, carbohydrateStr.length() -3);
        model.addAttribute("carbohydrate", carbohydrateD);
        model.addAttribute("carbohydratePercent", carbohydrateStr + "%");

        BigDecimal step = new BigDecimal(result.getStep());
        BigDecimal stepAdvice = new BigDecimal("8000");
        String stepStr = step.divide(stepAdvice, 2, BigDecimal.ROUND_HALF_UP).multiply(scal).toString();
        double stepD = Double.parseDouble(stepStr);
        stepStr = stepStr.substring(0, stepStr.length() -3);
        model.addAttribute("step", stepD);
        model.addAttribute("stepPercent", stepStr + "%");

        BigDecimal energy = new BigDecimal(result.getEnergy());
        BigDecimal energyAdvice = new BigDecimal("600");
        String energyStr = energy.divide(energyAdvice, 2, BigDecimal.ROUND_HALF_UP).multiply(scal).toString();
        double energyD = Double.parseDouble(energyStr);
        energyStr = energyStr.substring(0, energyStr.length() -3);
        model.addAttribute("energy", energyD);
        model.addAttribute("energyPercent", energyStr + "%");

        BigDecimal floor = new BigDecimal(result.getFloor());
        BigDecimal floorAdvice = new BigDecimal("10");
        String floorStr = floor.divide(floorAdvice, 2, BigDecimal.ROUND_HALF_UP).multiply(scal).toString();
        double floorD = Double.parseDouble(floorStr);
        floorStr = floorStr.substring(0, floorStr.length() -3);
        model.addAttribute("floor", floorD);
        model.addAttribute("floorPercent", floorStr + "%");

        BigDecimal stand = new BigDecimal(result.getStand());
        BigDecimal standAdvice = new BigDecimal("10");
        String standStr = stand.divide(standAdvice, 2, BigDecimal.ROUND_HALF_UP).multiply(scal).toString();
        double standD = Double.parseDouble(standStr);
        standStr = standStr.substring(0, standStr.length() -3);
        model.addAttribute("stand", standD);
        model.addAttribute("standPercent", standStr + "%");
        return "/mainDashboard";
    }
}
