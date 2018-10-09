package com.zweirm.ahza_health_mixfront.utils;

import com.zweirm.ahza_health_mixfront.domain.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UserUtils {
    public static String username = null;

    private UserUtils() {
    }

    public static String getUsername() throws UnsupportedEncodingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();

        Boolean isAutoLogin = LoginUtils.isAutoLogin;
        Boolean isLogin = LoginUtils.isLogin;

        if (isAutoLogin) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("autoLogin")) {
                    String autoLogin = cookie.getValue();
                    String[] subStrs = autoLogin.split("#");
                    username = URLDecoder.decode(subStrs[0], "utf-8");
                }
            }
        }

        if (isLogin) {
            User user = (User) session.getAttribute("user");
            username = user.getUsername();
        }

        return username;
    }
}
