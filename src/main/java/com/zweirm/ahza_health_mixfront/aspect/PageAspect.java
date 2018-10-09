package com.zweirm.ahza_health_mixfront.aspect;

import com.zweirm.ahza_health_mixfront.utils.LoginUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Aspect
@Component
public class PageAspect {
    @Pointcut(value = "execution(* com.zweirm.ahza_health_mixfront.controller.PageController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore() throws UnsupportedEncodingException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        HttpServletRequest request = attributes.getRequest();
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        LoginUtils.checkLogin();

        Boolean isAutoLogin = LoginUtils.isAutoLogin;
        Boolean isLogin = LoginUtils.isLogin;

        if (!isAutoLogin && !isLogin) {
            try {
                response.sendRedirect("/index");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
