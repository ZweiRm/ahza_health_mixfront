package com.zweirm.ahza_health_mixfront.aspect;

import com.zweirm.ahza_health_mixfront.domain.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Aspect
@Component
public class RegisterAspect {
    @Pointcut(value = "execution(* com.zweirm.ahza_health_mixfront.controller.UserController.register(..)) && args(user)")
    public void log(User user) {
    }

    @Before(value = "log(user)", argNames = "user")
    public void doBefore(User user) {
        String password = user.getPassword();
        String newPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            newPassword = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        user.setPassword(newPassword);
    }
}
