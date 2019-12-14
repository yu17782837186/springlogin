package com.ning.advice;

import com.ning.pojo.Users;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        Logger logger =Logger.getLogger(MyAfter.class);
        Users users = (Users) objects[0];
        if (o != null) {
            logger.info(users.getUsername()+"登录成功！");
        }else {
            logger.info(users.getUsername()+"登录失败！");
        }
    }
}
