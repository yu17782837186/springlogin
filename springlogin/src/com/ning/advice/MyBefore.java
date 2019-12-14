package com.ning.advice;

import com.ning.pojo.Users;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Date;

public class MyBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        Users users = (Users) objects[0];
        Logger logger = Logger.getLogger(MyBefore.class);
        logger.info(users.getUsername()+"在"+new Date().toLocaleString()+"进行登录");
    }
}
