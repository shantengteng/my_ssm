package com.stt.service.impl;

import com.stt.dao.IUserDao;
import com.stt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl {

    @Resource
    private IUserDao userDao;

    public User findUser(Long id){
        return this.userDao.findUser(id);
    }
}
