package com.zweirm.ahza_health_mixfront.controller;

import com.zweirm.ahza_health_mixfront.service.SportService;
import com.zweirm.ahza_health_mixfront.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

@Controller
public class SportController {
    @Autowired
    private SportService sportService;

    @RequestMapping("/goHealth/food")
    public String saveSport(Integer step, Integer energy, Integer floor, Integer stand) throws UnsupportedEncodingException {
        String username = UserUtils.getUsername();
        sportService.saveSport(username, step, energy, floor, stand);
        return "/mainHealthFood";
    }
}
