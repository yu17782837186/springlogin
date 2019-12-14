package com.ning.service.impl;

import com.ning.mapper.UsersMapper;
import com.ning.pojo.Users;
import com.ning.service.UsersService;

import org.springframework.beans.factory.annotation.Value;


public class UsersServiceImpl implements UsersService {
    @Value("${my.demo}")
    private String test;
    @Value("${my.demo1}")
    private int test1;


    private UsersMapper usersMapper;

    public UsersMapper getUsersMapper() {
        return usersMapper;
    }

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public Users login(Users users) {
        System.out.println("输出："+test+"  "+test1);
        return usersMapper.selByUsers(users);
    }
}




