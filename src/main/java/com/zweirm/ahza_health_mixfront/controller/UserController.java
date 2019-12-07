package com.zweirm.ahza_health_mixfront.controller;

import com.zweirm.ahza_health_mixfront.domain.User;
import com.zweirm.ahza_health_mixfront.service.ResultService;
import com.zweirm.ahza_health_mixfront.service.UserService;
import com.zweirm.ahza_health_mixfront.utils.LoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ResultService resultService;

    @RequestMapping("/login")
    public String login(String username, String password, Model model) throws UnsupportedEncodingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        HttpSession session = request.getSession();

        String autoLogin = request.getParameter("autoLogin");

        // 自动登录
        if ("autoLogin".equals(autoLogin)) {
            Cookie autoLoginCookie = new Cookie("autoLogin", URLEncoder.encode(username, "utf-8") + "#" + password);
            autoLoginCookie.setMaxAge(3600 * 24 * 30);
            autoLoginCookie.setPath(request.getContextPath() + "/");
            response.addCookie(autoLoginCookie);
        } else {
            Cookie autoLoginCookie = new Cookie("autoLogin", "");
            autoLoginCookie.setMaxAge(0);
            autoLoginCookie.setPath(request.getContextPath() + "/");
            response.addCookie(autoLoginCookie);
        }

        User user = userService.findUserByUsernameAndPassword(username, password);
        if (user == null) {
            model.addAttribute("msg", "用户名或密码错误");
            return "/index";
        } else {
            model.addAttribute("user", user);
            session.setAttribute("user", user);
            LoginUtils.setLogin();
            return "/main";
        }
    }

    @RequestMapping("/register")
    public String register(User user) {
        userService.save(user);
        resultService.saveDefaultResult(user.getUsername());
        return "redirect:/index";
    }

    @RequestMapping("/checkUserExist")
    @ResponseBody
    public User checkUserExist(String username) {
        return userService.findUserByUsername(username);
    }

    @RequestMapping("/logout")
    public String logout() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        HttpSession session = request.getSession();

        Cookie autoLoginCookie = new Cookie("autoLogin", "");
        autoLoginCookie.setMaxAge(0);
        autoLoginCookie.setPath("/");
        response.addCookie(autoLoginCookie);

        session.removeAttribute("user");

        LoginUtils.setLogout();
        return "/index";
    }

}
