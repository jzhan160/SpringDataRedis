package com.springboot.redis.service;

import com.springboot.redis.mapper.UserMapper;
import com.springboot.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService {
    @Resource
    private UserMapper userMapper;

    public void addUser(String name){
        userMapper.addUser(name);
    }
    public User getUser(String name){
       return userMapper.find(name);
    }
}
