package com.zweirm.ahza_health_mixfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/goMain")
    public String goMain() {
        return "/main";
    }

    @RequestMapping("/goHealth")
    public String goHealth() {
        return "/mainHealth";
    }

    @RequestMapping("/goGene")
    public String goGene() {
        return "/mainGene";
    }

    @RequestMapping("/goGeneResult")
    public String goGeneShow() {
        return "/mainGeneShow";
    }
}
