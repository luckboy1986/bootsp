package com.zhaomlb.club.bootsp.impl;

import com.zhaomlb.club.bootsp.entity.UserDto;
import com.zhaomlb.club.bootsp.respository.UserRespository;
import com.zhaomlb.club.bootsp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImple implements UserService {

    @Autowired
    private UserRespository userRespository;
    @Override
    public List<UserDto> getUserList() {
        return userRespository.findAll();
    }
    @Override
    public  UserDto  insert(UserDto userDto)
    {
       return userRespository.save(userDto);
    }
}
