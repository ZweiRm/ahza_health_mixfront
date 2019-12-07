package com.zweirm.ahza_health_mixfront.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtils {
    public static Boolean isAutoLogin = false;
    public static Boolean isLogin = false;

    private LoginUtils() {
    }

    public static void checkLogin() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();

        Cookie[] cookies = request.getCookies();
        System.out.println(cookies.length);
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName());
            if (cookie.getName().equals("autoLogin")) {
                isAutoLogin = true;
            }
        }

        if (session.getAttribute("user") != null) {
            isLogin = true;
        }
    }

    public static void setLogin() {
        isLogin = true;
    }

    public static void setLogout() {
        isAutoLogin = false;
        isLogin = false;
    }
}
