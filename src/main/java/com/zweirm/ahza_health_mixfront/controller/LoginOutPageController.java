package com.zweirm.ahza_health_mixfront.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginOutPageController {
    @RequestMapping("/goRegister")
    public String goRegister() {
        return "/register";
    }

    @RequestMapping("/goIndex")
    public String goIndex() {
        return "/index";
    }

    @RequestMapping("/index")
    public String goIndex2() {
        return "/index";
    }
}
