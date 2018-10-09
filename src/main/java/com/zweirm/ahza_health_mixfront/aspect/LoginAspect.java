package com.zweirm.ahza_health_mixfront.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Aspect
@Component
public class LoginAspect {
    @Pointcut(value = "execution(* com.zweirm.ahza_health_mixfront.controller.UserController.login(..))")
    public void log() {
    }

    @Around("log()")
    public Object doBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0 && args[1].getClass() == String.class) {
            try {
                String password = (String) args[1];
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                args[1] = new BigInteger(1, md.digest()).toString(16);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        for (Object arg : args) {
            System.out.println(arg);
        }

        return joinPoint.proceed(args);
    }
}
